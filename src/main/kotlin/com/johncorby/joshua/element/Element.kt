package com.johncorby.joshua.element

import com.johncorby.joshua.Context
import com.johncorby.joshua.IO
import com.johncorby.joshua.Visitor
import com.johncorby.joshua.eprintln


typealias FilePos = Pair<Int, Int>

inline val Context.filePos get() = FilePos(start.line, start.charPositionInLine + 1)
inline val FilePos.line get() = first
inline val FilePos.char get() = second
fun FilePos.print() {
    eprintln("at $line:$char")
    eprintln(IO.inText.lines()[line - 1])
    eprintln(" ".repeat(char - 1) + "^")
}


/**
 * an element tree that is higher-level than antlr's tree
 * and performs more checks
 */
interface Element {
    val filePos: FilePos
    fun bad(message: Any?) {
        eprintln(message)
        filePos.print()
    }

    fun warn(message: Any?) = bad("warning: $message")


    val elementType: String

    fun preEval() {}
    fun postEval() {}
    fun eval() = try {
        preEval()
        val ret = evalImpl()
        postEval()
        ret
    } catch (e: IllegalStateException) {
        bad("error: ${e.message}")
        IO.errorOccurred = true
        ""
    }

    /**
     * this is the eval method to implement,
     * but the actual [eval] is the one that should be called
     */
    fun evalImpl(): String
}

/**
 * all [Element]s must also override this class,
 * which simply contains initialized variables (since interfaces cant have those).
 * this slightly reduces code rewriting.
 */
abstract class ElementImpl : Element {
    override val elementType = this::class.simpleName.toString()
    override val filePos = Visitor.ctx.filePos
}


data class Program(val defines: List<Define>) : ElementImpl() {
    override fun evalImpl() = defines
        .joinToString("") { "${it.eval()};" }
        .postProcess()

    private fun String.postProcess() = this
        .replace(";+".toRegex(), ";") // duplicate ;
        .replace("};", "}") // ; after }
        .replace("} ;", "};") // except for structs which need it
}
