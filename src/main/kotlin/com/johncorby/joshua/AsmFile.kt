package com.johncorby.joshua

import com.johncorby.joshua.symbol.Func
import com.johncorby.joshua.symbol.GlobalVar
import java.io.FileWriter

/**
 * block-based list of strings
 *
 * labels used to get blocks
 *
 * writePos controls where things are written to
 */
object AsmFile {
    private lateinit var OUT_PATH: String
    private lateinit var OUT_STREAM: FileWriter

    fun init() {
        OUT_PATH = changeExt(IN_PATH, ".asm")
        OUT_STREAM = FileWriter(OUT_PATH)

        append("globals:")
        label("globals")
    }

    fun make() {
        OUT_STREAM.write(toString())
        OUT_STREAM.close()

        // todo include as resource
        doCmd("./make.sh", OUT_PATH)
    }


    private val blocks = mutableListOf<String>()
    private val labels = mutableMapOf<String, Int>()
    private var writePos = -1

    fun append(vararg blocks: String) = blocks.forEach {
        this.blocks.add(writePos + 1, it)
        writePos++
    }

    fun overwrite(vararg blocks: String) = blocks.forEach {
        this.blocks[writePos] = it
        writePos++
    }

    fun label(label: String) {
        labels[label] = writePos
    }

    fun seek(pos: Int) {
        writePos = pos
    }

    override fun toString() = blocks.joinToString("\n")
    operator fun get(label: String) = labels[label] ?: throw CompilerError("label $label doesn't exist")

    object Labels {
        fun begin(f: Func) = "func begin $f"
        fun end(f: Func) = "func end $f"
        fun global(v: GlobalVar) = "global var $v"
        const val lastGlobal = "last global"
    }
}
