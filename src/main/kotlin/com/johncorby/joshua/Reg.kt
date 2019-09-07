package com.johncorby.joshua

/**
 * stores register usage data
 * handles operations that use registers
 *
 * uses c calling conventions
 * scratch: eax, ecx, edx
 * preserved: ebx, esi, edi, ebp, esp
 *
 * todo use preserved and push and stuff
 * todo preserved regs start off used because they might store important values (see above)
 *
 * todo other operations
 * todo at some point, this system will need to be redesigned to work with other types besides just unsigned dwords
 */
enum class Reg(preserved: Boolean) {
    EAX(false),
    EDX(false),
    ECX(false),
    EBX(true),
    ESI(true),
    EDI(true),
    EBP(true),
    ESP(true);

    var free = true
        set(value) {
            if (field == value) throw CompilerError("old/new value of free are the same ($field)")
            field = value
        }

    @RegFunc
    fun store(to: String) {
        AsmFile.label("mov $to, $this")
        free = true
    }

    override fun toString() = super.toString().toLowerCase()

    companion object {
        private fun findFree() = values().find { it.free } ?: throw CompilerError("ran out of free regs")

        @RegFunc
        fun load(from: String): Reg {
            val to = findFree()
            AsmFile.label("mov $to, $from")
            to.free = false
            return to
        }

        @RegFunc
        fun binaryOp(left: Reg, right: Reg, op: String) = when (op) {
            "+" -> {
                AsmFile.label("add $left, $right")
                right.free = true
                left
            }
            "-" -> {
                AsmFile.label("sub $left, $right")
                right.free = true
                left
            }
            "*" -> {
                AsmFile.label("imul $left, $right")
                right.free = true
                left
            }
            else -> throw CompilerError("op $op defined but not implemented")
        }
    }
}

/**
 * annotates function that takes/returns [Reg]/s
 */
@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.FUNCTION)
@MustBeDocumented
annotation class RegFunc
