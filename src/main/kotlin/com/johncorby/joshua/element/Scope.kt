package com.johncorby.joshua.element

import kotlin.reflect.KClass
import kotlin.reflect.safeCast

/**
 * handles scoping of [Define]s
 *
 * really only [VarDefine]s are able to be scoped, but we'll support all [Define]s here anyway
 * for future implementation
 */
object Scope {
    /**
     * map of scope level to defines
     * defines are also mapped to their names for hopefully faster access
     */
    val scope = mutableMapOf<Int, MutableMap<String, Define>>()
    var level = 0

    init {
        scope[level] = mutableMapOf()
    }

    fun create() {
        level++
        scope[level] = mutableMapOf()
    }

    fun destroy() {
        check(level > 0) { "cant destroy scope level 0" }

        scope.remove(level)!!.values.forEach { it.undefine() }
        level--
    }


    fun add(define: Define) {
        val varMap = scope[level]!!

        check(define.name !in varMap) { "var ${define.name} already exists at scope level $level" }
        varMap[define.name] = define
    }

    @OptIn(ExperimentalStdlibApi::class)
    operator fun <T : Define> get(type: KClass<T>, name: String): T {
        for (currentLevel in level downTo 0) {
            val defines = scope[currentLevel]!!
            val define = defines[name]
            return type.safeCast(define) ?: continue
        }

        error("${type.simpleName} $name doesnt exist in any scope")
    }
}


/**
 * a function that creates and then destroys a scope
 */
interface Scoped : Element {
    override fun preEval() = Scope.create()
    override fun postEval() = Scope.destroy()
}
