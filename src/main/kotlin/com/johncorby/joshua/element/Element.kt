package com.johncorby.joshua.element

import com.johncorby.joshua.FilePos
import com.johncorby.joshua.mapSafe


/**
 * an element tree that is higher-level than antlr's tree
 * and performs more checks
 *
 * converts to [String]s with [eval]
 * the 2nd pass
 */
interface Element {
    val filePos: FilePos

    fun preEval() {}
    fun postEval() {}
    fun eval(): String {
        FilePos.update(this)
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
 * auto inits [ctx], less code writing
 */
abstract class ElementImpl : Element {
    override val filePos = FilePos.current
}

fun List<Element>.eval() = mapSafe { it.eval() }


data class Program(val defines: List<Define>) : ElementImpl() {
    override fun evalImpl() = defines.eval().joinToString("") { "$it;" }
}
