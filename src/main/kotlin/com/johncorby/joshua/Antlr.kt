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
@Suppress("UNCHECKED_CAST")
fun <T : Ast> ParseTree.visit(): T = Visitor.visit(this) as T
fun <T : Ast> List<ParseTree>.visit() = map { it.visit<T>() }

/**
 * converts antlr tree to [Ast]
 */
object Visitor : GrammarBaseVisitor<Ast>() {
    override fun visitProgram(ctx: GrammarParser.ProgramContext) =
        Program(ctx.statements.map {
            @Suppress("RemoveExplicitTypeArguments")
            it.visit<Statement>()
        })


    override fun visitCCode(ctx: GrammarParser.CCodeContext) =
        CCode(ctx.code.text.drop(1).dropLast(1).trimIndent())


    override fun visitFuncDeclare(ctx: GrammarParser.FuncDeclareContext) =
        FuncDeclare(ctx.type.text.toType(), ctx.name.text, ctx.args.visit(), ctx.block().statements.visit())

    override fun visitFuncCall(ctx: GrammarParser.FuncCallContext) =
        FuncCall(ctx.name.text, ctx.args.visit())


    override fun visitVarDeclare(ctx: GrammarParser.VarDeclareContext) =
        VarDeclare(ctx.type.text.toType(), ctx.name.text, ctx.value.visit())

    override fun visitVarAssign(ctx: GrammarParser.VarAssignContext) =
        VarAssign(ctx.name.text, ctx.value.visit())


    override fun visitIntExpr(ctx: GrammarParser.IntExprContext) =
        Literal(ctx.value.text.toInt())

    override fun visitFloatExpr(ctx: GrammarParser.FloatExprContext) =
        Literal(ctx.value.text.toFloat())

    override fun visitCharExpr(ctx: GrammarParser.CharExprContext) =
        Literal(ctx.value.text[1])

    override fun visitStrExpr(ctx: GrammarParser.StrExprContext) =
        Literal(ctx.value.text.drop(1).dropLast(1))


    override fun visitVarExpr(ctx: GrammarParser.VarExprContext) =
        Var(ctx.name.text)

    override fun visitFuncExpr(ctx: GrammarParser.FuncExprContext) =
        ctx.call.visit<FuncCall>()

    override fun visitBinExpr(ctx: GrammarParser.BinExprContext) =
        BinOp(ctx.left.visit(), ctx.right.visit(), ctx.op.text)
}
