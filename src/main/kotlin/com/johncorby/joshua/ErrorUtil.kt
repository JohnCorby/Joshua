/**
 * utils for handling/displaying errors/warnings
 */
@file:Suppress("NOTHING_TO_INLINE")

package com.johncorby.joshua

object FilePos {
    lateinit var ctx: Context

    fun print() {
        val line = ctx.start.line
        val char = ctx.start.charPositionInLine + 1

        println("at $line:$char")
        println(Compiler.inText.lines()[line - 1])
        println(" ".repeat(char - 1) + "^")
    }
}


fun warn(message: Any?) {
    print(Color.YELLOW)
    println("warning: $message")
    FilePos.print()
    print(Color.RESET)
}


/**
 * throw error that wont be displayed
 */
inline fun ignore(): Nothing = throw Ignore()
class Ignore : RuntimeException()


fun <T, R> Iterable<T>.mapCatching(transform: (T) -> R): List<R> {
    val destination = ArrayList<R>()
    forEach {
        try {
            destination += transform(it)
        } catch (e: Ignore) {
        } catch (e: IllegalStateException) {
            print(Color.RED)
            println("error: ${e.message}")
            FilePos.print()
            println()
            print(Color.RESET)
            Compiler.queueFail()
        } catch (e: Throwable) {
            print(Color.RED)
            println("UNCAUGHT ERROR:")
            e.printStackTrace(System.out)
            FilePos.print()
            println()
            print(Color.RESET)
            Compiler.queueFail()
        }
    }
    return destination
}

