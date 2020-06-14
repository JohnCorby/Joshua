package com.johncorby.joshua

import com.johncorby.joshua.antlr.GrammarParser

/**
 * higher level ast
 */
interface Ast {
    fun eval(): String
}

interface Statement : Ast
interface Expr : Ast

data class Program(val statements: List<Statement>) : Ast {
    override fun eval() = statements.joinToString("") { "${it.eval()};" }
}

data class CCode(val code: String) : Statement {
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
    override fun eval() = "${type.c} $name" +
            args.joinToString(",", "(", ")") +
            block.joinToString("", "{", "}") { "${it.eval()};" }
}

data class FuncCall(val name: String, val args: List<Expr>?) : Statement, Expr {
    override fun eval() = name + args?.joinToString(",", "(", ")") { it.eval() }
}


data class VarDeclare(val type: Type, val name: String, val value: Expr?) : Statement {
    override fun eval() = "${type.c} $name" + value?.run { "=${eval()}" }.orEmpty()
}

data class VarAssign(val name: String, val value: Expr) : Statement {
    override fun eval() = "$name=${value.eval()}"
}


data class Literal<T>(val value: T) : Expr {
    override fun eval() = value.toString()
}

data class Var(val name: String) : Expr {
    override fun eval() = name
}

/**
 * todo make [op] an enum instead of a plain string lol
 */
data class BinOp(val left: Expr, val right: Expr, val op: String) : Expr {
    override fun eval() = "${left.eval()}$op${right.eval()}"
}
