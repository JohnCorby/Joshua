package com.johncorby.joshua

import java.io.File

/**
 * represents the file that will be output
 */
object OutFile {
    init {
        C_PATH = IN_PATH.changeExt("c")

        transform()
        compile()
    }

    /**
     * transform input code into c code and write it to a file
     */
    private fun transform() {
        val input = File(IN_PATH).readText()
        val output = parse<Program>(input) { it.program() }.eval()

        File(C_PATH).writeText(output)
    }

    /**
     * compile the c program into an executable
     */
    private fun compile() {
        doCommand("make.bat", C_PATH)
    }
}
