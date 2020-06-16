package com.johncorby.joshua

enum class BinaryOp(val op: String, val c: String = op) {
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
    NEQ("!="),
}

fun String.toBinaryOp() = BinaryOp.values().find { this == it.op } ?: error("binary op $this doesnt exist")

enum class UnaryOp(val op: String, val c: String = op) {
    NEGATE("-"),
    NOT("!"),
}

fun String.toUnaryOp() = UnaryOp.values().find { this == it.op } ?: error("unary op $this doesnt exist")
