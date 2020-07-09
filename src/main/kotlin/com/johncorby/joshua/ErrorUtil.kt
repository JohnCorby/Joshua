/**
 * utils for handling/displaying errors/warnings
 */
@file:Suppress("NOTHING_TO_INLINE")

package com.johncorby.joshua

import com.johncorby.joshua.element.Element
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.Token
import org.antlr.v4.runtime.tree.Tree

class FilePos private constructor(val line: Int, val char: Int) {
    override fun toString() = "$line:$char"

    companion object {
        lateinit var current: FilePos

        inline fun update(element: Element) {
            current = element.filePos
        }

        fun update(tree: Tree) = when (val payload = tree.payload) {
            is ParserRuleContext -> update(payload.start)
            is Token -> update(payload)
            else -> errorc("cant update filepos using ${tree.className} (${tree.toStringTree()})")
        }

        private inline fun update(token: Token) {
            current = FilePos(token.line, token.charPositionInLine + 1)
        }

        fun print() = with(current) {
            println("at $current")
            println(Compiler.inText.lines()[line - 1])
            println(" ".repeat(char - 1) + "^")
        }
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


inline fun <R> runSafe(block: () -> R) {
    try {
        block()
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
}

fun <T, R> Iterable<T>.mapSafe(transform: (T) -> R): List<R> {
    val destination = ArrayList<R>()
    for (item in this) runSafe { destination += transform(item) }
    return destination
}

