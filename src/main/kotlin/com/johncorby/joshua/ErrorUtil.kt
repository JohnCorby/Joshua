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

class CompileError(s: String) : IllegalStateException(s)
class Ignore : IllegalStateException()

inline fun errorc(message: Any): Nothing = throw CompileError(message.toString())
inline fun checkc(value: Boolean, lazyMessage: () -> Any) {
    if (!value) throw CompileError(lazyMessage().toString())
}

inline fun ignore(): Nothing = throw Ignore()


inline fun <R> runSafe(block: () -> R): R? {
    try {
        return block()
    } catch (e: Ignore) {
    } catch (e: CompileError) {
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
    return null
}

fun <T, R> Iterable<T>.mapSafe(transform: (T) -> R): List<R> {
    val destination = ArrayList<R>()
    for (item in this) runSafe { destination += transform(item) }
    return destination
}

