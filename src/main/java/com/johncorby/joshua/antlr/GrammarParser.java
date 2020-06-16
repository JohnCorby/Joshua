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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, C_CODE=24, 
		INT_LITERAL=25, FLOAT_LITERAL=26, BOOL_LITERAL=27, CHAR_LITERAL=28, STR_LITERAL=29, 
		IDENT=30, WHITESPACE=31, COMMENT=32, BLOCK_COMMENT=33;
	public static final int
		RULE_program = 0, RULE_statement = 1, RULE_cCode = 2, RULE_block = 3, 
		RULE_funcDeclare = 4, RULE_funcCall = 5, RULE_varDeclare = 6, RULE_varAssign = 7, 
		RULE_iff = 8, RULE_until = 9, RULE_forr = 10, RULE_expr = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "statement", "cCode", "block", "funcDeclare", "funcCall", 
			"varDeclare", "varAssign", "iff", "until", "forr", "expr"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'('", "','", "')'", "'='", "'if'", "'else'", "'until'", 
			"'for'", "';'", "'-'", "'!'", "'*'", "'/'", "'%'", "'+'", "'<'", "'<='", 
			"'>'", "'>='", "'=='", "'!='"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			"C_CODE", "INT_LITERAL", "FLOAT_LITERAL", "BOOL_LITERAL", "CHAR_LITERAL", 
			"STR_LITERAL", "IDENT", "WHITESPACE", "COMMENT", "BLOCK_COMMENT"
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
			setState(27);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << C_CODE) | (1L << IDENT))) != 0)) {
				{
				{
				setState(24);
				((ProgramContext)_localctx).statement = statement();
				((ProgramContext)_localctx).statements.add(((ProgramContext)_localctx).statement);
				}
				}
				setState(29);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(30);
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
		public IffContext iff() {
			return getRuleContext(IffContext.class,0);
		}
		public UntilContext until() {
			return getRuleContext(UntilContext.class,0);
		}
		public ForrContext forr() {
			return getRuleContext(ForrContext.class,0);
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
			setState(40);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				cCode();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(33);
				funcDeclare();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(34);
				funcCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(35);
				varDeclare();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(36);
				varAssign();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(37);
				iff();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(38);
				until();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(39);
				forr();
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
			setState(42);
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
		enterRule(_localctx, 6, RULE_block);
		int _la;
		try {
			setState(53);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
			case T__8:
			case T__9:
			case C_CODE:
			case IDENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				((BlockContext)_localctx).statement = statement();
				((BlockContext)_localctx).statements.add(((BlockContext)_localctx).statement);
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				match(T__0);
				setState(49);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << C_CODE) | (1L << IDENT))) != 0)) {
					{
					{
					setState(46);
					((BlockContext)_localctx).statement = statement();
					((BlockContext)_localctx).statements.add(((BlockContext)_localctx).statement);
					}
					}
					setState(51);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(52);
				match(T__1);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		enterRule(_localctx, 8, RULE_funcDeclare);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			((FuncDeclareContext)_localctx).type = match(IDENT);
			setState(56);
			((FuncDeclareContext)_localctx).name = match(IDENT);
			setState(57);
			match(T__2);
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENT) {
				{
				setState(58);
				((FuncDeclareContext)_localctx).varDeclare = varDeclare();
				((FuncDeclareContext)_localctx).args.add(((FuncDeclareContext)_localctx).varDeclare);
				setState(63);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(59);
					match(T__3);
					setState(60);
					((FuncDeclareContext)_localctx).varDeclare = varDeclare();
					((FuncDeclareContext)_localctx).args.add(((FuncDeclareContext)_localctx).varDeclare);
					}
					}
					setState(65);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(68);
			match(T__4);
			setState(69);
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
			setState(71);
			((FuncCallContext)_localctx).name = match(IDENT);
			setState(72);
			match(T__2);
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__11) | (1L << T__12) | (1L << C_CODE) | (1L << INT_LITERAL) | (1L << FLOAT_LITERAL) | (1L << BOOL_LITERAL) | (1L << CHAR_LITERAL) | (1L << STR_LITERAL) | (1L << IDENT))) != 0)) {
				{
				setState(73);
				((FuncCallContext)_localctx).expr = expr(0);
				((FuncCallContext)_localctx).args.add(((FuncCallContext)_localctx).expr);
				setState(78);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(74);
					match(T__3);
					setState(75);
					((FuncCallContext)_localctx).expr = expr(0);
					((FuncCallContext)_localctx).args.add(((FuncCallContext)_localctx).expr);
					}
					}
					setState(80);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(83);
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
			setState(85);
			((VarDeclareContext)_localctx).type = match(IDENT);
			setState(86);
			((VarDeclareContext)_localctx).name = match(IDENT);
			setState(89);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__5) {
				{
				setState(87);
				match(T__5);
				setState(88);
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
			setState(91);
			((VarAssignContext)_localctx).name = match(IDENT);
			setState(92);
			match(T__5);
			setState(93);
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

	public static class IffContext extends ParserRuleContext {
		public ExprContext cond;
		public BlockContext thenBlock;
		public BlockContext elseBlock;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public IffContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iff; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterIff(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitIff(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitIff(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IffContext iff() throws RecognitionException {
		IffContext _localctx = new IffContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_iff);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(T__6);
			setState(96);
			match(T__2);
			setState(97);
			((IffContext)_localctx).cond = expr(0);
			setState(98);
			match(T__4);
			setState(99);
			((IffContext)_localctx).thenBlock = block();
			setState(102);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				{
				setState(100);
				match(T__7);
				setState(101);
				((IffContext)_localctx).elseBlock = block();
				}
				break;
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

	public static class UntilContext extends ParserRuleContext {
		public ExprContext cond;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public UntilContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_until; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterUntil(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitUntil(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitUntil(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UntilContext until() throws RecognitionException {
		UntilContext _localctx = new UntilContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_until);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(T__8);
			setState(105);
			match(T__2);
			setState(106);
			((UntilContext)_localctx).cond = expr(0);
			setState(107);
			match(T__4);
			setState(108);
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

	public static class ForrContext extends ParserRuleContext {
		public VarDeclareContext init;
		public ExprContext cond;
		public StatementContext update;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public VarDeclareContext varDeclare() {
			return getRuleContext(VarDeclareContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).enterForr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener ) ((GrammarListener)listener).exitForr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor ) return ((GrammarVisitor<? extends T>)visitor).visitForr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForrContext forr() throws RecognitionException {
		ForrContext _localctx = new ForrContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_forr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(T__9);
			setState(111);
			match(T__2);
			setState(112);
			((ForrContext)_localctx).init = varDeclare();
			setState(113);
			match(T__10);
			setState(114);
			((ForrContext)_localctx).cond = expr(0);
			setState(115);
			match(T__10);
			setState(116);
			((ForrContext)_localctx).update = statement();
			setState(117);
			match(T__4);
			setState(118);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				_localctx = new CExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(121);
				cCode();
				}
				break;
			case 2:
				{
				_localctx = new LitExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(122);
				match(INT_LITERAL);
				}
				break;
			case 3:
				{
				_localctx = new LitExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(123);
				match(FLOAT_LITERAL);
				}
				break;
			case 4:
				{
				_localctx = new LitExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(124);
				match(BOOL_LITERAL);
				}
				break;
			case 5:
				{
				_localctx = new LitExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(125);
				match(CHAR_LITERAL);
				}
				break;
			case 6:
				{
				_localctx = new LitExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(126);
				match(STR_LITERAL);
				}
				break;
			case 7:
				{
				_localctx = new VarExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(127);
				match(IDENT);
				}
				break;
			case 8:
				{
				_localctx = new FuncExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(128);
				funcCall();
				}
				break;
			case 9:
				{
				_localctx = new ParenExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(129);
				match(T__2);
				setState(130);
				expr(0);
				setState(131);
				match(T__4);
				}
				break;
			case 10:
				{
				_localctx = new UnExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(133);
				((UnExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__11 || _la==T__12) ) {
					((UnExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(134);
				expr(5);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(151);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(149);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new BinExprContext(new ExprContext(_parentctx, _parentState));
						((BinExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(137);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(138);
						((BinExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__13) | (1L << T__14) | (1L << T__15))) != 0)) ) {
							((BinExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(139);
						((BinExprContext)_localctx).right = expr(5);
						}
						break;
					case 2:
						{
						_localctx = new BinExprContext(new ExprContext(_parentctx, _parentState));
						((BinExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(140);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(141);
						((BinExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__11 || _la==T__16) ) {
							((BinExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(142);
						((BinExprContext)_localctx).right = expr(4);
						}
						break;
					case 3:
						{
						_localctx = new BinExprContext(new ExprContext(_parentctx, _parentState));
						((BinExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(143);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(144);
						((BinExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__17) | (1L << T__18) | (1L << T__19) | (1L << T__20))) != 0)) ) {
							((BinExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(145);
						((BinExprContext)_localctx).right = expr(3);
						}
						break;
					case 4:
						{
						_localctx = new BinExprContext(new ExprContext(_parentctx, _parentState));
						((BinExprContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(146);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(147);
						((BinExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__21 || _la==T__22) ) {
							((BinExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(148);
						((BinExprContext)_localctx).right = expr(2);
						}
						break;
					}
					} 
				}
				setState(153);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
		case 11:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3#\u009d\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\7\2\34\n\2\f\2\16\2\37\13\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\5\3+\n\3\3\4\3\4\3\5\3\5\3\5\7\5\62\n\5\f\5\16"+
		"\5\65\13\5\3\5\5\58\n\5\3\6\3\6\3\6\3\6\3\6\3\6\7\6@\n\6\f\6\16\6C\13"+
		"\6\5\6E\n\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\7\7O\n\7\f\7\16\7R\13\7\5"+
		"\7T\n\7\3\7\3\7\3\b\3\b\3\b\3\b\5\b\\\n\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\5\ni\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\5\r\u008a\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\7\r\u0098\n\r\f\r\16\r\u009b\13\r\3\r\2\3\30\16\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\2\7\3\2\16\17\3\2\20\22\4\2\16\16\23\23\3\2\24\27\3\2"+
		"\30\31\2\u00ad\2\35\3\2\2\2\4*\3\2\2\2\6,\3\2\2\2\b\67\3\2\2\2\n9\3\2"+
		"\2\2\fI\3\2\2\2\16W\3\2\2\2\20]\3\2\2\2\22a\3\2\2\2\24j\3\2\2\2\26p\3"+
		"\2\2\2\30\u0089\3\2\2\2\32\34\5\4\3\2\33\32\3\2\2\2\34\37\3\2\2\2\35\33"+
		"\3\2\2\2\35\36\3\2\2\2\36 \3\2\2\2\37\35\3\2\2\2 !\7\2\2\3!\3\3\2\2\2"+
		"\"+\5\6\4\2#+\5\n\6\2$+\5\f\7\2%+\5\16\b\2&+\5\20\t\2\'+\5\22\n\2(+\5"+
		"\24\13\2)+\5\26\f\2*\"\3\2\2\2*#\3\2\2\2*$\3\2\2\2*%\3\2\2\2*&\3\2\2\2"+
		"*\'\3\2\2\2*(\3\2\2\2*)\3\2\2\2+\5\3\2\2\2,-\7\32\2\2-\7\3\2\2\2.8\5\4"+
		"\3\2/\63\7\3\2\2\60\62\5\4\3\2\61\60\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2"+
		"\2\63\64\3\2\2\2\64\66\3\2\2\2\65\63\3\2\2\2\668\7\4\2\2\67.\3\2\2\2\67"+
		"/\3\2\2\28\t\3\2\2\29:\7 \2\2:;\7 \2\2;D\7\5\2\2<A\5\16\b\2=>\7\6\2\2"+
		">@\5\16\b\2?=\3\2\2\2@C\3\2\2\2A?\3\2\2\2AB\3\2\2\2BE\3\2\2\2CA\3\2\2"+
		"\2D<\3\2\2\2DE\3\2\2\2EF\3\2\2\2FG\7\7\2\2GH\5\b\5\2H\13\3\2\2\2IJ\7 "+
		"\2\2JS\7\5\2\2KP\5\30\r\2LM\7\6\2\2MO\5\30\r\2NL\3\2\2\2OR\3\2\2\2PN\3"+
		"\2\2\2PQ\3\2\2\2QT\3\2\2\2RP\3\2\2\2SK\3\2\2\2ST\3\2\2\2TU\3\2\2\2UV\7"+
		"\7\2\2V\r\3\2\2\2WX\7 \2\2X[\7 \2\2YZ\7\b\2\2Z\\\5\30\r\2[Y\3\2\2\2[\\"+
		"\3\2\2\2\\\17\3\2\2\2]^\7 \2\2^_\7\b\2\2_`\5\30\r\2`\21\3\2\2\2ab\7\t"+
		"\2\2bc\7\5\2\2cd\5\30\r\2de\7\7\2\2eh\5\b\5\2fg\7\n\2\2gi\5\b\5\2hf\3"+
		"\2\2\2hi\3\2\2\2i\23\3\2\2\2jk\7\13\2\2kl\7\5\2\2lm\5\30\r\2mn\7\7\2\2"+
		"no\5\b\5\2o\25\3\2\2\2pq\7\f\2\2qr\7\5\2\2rs\5\16\b\2st\7\r\2\2tu\5\30"+
		"\r\2uv\7\r\2\2vw\5\4\3\2wx\7\7\2\2xy\5\b\5\2y\27\3\2\2\2z{\b\r\1\2{\u008a"+
		"\5\6\4\2|\u008a\7\33\2\2}\u008a\7\34\2\2~\u008a\7\35\2\2\177\u008a\7\36"+
		"\2\2\u0080\u008a\7\37\2\2\u0081\u008a\7 \2\2\u0082\u008a\5\f\7\2\u0083"+
		"\u0084\7\5\2\2\u0084\u0085\5\30\r\2\u0085\u0086\7\7\2\2\u0086\u008a\3"+
		"\2\2\2\u0087\u0088\t\2\2\2\u0088\u008a\5\30\r\7\u0089z\3\2\2\2\u0089|"+
		"\3\2\2\2\u0089}\3\2\2\2\u0089~\3\2\2\2\u0089\177\3\2\2\2\u0089\u0080\3"+
		"\2\2\2\u0089\u0081\3\2\2\2\u0089\u0082\3\2\2\2\u0089\u0083\3\2\2\2\u0089"+
		"\u0087\3\2\2\2\u008a\u0099\3\2\2\2\u008b\u008c\f\6\2\2\u008c\u008d\t\3"+
		"\2\2\u008d\u0098\5\30\r\7\u008e\u008f\f\5\2\2\u008f\u0090\t\4\2\2\u0090"+
		"\u0098\5\30\r\6\u0091\u0092\f\4\2\2\u0092\u0093\t\5\2\2\u0093\u0098\5"+
		"\30\r\5\u0094\u0095\f\3\2\2\u0095\u0096\t\6\2\2\u0096\u0098\5\30\r\4\u0097"+
		"\u008b\3\2\2\2\u0097\u008e\3\2\2\2\u0097\u0091\3\2\2\2\u0097\u0094\3\2"+
		"\2\2\u0098\u009b\3\2\2\2\u0099\u0097\3\2\2\2\u0099\u009a\3\2\2\2\u009a"+
		"\31\3\2\2\2\u009b\u0099\3\2\2\2\17\35*\63\67ADPS[h\u0089\u0097\u0099";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}