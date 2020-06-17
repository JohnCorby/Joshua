package com.johncorby.joshua

lateinit var IN_PATH: String
lateinit var C_PATH: String

fun main(args: Array<String>) {
    require(System.getProperty("os.name").contains("windows", true)) { "must be on windows ('windows' in os.name)" }
    require(System.getProperty("os.arch").contains("64", true)) { "must be on 64 bit machine ('64' in os.arch)" }

    IN_PATH = args.getOrNull(0) ?: error("1 argument must be provided")

    OutFile
}
