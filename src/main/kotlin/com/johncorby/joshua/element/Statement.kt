package com.johncorby.joshua.element

import com.johncorby.joshua.*

interface Statement : Element

data class FuncCall(val name: String, val args: List<Expr>) : ExprImpl(), Statement, TypeChecked {
    private lateinit var define: FuncDefine
    override fun checkTypes() = checkTypesSame("call arg", args.types, "func arg", define.args.types)

    override fun preEval() {
        define = Scope[name]
        type = define.type
    }

    override fun evalImpl() = type.cast(
        name,
        args.evalThenCheckTypes().joinToString(",", "(", ")")
    )
}

data class VarAssign(val name: String, val value: Expr) : ExprImpl(), Statement, TypeChecked {
    override fun checkTypes() = checkTypesSame("value", value.type, "var", type)
    override fun preEval() {
        type = Scope.get<VarDefine>(name).type
    }

    override fun evalImpl() = "$name=${value.evalThenCheckTypes()}"
}


typealias Block = List<Statement>

fun Block.blockEval() = eval().joinToString("", "{", "}") { "$it;" }


/**
 * statement that has a conditional expression
 */
abstract class ConditionalStatement : ElementImpl(), Statement, Scoped, TypeChecked {
    protected abstract val condition: Expr

    override fun checkTypes() = checkTypeIs("$className condition", condition.type, Type.BOOL)
}

/**
 * a conditional statement that you can put a break or continue in
 */
abstract class LoopStatement : ConditionalStatement() {
    companion object {
        var inLoop = false
    }

    override fun preEval() {
        inLoop = true
        super.preEval()
    }

    override fun postEval() {
        inLoop = false
        super.postEval()
    }
}

data class If(override val condition: Expr, val thenBlock: Block, val elseBlock: Block? = null) :
    ConditionalStatement() {
    override fun evalImpl() = "if(${condition.evalThenCheckTypes()})${thenBlock.blockEval()}" +
            elseBlock?.let { "else${it.blockEval()}" }.orEmpty()
}

data class Until(override val condition: Expr, val block: Block) : LoopStatement() {
    override fun evalImpl() = "while(!(${condition.evalThenCheckTypes()}))${block.blockEval()}"
}

data class For(val init: VarDefine, override val condition: Expr, val update: Statement, val block: Block) :
    LoopStatement() {
    override fun evalImpl() =
        "for(${init.eval()};${condition.evalThenCheckTypes()};${update.eval()})${block.blockEval()}"
}


data class Ret(val value: Expr? = null) : ElementImpl(), Statement, TypeChecked {
    override fun preEval() {
        checkc(FuncDefine.current != null) { "tried to return when not in a func" }
    }

    override fun checkTypes() = checkTypesSame("return", value.type, "func", FuncDefine.current!!.type)
    override fun evalImpl() = "return" + value?.evalThenCheckTypes().orEmpty()
}

class Break : ElementImpl(), Statement {
    override fun preEval() = checkc(LoopStatement.inLoop) { "cant break when not in loop" }
    override fun evalImpl() = "break"
}

class Continue : ElementImpl(), Statement {
    override fun preEval() = checkc(LoopStatement.inLoop) { "cant continue when not in loop" }
    override fun evalImpl() = "continue"
}
