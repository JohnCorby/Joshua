package com.johncorby.joshua.symbol

import com.johncorby.joshua.Reg
import com.johncorby.joshua.RegFunc
import com.johncorby.joshua.Type
import kotlin.math.abs

/**
 * [Symbol] that refers to assignable memory address
 */
sealed class Var(val type: Type, name: String, value: Reg?) : Symbol(name), Resolvable {
    private val memBase: String = initMemBase()
    private val memOfs: Int = initMemOfs()

    init {
        if (value != null) init(value)
    }

    abstract fun initMemBase(): String
    abstract fun initMemOfs(): Int

    @RegFunc
    abstract fun init(value: Reg)

    @RegFunc
    fun assign(value: Reg) = value.store(resolve())

    override fun resolve() = "${type.sizeOperand} [$memBase ${if (memOfs < 0) "-" else "+"} ${abs(memOfs)}]"
}

/**
 * [Var] of a [Func]
 */
sealed class LocalVar(type: Type, name: String, value: Reg?) : Var(type, name, value) {
    override fun initMemBase() = "ebp"

    override fun init(value: Reg) = assign(value)
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
class GlobalVar(type: Type, name: String, value: Reg?) : Var(type, name, value) {
    override fun initMemBase() = "globals"
    override fun initMemOfs() = symbols.get<GlobalVar>().map { it.type.size }.sum()

    override fun init(value: Reg) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
