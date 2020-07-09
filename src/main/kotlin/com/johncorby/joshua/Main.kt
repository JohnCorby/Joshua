/**
 * todo
 *  do all the work on the compiler end, rather than just letting c do all the work and find all the errors.
 *  c is apparently not cool sometimes, so i shouldnt completely trust it to catch everything like that.
 *  this is my language, c is just the backend, cmon will.
 *  this also means that we'll probably PUT COMPATIBILITY WITH OTHER LANGUAGES (mainly C/C++) AT LOWER PRIORITY
 */
package com.johncorby.joshua

fun main(args: Array<String>) {
    checkc(System.getProperty("os.name").contains("windows", true)) { "must be on windows ('windows' in os.name)" }
    checkc(System.getProperty("os.arch").contains("64", true)) { "must be on 64 bit machine ('64' in os.arch)" }

    Compiler.go(args.getOrElse(0) { errorc("1 argument must be provided") })
}
