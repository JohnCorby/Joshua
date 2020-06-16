package com.johncorby.joshua

import com.johncorby.joshua.antlr.GrammarParser

/**
 * higher level ast
 */
interface Ast {
    override fun toString(): String
}

interface Statement : Ast
interface Expr : Ast

data class Program(val statements: List<Statement>) : Ast {
    override fun toString() = statements.joinToString("") { "$it;" }
}


data class CCode(val code: String) : Statement, Expr {
    override fun toString() =
        code.replace("<(.+?)>".toRegex())
        { parse<Expr>(it.groupValues[1], GrammarParser::expr).toString() }
}


data class Block(val statements: List<Statement>) : Ast {
    override fun toString() = statements.joinToString("", "{", "}") { "$it;" }
}


data class FuncDeclare(
    val type: Type,
    val name: String,
    val args: List<VarDeclare>,
    val block: Block
) : Statement {
    override fun toString() = "$type $name" +
            args.joinToString(",", "(", ")") +
            block
}


data class FuncCall(val name: String, val args: List<Expr>?) : Statement, Expr {
    override fun toString() = name + args?.joinToString(",", "(", ")")
}


data class VarDeclare(val type: Type, val name: String, val value: Expr?) : Statement {
    override fun toString() = "$type $name" + value?.let { "=$it" }.orEmpty()
}

data class VarAssign(val name: String, val value: Expr) : Statement {
    override fun toString() = "$name=$value"
}


data class If(val condition: Expr, val thenBlock: Block, val elseBlock: Block?) : Statement {
    override fun toString() = "if($condition)$thenBlock" + elseBlock?.let { "else$it" }.orEmpty()
}

data class Until(val condition: Expr, val block: Block) : Statement {
    override fun toString() = "while(!($condition))$block"
}


data class Literal<T>(val value: T) : Expr {
    override fun toString() = when (value) {
        is Char -> "'$value'"
        is String -> "\"$value\""
        else -> value.toString()
    }
}

data class Var(val name: String) : Expr {
    override fun toString() = name
}

data class Binary(val left: Expr, val right: Expr, val op: BinaryOp) : Expr {
    override fun toString() = "$left$op$right"
}

data class Unary(val expr: Expr, val op: UnaryOp) : Expr {
    override fun toString() = "$op$expr"
}
