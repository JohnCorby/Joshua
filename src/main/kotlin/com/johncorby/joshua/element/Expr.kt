package com.johncorby.joshua.element

import com.johncorby.joshua.*

/**
 * if type depends on sub-elements, init type mid-eval
 * otherwise, init as constructor param or in pre-eval
 */
interface Expr : Element, Typed

/**
 * auto inits [type], less code writing
 */
abstract class ExprImpl : ElementImpl(), Expr {
    override lateinit var type: Type
}


data class Var(val name: String) : ExprImpl() {
    override fun preEval() {
        type = Scope.get<VarDefine>(name).type
    }

    override fun evalImpl() = type.cast(name)
}

data class Literal<T : Any>(val value: T) : ExprImpl() {
    override fun preEval() {
        type = when (value) {
            is Int -> Type.INT
            is Float -> Type.FLOAT
            is Boolean -> Type.BOOL
            is Char -> Type.CHAR
            is String -> Type.STRING
            else -> errorc("no type for value of class ${value.className}")
        }
    }

    override fun evalImpl() = type.cast(
        when (value) {
            is Char -> "'$value'"
            is String -> "\"$value\""
            is Boolean -> if (value) "1" else "0"
            else -> value.toString()
        }
    )
}


data class Cast(override val type: Type, val expr: Expr) : ElementImpl(), Expr, TypeChecked {
    override fun checkTypes() {
        // todo does nothing for now, just let c handle casting
    }

    override fun preEval() = checkTypes()
    override fun evalImpl() = type.cast(expr.eval())
}

data class Binary(val left: Expr, val right: Expr, val operator: BinaryOp) : ExprImpl(), TypeChecked {
    override fun checkTypes() = operator.check(left.type, right.type)
    override fun evalImpl(): String {
        val leftEval = left.eval()
        val rightEval = right.eval()

        checkTypes()
        type = left.type

        return type.cast(
            leftEval,
            operator.c,
            rightEval
        )
    }
}

data class Unary(val operand: Expr, val operator: UnaryOp) : ExprImpl(), TypeChecked {
    override fun checkTypes() = operator.check(operand.type)
    override fun evalImpl(): String {
        val operandEval = operand.eval()

        checkTypes()
        type = operand.type

        return type.cast(
            operator.c,
            operandEval
        )
    }
}
