package com.johncorby.joshua

import com.johncorby.joshua.antlr.GrammarBaseVisitor
import com.johncorby.joshua.antlr.GrammarLexer
import com.johncorby.joshua.antlr.GrammarParser
import com.johncorby.joshua.antlr.GrammarParser.*
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTree

/**
 * simple alias for [Visitor.visit]
 */
inline fun <reified T : Element> ParseTree.visit() = Visitor.visit(this) as T
inline fun <reified T : Element> List<ParseTree>.visit() = map { it.visit<T>() }


/**
 * convert [code] to [Element] using the appropriate context gotten using [contextGetter]
 */
inline fun <reified T : Element> parse(code: String, contextGetter: (GrammarParser) -> ParseTree): T {
    val stream: CharStream = CharStreams.fromString(code)
    val lexer = GrammarLexer(stream)
    val tokens = CommonTokenStream(lexer)
    val parser = GrammarParser(tokens)
    val context = contextGetter(parser)
    return context.visit()
}


/**
 * converts antlr tree to [Element]
 */
object Visitor : GrammarBaseVisitor<Element>() {
    override fun visitProgram(ctx: ProgramContext) =
        Program(ctx.declares.visit())


    override fun visitCCode(ctx: CCodeContext) =
        CCode(ctx.text.drop(2).dropLast(2).trimIndent())


    override fun visitBlock(ctx: BlockContext) =
        Block(ctx.statements.visit())


    override fun visitFuncDeclare(ctx: FuncDeclareContext) =
        FuncDeclare(ctx.type.text.toType(), ctx.name.text, ctx.args.visit(), ctx.block().visit())

    override fun visitFuncCall(ctx: FuncCallContext) =
        FuncCall(ctx.name.text, ctx.args.visit())


    override fun visitVarDeclare(ctx: VarDeclareContext) =
        VarDeclare(ctx.type.text.toType(), ctx.name.text, ctx.init?.visit())

    override fun visitVarAssign(ctx: VarAssignContext) =
        VarAssign(ctx.name.text, ctx.value.visit())


    override fun visitIff(ctx: IffContext) =
        If(ctx.cond.visit(), ctx.thenBlock.visit(), ctx.elseBlock?.visit())

    override fun visitUntil(ctx: UntilContext) =
        Until(ctx.cond.visit(), ctx.block().visit())

    override fun visitForr(ctx: ForrContext) =
        For(ctx.init.visit(), ctx.cond.visit(), ctx.update.visit(), ctx.block().visit())

    override fun visitStructDeclare(ctx: StructDeclareContext) =
        StructDeclare(ctx.name.text, ctx.declares.visit())


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

    override fun visitVarExpr(ctx: VarExprContext) =
        Var(ctx.text)

    override fun visitUnExpr(ctx: UnExprContext) =
        Unary(ctx.expr().visit(), ctx.op.text.toUnaryOp())

    override fun visitBinExpr(ctx: BinExprContext) =
        Binary(ctx.left.visit(), ctx.right.visit(), ctx.op.text.toBinaryOp())
}
