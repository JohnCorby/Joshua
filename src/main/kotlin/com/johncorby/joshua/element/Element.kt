package com.johncorby.joshua.element

import com.johncorby.joshua.Context
import com.johncorby.joshua.FilePos
import com.johncorby.joshua.mapCatching


/**
 * an element tree that is higher-level than antlr's tree
 * and performs more checks
 *
 * converts to [String]s with [eval]
 * the 2nd pass
 */
interface Element {
    val ctx: Context
    var parent: Element

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

abstract class ElementImpl : Element {
    override val ctx = FilePos.ctx
    override lateinit var parent: Element
}

fun List<Element>.eval() = mapCatching { it.eval() }
inline var List<Element>.parent: Element
    get() = first().parent
    set(value) = forEach { it.parent = value }


data class Program(val defines: List<Define>) : ElementImpl() {
    override var parent: Element
        get() = error("attempted to get $this.parent")
        set(value) = error("attempted to set $this.parent = $value")

    init {
        defines.parent = this
    }

    override fun evalImpl() = defines.eval()
        .joinToString("") { "$it;" }
//        .postProcess()

    private fun String.postProcess() = this
        .replace(";+".toRegex(), ";") // duplicate ;
        .replace("};", "}") // ; after }
        .replace("} ;", "};") // except for structs which need it
}
