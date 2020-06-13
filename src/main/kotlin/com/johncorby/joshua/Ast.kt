package com.johncorby.joshua

import com.johncorby.joshua.antlr.GrammarParser

/**
 * higher level ast
 */
interface Ast {
    fun eval(): Any
    override fun toString(): String
}

interface Statement : Ast
interface Expr : Ast {
    override fun eval(): String
}

data class Program(val statements: List<Statement>) : Ast {
    override fun eval() = statements.forEach { it.eval() }
}

data class CCode(val code: String) :
    Statement, Expr {
    override fun eval() =
        code.replace("""\{(.+?)}""".toRegex())
        { parse<Expr>(it.groupValues[1], GrammarParser::expr).eval() }
}


data class FuncDeclare(
    val type: Type,
    val name: String,
    val args: List<VarDeclare>,
    val block: List<Statement>
) : Statement {
    override fun eval() = TODO()
}

data class FuncCall(val name: String, val args: List<Expr>?) : Statement, Expr {
    override fun eval() = TODO()
}


data class VarDeclare(val type: Type, val name: String, val value: Expr?) : Statement {
    override fun eval() = TODO()
}

data class VarAssign(val name: String, val value: Expr) : Statement {
    override fun eval() = TODO()
}


data class Literal<T>(val value: T) : Expr {
    override fun eval() = TODO()
}

data class BinOp(val left: Expr, val right: Expr, val op: String) : Expr {
    override fun eval() = TODO()
}

data class Var(val name: String) : Expr {
    override fun eval() = TODO()
}
