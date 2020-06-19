package com.johncorby.joshua.element

import com.johncorby.joshua.Compiler
import com.johncorby.joshua.Context
import com.johncorby.joshua.Visitor
import com.johncorby.joshua.eprintln


typealias FilePos = Pair<Int, Int>

inline val Context.filePos get() = FilePos(start.line, start.charPositionInLine + 1)
inline val FilePos.line get() = first
inline val FilePos.char get() = second
fun FilePos.print() {
    eprintln("at $line:$char")
    eprintln(Compiler.inText.lines()[line - 1])
    eprintln(" ".repeat(char - 1) + "^")
}


/**
 * an element tree that is higher-level than antlr's tree
 * and performs more checks
 *
 * converts to [String]s with [eval]
 * the 2nd pass
 */
interface Element {
    val filePos: FilePos
    fun warn(message: Any?) {
        eprintln("warning: $message")
        filePos.print()
    }


    val elementType get() = this::class.simpleName.toString()

    fun preEval() {}
    fun postEval() {}
    fun eval() = runCatching {
        preEval()
        val ret = evalImpl()
        postEval()
        ret
    }.getOrElse {
        eprintln("error: ${it.message}")
        filePos.print()
        Compiler.queueFail()
        null
    }

    /**
     * this is the eval method to implement,
     * but the actual [blockEval] is the one that should be called
     */
    fun evalImpl(): String
}

/**
 * all [Element]s must extend this class,
 * which simply initializes variables (since interfaces cant).
 * this slightly reduces code rewriting.
 */
abstract class ElementImpl : Element {
    override val filePos = Visitor.ctx.filePos
}

fun List<Element>.eval() = mapNotNull { it.eval() }




data class Program(val defines: List<Define>) : ElementImpl() {
    override fun evalImpl() = defines.eval()
        .joinToString("") { "$it;" }
        .postProcess()

    private fun String.postProcess() = this
        .replace(";+".toRegex(), ";") // duplicate ;
        .replace("};", "}") // ; after }
        .replace("} ;", "};") // except for structs which need it
}
