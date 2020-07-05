package com.johncorby.joshua.element

import com.johncorby.joshua.BinaryOp
import com.johncorby.joshua.Type
import com.johncorby.joshua.UnaryOp
import com.johncorby.joshua.className

interface Expr : Element {
    /**
     * NOTE: eval sub-elements before getting their types.
     * otherwise, this will be initialized pre-eval
     *
     * casting is built-in
     * and lets c do the actual work
     * meaning it might be a conversion or it might not be.
     * todo we should probably be in more control of this later
     */
    var type: Type
}

abstract class ExprImpl : ElementImpl(), Expr {
    override lateinit var type: Type
}

inline val Expr?.type get() = this?.type ?: Type.VOID


data class Var(val name: String) : ExprImpl() {
    override fun preEval() {
        type = Scope.get<VarDefine>(name).type
    }

    override fun evalImpl() = "(${type.eval()})(" +
            name +
            ")"
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

    override fun evalImpl() = "(${type.eval()})(" +
            when (value) {
                is Char -> "'$value'"
                is String -> "\"$value\""
                is Boolean -> if (value) "1" else "0"
                else -> value.toString()
            } +
            ")"
}


data class Binary(val left: Expr, val right: Expr, val operator: BinaryOp) : ExprImpl() {
    override fun evalImpl(): String {
        val leftEval = left.eval()
        val rightEval = right.eval()

        operator.check(left.type, right.type)
        type = left.type

        return "(${type.eval()})(" +
                leftEval +
                operator.eval() +
                rightEval +
                ")"
    }
}

data class Unary(val operand: Expr, val operator: UnaryOp) : ExprImpl() {
    override fun evalImpl(): String {
        val operandEval = operand.eval()

        operator.check(operand.type)
        type = operand.type

        return "(${type.eval()})(" +
                operator.eval() +
                operandEval +
                ")"
    }
}
