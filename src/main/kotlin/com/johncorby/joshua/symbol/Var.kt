package com.johncorby.joshua.symbol

import com.johncorby.joshua.Reg
import com.johncorby.joshua.RegFunc
import com.johncorby.joshua.Type
import kotlin.math.abs

/**
 * [Symbol] that refers to assignable memory address
 */
sealed class Var(val type: Type, name: String, value: Reg?) : Symbol(name), Resolvable {
    abstract val memBase: String
    abstract val memOfs: Int

    init {
        if (value != null) init(value)
    }

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
    override val memBase = "ebp"
    override fun init(value: Reg) = assign(value)
}

/**
 * [LocalVar] stored in stack frame of [Func]
 */
class ParamVar(type: Type, name: String, value: Reg?) : LocalVar(type, name, value) {
    override val memOfs = (1 + symbols.get<ParamVar>().size) * 4
}

/**
 * [LocalVar] stored as parameter of [Func]
 */
class FrameVar(type: Type, name: String, value: Reg?) : LocalVar(type, name, value) {
    override val memOfs = -symbols.get<FrameVar>().map { it.type.size }.sum()
}

/**
 * [Var] stored globally
 */
class GlobalVar(type: Type, name: String, value: Reg?) : Var(type, name, value) {
    override val memBase = "globals"
    override val memOfs = symbols.get<GlobalVar>().map { it.type.size }.sum()

    override fun init(value: Reg) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
