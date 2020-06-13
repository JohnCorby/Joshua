package com.johncorby.joshua

import java.io.File

/**
 * represents the file that will be output
 */
object OutFile {
    private val contents = StringBuilder()

    init {
        OUT_PATH = IN_PATH.changeExt("c")
    }

    /**
     * write to the file
     */
    fun finish() = File(OUT_PATH).writeText(contents.toString())

    /**
     * write [lines] to this [OutFile]
     */
    fun write(vararg lines: String) = lines.forEach { contents.append(it) }
}
