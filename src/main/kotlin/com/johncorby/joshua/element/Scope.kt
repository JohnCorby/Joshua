package com.johncorby.joshua.element

import com.johncorby.joshua.className
import com.johncorby.joshua.name
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
    private val scope = mutableListOf(mutableMapOf<String, Define>())
    private inline val level get() = scope.lastIndex

    fun create() {
        scope += mutableMapOf()
    }

    fun destroy() {
        check(level > 0) { "cant destroy top level scope" }

        val defMap = scope.removeAt(level)
        defMap.values.forEach { it.undefine() }
    }


    fun add(define: Define) {
        val defMap = scope[level]

        defMap[define.name]?.run { error("${define.name} already exists in this scope as $className") }

        defMap[define.name] = define
    }

    operator fun <T : Define> get(clazz: KClass<T>, name: String): T {
        for (currentLevel in level downTo 0) {
            val defMap = scope[currentLevel]

            val define = defMap[name] ?: continue
            check(clazz.isInstance(define)) { "expected $name to be ${clazz.name}, but got ${define.className}" }
            @Suppress("UNCHECKED_CAST")
            return define as T
        }

        error("${clazz.name} $name doesnt exist in any scope")
    }

    inline operator fun <reified T : Define> get(name: String) = get(T::class, name)
}


/**
 * an [Element] that creates and then destroys a scope
 */
interface Scoped : Element {
    override fun preEval() = Scope.create()
    override fun postEval() = Scope.destroy()
}
