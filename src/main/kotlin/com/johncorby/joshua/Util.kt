/**
 * misc utils
 */
package com.johncorby.joshua

import org.antlr.v4.runtime.tree.Tree

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

    is Tree -> toStringTree()

    else -> toString()
}

/**
 * create a [Process] and execute it with [args]
 */
fun doCommand(vararg args: String) = ProcessBuilder(*args).inheritIO().start().waitFor()

/**
 * change extension of file name
 */
fun String.changeExt(ext: String) = replaceAfter('.', ext)


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
