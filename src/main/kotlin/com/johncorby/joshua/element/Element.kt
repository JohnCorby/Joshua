package com.johncorby.joshua.element

import com.johncorby.joshua.BinaryOp
import com.johncorby.joshua.UnaryOp
import com.johncorby.joshua.antlr.GrammarParser
import com.johncorby.joshua.parse

/**
 * an element tree that is higher-level than antlr's tree
 * and performs more checks
 */
interface Element {
    override fun toString(): String
}

interface Statement : Element
interface Expr : Element

data class Program(val defines: List<Define>) : Element {
    override fun toString() = defines
        .joinToString("") { "$it;" }
        .replace(";+".toRegex(), ";") // duplicate ;
        .replace("};", "}") // ; after }
        .replace("} ;", "};") // except for structs which need it
}


data class CCode(val code: String) : Define, Statement, Expr {
    override fun toString() =
        code.replace("<(.+?)>".toRegex())
        {
            parse<Expr>(
                it.groupValues[1],
                GrammarParser::expr
            ).toString()
        }

    override fun define() = error("cant define c code")
    override fun undefine() = error("cant undefine c code")
}


data class Block(val statements: List<Statement>) :
    Element {
    override fun toString() = statements.joinToString("", "{", "}") { "$it;" }
}


data class FuncCall(val name: String, val args: List<Expr>) : Statement,
    Expr {
    override fun toString() = name + args.joinToString(",", "(", ")")
}


data class VarAssign(val name: String, val value: Expr) :
    Statement {
    override fun toString() = "$name=$value"
}


data class If(val condition: Expr, val thenBlock: Block, val elseBlock: Block? = null) :
    Statement {
    override fun toString() = "if($condition)$thenBlock" + elseBlock?.let { "else$it" }.orEmpty()
}

data class Until(val condition: Expr, val block: Block) :
    Statement {
    override fun toString() = "while(!($condition))$block"
}

data class For(val init: VarDefine, val condition: Expr, val update: Statement, val block: Block) :
    Statement {
    override fun toString() = "for($init;$condition;$update)$block"
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

data class Binary(val left: Expr, val right: Expr, val operator: BinaryOp) :
    Expr {
    override fun toString() = "$left$operator$right"
}

data class Unary(val operand: Expr, val operator: UnaryOp) :
    Expr {
    override fun toString() = "$operator$operand"
}
