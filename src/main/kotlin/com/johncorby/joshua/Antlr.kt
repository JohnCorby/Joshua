package com.johncorby.joshua

import com.johncorby.joshua.antlr.GrammarBaseVisitor
import com.johncorby.joshua.antlr.GrammarLexer
import com.johncorby.joshua.antlr.GrammarParser
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.ParseTree

/**
 * converts [code] to [Ast] using the appropriate context gotten from [contextGetter]
 */
fun <T : Ast> parse(code: String, contextGetter: (GrammarParser) -> ParserRuleContext): T {
    val stream: CharStream = CharStreams.fromString(code)
    val lexer = GrammarLexer(stream)
    val tokens = CommonTokenStream(lexer)
    val parser = GrammarParser(tokens)

    @Suppress("UNCHECKED_CAST")
    return Visitor.visit(contextGetter(parser)) as T
}


/**
 * simple alias for [ParseTree.visit]
 */
inline fun <reified T : Ast> ParseTree.visit(): T = Visitor.visit(this) as T
inline fun <reified T : Ast> List<ParseTree>.visit() = map { it.visit<T>() }


/**
 * converts antlr tree to [Ast]
 */
object Visitor : GrammarBaseVisitor<Ast>() {
    override fun visitProgram(ctx: GrammarParser.ProgramContext) =
        Program(ctx.statements.visit())


    override fun visitCCode(ctx: GrammarParser.CCodeContext) =
        CCode(ctx.text.drop(2).dropLast(2).trimIndent())


    override fun visitBlock(ctx: GrammarParser.BlockContext) =
        Block(ctx.statements.visit())


    override fun visitFuncDeclare(ctx: GrammarParser.FuncDeclareContext) =
        FuncDeclare(ctx.type.text.toType(), ctx.name.text, ctx.args.visit(), ctx.block().visit())

    override fun visitFuncCall(ctx: GrammarParser.FuncCallContext) =
        FuncCall(ctx.name.text, ctx.args.visit())


    override fun visitVarDeclare(ctx: GrammarParser.VarDeclareContext) =
        VarDeclare(ctx.type.text.toType(), ctx.name.text, ctx.value.visit())

    override fun visitVarAssign(ctx: GrammarParser.VarAssignContext) =
        VarAssign(ctx.name.text, ctx.value.visit())


    override fun visitIfStatement(ctx: GrammarParser.IfStatementContext) =
        If(ctx.cond.visit(), ctx.thenBlock.visit(), ctx.elseBlock?.visit())

    override fun visitUntilStatement(ctx: GrammarParser.UntilStatementContext) =
        Until(ctx.cond.visit(), ctx.block().visit())


    override fun visitLitExpr(ctx: GrammarParser.LitExprContext) = Literal(
        when {
            ctx.INT_LITERAL() != null -> ctx.text.toInt()
            ctx.FLOAT_LITERAL() != null -> ctx.text.toFloat()
            ctx.BOOL_LITERAL() != null -> ctx.text.toBoolean()
            ctx.CHAR_LITERAL() != null -> ctx.text[1]
            ctx.STR_LITERAL() != null -> ctx.text.drop(1).dropLast(1)
            else -> error("invalid literal ${ctx.text}")
        }
    )

    override fun visitVarExpr(ctx: GrammarParser.VarExprContext) =
        Var(ctx.text)

    override fun visitUnExpr(ctx: GrammarParser.UnExprContext) =
        Unary(ctx.expr().visit(), ctx.op.text.toUnaryOp())

    override fun visitBinExpr(ctx: GrammarParser.BinExprContext) =
        Binary(ctx.left.visit(), ctx.right.visit(), ctx.op.text.toBinaryOp())
}
