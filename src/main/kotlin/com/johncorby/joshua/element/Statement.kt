package com.johncorby.joshua.element

interface Statement : Element

data class FuncCall(val name: String, val args: List<Expr>) : ElementImpl(), Statement, Expr {
    override fun preEval() {
        Scope[FuncDefine::class, name]
    }

    override fun evalImpl() = name + args.joinToString(",", "(", ")") { it.eval() }
}

data class VarAssign(val name: String, val value: Expr) : ElementImpl(), Statement {
    override fun preEval() {
        Scope[VarDefine::class, name]
    }

    override fun evalImpl() = "$name=${value.eval()}"
}


data class Block(val statements: List<Statement>) : ElementImpl(), Element {
    override fun evalImpl() = statements.joinToString("", "{", "}") { "${it.eval()};" }
}


data class If(val condition: Expr, val thenBlock: Block, val elseBlock: Block? = null) :
    ElementImpl(), Statement, Scoped {
    override fun evalImpl() = "if(${condition.eval()})${thenBlock.eval()}" +
            elseBlock?.let { "else${it.eval()}" }.orEmpty()
}

data class Until(val condition: Expr, val block: Block) : ElementImpl(), Statement, Scoped {
    override fun evalImpl() = "while(!(${condition.eval()}))${block.eval()}"
}

data class For(val init: VarDefine, val condition: Expr, val update: Statement, val block: Block) :
    ElementImpl(), Statement, Scoped {
    override fun evalImpl() = "for(${init.eval()};${condition.eval()};${update.eval()})${block.eval()}"
}
