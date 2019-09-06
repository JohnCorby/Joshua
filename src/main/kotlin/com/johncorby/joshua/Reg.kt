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

    // preserved regs start off used because they might store important values
    var free = !preserved
        set(value) {
            assert(field != value, "old free and new free are the same ($field)")
            field = value
        }

    @RegFunc
    fun store(to: String) {
        AsmString.add("mov $to, $this")
        free = true
    }

    companion object {
        private fun findFree() = values().firstOrNull(Reg::free) ?: throw CompileError("ran out of free regs")

        @RegFunc
        fun load(from: String): Reg {
            val to = findFree()
            AsmString.add("mov $to, $from")
            to.free = false
            return to
        }

        @RegFunc
        fun binaryOp(left: Reg, right: Reg, op: String) = when (op) {
            "+" -> {
                AsmString.add("add $left, $right")
                right.free = true
                left
            }
            "-" -> {
                AsmString.add("sub $left, $right")
                right.free = true
                left
            }
            "*" -> {
                AsmString.add("imul $left, $right")
                right.free
                left
            }
            else -> throw CompileError("op $op defined but not implemented")
        }
    }
}

/**
 * annotates function that takes/returns [Reg]/s
 */
@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.FUNCTION)
annotation class RegFunc
