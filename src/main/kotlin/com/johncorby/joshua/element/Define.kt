package com.johncorby.joshua.element

import com.johncorby.joshua.Type
import com.johncorby.joshua.checkTypes

/**
 * a top-level element
 * usually tracked
 */
interface Define : Element {
    val name: String

    fun undefine() {}
}


data class FuncDefine(
    val type: Type,
    override val name: String,
    val args: List<VarDefine>,
    val block: Block
) : ElementImpl(), Define, Scoped {
    init {
        args.parent = this
        block.parent = this
    }

    override fun preEval() {
        // todo remove this later when we implement this
        check(args.all { it.init == null }) { "func args cant be initialized" }

        Scope.add(this)

        super<Scoped>.preEval()
    }

    override fun evalImpl() = "${type.eval()} $name" +
            args.eval().joinToString(",", "(", ")") +
            block.blockEval()
}


data class VarDefine(val type: Type, override val name: String, val init: Expr? = null) :
    ElementImpl(), Define, Statement {
    init {
        init?.parent = this
    }

    override fun preEval() {
        check(type != Type.VOID) { "vars cant be void type" }

        Scope.add(this)
    }

    override fun evalImpl(): String {
        val initEval = init?.eval()

        if (init?.type != null)
            checkTypes("init", init.type!!, "var", type)

        return "${type.eval()} $name" + initEval?.let { "=$it" }.orEmpty()
    }
}


/**
 * these are a special kind of [Define]
 * they dont actually allocate memory
 * rather, they will be simply stored as a type for now
 * and also a bit of extra info maybe like ctor or something idk
 *
 * todo scoping isnt the right thing to do here, things will break
 */
data class StructDefine(override val name: String, val defines: List<Define>) : ElementImpl(), Define, Scoped {
    init {
        defines.parent = this
    }

    private val vars = mutableListOf<VarDefine>()
    private val funcs = mutableListOf<FuncDefine>()

    override fun preEval() {
        defines.forEach {
            when (it) {
                is VarDefine -> vars += it.apply {
                    // todo remove this later when we implement this
                    check(init == null) { "struct members cant be initialized" }
                }
                is FuncDefine -> funcs += it.copy(
                    type = it.type,
                    name = "$name$${it.name}",
                    args = listOf(VarDefine(Type.ADDR, "this")) + it.args,
                    block = it.block
                )
                else -> error("structs can only contain vars and funcs")
            }
        }

        Scope.add(this)

        super<Scoped>.preEval()
    }

    override fun evalImpl() = "struct $name" +
            "${vars.blockEval()} ;" +
            funcs.eval().joinToString("")
}
