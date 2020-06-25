package com.johncorby.joshua

import com.johncorby.joshua.antlr.GrammarLexer
import com.johncorby.joshua.antlr.GrammarParser
import com.johncorby.joshua.element.Program
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File
import kotlin.system.exitProcess

/**
 * handles input and output files/text
 */
object Compiler {
    lateinit var inPath: String
    lateinit var inText: String

    lateinit var outPath: String
    lateinit var outText: String

    fun go(inPath: String) {
        this.inPath = inPath
        outPath = inPath.changeExt("c")

        transform()
        compile()
    }

    /**
     * transform input code into c code and write it to a file
     */
    private fun transform() {
        inText = File(inPath).readText()

        val stream = CharStreams.fromString(inText)
        val lexer = GrammarLexer(stream)
        val tokens = CommonTokenStream(lexer)
        val parser = GrammarParser(tokens)
        val context = parser.program()

        ProblemInfo.pass = 1
        val element = context.visit<Program>()
        ProblemInfo.pass = 2
        outText = element.eval()
        failIfQueued()

        File(outPath).writeText(outText)
    }

    /**
     * compile the c program into an executable
     */
    private fun compile() {
        if (doCommand("make.bat", outPath) != 0) fail()
    }


    private var failQueued = false
    fun queueFail() {
        failQueued = true
    }

    private fun failIfQueued() {
        if (failQueued) fail()
    }

    private fun fail() {
        exitProcess(1)
    }
}
