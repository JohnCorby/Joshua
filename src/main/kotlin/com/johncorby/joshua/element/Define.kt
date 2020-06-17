package com.johncorby.joshua.element

import com.johncorby.joshua.Type


/**
 * an element of code that is tracked
 */
interface Define : Element {
    fun define()
    fun undefine()
}


data class FuncDefine(val type: Type, val name: String, val args: List<VarDefine>, val block: Block) : Define {
    init {
        // todo remove this later when we implement func arg initializing
        check(args.all { it.init == null }) { "func args cant be initialized" }
    }

    override fun toString() = "$type $name" +
            args.joinToString(",", "(", ")") +
            block

    override fun define() = TODO()
    override fun undefine() = error("cant undefine a func")
}


data class VarDefine(val type: Type, val name: String, val init: Expr? = null) : Define, Statement {
    override fun toString() = "$type $name" + init?.let { "=$it" }.orEmpty()

    override fun define() = TODO()
    override fun undefine() = TODO()
}


/**
 * these are a special kind of [Define]
 * they dont actually allocate memory
 * rather, they will be simply stored as a type for now
 * and also a bit of extra info maybe like ctor or something idk
 */
data class StructDefine(val name: String, val defines: List<Define>) : Define {
    private val others = mutableListOf<Define>()
    private val funcs = mutableListOf<FuncDefine>()

    init {
        defines.forEach {
            if (it is FuncDefine) funcs += it
            else others += it
        }

        // todo remove this later when we implement struct member initializing
        check(others.filterIsInstance<VarDefine>().all { it.init == null }) { "struct members cant be initialized" }
    }

    override fun toString() = "struct $name" +
            others.joinToString("", "{", "} ;") { "$it;" } +
            funcs.map {
                it.copy(
                    type = it.type,
                    name = "$name$${it.name}",
                    args = listOf(
                        VarDefine(
                            Type.ADDR,
                            "this"
                        )
                    ) + it.args,
                    block = it.block
                )
            }.joinToString("")

    override fun define() = TODO()
    override fun undefine() = TODO()
}
