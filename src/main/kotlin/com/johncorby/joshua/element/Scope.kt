package com.johncorby.joshua.element

import kotlin.reflect.KClass

/**
 * handles scoping of [Define]s
 * and just tracking [Define]s in general
 */
object Scope {
    /**
     * map of scope level to defines
     * defines are also mapped to their names for hopefully faster access
     */
    private val scope = mutableMapOf<Int, MutableMap<String, Define>>()
    private var level = 0

    init {
        scope[0] = mutableMapOf()
    }

    fun create() {
        level++
        scope[level] = mutableMapOf()
    }

    fun destroy() {
        check(level > 0) { "cant destroy top level scope" }

        scope.remove(level)!!.values.forEach { it.undefine() }
        level--
    }


    fun add(define: Define) {
        val defines = scope[level]!!

        defines[define.name]?.run { error("$name already exists in this scope as $elementType") }

        defines[define.name] = define
    }

    operator fun <T : Define> get(type: KClass<T>, name: String): T {
        for (currentLevel in level downTo 0) {
            val defines = scope[currentLevel]!!

            val define = defines[name] ?: continue
            check(type.isInstance(define)) { "expected $name to be ${type.elementType}, but got ${define.elementType}" }
            @Suppress("UNCHECKED_CAST")
            return define as T
        }

        error("${type.elementType} $name doesnt exist in any scope")
    }

    inline operator fun <reified T : Define> get(name: String) = get(T::class, name)
}


/**
 * a function that creates and then destroys a scope
 */
interface Scoped : Element {
    override fun preEval() = Scope.create()
    override fun postEval() = Scope.destroy()
}
