@file:Suppress("MemberVisibilityCanBePrivate")

package com.johncorby.joshua

/**
 * represents a data type
 */
enum class Type(val c: String) {
    VOID("void"),


    BYTE("char"),
    UBYTE("unsigned char"),

    SHORT("short"),
    USHORT("unsigned short"),

    INT("int"),
    UINT("unsigned int"),

    LONG("long"),
    ULONG("unsigned long"),


    FLOAT("float"),

    DOUBLE("double");

    override fun toString() = c
}

/**
 * tries to convert this [String] to [Type]
 */
fun String.toType() = Type.values().find { this == it.name.toLowerCase() } ?: error("type $this doesnt exist")
