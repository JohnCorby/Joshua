package com.johncorby.joshua

/**
 * represents var types
 */
enum class Type(val size: Int) {
    BYTE(1),
    WORD(2),
    DWORD(4);

    val sizeOperand
        get() = when (size) {
            1 -> "byte"
            2 -> "word"
            4 -> "dword"
            else -> throw CompileError("unknown size operand $size for $this")
        }
}

fun String.toType() = Type.valueOf(toUpperCase())
