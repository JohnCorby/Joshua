package com.johncorby.joshua.element

/**
 * handles scoping of variables
 *
 * this should be pretty easy
 * store scope LEVEL (number) in variable/as map
 * and change the level appropriately when entering/exiting scopes
 * then we can easily find variables at higher scopes by simply decreasing the level and trying to find it
 */
object VarScope {
    /**
     * map of scope level to vars
     * vars are also mapped to their names for hopefully faster access
     */
    private val scope = mutableMapOf<Int, MutableMap<String, VarDefine>>()
    private var level = 0

    init {
        scope[level] = mutableMapOf()
    }

    fun createScope(): MutableMap<String, VarDefine> {
        level++
        return mutableMapOf<String, VarDefine>().also { scope[level] = it }
    }

    fun destroyScope() {
        check(level > 0) { "cant destroy scope level 0" }

        scope.remove(level)!!.values.forEach { it.undefine() }
        level--
    }


    fun addVar(variable: VarDefine) {
        val varMap = scope[level]!!

        check(variable.name !in varMap) { "var ${variable.name} already exists at scope level $level" }
        varMap[variable.name] = variable
    }

    fun getVar(level: Int, name: String): VarDefine {
        for (currentLevel in level..0) {
            val vars = scope[level]!!
            return vars[name] ?: continue
        }

        error("var $name doesnt exist in any scope")
    }
}
