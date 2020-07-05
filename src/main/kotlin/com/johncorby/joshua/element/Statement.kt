package com.johncorby.joshua.element

interface Statement : Element

data class FuncCall(val name: String, val args: List<Expr>) : ExprImpl(), Statement {
    init {
        args.forEach { it.parent = this }
    }

    override fun preEval() {
        type = Scope.get<FuncDefine>(name).type
        // todo check arg types
    }

    override fun evalImpl() = name + args.eval().joinToString(",", "(", ")")
}

data class VarAssign(val name: String, val value: Expr) : ElementImpl(), Statement {
    init {
        value.parent = this
    }

    override fun preEval() {
        val type = Scope.get<VarDefine>(name).type
        // todo check value type
    }

    override fun evalImpl() = "$name=${value.eval()}"
}


typealias Block = List<Statement>

fun Block.blockEval() = eval().joinToString("", "{", "}") { "$it;" }


/**
 * control statement that has a conditional expression
 */
abstract class ControlStatement : ElementImpl(), Statement, Scoped {
    abstract val condition: Expr

    init {
        @Suppress("LeakingThis")
        condition.parent = this
    }

    override fun preEval() {
        check(condition.type == Type.BOOL) { "$this condition must be bool (got ${condition.type}" }

        super<Scoped>.preEval()
    }
}

data class If(override val condition: Expr, val thenBlock: Block, val elseBlock: Block? = null) : ControlStatement() {
    init {
        thenBlock.parent = this
        elseBlock?.parent = this
    }

    override fun evalImpl() = "if(${condition.eval()})${thenBlock.blockEval()}" +
            elseBlock?.let { "else${it.blockEval()}" }.orEmpty()
}

data class Until(override val condition: Expr, val block: Block) : ControlStatement() {
    init {
        condition.parent = this
        block.parent = this
    }

    override fun evalImpl() = "while(!(${condition.eval()}))${block.blockEval()}"
}

data class For(val init: VarDefine, override val condition: Expr, val update: Statement, val block: Block) :
    ControlStatement() {
    init {
        init.parent = this
        condition.parent = this
        update.parent = this
        block.parent = this
    }

    override fun evalImpl() = "for(${init.eval()};${condition.eval()};${update.eval()})${block.blockEval()}"
}


data class Ret(val value: Expr? = null) : ElementImpl(), Statement {
    init {
        value?.parent = this
    }

    override fun evalImpl(): String {
        val valueEval = value?.eval()

        val type = value?.type ?: Type.VOID
        // parent should always be func
        val funcType = (parent as FuncDefine).type
        check(type == funcType) { "return type $type does not match func type $funcType" }

        return "return" + valueEval.orEmpty() + ";"
    }
}
