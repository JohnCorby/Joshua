package com.johncorby.joshua

/**
 * represents a data type
 */
enum class Type(val c: String) {
    VOID("void"),


    I8("char"),
    UI8("unsigned char"),

    I16("short"),
    UI16("unsigned short"),

    I32("int"),
    UI32("unsigned int"),

    I64("long"),
    UI64("unsigned long"),


    F32("float"),

    F64("double")

}

/**
 * tries to convert this [String] to [Type]
 */
fun String.toType() = Type.valueOf(toUpperCase())
