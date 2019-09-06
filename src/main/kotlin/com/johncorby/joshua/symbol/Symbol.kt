package com.johncorby.joshua.symbol

import java.io.Closeable
import kotlin.reflect.KClass

class SymbolMap : HashMap<Pair<KClass<out Symbol>, String>, Symbol>() {
    inline fun <reified T : Symbol> get(name: String) = get(Pair(T::class, name)) as T
    inline fun <reified T : Symbol> get() = filterKeys { it.first is T }.map { it.value as T }

    fun add(symbol: Symbol) = set(symbol.getMapKey(), symbol)
    fun remove(symbol: Symbol) = remove(symbol.getMapKey())
}

val symbols: SymbolMap = SymbolMap()
fun Symbol.getMapKey() = Pair(this::class, name)

/**
 * high-level programming element
 */
open class Symbol(val name: String) : Closeable {
    init {
        println(this)
        symbols.add(this)
    }

    override fun close() {
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
    /**
     * for debugging
     */
    override fun toString() = "${this::class}(name=$name)"
}

/**
 * [Symbol] that can be resolved to memory address without any extra assembly
 */
interface Resolvable {
    fun resolve(): String
}
