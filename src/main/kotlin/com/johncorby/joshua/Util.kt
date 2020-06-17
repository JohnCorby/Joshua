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
    is ByteArray    -> contentToString()
    is ShortArray   -> contentToString()
    is IntArray     -> contentToString()
    is LongArray    -> contentToString()
    is FloatArray   -> contentToString()
    is DoubleArray  -> contentToString()
    is CharArray    -> contentToString()
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
