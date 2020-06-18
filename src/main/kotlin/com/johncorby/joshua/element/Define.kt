package com.johncorby.joshua.element

import com.johncorby.joshua.Type
import com.johncorby.joshua.warn


/**
 * a top-level element
 * usually tracked
 */
interface Define : Element {
    val name: String

    fun undefine() = warn("undefining $elementType does nothing")
}


data class FuncDefine(
    val type: Type,
    override val name: String,
    val args: List<VarDefine>,
    val block: Block
) : Define, Scoped {
    init {
        // todo remove this later when we implement this
        check(args.all { it.init == null }) { "func args cant be initialized" }
    }

    override fun evalImpl() = "${type.eval()} $name" +
            args.joinToString(",", "(", ")") { it.eval() } +
            block.eval()
}


data class VarDefine(val type: Type, override val name: String, val init: Expr? = null) : Define, Statement {
    override fun evalImpl() = "${type.eval()} $name" + init?.eval()?.let { "=$it" }.orEmpty()

    override fun preEval() = Scope.add(this)
}


/**
 * these are a special kind of [Define]
 * they dont actually allocate memory
 * rather, they will be simply stored as a type for now
 * and also a bit of extra info maybe like ctor or something idk
 */
data class StructDefine(override val name: String, val defines: List<Define>) : Define, Scoped {
    private val vars = mutableListOf<VarDefine>()
    private val funcs = mutableListOf<FuncDefine>()

    init {
        defines.forEach {
            when (it) {
                is VarDefine -> vars += it.apply {
                    // todo remove this later when we implement this
                    check(init == null) { "struct members cant be initialized" }
                }
                is FuncDefine -> funcs += it
                else -> error("structs can only contain vars and funcs")
            }
        }
    }

    override fun evalImpl() = "struct $name" +
            vars.joinToString("", "{", "} ;") { "${it.eval()};" } +
            funcs.map {
                it.copy(
                    type = it.type,
                    name = "$name$${it.name}",
                    args = listOf(VarDefine(Type.ADDR, "this")) + it.args,
                    block = it.block
                )
            }.joinToString("") { it.eval() }
}
