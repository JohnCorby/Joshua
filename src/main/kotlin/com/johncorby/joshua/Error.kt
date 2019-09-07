package com.johncorby.joshua

/**
 * [Error] caused by user's program
 */
class ProgramError(message: String) : Error(message)

/**
 * [Error] caused by my compiler
 */
class CompilerError(message: String) : Error(message)
