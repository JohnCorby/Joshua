package com.johncorby.joshua

import com.johncorby.joshua.element.Element

enum class BinaryOp(val op: String, private val c: String = op) : Element {
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


    override fun evalImpl() = c
}

fun String.toBinaryOp() = BinaryOp.values().find { this == it.op } ?: error("binary op $this doesnt exist")


enum class UnaryOp(val op: String, private val c: String = op) : Element {
    NEGATE("-"),
    NOT("!");


    override fun evalImpl() = c
}

fun String.toUnaryOp() = UnaryOp.values().find { this == it.op } ?: error("unary op $this doesnt exist")
