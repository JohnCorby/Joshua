package com.johncorby.joshua

import com.johncorby.joshua.antlr.GrammarBaseVisitor
import com.johncorby.joshua.antlr.GrammarLexer
import com.johncorby.joshua.antlr.GrammarParser
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.tree.ErrorNode

/**
 * parse [input] to ast of type [T]
 */
fun <T : Ast> parse(input: CharStream, ctx: (GrammarParser) -> ParserRuleContext): T {
    val lexer = GrammarLexer(input)
    val tokens = CommonTokenStream(lexer)
    val parser = GrammarParser(tokens)

    val tree = ctx(parser)
    @Suppress("UNCHECKED_CAST")
    return Visitor.visit(tree) as T
}

/**
 * used to convert [ParserRuleContext] to [Ast]
 */
object Visitor : GrammarBaseVisitor<Ast>() {
    // todo for some reason this isnt catching errors??????
    override fun visitErrorNode(node: ErrorNode) = throw ProgramError("parsing failed")

    override fun visitProgram(ctx: GrammarParser.ProgramContext) =
        Ast.Program(ctx.statement().map { visit(it) as Ast.Statement })

    override fun visitFuncDeclare(ctx: GrammarParser.FuncDeclareContext) = Ast.Statement.FuncDeclare(
        ctx.retType.text,
        ctx.name.text,
        ctx.funcArg().map { visit(it) as Ast.Statement.VarDeclare },
        ctx.block()?.statement()?.map { visit(it) as Ast.Statement }
    )

    override fun visitFuncArg(ctx: GrammarParser.FuncArgContext) =
        Ast.Statement.VarDeclare(ctx.argType.text, ctx.name.text, null)

    override fun visitFuncCall(ctx: GrammarParser.FuncCallContext) =
        Ast.Statement.FuncCall(ctx.name.text, ctx.args.expr().map { visit(it) as Ast.Expr })

    override fun visitVarDeclare(ctx: GrammarParser.VarDeclareContext) =
        Ast.Statement.VarDeclare(ctx.varType.text, ctx.name.text, ctx.`val`?.let { visit(it) as Ast.Expr })

    override fun visitVarAssign(ctx: GrammarParser.VarAssignContext) =
        Ast.Statement.VarAssign(ctx.name.text, visit(ctx.`val`) as Ast.Expr)

    override fun visitAsm(ctx: GrammarParser.AsmContext) = Ast.Statement.Asm(
        ctx
            .code
            .text
            .drop(1)
            .dropLast(1)
            .trimIndent()
    )

    override fun visitParenExpr(ctx: GrammarParser.ParenExprContext) = visit(ctx.expr()) as Ast.Expr

    override fun visitBinExpr(ctx: GrammarParser.BinExprContext) =
        Ast.Expr.Binary(visit(ctx.left) as Ast.Expr, visit(ctx.right) as Ast.Expr, ctx.op.text)

    override fun visitFuncExpr(ctx: GrammarParser.FuncExprContext) =
        Ast.Expr.Func(ctx.name.text, ctx.args.expr().map { visit(it) as Ast.Expr })

    override fun visitVarExpr(ctx: GrammarParser.VarExprContext) = Ast.Expr.Var(ctx.text)
    override fun visitIntExpr(ctx: GrammarParser.IntExprContext) = Ast.Expr.Int(ctx.text.toInt())
    override fun visitFloatExpr(ctx: GrammarParser.FloatExprContext) = Ast.Expr.Float(ctx.text.toFloat())
    override fun visitCharExpr(ctx: GrammarParser.CharExprContext) = Ast.Expr.Char(ctx.text[1])
    override fun visitStrExpr(ctx: GrammarParser.StrExprContext) = Ast.Expr.String(ctx.text.drop(1).dropLast(1))
}
