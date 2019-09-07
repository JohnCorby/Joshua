/**
 * handles writing and building assembly file
 */
package com.johncorby.joshua

import com.johncorby.joshua.AsmFile.Marker
import com.johncorby.joshua.AsmFile.writePos
import com.johncorby.joshua.symbol.Func
import com.johncorby.joshua.symbol.Symbol
import com.johncorby.joshua.symbol.Var
import java.io.FileWriter

lateinit var OUT_PATH: String
lateinit var OUT_STREAM: FileWriter

fun initAsm() {
    OUT_PATH = changeExt(IN_PATH, ".asm")
    OUT_STREAM = FileWriter(OUT_PATH)
}

fun makeAsm() {
    OUT_STREAM.write(AsmFile.toString())
    OUT_STREAM.close()

    // todo include as resource
    doCmd("./make.sh", OUT_PATH)
}

/**
 * line-based list of strings
 *
 * [Marker]s can be used to retrieve lines
 *
 * [writePos] can be changed to change where in the list a line is added
 *
 * todo move stuff above here
 */
object AsmFile {
    private val lines: MutableList<String> = mutableListOf()
    private val markers: MutableMap<Marker, Int> = mutableMapOf()
    /**
     * line index that's used for insertion
     */
    var writePos = 0

    /**
     * add lines
     *
     * re-split [data] in case each [String] contains newlines
     */
    fun add(vararg data: String) = data
        .joinToString("\n")
        .split("\n")
        .forEach {
            lines.add(writePos, it)
            writePos++
        }

    fun add(marker: Marker) {
        markers[marker] = writePos
    }

    operator fun get(pos: Int) = lines[pos]
    operator fun set(pos: Int, line: String) = lines.set(pos, line)

    override fun toString() = lines.joinToString("\n")

    /**
     * used to retrieve lines
     */
    sealed class Marker(val symbol: Symbol) {
        class DEFINE(`var`: Var) : Marker(`var`)
        class BEGIN(func: Func) : Marker(func)
        class END(func: Func) : Marker(func)

        fun toPos() = markers[this]!!

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Marker

            if (symbol != other.symbol) return false

            return true
        }

        override fun hashCode() = symbol.hashCode()
        override fun toString() = "${this::class.simpleName}($symbol)"
    }
}
