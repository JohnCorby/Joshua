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
 *
 * todo eventually, make this Element (pass 2) so we can have custom types
 */
enum class Type(private val c: String, val size: Int) {
    BYTE("signed char", 1),
    UBYTE("unsigned char", 1),
    SHORT("signed short", 2),
    USHORT("unsigned short", 2),
    INT("signed int", 4),
    UINT("unsigned int", 4),
    LONG("signed long long", 8),
    ULONG("unsigned long long", 8),

    FLOAT("signed float", 4),
    DOUBLE("signed double", 8),

    BOOL("signed char", 1),
    CHAR("char", 1),
    STRING("char*", -1),
    VOID("void", -1),

    ADDR("void*", 8);

    override fun toString() = name.toLowerCase()
    fun eval() = c

    fun isNum() = equals(BYTE, UBYTE, SHORT, USHORT, INT, UINT, LONG, ULONG, FLOAT, DOUBLE)
    fun isBool() = this == BOOL
    fun isNumOrBool() = isNum() || isBool()
}

/**
 * tries to convert this [String] to [Type]
 */
fun String.toType() = Type.values().find { this == it.toString() } ?: error("type $this doesnt exist")


fun checkTypes(firstName: String, first: Type, secondName: String, second: Type) =
    check(first == second) { "$firstName type $first doesnt match $secondName type $second" }
