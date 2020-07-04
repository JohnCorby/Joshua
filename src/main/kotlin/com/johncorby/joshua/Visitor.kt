package com.johncorby.joshua

import com.johncorby.joshua.antlr.GrammarBaseVisitor
import com.johncorby.joshua.antlr.GrammarParser.*
import com.johncorby.joshua.element.*
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.ParseTree

typealias Context = ParserRuleContext

inline fun <reified T : Element> Context.visit() = Visitor.visit(this) as T
inline fun <reified T : Element> List<Context>.visit() = mapCatching { it.visit<T>() }

fun BlockContext.visit() = statements.visit<Statement>()


/**
 * converts [Context]s to [Element]s
 * with [Visitor.visit]
 *
 * the 1st pass
 */
object Visitor : GrammarBaseVisitor<Element>() {
    override fun visit(tree: ParseTree): Element {
        FilePos.ctx = tree as Context
        return super.visit(tree) ?: ignore()
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

    override fun visitVarAssign(ctx: VarAssignContext) = VarAssign(ctx.name.text, ctx.value.visit())
    override fun visitStructDefine(ctx: StructDefineContext) = StructDefine(ctx.name.text, ctx.defines.visit())
    override fun visitIff(ctx: IffContext) = If(
        ctx.cond.visit(),
        ctx.thenBlock.visit(),
        ctx.elseBlock.visit()
    )

    override fun visitUntil(ctx: UntilContext) = Until(ctx.cond.visit(), ctx.block().visit())
    override fun visitForr(ctx: ForrContext) = For(
        ctx.init.visit(),
        ctx.cond.visit(),
        ctx.update.visit(),
        ctx.block().visit()
    )

    override fun visitRet(ctx: RetContext) = Ret(ctx.value.visit())
    override fun visitLitExpr(ctx: LitExprContext) = when {
        ctx.INT_LITERAL() != null -> Literal(ctx.text.toInt())
        ctx.FLOAT_LITERAL() != null -> Literal(ctx.text.toFloat())
        ctx.BOOL_LITERAL() != null -> Literal(ctx.text.toBoolean())
        ctx.CHAR_LITERAL() != null -> Literal(ctx.text[1])
        ctx.STR_LITERAL() != null -> Literal(ctx.text.drop(1).dropLast(1))
        else -> error("invalid literal ${ctx.text}")
    }

    override fun visitVarExpr(ctx: VarExprContext) = Var(ctx.text)
    override fun visitUnExpr(ctx: UnExprContext) = Unary(ctx.expr().visit(), ctx.op.text.toUnaryOp())
    override fun visitBinExpr(ctx: BinExprContext) = Binary(
        ctx.left.visit(),
        ctx.right.visit(),
        ctx.op.text.toBinaryOp()
    )
}
