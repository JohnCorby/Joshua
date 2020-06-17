// Generated from D:/Code Stuff/Joshua\Grammar.g4 by ANTLR 4.8
package com.johncorby.joshua.antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclare(GrammarParser.DeclareContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(GrammarParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#cCode}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCCode(GrammarParser.CCodeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(GrammarParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#funcDeclare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDeclare(GrammarParser.FuncDeclareContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#funcCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(GrammarParser.FuncCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#varDeclare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclare(GrammarParser.VarDeclareContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#varAssign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAssign(GrammarParser.VarAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#iff}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIff(GrammarParser.IffContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#until}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUntil(GrammarParser.UntilContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#forr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForr(GrammarParser.ForrContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#structDeclare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructDeclare(GrammarParser.StructDeclareContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarExpr(GrammarParser.VarExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinExpr(GrammarParser.BinExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncExpr(GrammarParser.FuncExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnExpr(GrammarParser.UnExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCExpr(GrammarParser.CExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code litExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLitExpr(GrammarParser.LitExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(GrammarParser.ParenExprContext ctx);
}