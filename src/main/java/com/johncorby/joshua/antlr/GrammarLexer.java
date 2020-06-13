// Generated from D:/Code Stuff/Joshua\Grammar.g4 by ANTLR 4.8
package com.johncorby.joshua.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, INT_LITERAL=13, FLOAT_LITERAL=14, CHAR_LITERAL=15, 
		STR_LITERAL=16, IDENT=17, WHITESPACE=18, COMMENT=19, BLOCK_COMMENT=20;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "INT_LITERAL", "FLOAT_LITERAL", "CHAR_LITERAL", 
			"STR_LITERAL", "IDENT", "WHITESPACE", "COMMENT", "BLOCK_COMMENT", "DIGIT", 
			"LETTER", "NEWLINE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'c'", "'('", "','", "')'", "'{'", "'}'", "'='", "'*'", "'/'", 
			"'%'", "'+'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "INT_LITERAL", "FLOAT_LITERAL", "CHAR_LITERAL", "STR_LITERAL", 
			"IDENT", "WHITESPACE", "COMMENT", "BLOCK_COMMENT"
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\26\u00a5\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2"+
		"\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3"+
		"\13\3\13\3\f\3\f\3\r\3\r\3\16\5\16K\n\16\3\16\6\16N\n\16\r\16\16\16O\3"+
		"\17\3\17\5\17T\n\17\3\17\7\17W\n\17\f\17\16\17Z\13\17\3\17\3\17\6\17^"+
		"\n\17\r\17\16\17_\5\17b\n\17\3\20\3\20\3\20\3\20\3\21\3\21\7\21j\n\21"+
		"\f\21\16\21m\13\21\3\21\3\21\3\22\3\22\5\22s\n\22\3\22\3\22\3\22\7\22"+
		"x\n\22\f\22\16\22{\13\22\3\23\3\23\6\23\177\n\23\r\23\16\23\u0080\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\7\24\u0089\n\24\f\24\16\24\u008c\13\24\3\24"+
		"\3\24\3\24\3\24\3\25\3\25\3\25\3\25\7\25\u0096\n\25\f\25\16\25\u0099\13"+
		"\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\5k\u008a\u0097"+
		"\2\31\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\2-\2/\2\3\2\6\4\2\13\13\"\"\3\2\62;\4"+
		"\2C\\c|\4\2\f\f\17\17\2\u00b0\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3"+
		"\61\3\2\2\2\5\63\3\2\2\2\7\65\3\2\2\2\t\67\3\2\2\2\139\3\2\2\2\r;\3\2"+
		"\2\2\17=\3\2\2\2\21?\3\2\2\2\23A\3\2\2\2\25C\3\2\2\2\27E\3\2\2\2\31G\3"+
		"\2\2\2\33J\3\2\2\2\35a\3\2\2\2\37c\3\2\2\2!g\3\2\2\2#r\3\2\2\2%~\3\2\2"+
		"\2\'\u0084\3\2\2\2)\u0091\3\2\2\2+\u009f\3\2\2\2-\u00a1\3\2\2\2/\u00a3"+
		"\3\2\2\2\61\62\7e\2\2\62\4\3\2\2\2\63\64\7*\2\2\64\6\3\2\2\2\65\66\7."+
		"\2\2\66\b\3\2\2\2\678\7+\2\28\n\3\2\2\29:\7}\2\2:\f\3\2\2\2;<\7\177\2"+
		"\2<\16\3\2\2\2=>\7?\2\2>\20\3\2\2\2?@\7,\2\2@\22\3\2\2\2AB\7\61\2\2B\24"+
		"\3\2\2\2CD\7\'\2\2D\26\3\2\2\2EF\7-\2\2F\30\3\2\2\2GH\7/\2\2H\32\3\2\2"+
		"\2IK\7/\2\2JI\3\2\2\2JK\3\2\2\2KM\3\2\2\2LN\5+\26\2ML\3\2\2\2NO\3\2\2"+
		"\2OM\3\2\2\2OP\3\2\2\2P\34\3\2\2\2Qb\5\33\16\2RT\7/\2\2SR\3\2\2\2ST\3"+
		"\2\2\2TX\3\2\2\2UW\5+\26\2VU\3\2\2\2WZ\3\2\2\2XV\3\2\2\2XY\3\2\2\2Y[\3"+
		"\2\2\2ZX\3\2\2\2[]\7\60\2\2\\^\5+\26\2]\\\3\2\2\2^_\3\2\2\2_]\3\2\2\2"+
		"_`\3\2\2\2`b\3\2\2\2aQ\3\2\2\2aS\3\2\2\2b\36\3\2\2\2cd\7)\2\2de\13\2\2"+
		"\2ef\7)\2\2f \3\2\2\2gk\7$\2\2hj\13\2\2\2ih\3\2\2\2jm\3\2\2\2kl\3\2\2"+
		"\2ki\3\2\2\2ln\3\2\2\2mk\3\2\2\2no\7$\2\2o\"\3\2\2\2ps\5-\27\2qs\7a\2"+
		"\2rp\3\2\2\2rq\3\2\2\2sy\3\2\2\2tx\5+\26\2ux\5-\27\2vx\7a\2\2wt\3\2\2"+
		"\2wu\3\2\2\2wv\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z$\3\2\2\2{y\3\2\2"+
		"\2|\177\t\2\2\2}\177\5/\30\2~|\3\2\2\2~}\3\2\2\2\177\u0080\3\2\2\2\u0080"+
		"~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\b\23\2\2"+
		"\u0083&\3\2\2\2\u0084\u0085\7\61\2\2\u0085\u0086\7\61\2\2\u0086\u008a"+
		"\3\2\2\2\u0087\u0089\13\2\2\2\u0088\u0087\3\2\2\2\u0089\u008c\3\2\2\2"+
		"\u008a\u008b\3\2\2\2\u008a\u0088\3\2\2\2\u008b\u008d\3\2\2\2\u008c\u008a"+
		"\3\2\2\2\u008d\u008e\5/\30\2\u008e\u008f\3\2\2\2\u008f\u0090\b\24\2\2"+
		"\u0090(\3\2\2\2\u0091\u0092\7\61\2\2\u0092\u0093\7,\2\2\u0093\u0097\3"+
		"\2\2\2\u0094\u0096\13\2\2\2\u0095\u0094\3\2\2\2\u0096\u0099\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0097\u0095\3\2\2\2\u0098\u009a\3\2\2\2\u0099\u0097\3\2"+
		"\2\2\u009a\u009b\7,\2\2\u009b\u009c\7\61\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\u009e\b\25\2\2\u009e*\3\2\2\2\u009f\u00a0\t\3\2\2\u00a0,\3\2\2\2\u00a1"+
		"\u00a2\t\4\2\2\u00a2.\3\2\2\2\u00a3\u00a4\t\5\2\2\u00a4\60\3\2\2\2\21"+
		"\2JOSX_akrwy~\u0080\u008a\u0097\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}