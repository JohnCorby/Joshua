/**
 * misc utils
 */
package com.johncorby.joshua

import org.antlr.v4.runtime.ParserRuleContext

fun Any?.toPrintString(): String = when (this) {
    is Array<*> -> this.contentDeepToString()
    is ParserRuleContext -> this.toStringTree()
    else -> this.toString()
}

/**
 * exec command as process
 */
fun doCmd(vararg args: String) = ProcessBuilder(*args).inheritIO().start().waitFor()

/**
 * change extension of file name
 */
fun changeExt(file: String, ext: String) = file.substring(0, file.lastIndexOf('.')) + ext

/**
 * assert but raise [CompileError] instead of [AssertionError]
 */
fun assert(condition: Boolean, falseMsg: String) {
    if (!condition) throw CompileError(falseMsg)
}
