@file:Suppress("NOTHING_TO_INLINE")

package com.johncorby.joshua

import kotlin.reflect.KClass


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


enum class Color(private val code: String) {
    RESET("\u001B[0m"),
    BLACK("\u001B[30m"),
    RED("\u001B[31m"),
    GREEN("\u001B[32m"),
    YELLOW("\u001B[33m"),
    BLUE("\u001B[34m"),
    PURPLE("\u001B[35m"),
    CYAN("\u001B[36m"),
    WHITE("\u001B[37m");

    override fun toString() = code
}
