package com.johncorby.joshua.element

import com.johncorby.joshua.antlr.GrammarParser
import com.johncorby.joshua.visit

/**
 * an element tree that is higher-level than antlr's tree
 * and performs more checks
 */
interface Element {
    val elementType get() = this::class.simpleName.toString()

    fun preEval() {}
    fun postEval() {}
    fun eval(): String {
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


data class Program(val defines: List<Define>) : Element {
    override fun evalImpl() = defines
        .joinToString("") { "${it.eval()};" }
        .postProcess()


    private fun String.postProcess() = this
        .replace(";+".toRegex(), ";") // duplicate ;
        .replace("};", "}") // ; after }
        .replace("} ;", "};") // except for structs which need it
}


/**
 * this is an odd element.
 * its technically every element type in order for it to be almost anywhere
 * but in reality, it's not really any of those types.
 */
data class CCode(val c: String) : Define, Statement, Expr {
    override val name = ""

    override fun evalImpl() = c.replace("<(.+?)>".toRegex()) {
        it.groupValues[1]
            .visit<Expr>(GrammarParser::expr)
            .eval()
    }
}
