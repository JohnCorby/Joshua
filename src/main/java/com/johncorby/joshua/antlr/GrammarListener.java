// Generated from D:/Code Stuff/Joshua\Grammar.g4 by ANTLR 4.8
package com.johncorby.joshua.antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(GrammarParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(GrammarParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#cCode}.
	 * @param ctx the parse tree
	 */
	void enterCCode(GrammarParser.CCodeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#cCode}.
	 * @param ctx the parse tree
	 */
	void exitCCode(GrammarParser.CCodeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(GrammarParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(GrammarParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#funcDeclare}.
	 * @param ctx the parse tree
	 */
	void enterFuncDeclare(GrammarParser.FuncDeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#funcDeclare}.
	 * @param ctx the parse tree
	 */
	void exitFuncDeclare(GrammarParser.FuncDeclareContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(GrammarParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(GrammarParser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#varDeclare}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclare(GrammarParser.VarDeclareContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#varDeclare}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclare(GrammarParser.VarDeclareContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#varAssign}.
	 * @param ctx the parse tree
	 */
	void enterVarAssign(GrammarParser.VarAssignContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#varAssign}.
	 * @param ctx the parse tree
	 */
	void exitVarAssign(GrammarParser.VarAssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(GrammarParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(GrammarParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#untilStatement}.
	 * @param ctx the parse tree
	 */
	void enterUntilStatement(GrammarParser.UntilStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#untilStatement}.
	 * @param ctx the parse tree
	 */
	void exitUntilStatement(GrammarParser.UntilStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterVarExpr(GrammarParser.VarExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitVarExpr(GrammarParser.VarExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBinExpr(GrammarParser.BinExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBinExpr(GrammarParser.BinExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFuncExpr(GrammarParser.FuncExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code funcExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFuncExpr(GrammarParser.FuncExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUnExpr(GrammarParser.UnExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUnExpr(GrammarParser.UnExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code cExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCExpr(GrammarParser.CExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code cExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCExpr(GrammarParser.CExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code litExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLitExpr(GrammarParser.LitExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code litExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLitExpr(GrammarParser.LitExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(GrammarParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link GrammarParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(GrammarParser.ParenExprContext ctx);
}