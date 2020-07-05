package com.johncorby.joshua.element

import com.johncorby.joshua.BinaryOp
import com.johncorby.joshua.UnaryOp
import com.johncorby.joshua.className

interface Expr : Element {
    /**
     * this either gets initialized pre-eval,
     * or during eval if types of sub-elements are needed
     */
    val type: Type
}

abstract class ExprImpl : ElementImpl(), Expr {
    override lateinit var type: Type
}


data class Var(val name: String) : ExprImpl() {
    override fun preEval() {
        type = Scope.get<VarDefine>(name).type
    }

    override fun evalImpl() = name
}

data class Literal<T : Any>(val value: T) : ExprImpl() {
    override fun preEval() {
        type = when (value) {
            is Int -> Type.INT
            is Float -> Type.FLOAT
            is Boolean -> Type.BOOL
            is Char -> Type.CHAR
            is String -> Type.STRING
            else -> error("no type for value of class ${value.className}")
        }
    }

    override fun evalImpl() = when (value) {
        is Char -> "'$value'"
        is String -> "\"$value\""
        is Boolean -> if (value) "1" else "0"
        else -> value.toString()
    }
}


data class Binary(val left: Expr, val right: Expr, val operator: BinaryOp) : ExprImpl() {
    init {
        left.parent = this
        right.parent = this
    }

    override fun evalImpl(): String {
        val leftEval = left.eval()
        val rightEval = right.eval()

        operator.check(left.type, right.type)
        // choose the largest of the 2 types
        type = if (left.type.size > right.type.size) left.type else right.type

        // promote to that largest type
        return "(${type.eval()})$leftEval${operator.eval()}(${type.eval()})$rightEval"
    }
}

data class Unary(val operand: Expr, val operator: UnaryOp) : ExprImpl() {
    init {
        operand.parent = this
    }

    override fun evalImpl(): String {
        val operandEval = operand.eval()

        operator.check(operand.type)
        // simple passthrough
        type = operand.type

        return "${operator.eval()}$operandEval"
    }
}
