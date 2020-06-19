package com.johncorby.joshua

import com.johncorby.joshua.Visitor.visit
import com.johncorby.joshua.antlr.GrammarBaseVisitor
import com.johncorby.joshua.antlr.GrammarParser.*
import com.johncorby.joshua.element.*
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.ParseTree

typealias Context = ParserRuleContext

inline fun <reified T : Element> Context.visit() = visit(this) as T?
inline fun <reified T : Element> List<Context>.visit() = mapNotNull { it.visit<T>() }

fun BlockContext.visit() = statements.visit<Statement>()

/**
 * converts [Context]s to [Element]s
 * with [visit]
 *
 * the 1st pass
 */
object Visitor : GrammarBaseVisitor<Element?>() {
    lateinit var ctx: Context
    override fun visit(tree: ParseTree) = runCatching {
        ctx = tree as Context
        super.visit(tree)
    }.getOrElse {
        eprintln("error: ${it.message}")
        ctx.filePos.print()
        Compiler.queueFail()
        null
    }

    override fun visitProgram(ctx: ProgramContext) = Program(ctx.defines.visit())
    override fun visitFuncDefine(ctx: FuncDefineContext) = FuncDefine(
        ctx.type.text.toType(),
        ctx.name.text,
        ctx.args.visit(),
        ctx.block().visit()
    )

    override fun visitFuncCall(ctx: FuncCallContext) = FuncCall(ctx.name.text, ctx.args.visit())
    override fun visitVarDefine(ctx: VarDefineContext) = VarDefine(
        ctx.type.text.toType(),
        ctx.name.text,
        ctx.init?.visit()
    )

    override fun visitVarAssign(ctx: VarAssignContext) = VarAssign(ctx.name.text, ctx.value.visit()!!)
    override fun visitIff(ctx: IffContext) = If(
        ctx.cond.visit()!!,
        ctx.thenBlock.visit(),
        ctx.elseBlock.visit()
    )

    override fun visitUntil(ctx: UntilContext) = Until(ctx.cond.visit()!!, ctx.block().visit())
    override fun visitForr(ctx: ForrContext) = For(
        ctx.init.visit()!!,
        ctx.cond.visit()!!,
        ctx.update.visit()!!,
        ctx.block().visit()
    )

    override fun visitStructDefine(ctx: StructDefineContext) = StructDefine(ctx.name.text, ctx.defines.visit())
    override fun visitLitExpr(ctx: LitExprContext) = Literal(
        when {
            ctx.INT_LITERAL() != null -> ctx.text.toInt()
            ctx.FLOAT_LITERAL() != null -> ctx.text.toFloat()
            ctx.BOOL_LITERAL() != null -> ctx.text.toBoolean()
            ctx.CHAR_LITERAL() != null -> ctx.text[1]
            ctx.STR_LITERAL() != null -> ctx.text.drop(1).dropLast(1)
            else -> error("invalid literal ${ctx.text}")
        }
    )

    override fun visitVarExpr(ctx: VarExprContext) = Var(ctx.text)
    override fun visitUnExpr(ctx: UnExprContext) = Unary(ctx.expr().visit()!!, ctx.op.text.toUnaryOp())
    override fun visitBinExpr(ctx: BinExprContext) = Binary(
        ctx.left.visit()!!,
        ctx.right.visit()!!,
        ctx.op.text.toBinaryOp()
    )
}