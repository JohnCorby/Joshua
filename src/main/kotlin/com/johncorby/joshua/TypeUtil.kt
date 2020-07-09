/**
 * utils for storing/checking types
 */
@file:Suppress("NOTHING_TO_INLINE")

package com.johncorby.joshua

import com.johncorby.joshua.BinaryOp.*
import com.johncorby.joshua.Type.*
import com.johncorby.joshua.UnaryOp.NEGATE
import com.johncorby.joshua.UnaryOp.NOT
import com.johncorby.joshua.element.Element
import com.johncorby.joshua.element.Expr
import com.johncorby.joshua.element.eval

private inline fun Type.isNum() = equals(BYTE, UBYTE, SHORT, USHORT, INT, UINT, LONG, ULONG, FLOAT, DOUBLE)
private inline fun Type.isBool() = this == BOOL
private inline fun Type.isNumOrBool() = isNum() || isBool()

private inline fun BinaryOp.takesNumsOrBools() = equals(EQ, NEQ)
private inline fun BinaryOp.takesNums() = equals(MUL, DIV, MOD, ADD, SUB, LT, LTE, GT, GTE)
fun BinaryOp.check(left: Type, right: Type) {
    checkTypesSame("left", left, "right", right)

    when {
        takesNums() -> checkc(left.isNum() && right.isNum())
        { "op '$this' only works for numbers (got $left and $right)" }

        takesNumsOrBools() -> checkc(left.isNumOrBool() && right.isNumOrBool())
        { "op '$this' only works for numbers and bools (got $left and $right)" }
    }
}

fun UnaryOp.check(type: Type) = when (this) {
    NEGATE -> checkc(type.isNum())
    { "op '$this' only works for numbers (got $type)" }

    NOT -> checkc(type.isBool())
    { "op '$this' only works for bools (got $type)" }
}

/**
 * c casting boilerplate for [parts]
 */
fun Type.cast(vararg parts: String) = "($c)(${parts.joinToString("")})"


/**
 * has a type
 */
interface Typed {
    val type: Type
}

inline val List<Typed>.types get() = map { it.type }
inline val Expr?.type get() = this?.type ?: VOID

/**
 * has sub-elements who need to be type checked
 */
interface TypeChecked : Element {
    /**
     * check types of sub-elements,
     * maybe compare to own type
     *
     * NOTE: dont init own type here
     */
    fun checkTypes()

    fun Element.evalThenCheckTypes() = eval().also { checkTypes() }
    fun List<Element>.evalThenCheckTypes() = eval().also { checkTypes() }
}

inline fun checkTypesSame(firstName: String, first: Type, secondName: String, second: Type) =
    checkc(first == second) { "$firstName type $first doesnt match $secondName type $second" }

inline fun checkTypesSame(firstName: String, first: List<Type>, secondName: String, second: List<Type>) =
    (first zip second).forEach { checkTypesSame(firstName, it.first, secondName, it.second) }

inline fun checkTypeIs(name: String, type: Type, required: Type) =
    checkc(type == required) { "$name type must be $required, not $type" }
