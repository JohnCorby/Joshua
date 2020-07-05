/**
 * todo eventually, make these Elements (pass 2) so we can have custom ops
 */
package com.johncorby.joshua

enum class BinaryOp(val c: String) {
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
}

enum class UnaryOp(val c: String) {
    NEGATE("-"),
    NOT("!");


    override fun toString() = c
}
