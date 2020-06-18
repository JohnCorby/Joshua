package com.johncorby.joshua

import com.johncorby.joshua.antlr.GrammarBaseVisitor
import com.johncorby.joshua.antlr.GrammarLexer
import com.johncorby.joshua.antlr.GrammarParser
import com.johncorby.joshua.antlr.GrammarParser.*
import com.johncorby.joshua.element.*
import org.antlr.v4.runtime.CharStream
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ErrorNode
import org.antlr.v4.runtime.tree.ParseTree
import org.antlr.v4.runtime.tree.TerminalNode

typealias Context = ParseTree

inline fun <reified T : Element> Context.visit() = Visitor.visit(this) as T
inline fun <reified T : Element> List<Context>.visit() = map { it.visit<T>() }

/**
 * convert this code [String] to a [Context] and then to an [Element]
 */
inline fun <reified T : Element> String.visit(contextGetter: (GrammarParser) -> Context): T {
    val stream: CharStream = CharStreams.fromString(this)
    val lexer = GrammarLexer(stream)
    val tokens = CommonTokenStream(lexer)
    val parser = GrammarParser(tokens)
    val context = contextGetter(parser)
    return context.visit()
}


/**
 * used to convert [Context]s into [Element]s
 */
object Visitor : GrammarBaseVisitor<Element>() {
    override fun visitTerminal(node: TerminalNode) = error("visted terminal node ${node.toPrettyString()}")
    override fun visitErrorNode(node: ErrorNode?) = error("visited error node ${node.toPrettyString()}")


    override fun visitProgram(ctx: ProgramContext) =
        Program(ctx.defines.visit())


    override fun visitCCode(ctx: CCodeContext) =
        CCode(ctx.text.drop(2).dropLast(2).trimIndent())


    override fun visitBlock(ctx: BlockContext) =
        Block(ctx.statements.visit())


    override fun visitFuncDefine(ctx: FuncDefineContext) =
        FuncDefine(
            ctx.type.text.toType(),
            ctx.name.text,
            ctx.args.visit(),
            ctx.block().visit()
        )

    override fun visitFuncCall(ctx: FuncCallContext) =
        FuncCall(ctx.name.text, ctx.args.visit())


    override fun visitVarDefine(ctx: VarDefineContext) =
        VarDefine(
            ctx.type.text.toType(),
            ctx.name.text,
            ctx.init?.visit()
        )

    override fun visitVarAssign(ctx: VarAssignContext) =
        VarAssign(ctx.name.text, ctx.value.visit())


    override fun visitIff(ctx: IffContext) =
        If(
            ctx.cond.visit(),
            ctx.thenBlock.visit(),
            ctx.elseBlock?.visit()
        )

    override fun visitUntil(ctx: UntilContext) =
        Until(ctx.cond.visit(), ctx.block().visit())

    override fun visitForr(ctx: ForrContext) =
        For(
            ctx.init.visit(),
            ctx.cond.visit(),
            ctx.update.visit(),
            ctx.block().visit()
        )

    override fun visitStructDefine(ctx: StructDefineContext) =
        StructDefine(ctx.name.text, ctx.defines.visit())


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
        Binary(
            ctx.left.visit(),
            ctx.right.visit(),
            ctx.op.text.toBinaryOp()
        )
}
