/**
 * todo re-implement elements
 * todo resolvable replacer for asm
 */
package com.johncorby.joshua

lateinit var IN_PATH: String

fun main(args: Array<String>) {
    IN_PATH = args[0]

    initAsm()
    parse()
    makeAsm()
}
