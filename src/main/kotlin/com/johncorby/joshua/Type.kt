package com.johncorby.joshua

/**
 * represents a data type
 */
enum class Type(private val c: String) {
    BYTE("char"),
    UBYTE("unsigned char"),
    SHORT("short"),
    USHORT("unsigned short"),
    INT("int"),
    UINT("unsigned int"),
    LONG("long long"),
    ULONG("unsigned long long"),

    FLOAT("float"),
    DOUBLE("double"),

    BOOL("int"),

    CHAR("char"),

    STRING("char*"),

    VOID("void"),
    PTR("unsigned long long");


    override fun toString() = c
}

/**
 * tries to convert this [String] to [Type]
 */
fun String.toType() = Type.values().find { this == it.name.toLowerCase() } ?: error("type $this doesnt exist")
