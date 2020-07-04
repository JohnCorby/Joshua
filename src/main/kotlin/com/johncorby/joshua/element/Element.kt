package com.johncorby.joshua.element

import com.johncorby.joshua.Context
import com.johncorby.joshua.FilePos
import com.johncorby.joshua.mapCatching
import kotlin.reflect.KClass


/**
 * an element tree that is higher-level than antlr's tree
 * and performs more checks
 *
 * converts to [String]s with [eval]
 * the 2nd pass
 */
interface Element {
    val elementType get() = this::class.elementType
    val ctx: Context

    fun preEval() {}
    fun postEval() {}
    fun eval(): String {
        FilePos.ctx = ctx
        preEval()
        val ret = evalImpl()
        postEval()
        return ret
    }

    /**
     * this is the eval method to implement,
     * but the actual [eval] is the one that should be called
     */
    fun evalImpl(): String
}

/**
 * all [Element]s must extend this class,
 * which simply initializes variables (since interfaces cant).
 * this slightly reduces code rewriting.
 */
abstract class ElementImpl : Element {
    override val ctx = FilePos.ctx
}

inline val KClass<out Element>.elementType get() = simpleName.toString()
fun List<Element>.eval() = mapCatching { it.eval() }


data class Program(val defines: List<Define>) : ElementImpl() {
    override fun evalImpl() = defines.eval()
        .joinToString("") { "$it;" }
        .postProcess()

    private fun String.postProcess() = this
        .replace(";+".toRegex(), ";") // duplicate ;
        .replace("};", "}") // ; after }
        .replace("} ;", "};") // except for structs which need it
}
