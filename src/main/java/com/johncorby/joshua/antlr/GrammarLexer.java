// Generated from /media/johncorby/Shared/Code Stuff/Joshua/Grammar.g4 by ANTLR 4.7.2
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
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, INT_LITERAL=14, FLOAT_LITERAL=15, 
		CHAR_LITERAL=16, STR_LITERAL=17, IDENT=18, WHITESPACE=19, COMMENT=20, 
		BLOCK_COMMENT=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "INT_LITERAL", "FLOAT_LITERAL", "CHAR_LITERAL", 
			"STR_LITERAL", "IDENT", "WHITESPACE", "COMMENT", "BLOCK_COMMENT", "DIGIT", 
			"LETTER", "NEWLINE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "';'", "'{'", "'}'", "'='", "'asm'", "'*'", 
			"'/'", "'%'", "'+'", "'-'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "INT_LITERAL", "FLOAT_LITERAL", "CHAR_LITERAL", "STR_LITERAL", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\27\u00ab\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\5\17Q\n\17\3"+
		"\17\6\17T\n\17\r\17\16\17U\3\20\3\20\5\20Z\n\20\3\20\7\20]\n\20\f\20\16"+
		"\20`\13\20\3\20\3\20\6\20d\n\20\r\20\16\20e\5\20h\n\20\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\7\22p\n\22\f\22\16\22s\13\22\3\22\3\22\3\23\3\23\5\23"+
		"y\n\23\3\23\3\23\3\23\7\23~\n\23\f\23\16\23\u0081\13\23\3\24\3\24\6\24"+
		"\u0085\n\24\r\24\16\24\u0086\3\24\3\24\3\25\3\25\3\25\3\25\7\25\u008f"+
		"\n\25\f\25\16\25\u0092\13\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\7"+
		"\26\u009c\n\26\f\26\16\26\u009f\13\26\3\26\3\26\3\26\3\26\3\26\3\27\3"+
		"\27\3\30\3\30\3\31\3\31\5q\u0090\u009d\2\32\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\2/\2\61\2\3\2\6\4\2\13\13\"\"\3\2\62;\4\2C\\c|\4\2\f\f\17\17\2\u00b6"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\3\63\3\2\2\2\5\65\3"+
		"\2\2\2\7\67\3\2\2\2\t9\3\2\2\2\13;\3\2\2\2\r=\3\2\2\2\17?\3\2\2\2\21A"+
		"\3\2\2\2\23E\3\2\2\2\25G\3\2\2\2\27I\3\2\2\2\31K\3\2\2\2\33M\3\2\2\2\35"+
		"P\3\2\2\2\37g\3\2\2\2!i\3\2\2\2#m\3\2\2\2%x\3\2\2\2\'\u0084\3\2\2\2)\u008a"+
		"\3\2\2\2+\u0097\3\2\2\2-\u00a5\3\2\2\2/\u00a7\3\2\2\2\61\u00a9\3\2\2\2"+
		"\63\64\7*\2\2\64\4\3\2\2\2\65\66\7.\2\2\66\6\3\2\2\2\678\7+\2\28\b\3\2"+
		"\2\29:\7=\2\2:\n\3\2\2\2;<\7}\2\2<\f\3\2\2\2=>\7\177\2\2>\16\3\2\2\2?"+
		"@\7?\2\2@\20\3\2\2\2AB\7c\2\2BC\7u\2\2CD\7o\2\2D\22\3\2\2\2EF\7,\2\2F"+
		"\24\3\2\2\2GH\7\61\2\2H\26\3\2\2\2IJ\7\'\2\2J\30\3\2\2\2KL\7-\2\2L\32"+
		"\3\2\2\2MN\7/\2\2N\34\3\2\2\2OQ\7/\2\2PO\3\2\2\2PQ\3\2\2\2QS\3\2\2\2R"+
		"T\5-\27\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2\2\2V\36\3\2\2\2Wh\5\35\17"+
		"\2XZ\7/\2\2YX\3\2\2\2YZ\3\2\2\2Z^\3\2\2\2[]\5-\27\2\\[\3\2\2\2]`\3\2\2"+
		"\2^\\\3\2\2\2^_\3\2\2\2_a\3\2\2\2`^\3\2\2\2ac\7\60\2\2bd\5-\27\2cb\3\2"+
		"\2\2de\3\2\2\2ec\3\2\2\2ef\3\2\2\2fh\3\2\2\2gW\3\2\2\2gY\3\2\2\2h \3\2"+
		"\2\2ij\7)\2\2jk\13\2\2\2kl\7)\2\2l\"\3\2\2\2mq\7$\2\2np\13\2\2\2on\3\2"+
		"\2\2ps\3\2\2\2qr\3\2\2\2qo\3\2\2\2rt\3\2\2\2sq\3\2\2\2tu\7$\2\2u$\3\2"+
		"\2\2vy\5/\30\2wy\7a\2\2xv\3\2\2\2xw\3\2\2\2y\177\3\2\2\2z~\5-\27\2{~\5"+
		"/\30\2|~\7a\2\2}z\3\2\2\2}{\3\2\2\2}|\3\2\2\2~\u0081\3\2\2\2\177}\3\2"+
		"\2\2\177\u0080\3\2\2\2\u0080&\3\2\2\2\u0081\177\3\2\2\2\u0082\u0085\t"+
		"\2\2\2\u0083\u0085\5\61\31\2\u0084\u0082\3\2\2\2\u0084\u0083\3\2\2\2\u0085"+
		"\u0086\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\3\2"+
		"\2\2\u0088\u0089\b\24\2\2\u0089(\3\2\2\2\u008a\u008b\7\61\2\2\u008b\u008c"+
		"\7\61\2\2\u008c\u0090\3\2\2\2\u008d\u008f\13\2\2\2\u008e\u008d\3\2\2\2"+
		"\u008f\u0092\3\2\2\2\u0090\u0091\3\2\2\2\u0090\u008e\3\2\2\2\u0091\u0093"+
		"\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0094\5\61\31\2\u0094\u0095\3\2\2\2"+
		"\u0095\u0096\b\25\2\2\u0096*\3\2\2\2\u0097\u0098\7\61\2\2\u0098\u0099"+
		"\7,\2\2\u0099\u009d\3\2\2\2\u009a\u009c\13\2\2\2\u009b\u009a\3\2\2\2\u009c"+
		"\u009f\3\2\2\2\u009d\u009e\3\2\2\2\u009d\u009b\3\2\2\2\u009e\u00a0\3\2"+
		"\2\2\u009f\u009d\3\2\2\2\u00a0\u00a1\7,\2\2\u00a1\u00a2\7\61\2\2\u00a2"+
		"\u00a3\3\2\2\2\u00a3\u00a4\b\26\2\2\u00a4,\3\2\2\2\u00a5\u00a6\t\3\2\2"+
		"\u00a6.\3\2\2\2\u00a7\u00a8\t\4\2\2\u00a8\60\3\2\2\2\u00a9\u00aa\t\5\2"+
		"\2\u00aa\62\3\2\2\2\21\2PUY^egqx}\177\u0084\u0086\u0090\u009d\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}