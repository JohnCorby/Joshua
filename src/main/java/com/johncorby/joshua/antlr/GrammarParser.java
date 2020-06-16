// Generated from D:/Code Stuff/Joshua\Grammar.g4 by ANTLR 4.8
package com.johncorby.joshua.antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, C_CODE=19, INT_LITERAL=20, FLOAT_LITERAL=21, BOOL_LITERAL=22, 
		CHAR_LITERAL=23, STR_LITERAL=24, IDENT=25, WHITESPACE=26, COMMENT=27, 
		BLOCK_COMMENT=28;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_cCode = 2, RULE_funcDeclare = 3, 
		RULE_block = 4, RULE_funcCall = 5, RULE_varDeclare = 6, RULE_varAssign = 7, 
		RULE_expr = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "cCode", "funcDeclare", "block", "funcCall", 
			"varDeclare", "varAssign", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "'{'", "'}'", "'='", "'-'", "'!'", "'*'", 
			"'/'", "'%'", "'+'", "'<'", "'<='", "'>'", "'>='", "'=='", "'!='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, "C_CODE", "INT_LITERAL", "FLOAT_LITERAL", 
			"BOOL_LITERAL", "CHAR_LITERAL", "STR_LITERAL", "IDENT", "WHITESPACE", 
			"COMMENT", "BLOCK_COMMENT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public StatementContext statement;
		public List<StatementContext> statements = new ArrayList<StatementContext>();
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==C_CODE || _la==IDENT) {
				{
				{
				setState(18);
				((ProgramContext)_localctx).statement = statement();
				((ProgramContext)_localctx).statements.add(((ProgramContext)_localctx).statement);
				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(24);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public CCodeContext cCode() {
			return getRuleContext(CCodeContext.class,0);
		}
		public FuncDeclareContext funcDeclare() {
			return getRuleContext(FuncDeclareContext.class,0);
		}
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public VarDeclareContext varDeclare() {
			return getRuleContext(VarDeclareContext.class,0);
		}
		public VarAssignContext varAssign() {
			return getRuleContext(VarAssignContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_statement);
		try {
			setState(31);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				cCode();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(27);
				funcDeclare();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(28);
				funcCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(29);
				varDeclare();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(30);
				varAssign();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CCodeContext extends ParserRuleContext {
		public TerminalNode C_CODE() { return getToken(GrammarParser.C_CODE, 0); }
		public CCodeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cCode; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCCode(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCCode(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitCCode(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CCodeContext cCode() throws RecognitionException {
		CCodeContext _localctx = new CCodeContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_cCode);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			match(C_CODE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncDeclareContext extends ParserRuleContext {
		public Token type;
		public Token name;
		public VarDeclareContext varDeclare;
		public List<VarDeclareContext> args = new ArrayList<VarDeclareContext>();
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<TerminalNode> IDENT() { return getTokens(GrammarParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(GrammarParser.IDENT, i);
		}
		public List<VarDeclareContext> varDeclare() {
			return getRuleContexts(VarDeclareContext.class);
		}
		public VarDeclareContext varDeclare(int i) {
			return getRuleContext(VarDeclareContext.class,i);
		}
		public FuncDeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcDeclare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterFuncDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitFuncDeclare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitFuncDeclare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncDeclareContext funcDeclare() throws RecognitionException {
		FuncDeclareContext _localctx = new FuncDeclareContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_funcDeclare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			((FuncDeclareContext)_localctx).type = match(IDENT);
			setState(36);
			((FuncDeclareContext)_localctx).name = match(IDENT);
			setState(37);
			match(T__0);
			setState(46);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(38);
				((FuncDeclareContext)_localctx).varDeclare = varDeclare();
				((FuncDeclareContext)_localctx).args.add(((FuncDeclareContext)_localctx).varDeclare);
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(39);
					match(T__1);
					setState(40);
					((FuncDeclareContext)_localctx).varDeclare = varDeclare();
					((FuncDeclareContext)_localctx).args.add(((FuncDeclareContext)_localctx).varDeclare);
					}
					}
					setState(45);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(48);
			match(T__2);
			setState(49);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public StatementContext statement;
		public List<StatementContext> statements = new ArrayList<StatementContext>();
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(T__3);
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==C_CODE || _la==IDENT) {
				{
				{
				setState(52);
				((BlockContext)_localctx).statement = statement();
				((BlockContext)_localctx).statements.add(((BlockContext)_localctx).statement);
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(58);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FuncCallContext extends ParserRuleContext {
		public Token name;
		public ExprContext expr;
		public List<ExprContext> args = new ArrayList<ExprContext>();
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FuncCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterFuncCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitFuncCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitFuncCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FuncCallContext funcCall() throws RecognitionException {
		FuncCallContext _localctx = new FuncCallContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_funcCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(60);
			((FuncCallContext)_localctx).name = match(IDENT);
			setState(61);
			match(T__0);
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__6) | (1L << T__7) | (1L << C_CODE) | (1L << INT_LITERAL) | (1L << FLOAT_LITERAL) | (1L << BOOL_LITERAL) | (1L << CHAR_LITERAL) | (1L << STR_LITERAL) | (1L << IDENT))) != 0)) {
				{
				setState(62);
				((FuncCallContext)_localctx).expr = expr(0);
				((FuncCallContext)_localctx).args.add(((FuncCallContext)_localctx).expr);
				setState(67);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(63);
					match(T__1);
					setState(64);
					((FuncCallContext)_localctx).expr = expr(0);
					((FuncCallContext)_localctx).args.add(((FuncCallContext)_localctx).expr);
					}
					}
					setState(69);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(72);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarDeclareContext extends ParserRuleContext {
		public Token type;
		public Token name;
		public ExprContext value;
		public List<TerminalNode> IDENT() { return getTokens(GrammarParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(GrammarParser.IDENT, i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarDeclareContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDeclare; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterVarDeclare(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitVarDeclare(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitVarDeclare(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclareContext varDeclare() throws RecognitionException {
		VarDeclareContext _localctx = new VarDeclareContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_varDeclare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			((VarDeclareContext)_localctx).type = match(IDENT);
			setState(75);
			((VarDeclareContext)_localctx).name = match(IDENT);
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(76);
				match(T__5);
				setState(77);
				((VarDeclareContext)_localctx).value = expr(0);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VarAssignContext extends ParserRuleContext {
		public Token name;
		public ExprContext value;
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarAssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varAssign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterVarAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitVarAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitVarAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarAssignContext varAssign() throws RecognitionException {
		VarAssignContext _localctx = new VarAssignContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_varAssign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			((VarAssignContext)_localctx).name = match(IDENT);
			setState(81);
			match(T__5);
			setState(82);
			((VarAssignContext)_localctx).value = expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class VarExprContext extends ExprContext {
		public TerminalNode IDENT() { return getToken(GrammarParser.IDENT, 0); }
		public VarExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterVarExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitVarExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitVarExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinExprContext extends ExprContext {
		public ExprContext left;
		public Token op;
		public ExprContext right;
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public BinExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterBinExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitBinExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitBinExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FuncExprContext extends ExprContext {
		public FuncCallContext funcCall() {
			return getRuleContext(FuncCallContext.class,0);
		}
		public FuncExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterFuncExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitFuncExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitFuncExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnExprContext extends ExprContext {
		public Token op;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UnExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterUnExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitUnExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitUnExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CExprContext extends ExprContext {
		public CCodeContext cCode() {
			return getRuleContext(CCodeContext.class,0);
		}
		public CExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterCExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitCExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitCExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LitExprContext extends ExprContext {
		public TerminalNode INT_LITERAL() { return getToken(GrammarParser.INT_LITERAL, 0); }
		public TerminalNode FLOAT_LITERAL() { return getToken(GrammarParser.FLOAT_LITERAL, 0); }
		public TerminalNode BOOL_LITERAL() { return getToken(GrammarParser.BOOL_LITERAL, 0); }
		public TerminalNode CHAR_LITERAL() { return getToken(GrammarParser.CHAR_LITERAL, 0); }
		public TerminalNode STR_LITERAL() { return getToken(GrammarParser.STR_LITERAL, 0); }
		public LitExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterLitExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitLitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitLitExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParenExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ParenExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterParenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitParenExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitParenExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new CExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(85);
				cCode();
				}
				break;
			case 2:
				{
				_localctx = new LitExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86);
				match(INT_LITERAL);
				}
				break;
			case 3:
				{
				_localctx = new LitExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(87);
				match(FLOAT_LITERAL);
				}
				break;
			case 4:
				{
				_localctx = new LitExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(88);
				match(BOOL_LITERAL);
				}
				break;
			case 5:
				{
				_localctx = new LitExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(89);
				match(CHAR_LITERAL);
				}
				break;
			case 6:
				{
				_localctx = new LitExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(90);
				match(STR_LITERAL);
				}
				break;
			case 7:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(91);
				match(IDENT);
				}
				break;
			case 8:
				{
				_localctx = new FuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(92);
				funcCall();
				}
				break;
			case 9:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(93);
				match(T__0);
				setState(94);
				expr(0);
				setState(95);
				match(T__2);
				}
				break;
			case 10:
				{
				_localctx = new UnExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(97);
				((UnExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__6 || _la==T__7) ) {
					((UnExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(98);
				expr(5);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(115);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(113);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new BinExprContext(new ExprContext(_parentctx, _parentState));
						((BinExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(101);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(102);
						((BinExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__9) | (1L << T__10))) != 0)) ) {
							((BinExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(103);
						((BinExprContext)_localctx).right = expr(5);
						}
						break;
					case 2:
						{
						_localctx = new BinExprContext(new ExprContext(_parentctx, _parentState));
						((BinExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(104);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(105);
						((BinExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__6 || _la==T__11) ) {
							((BinExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(106);
						((BinExprContext)_localctx).right = expr(4);
						}
						break;
					case 3:
						{
						_localctx = new BinExprContext(new ExprContext(_parentctx, _parentState));
						((BinExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(107);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(108);
						((BinExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) ) {
							((BinExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(109);
						((BinExprContext)_localctx).right = expr(3);
						}
						break;
					case 4:
						{
						_localctx = new BinExprContext(new ExprContext(_parentctx, _parentState));
						((BinExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(110);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(111);
						((BinExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__16 || _la==T__17) ) {
							((BinExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(112);
						((BinExprContext)_localctx).right = expr(2);
						}
						break;
					}
					} 
				}
				setState(117);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 8:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 4);
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\36y\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\7\2\26"+
		"\n\2\f\2\16\2\31\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\5\3\"\n\3\3\4\3\4\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\7\5,\n\5\f\5\16\5/\13\5\5\5\61\n\5\3\5\3\5\3\5"+
		"\3\6\3\6\7\68\n\6\f\6\16\6;\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7D\n\7"+
		"\f\7\16\7G\13\7\5\7I\n\7\3\7\3\7\3\b\3\b\3\b\3\b\5\bQ\n\b\3\t\3\t\3\t"+
		"\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nf"+
		"\n\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\7\nt\n\n\f\n\16\n"+
		"w\13\n\3\n\2\3\22\13\2\4\6\b\n\f\16\20\22\2\7\3\2\t\n\3\2\13\r\4\2\t\t"+
		"\16\16\3\2\17\22\3\2\23\24\2\u0087\2\27\3\2\2\2\4!\3\2\2\2\6#\3\2\2\2"+
		"\b%\3\2\2\2\n\65\3\2\2\2\f>\3\2\2\2\16L\3\2\2\2\20R\3\2\2\2\22e\3\2\2"+
		"\2\24\26\5\4\3\2\25\24\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2"+
		"\2\30\32\3\2\2\2\31\27\3\2\2\2\32\33\7\2\2\3\33\3\3\2\2\2\34\"\5\6\4\2"+
		"\35\"\5\b\5\2\36\"\5\f\7\2\37\"\5\16\b\2 \"\5\20\t\2!\34\3\2\2\2!\35\3"+
		"\2\2\2!\36\3\2\2\2!\37\3\2\2\2! \3\2\2\2\"\5\3\2\2\2#$\7\25\2\2$\7\3\2"+
		"\2\2%&\7\33\2\2&\'\7\33\2\2\'\60\7\3\2\2(-\5\16\b\2)*\7\4\2\2*,\5\16\b"+
		"\2+)\3\2\2\2,/\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\61\3\2\2\2/-\3\2\2\2\60(\3"+
		"\2\2\2\60\61\3\2\2\2\61\62\3\2\2\2\62\63\7\5\2\2\63\64\5\n\6\2\64\t\3"+
		"\2\2\2\659\7\6\2\2\668\5\4\3\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3"+
		"\2\2\2:<\3\2\2\2;9\3\2\2\2<=\7\7\2\2=\13\3\2\2\2>?\7\33\2\2?H\7\3\2\2"+
		"@E\5\22\n\2AB\7\4\2\2BD\5\22\n\2CA\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2"+
		"\2FI\3\2\2\2GE\3\2\2\2H@\3\2\2\2HI\3\2\2\2IJ\3\2\2\2JK\7\5\2\2K\r\3\2"+
		"\2\2LM\7\33\2\2MP\7\33\2\2NO\7\b\2\2OQ\5\22\n\2PN\3\2\2\2PQ\3\2\2\2Q\17"+
		"\3\2\2\2RS\7\33\2\2ST\7\b\2\2TU\5\22\n\2U\21\3\2\2\2VW\b\n\1\2Wf\5\6\4"+
		"\2Xf\7\26\2\2Yf\7\27\2\2Zf\7\30\2\2[f\7\31\2\2\\f\7\32\2\2]f\7\33\2\2"+
		"^f\5\f\7\2_`\7\3\2\2`a\5\22\n\2ab\7\5\2\2bf\3\2\2\2cd\t\2\2\2df\5\22\n"+
		"\7eV\3\2\2\2eX\3\2\2\2eY\3\2\2\2eZ\3\2\2\2e[\3\2\2\2e\\\3\2\2\2e]\3\2"+
		"\2\2e^\3\2\2\2e_\3\2\2\2ec\3\2\2\2fu\3\2\2\2gh\f\6\2\2hi\t\3\2\2it\5\22"+
		"\n\7jk\f\5\2\2kl\t\4\2\2lt\5\22\n\6mn\f\4\2\2no\t\5\2\2ot\5\22\n\5pq\f"+
		"\3\2\2qr\t\6\2\2rt\5\22\n\4sg\3\2\2\2sj\3\2\2\2sm\3\2\2\2sp\3\2\2\2tw"+
		"\3\2\2\2us\3\2\2\2uv\3\2\2\2v\23\3\2\2\2wu\3\2\2\2\r\27!-\609EHPesu";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}