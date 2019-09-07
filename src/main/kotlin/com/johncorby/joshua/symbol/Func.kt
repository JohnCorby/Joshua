package com.johncorby.joshua.symbol

import com.johncorby.joshua.*

/**
 * [Symbol] that refers to callable memory address
 */
sealed class Func(val retType: Type, name: String, args: List<Ast.Statement.VarDeclare>) : Symbol(name),
    Resolvable {
    @RegFunc
    fun call(args: List<Reg>): Reg {
        // todo push args in better way using esp offsets
//        AsmString.add("sub esp, ${args.size * 4}")
        args.forEach { AsmFile.label("push $it") }

        AsmFile.label("call ${resolve()}")

        AsmFile.label("add esp, ${args.size * 4}")

        return Reg.EAX
    }

    override fun resolve() = name
}

/**
 * [Func] defined in program
 */
class InternFunc(retType: Type, name: String, args: List<Ast.Statement.VarDeclare>, block: List<Ast.Statement>) :
    Func(retType, name, args) {
    companion object {
        var current: InternFunc? = null
    }

    init {
        current = this
        AsmFile.append(
            "global ${resolve()}",
            "${resolve()}:",
            "enter 0, 0"
        )
        AsmFile.label(AsmFile.Labels.begin(this))

        args.forEach { it.eval() }
        block.forEach { it.eval() }

        symbols.get<LocalVar>().forEach { it.undefine() }

        AsmFile.label(AsmFile.Labels.end(this))
        AsmFile.append(
            "leave",
            "ret"
        )
        current = null
    }
}

/**
 * [Func] defined outside program
 */
class ExternFunc(retType: Type, name: String, args: List<Ast.Statement.VarDeclare>) : Func(retType, name, args) {
    init {
        AsmFile.label("extern ${resolve()}")
    }
}
