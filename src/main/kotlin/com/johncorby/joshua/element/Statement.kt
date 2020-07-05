package com.johncorby.joshua.element

import com.johncorby.joshua.checkTypes
import com.johncorby.joshua.className

interface Statement : Element

data class FuncCall(val name: String, val args: List<Expr>) : ExprImpl(), Statement {
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
    override fun preEval() {
        val define: FuncDefine = Scope[name]
        type = define.type
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

    override fun preEval() {
        check(condition.type.isBool()) { "$className condition must be bool (got ${condition.type}" }

        super<Scoped>.preEval()
    }
}

data class If(override val condition: Expr, val thenBlock: Block, val elseBlock: Block? = null) : ControlStatement() {
    override fun evalImpl() = "if(${condition.eval()})${thenBlock.blockEval()}" +
            elseBlock?.let { "else${it.blockEval()}" }.orEmpty()
}

data class Until(override val condition: Expr, val block: Block) : ControlStatement() {
    override fun evalImpl() = "while(!(${condition.eval()}))${block.blockEval()}"
}

data class For(val init: VarDefine, override val condition: Expr, val update: Statement, val block: Block) :
    ControlStatement() {
    override fun evalImpl() = "for(${init.eval()};${condition.eval()};${update.eval()})${block.blockEval()}"
}


data class Ret(val value: Expr? = null) : ElementImpl(), Statement {
    override fun evalImpl(): String {
        val valueEval = value?.eval()

        checkTypes("return", value.type, "func", FuncDefine.current.type)

        return "return" + valueEval.orEmpty()
    }
}
