/**
 * todo eventually, make these Elements (pass 2) so we can have custom ops
 */
package com.johncorby.joshua

enum class BinaryOp(val op: String, private val c: String = op) {
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


    fun eval() = c
}

fun String.toBinaryOp() = BinaryOp.values().find { this == it.op } ?: error("binary op $this doesnt exist")


enum class UnaryOp(val op: String, private val c: String = op) {
    NEGATE("-"),
    NOT("!");


    fun eval() = c
}

fun String.toUnaryOp() = UnaryOp.values().find { this == it.op } ?: error("unary op $this doesnt exist")
