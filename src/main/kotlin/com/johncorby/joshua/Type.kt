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

    DOUBLE("double")
}

/**
 * tries to convert this [String] to [Type]
 */
fun String.toType() = try {
    Type.valueOf(toUpperCase())
} catch (e: IllegalArgumentException) {
    error("type $this doesnt exist")
}
