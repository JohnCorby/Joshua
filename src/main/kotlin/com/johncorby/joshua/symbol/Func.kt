package com.johncorby.joshua.symbol

import com.johncorby.joshua.*

/**
 * [Symbol] that refers to callable memory address
 */
sealed class Func(val retType: Type, name: String, val args: List<Ast.Statement.VarDeclare>) : Symbol(name),
    Resolvable {
    @RegFunc
    fun call(args: List<Reg>): Reg {
        // todo push args in better way using esp offsets
//        AsmString.add("sub esp, ${args.size * 4}")
        args.forEach { AsmFile.add("push $it") }

        AsmFile.add("call ${resolve()}")

        AsmFile.add("add esp, ${args.size * 4}")

        return Reg.EAX
    }

    override fun resolve() = name
}

/**
 * [Func] defined in program
 */
class InternFunc(
    retType: Type,
    name: String,
    args: List<Ast.Statement.VarDeclare>,
    block: List<Ast.Statement>
) :
    Func(retType, name, args) {
    companion object {
        var current: InternFunc? = null
    }

    init {
        current = this
        AsmFile.add(
            "global ${resolve()}",
            "${resolve()}:",
            "enter 0, 0"
        )
        AsmFile.add(AsmFile.Marker.BEGIN(this))

        args.forEach { it.eval() }
        block.forEach { it.eval() }

        undefine()
    }

    override fun undefine() {
        symbols.get<ParamVar>().forEach { it.undefine() }
        symbols.get<FrameVar>().forEach { it.undefine() }

        AsmFile.add(AsmFile.Marker.END(this))
        AsmFile.add(
            "leave",
            "ret"
        )
        current = null
        super.undefine()
    }
}

/**
 * [Func] defined outside program
 */
class ExternFunc(retType: Type, name: String, args: List<Ast.Statement.VarDeclare>) : Func(retType, name, args) {
    init {
        AsmFile.add("extern ${resolve()}")
    }
}
