/**
 * utils for handling/displaying errors/warnings
 */
package com.johncorby.joshua

object FilePos {
    lateinit var ctx: Context

    fun print() {
        val line = ctx.start.line
        val char = ctx.start.charPositionInLine + 1

        System.err.println("at $line:$char")
        System.err.println(Compiler.inText.lines()[line - 1])
        System.err.println(" ".repeat(char - 1) + "^")
    }
}


fun warn(message: Any?) {
    System.err.println("warning: $message")
    FilePos.print()
}


/**
 * throw error that wont be displayed
 */
fun ignore(): Nothing = throw Ignore()
class Ignore : RuntimeException()


inline fun <T, R> Iterable<T>.mapCatching(transform: (T) -> R): List<R> {
    val destination = ArrayList<R>()
    forEach {
        try {
            destination += transform(it)
        } catch (e: Ignore) {
        } catch (e: IllegalStateException) {
            System.err.println("error: ${e.message}")
            FilePos.print()
            System.err.println()
            Compiler.queueFail()
        } catch (e: Throwable) {
            System.err.println("UNCAUGHT ERROR")
            e.printStackTrace()
            System.err.println()
            Compiler.queueFail()
        }
    }
    return destination
}

