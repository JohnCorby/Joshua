package com.johncorby.joshua.element

import com.johncorby.joshua.BinaryOp
import com.johncorby.joshua.Type
import com.johncorby.joshua.UnaryOp
import com.johncorby.joshua.className

interface Expr : Element {
    /**
     * types are initialized post-eval,
     * so accessing them before that will error
     */
    val type: Type
}

data class Var(val name: String) : ElementImpl(), Expr {
    override fun evalImpl() = name

    override lateinit var type: Type
    override fun postEval() {
        type = Scope[VarDefine::class, name].type
    }
}

data class Literal<T : Any>(val value: T) : ElementImpl(), Expr {
    override fun evalImpl() = when (value) {
        is Char -> "'$value'"
        is String -> "\"$value\""
        is Boolean -> if (value) "1" else "0"
        else -> value.toString()
    }

    override lateinit var type: Type
    override fun postEval() {
        type = when (value) {
            is Int -> Type.INT
            is Float -> Type.FLOAT
            is Boolean -> Type.BOOL
            is Char -> Type.CHAR
            is String -> Type.STRING
            else -> error("no type for value of class ${value.className}")
        }
    }
}

data class Binary(val left: Expr, val right: Expr, val operator: BinaryOp) : ElementImpl(), Expr {
    override fun evalImpl() = "${left.eval()}${operator.eval()}${right.eval()}"

    override lateinit var type: Type
    override fun postEval() {
        with(left.type to right.type) {
            operator.check(first, second)
            type = if (first.size > second.size) first else second
        }
    }
}

data class Unary(val operand: Expr, val operator: UnaryOp) : ElementImpl(), Expr {
    override fun evalImpl() = "${operator.eval()}${operand.eval()}"

    override lateinit var type: Type
    override fun postEval() {
        operator.check(operand.type)
        type = operand.type
    }
}
