package com.johncorby.joshua.element

import com.johncorby.joshua.checkTypes
import com.johncorby.joshua.className

interface Statement : Element

data class FuncCall(val name: String, val args: List<Expr>) : ExprImpl(), Statement {
    init {
        args.forEach { it.parent = this }
    }

    private lateinit var define: FuncDefine
    override fun preEval() {
        define = Scope[name]
        type = define.type
    }

    override fun evalImpl(): String {
        val argsEval = args.eval()

        val defTypes = define.args.map { it.type }
        val ourTypes = args.map { it.type }
        // todo maybe add more detail?????? maybe not idk
        check(defTypes == ourTypes) { "call arg types $ourTypes doesnt match func arg types $defTypes" }

        return "(${type.eval()})(" +
                name + argsEval.joinToString(",", "(", ")") +
                ")"
    }
}

data class VarAssign(val name: String, val value: Expr) : ExprImpl(), Statement {
    init {
        value.parent = this
    }

    override fun preEval() {
        type = Scope.get<VarDefine>(name).type
    }

    override fun evalImpl(): String {
        val valueEval = value.eval()

        checkTypes("value", value.type, "var", type)

        return "$name=$valueEval"
    }
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
        check(condition.type.isBool()) { "$className condition must be bool (got ${condition.type}" }

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

        // walk up parent tree until we get a func
        var currentParent = parent
        while (currentParent !is FuncDefine) currentParent = currentParent.parent
        val define: FuncDefine = currentParent
        // then check its type
        checkTypes("return", value.type, "func", define.type)

        return "return" + valueEval.orEmpty() + ";"
    }
}
