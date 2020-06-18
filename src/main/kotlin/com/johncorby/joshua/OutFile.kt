package com.johncorby.joshua

import com.johncorby.joshua.antlr.GrammarParser
import com.johncorby.joshua.element.Program
import java.io.File

/**
 * represents the file that will be output
 */
object OutFile {
    fun go() {
        C_PATH = IN_PATH.changeExt("c")

        transform()
        compile()
    }

    /**
     * transform input code into c code and write it to a file
     */
    private fun transform() {
        val input = File(IN_PATH).readText()
        val program = input.visit<Program>(GrammarParser::program)
        val output = program.eval()

        File(C_PATH).writeText(output)
    }

    /**
     * compile the c program into an executable
     */
    private fun compile() {
        doCommand("make.bat", C_PATH)
    }
}
