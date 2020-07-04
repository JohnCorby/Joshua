package com.johncorby.joshua.element

import com.johncorby.joshua.Type

interface Statement : Element

data class FuncCall(val name: String, val args: List<Expr>) : ElementImpl(), Statement, Expr {
    override fun preEval() {
        Scope[FuncDefine::class, name]
    }

    override fun evalImpl() = name + args.eval().joinToString(",", "(", ")")

    override lateinit var type: Type
    override fun postEval() {
        type = Scope[FuncDefine::class, name].type
    }
}

data class VarAssign(val name: String, val value: Expr) : ElementImpl(), Statement {
    override fun preEval() {
        Scope[VarDefine::class, name]
    }

    override fun evalImpl() = "$name=${value.eval()}"
}


typealias Block = List<Statement>

fun Block.blockEval() = eval().joinToString("", "{", "}") { "$it;" }


data class If(val condition: Expr, val thenBlock: Block, val elseBlock: Block? = null) :
    ElementImpl(), Statement, Scoped {
    override fun evalImpl() = "if(${condition.eval()})${thenBlock.blockEval()}" +
            elseBlock?.let { "else${it.blockEval()}" }.orEmpty()
}

data class Until(val condition: Expr, val block: Block) : ElementImpl(), Statement, Scoped {
    override fun evalImpl() = "while(!(${condition.eval()}))${block.blockEval()}"
}

data class For(val init: VarDefine, val condition: Expr, val update: Statement, val block: Block) :
    ElementImpl(), Statement, Scoped {
    override fun evalImpl() = "for(${init.eval()};${condition.eval()};${update.eval()})${block.blockEval()}"
}

data class Ret(val value: Expr? = null) : ElementImpl(), Statement {
    override fun evalImpl() = "return" + value?.let { " ${it.eval()}" }.orEmpty() + ";"

    override fun postEval() {
        val type = value?.type ?: Type.VOID
        // todo get containing func and check types
    }
}
