/**
 * todo eventually, make these Elements (pass 2) so we can have custom ops
 */
package com.johncorby.joshua

enum class BinaryOp(private val c: String) {
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


    override fun toString() = c
    fun eval() = c

    private fun takesNums() = equals(MUL, DIV, MOD, ADD, SUB, LT, LTE, GT, GTE)
    private fun takesNumsOrBools() = equals(EQ, NEQ)
    fun check(left: Type, right: Type) {
        check(left == right) { "types $left and $right are different" }

        when {
            takesNums() -> check(left.isNum() && right.isNum())
            { "op '$this' only works for numbers (got $left and $right)" }
            takesNumsOrBools() -> check(left.isNumOrBool() && right.isNumOrBool())
            { "op '$this' only works for numbers and bools (got $left and $right)" }
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
        NEGATE -> check(type.isNum())
        { "op '$this' only works for numbers (got $type)" }
        NOT -> check(type.isBool())
        { "op '$this' only works for bools (got $type)" }
    }
}

fun String.toUnaryOp() = UnaryOp.values().find { this == it.toString() } ?: error("unary op '$this' doesnt exist")
