package com.johncorby.joshua

import com.johncorby.joshua.antlr.GrammarParser

/**
 * an ast that is higher-level than antlr's tree
 * and performs more checks
 */
interface Ast {
    override fun toString(): String
}

interface Declare : Ast
interface Statement : Ast
interface Expr : Ast

data class Program(val declares: List<Declare>) : Ast {
    override fun toString() = declares
        .joinToString("") { "$it;" }
        .replace(";+".toRegex(), ";") // duplicate ;
        .replace("};", "}") // ; after }
        .replace("} ;", "};") // except for structs which need it
}


data class CCode(val code: String) : Declare, Statement, Expr {
    override fun toString() =
        code.replace("<(.+?)>".toRegex())
        { parse<Expr>(it.groupValues[1], GrammarParser::expr).toString() }
}


data class Block(val statements: List<Statement>) : Ast {
    override fun toString() = statements.joinToString("", "{", "}") { "$it;" }
}


data class FuncDeclare(val type: Type, val name: String, val args: List<VarDeclare>, val block: Block) : Declare {
    init {
        // todo remove this later when we implement func arg initializing
        require(args.all { it.init == null }) { "function arguments cant be initialized" }
    }

    override fun toString() = "$type $name" +
            args.joinToString(",", "(", ")") +
            block
}

data class FuncCall(val name: String, val args: List<Expr>) : Statement, Expr {
    override fun toString() = name + args.joinToString(",", "(", ")")
}


data class VarDeclare(val type: Type, val name: String, val init: Expr? = null) : Declare, Statement {
    override fun toString() = "$type $name" + init?.let { "=$it" }.orEmpty()
}

data class VarAssign(val name: String, val value: Expr) : Statement {
    override fun toString() = "$name=$value"
}


data class If(val condition: Expr, val thenBlock: Block, val elseBlock: Block? = null) : Statement {
    override fun toString() = "if($condition)$thenBlock" + elseBlock?.let { "else$it" }.orEmpty()
}

data class Until(val condition: Expr, val block: Block) : Statement {
    override fun toString() = "while(!($condition))$block"
}

data class For(val init: VarDeclare, val condition: Expr, val update: Statement, val block: Block) : Statement {
    override fun toString() = "for($init;$condition;$update)$block"
}


data class StructDeclare(val name: String, val declares: List<Declare>) : Declare {
    private val others = mutableListOf<Declare>()
    private val funcs = mutableListOf<FuncDeclare>()

    init {
        declares.forEach {
            if (it is FuncDeclare) funcs += it
            else others += it
        }

        // todo remove this later when we implement struct member initializing
        require(others.filterIsInstance<VarDeclare>().all { it.init == null }) { "struct members cant be initialized" }
    }

    override fun toString() = "struct $name" +
            others.joinToString("", "{", "} ;") { "$it;" } +
            funcs.map {
                it.copy(
                    type = it.type,
                    name = "$name$${it.name}",
                    args = listOf(VarDeclare(Type.ADDR, "this")) + it.args,
                    block = it.block
                )
            }.joinToString("")
}


data class Literal<T>(val value: T) : Expr {
    override fun toString() = when (value) {
        is Char -> "'$value'"
        is String -> "\"$value\""
        is Boolean -> if (value) "1" else "0"
        else -> value.toString()
    }
}

data class Var(val name: String) : Expr {
    override fun toString() = name
}

data class Binary(val left: Expr, val right: Expr, val operator: BinaryOp) : Expr {
    override fun toString() = "$left$operator$right"
}

data class Unary(val operand: Expr, val operator: UnaryOp) : Expr {
    override fun toString() = "$operator$operand"
}
