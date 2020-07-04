/**
 * todo eventually, make these Elements (pass 2) so we can have custom ops
 */
package com.johncorby.joshua

enum class BinaryOp(private val op: String, private val c: String = op) {
    MUL("*"),
    DIV("/"),
    MOD("%"),

    ADD("+"),
    SUB("-"),

    LT("<"),
    LTE("<="),
    GT(">"),
    GTE(">="),

    EQ("=="),
    NEQ("!=");


    override fun toString() = op
    fun eval() = c

    private fun isNumeric() = equals(MUL, DIV, MOD, ADD, SUB)
    private fun isConditional() = equals(LT, LTE, GT, GTE, EQ, NEQ)
    fun check(left: Type, right: Type) {
        when {
            isNumeric() -> check(left.isNumber() && right.isNumber())
            { "op '$this' only works for numbers (got $left and $right)" }
            isConditional() -> check(left == Type.BOOL && right == Type.BOOL)
            { "op '$this' only works for bools (got $left and $right)" }
        }
    }
}

fun String.toBinaryOp() = BinaryOp.values().find { this == it.toString() } ?: error("binary op '$this' doesnt exist")


enum class UnaryOp(private val op: String, private val c: String = op) {
    NEGATE("-"),
    NOT("!");


    override fun toString() = op
    fun eval() = c

    fun check(type: Type) = when (this) {
        NEGATE -> check(type.isNumber())
        { "op '$this' only works for numbers (got $type)" }
        NOT -> check(type == Type.BOOL)
        { "op '$this' only works for bools (got $type)" }
    }
}

fun String.toUnaryOp() = UnaryOp.values().find { this == it.toString() } ?: error("unary op '$this' doesnt exist")
