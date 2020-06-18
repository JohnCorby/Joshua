package com.johncorby.joshua

/**
 * represents a data type
 *
 *
 *
 * lets not pretend, here. c data types are extremely flimsy
 * you can tell the compiler to treat any data type as any other and it will work.
 * actually, sometimes the compiler might (?) treat one type like another anyway, and youll have no idea.
 *
 * what im gonna try to do here it make it so that you have to be OBVIOUS that you want to change something
 * or that you want something flimsy for it to actually work. otherwise, it wont let you
 * maybe in SOME cases it can be okay (like float to int or something), but i might not even do that.
 * it might be annoying, but it will ensure that every time you wanna do something funky, you gotta be intentional
 */
enum class Type(private val c: String) {
    BYTE("signed char"),
    UBYTE("unsigned char"),
    SHORT("signed short"),
    USHORT("unsigned short"),
    INT("signed int"),
    UINT("unsigned int"),
    LONG("signed long long"),
    ULONG("unsigned long long"),

    FLOAT("signed float"),
    DOUBLE("signed double"),

    BOOL("int"),
    CHAR("char"),
    STRING("char*"),
    VOID("void"),


    ADDR("void*");


    fun eval() = c
}

/**
 * tries to convert this [String] to [Type]
 */
fun String.toType() = Type.values().find { this == it.name.toLowerCase() } ?: error("type $this doesnt exist")
