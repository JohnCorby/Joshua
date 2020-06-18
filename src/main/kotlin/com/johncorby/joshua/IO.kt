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
object IO {
    lateinit var inpath: String
    lateinit var inText: String

    lateinit var outPath: String
    lateinit var outText: String

    var errorOccurred = false

    fun go(inPath: String) {
        inpath = inPath
        outPath = this.inpath.changeExt("c")

        transform()
        compile()
    }

    /**
     * transform input code into c code and write it to a file
     */
    private fun transform() {
        inText = File(inpath).readText()

        val stream = CharStreams.fromString(inText)
        val lexer = GrammarLexer(stream)
        val tokens = CommonTokenStream(lexer)
        val parser = GrammarParser(tokens)
        val context = parser.program()
        val element = context.visit<Program>()
        outText = element.eval()
        if (errorOccurred) exitProcess(1)

        File(outPath).writeText(outText)
    }

    /**
     * compile the c program into an executable
     */
    private fun compile() {
        errorOccurred = doCommand("make.bat", outPath) != 0
        if (errorOccurred) exitProcess(1)
    }
}
