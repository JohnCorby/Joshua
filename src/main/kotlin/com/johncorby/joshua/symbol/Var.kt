package com.johncorby.joshua.symbol

import com.johncorby.joshua.AsmFile
import com.johncorby.joshua.Reg
import com.johncorby.joshua.RegFunc
import com.johncorby.joshua.Type
import kotlin.math.abs

/**
 * [Symbol] that refers to assignable memory address
 */
sealed class Var(val type: Type, name: String) : Symbol(name), Resolvable {
    private val memOfs = initMemOfs()

    abstract fun getMemBase(): String
    abstract fun initMemOfs(): Int

    @RegFunc
    open fun assign(value: Reg) = value.store(resolve())

    override fun resolve() = "${type.sizeOperand} [${getMemBase()} ${if (memOfs < 0) "-" else "+"} ${abs(memOfs)}]"
}

/**
 * [Var] of a [Func]
 */
sealed class LocalVar(type: Type, name: String, value: Reg?) : Var(type, name) {
    override fun getMemBase() = "ebp"

    init {
        value?.let { assign(it) }
    }
}

/**
 * [LocalVar] stored in stack frame of [Func]
 */
class ParamVar(type: Type, name: String, value: Reg?) : LocalVar(type, name, value) {
    override fun initMemOfs() = (1 + symbols.get<ParamVar>().size) * 4
}

/**
 * [LocalVar] stored as parameter of [Func]
 */
class FrameVar(type: Type, name: String, value: Reg?) : LocalVar(type, name, value) {
    override fun initMemOfs() = -symbols.get<FrameVar>().map { it.type.size }.sum()
}

/**
 * [Var] stored globally
 */
class GlobalVar(type: Type, name: String, value: Reg?) : Var(type, name) {
    override fun getMemBase() = "globals"
    override fun initMemOfs() = symbols.get<GlobalVar>().map { it.type.size }.sum()

    init {
        AsmFile.seek(AsmFile[AsmFile.Labels.lastGlobal])
        AsmFile.append("")
    }
}
