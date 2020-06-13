package com.johncorby.joshua

/**
 * represents a data type
 */
enum class Type(val cType: String) {
    BYTE("unsigned char"),
    WORD("unsigned short"),
    DWORD("unsigned int"),
}

/**
 * tries to convert this [String] to [Type]
 */
fun String.toType() = Type.valueOf(toUpperCase())
