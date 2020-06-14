package com.johncorby.joshua

import java.io.File

/**
 * represents the file that will be output
 */
object OutFile {
    init {
        OUT_PATH = IN_PATH.changeExt("c")

        makeC()
        // todo compile
    }

    /**
     * parse to C and write
     */
    fun makeC() {
        val input = File(IN_PATH).readText()
        val output = parse<Program>(input) { it.program() }.eval()

        File(OUT_PATH).writeText(output)
    }
}
