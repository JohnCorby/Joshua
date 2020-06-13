package com.johncorby.joshua

/**
 * represents a data type
 */
enum class Type {
    BYTE,
    WORD,
    DWORD
}

/**
 * tries to convert this [String] to [Type]
 */
fun String.toType() = Type.valueOf(toUpperCase())
