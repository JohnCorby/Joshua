@file:Suppress("NOTHING_TO_INLINE")

package com.johncorby.joshua

import kotlin.reflect.KClass

/**
 * convenient formatter for different types
 */
fun Any?.toPrettyString(): String = when (this) {
    is Array<*> -> this.contentDeepToString()
    is ByteArray -> contentToString()
    is ShortArray -> contentToString()
    is IntArray -> contentToString()
    is LongArray -> contentToString()
    is FloatArray -> contentToString()
    is DoubleArray -> contentToString()
    is CharArray -> contentToString()
    is BooleanArray -> contentToString()

    is Context -> toStringTree()

    is Class<*> -> this.simpleName
    is KClass<*> -> simpleName.toString()

    else -> toString()
}

inline val KClass<*>.name get() = simpleName.toString()
inline val Any.className get() = this::class.name

/**
 * create a [Process] and execute it with [args]
 */
inline fun doCommand(vararg args: String) = ProcessBuilder(*args).inheritIO().start().waitFor()

/**
 * change extension of file name
 */
inline fun String.changeExt(ext: String) = replaceAfter('.', ext)

/**
 * check if [this] equals any of the [values]
 */
inline fun Any?.equals(vararg values: Any?) = values.any { this == it }


/**
 * [MutableList] that ensures unique elements
 */
class UniqueList<E> : AbstractMutableList<E>() {
    private val list = mutableListOf<E>()
    override val size get() = list.size
    override fun add(index: Int, element: E) {
        if (element !in list) list.add(index, element)
    }

    override fun removeAt(index: Int) = list.removeAt(index)
    override fun get(index: Int) = list[index]
    override fun set(index: Int, element: E) = list[index].also {
        if (element !in list) list[index] = element
    }
}

/**
 * [MutableMap] has stores multiple values per key
 */
class MultiMap<K, V> : AbstractMutableMap<K, MutableList<V>>() {
    private val map = mutableMapOf<K, MutableList<V>>()
    override val entries get() = map.entries
    override fun put(key: K, value: MutableList<V>) = map.put(key, value)
    override fun get(key: K) = map.getOrElse(key) {
        val new = mutableListOf<V>()
        map[key] = new
        new
    }
}
