package com.johncorby.joshua.element

import com.johncorby.joshua.BinaryOp
import com.johncorby.joshua.UnaryOp

interface Expr : Element

data class Literal<T>(val value: T) : Expr {
    override fun evalImpl() = when (value) {
        is Char -> "'$value'"
        is String -> "\"$value\""
        is Boolean -> if (value) "1" else "0"
        else -> value.toString()
    }
}

data class Var(val name: String) : Expr {
    override fun evalImpl() = name

    override fun preEval() {
        Scope[VarDefine::class, name]
    }
}

data class Binary(val left: Expr, val right: Expr, val operator: BinaryOp) : Expr {
    override fun evalImpl() = "${left.eval()}${operator.eval()}${right.eval()}"
}

data class Unary(val operand: Expr, val operator: UnaryOp) : Expr {
    override fun evalImpl() = "${operator.eval()}${operand.eval()}"
}
