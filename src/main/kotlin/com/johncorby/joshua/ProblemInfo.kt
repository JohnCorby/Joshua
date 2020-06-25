package com.johncorby.joshua

/**
 * tracks things that are used when displaying errors
 */
object ProblemInfo {
    var pass = 0
    lateinit var ctx: Context

    fun printPos() {
        val line = ctx.start.line
        val char = ctx.start.charPositionInLine + 1

        eprintln("at $line:$char")
        eprintln(Compiler.inText.lines()[line - 1])
        eprintln(" ".repeat(char - 1) + "^")
    }
}

fun eprintln(message: Any?) = System.err.println(message)

fun warn(message: Any?) {
    eprintln("pass ${ProblemInfo.pass} warning: $message")
    ProblemInfo.printPos()
}


class Ignore : RuntimeException("ignore")

/**
 * throw error that wont be displayed
 */
fun ignore(): Nothing = throw Ignore()

inline fun <T, R> Iterable<T>.mapCatching(transform: (T) -> R): List<R> {
    val destination = ArrayList<R>()
    forEach {
        try {
            destination += transform(it)
        } catch (e: Throwable) {
            if (e !is Ignore) {
                eprintln("pass ${ProblemInfo.pass} error: ${e.message}")
                ProblemInfo.printPos()
                Compiler.queueFail()
            }
        }
    }
    return destination
}

