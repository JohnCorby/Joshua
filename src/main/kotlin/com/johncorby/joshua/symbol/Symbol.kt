package com.johncorby.joshua.symbol

/**
 * todo fix no duplicates problem without so much manual labor (global and local vars of same name)
 */
class Symbols : HashSet<Symbol>() {
    inline fun <reified T : Symbol> get() = filterIsInstance<T>()

    inline operator fun <reified T : Symbol> get(name: String) = get<T>().find { it.name == name }
}

val symbols: Symbols = Symbols()

/**
 * high-level programming element
 */
open class Symbol(val name: String) {
    init {
        symbols.add(this)
    }

    open fun undefine() {
        symbols.remove(this)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Symbol

        if (name != other.name) return false

        return true
    }

    override fun hashCode() = name.hashCode()
    override fun toString() = "${this::class.simpleName}($name)"
}

/**
 * [Symbol] that can be resolved to memory address without any extra assembly
 */
interface Resolvable {
    fun resolve(): String
}
