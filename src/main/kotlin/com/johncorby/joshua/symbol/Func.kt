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
        args.forEach { AsmString.add("push $it") }

        AsmString.add("call ${resolve()}")

        AsmString.add("add esp, ${args.size * 4}")

        return Reg.EAX
    }

    override fun resolve() = name
}

/**
 * [Func] defined in program
 */
class InternFunc(retType: Type, name: String, args: List<Ast.Statement.VarDeclare>, val block: List<Ast.Statement>) :
    Func(retType, name, args) {
    companion object {
        var current: InternFunc? = null
    }

    init {
        current = this
    }

    override fun close() {
        current = null
    }
}

/**
 * [Func] defined outside program
 */
class ExternFunc(retType: Type, name: String, args: List<Ast.Statement.VarDeclare>) : Func(retType, name, args)
