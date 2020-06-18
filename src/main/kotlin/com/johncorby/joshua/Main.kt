/**
 * todo
 *  do all the work on the compiler end, rather than just letting c do all the work and find all the errors.
 *  c is apparently not cool sometimes, so i shouldnt completely trust it to catch everything like that.
 *  this is my language, c is just the backend, cmon will.
 *  this also means that we'll probably PUT COMPATIBILITY WITH OTHER LANGUAGES (mainly C/C++) AT LOWER PRIORITY
 *
 * todo
 *  the next business after symbols is probably a bunch more type checking on our part (again, we do it, not c!!!)
 */
package com.johncorby.joshua

lateinit var IN_PATH: String
lateinit var C_PATH: String

fun main(args: Array<String>) {
    require(System.getProperty("os.name").contains("windows", true)) { "must be on windows ('windows' in os.name)" }
    require(System.getProperty("os.arch").contains("64", true)) { "must be on 64 bit machine ('64' in os.arch)" }

    IN_PATH = args.getOrNull(0) ?: error("1 argument must be provided")

    // makes nicer exceptions calling a function instead of using init{}
    OutFile.go()
}
