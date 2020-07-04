package com.johncorby.joshua.element

import com.johncorby.joshua.BinaryOp
import com.johncorby.joshua.Type
import com.johncorby.joshua.UnaryOp
import com.johncorby.joshua.className

interface Expr : Element {
    /**
     * this either gets initialized pre-eval,
     * or during eval if types of sub-elements are needed
     */
    val type: Type
}

data class Var(val name: String) : ElementImpl(), Expr {
    override lateinit var type: Type
    override fun preEval() {
        type = Scope[VarDefine::class, name].type
    }

    override fun evalImpl() = name
}

data class Literal<T : Any>(val value: T) : ElementImpl(), Expr {
    override lateinit var type: Type
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

data class Binary(val left: Expr, val right: Expr, val operator: BinaryOp) : ElementImpl(), Expr {
    override lateinit var type: Type
    override fun evalImpl(): String {
        val leftEval = left.eval()
        val rightEval = right.eval()

        with(left.type to right.type) {
            operator.check(first, second)
            type = if (first.size > second.size) first else second
        }

        // promote via cast to largest of the 2 types
        return "(${type.eval()})$leftEval${operator.eval()}(${type.eval()})$rightEval"
    }
}

data class Unary(val operand: Expr, val operator: UnaryOp) : ElementImpl(), Expr {
    override lateinit var type: Type

    override fun evalImpl(): String {
        val operandEval = operand.eval()

        type = operand.type

        return "${operator.eval()}$operandEval"
    }
}
