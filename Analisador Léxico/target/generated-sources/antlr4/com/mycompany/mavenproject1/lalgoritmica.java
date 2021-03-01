// Generated from com/mycompany/mavenproject1/lalgoritmica.g4 by ANTLR 4.7.2
package com.mycompany.mavenproject1;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class lalgoritmica extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		TIPOS=1, IO=2, RESERVADAS=3, DEFINICAO=4, ATRIBUICAO=5, INTERVALO=6, ENDERECOS=7, 
		OPRELACIONAL=8, OPS=9, OPLOGICO=10, NOT=11, VERDADEIRO_FALSO=12, VAR=13, 
		THEN=14, ELSE=15, IF=16, CASE=17, FOR=18, WHILE=19, STRUCT=20, PROCEDURE=21, 
		FUNCTION=22, NUM_INT=23, NUM_REAL=24, IDENT=25, IGNORAR=26, PULA_LINHA=27, 
		COMENTARIOS=28, COMENTARIOS_ERRADOS=29, VIRGULA=30, CAMPO=31, ABREPAR=32, 
		FECHAPAR=33, ABRECOL=34, FECHACOL=35, DOISP=36, CADEIA=37, CADEIA_ERRADA=38, 
		LETRA=39, LETRAMIN=40, DIGITO=41, ERRO=42;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"TIPOS", "IO", "RESERVADAS", "DEFINICAO", "ATRIBUICAO", "INTERVALO", 
			"ENDERECOS", "OPRELACIONAL", "OPS", "OPLOGICO", "NOT", "VERDADEIRO_FALSO", 
			"VAR", "THEN", "ELSE", "IF", "CASE", "FOR", "WHILE", "STRUCT", "PROCEDURE", 
			"FUNCTION", "NUM_INT", "NUM_REAL", "IDENT", "IGNORAR", "PULA_LINHA", 
			"COMENTARIOS", "COMENTARIOS_ERRADOS", "VIRGULA", "CAMPO", "ABREPAR", 
			"FECHAPAR", "ABRECOL", "FECHACOL", "DOISP", "CADEIA", "CADEIA_ERRADA", 
			"LETRA", "LETRAMIN", "DIGITO", "ERRO"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'tipo'", null, "'..'", null, null, null, null, 
			"'nao'", null, "'var'", "'entao'", "'senao'", null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "','", "'.'", 
			"'('", "')'", "'['", "']'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TIPOS", "IO", "RESERVADAS", "DEFINICAO", "ATRIBUICAO", "INTERVALO", 
			"ENDERECOS", "OPRELACIONAL", "OPS", "OPLOGICO", "NOT", "VERDADEIRO_FALSO", 
			"VAR", "THEN", "ELSE", "IF", "CASE", "FOR", "WHILE", "STRUCT", "PROCEDURE", 
			"FUNCTION", "NUM_INT", "NUM_REAL", "IDENT", "IGNORAR", "PULA_LINHA", 
			"COMENTARIOS", "COMENTARIOS_ERRADOS", "VIRGULA", "CAMPO", "ABREPAR", 
			"FECHAPAR", "ABRECOL", "FECHACOL", "DOISP", "CADEIA", "CADEIA_ERRADA", 
			"LETRA", "LETRAMIN", "DIGITO", "ERRO"
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


	public lalgoritmica(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "lalgoritmica.g4"; }

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

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 25:
			IGNORAR_action((RuleContext)_localctx, actionIndex);
			break;
		case 27:
			COMENTARIOS_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void IGNORAR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			skip();
			break;
		}
	}
	private void COMENTARIOS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			skip();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2,\u01df\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\5\2p\n\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\5\3}\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\u00a5\n\4\3\5\3\5\3\5\3\5\3\5\3\6\3"+
		"\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u00bc\n"+
		"\t\3\n\3\n\3\13\3\13\3\13\5\13\u00c3\n\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00d8\n\r\3\16\3"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00f2\n\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\5\22\u0104\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0119\n\23\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\5\24\u012f\n\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0145"+
		"\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\5\26\u0163\n\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\5\27"+
		"\u017c\n\27\3\30\3\30\7\30\u0180\n\30\f\30\16\30\u0183\13\30\3\31\3\31"+
		"\7\31\u0187\n\31\f\31\16\31\u018a\13\31\3\31\3\31\3\31\7\31\u018f\n\31"+
		"\f\31\16\31\u0192\13\31\3\32\3\32\5\32\u0196\n\32\3\32\3\32\3\32\7\32"+
		"\u019b\n\32\f\32\16\32\u019e\13\32\3\33\3\33\3\33\3\34\3\34\3\35\3\35"+
		"\7\35\u01a7\n\35\f\35\16\35\u01aa\13\35\3\35\3\35\3\35\3\36\3\36\7\36"+
		"\u01b1\n\36\f\36\16\36\u01b4\13\36\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\""+
		"\3\"\3#\3#\3$\3$\3%\3%\3&\3&\7&\u01c8\n&\f&\16&\u01cb\13&\3&\3&\3\'\3"+
		"\'\7\'\u01d1\n\'\f\'\16\'\u01d4\13\'\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\2"+
		"\2,\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,\3\2\f\4\2((``\4\2>>@@\6\2\'\',-//\61"+
		"\61\4\2\13\13\"\"\4\2\f\f\17\17\5\2\f\f\17\17\177\177\3\2\177\177\5\2"+
		"\f\f\17\17$$\3\2$$\4\2C\\c|\2\u0201\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3"+
		"\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2"+
		"\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2"+
		"\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\3o\3\2\2\2\5|\3\2\2\2\7\u00a4"+
		"\3\2\2\2\t\u00a6\3\2\2\2\13\u00ab\3\2\2\2\r\u00ae\3\2\2\2\17\u00b1\3\2"+
		"\2\2\21\u00bb\3\2\2\2\23\u00bd\3\2\2\2\25\u00c2\3\2\2\2\27\u00c4\3\2\2"+
		"\2\31\u00d7\3\2\2\2\33\u00d9\3\2\2\2\35\u00dd\3\2\2\2\37\u00e3\3\2\2\2"+
		"!\u00f1\3\2\2\2#\u0103\3\2\2\2%\u0118\3\2\2\2\'\u012e\3\2\2\2)\u0144\3"+
		"\2\2\2+\u0162\3\2\2\2-\u017b\3\2\2\2/\u017d\3\2\2\2\61\u0184\3\2\2\2\63"+
		"\u0195\3\2\2\2\65\u019f\3\2\2\2\67\u01a2\3\2\2\29\u01a4\3\2\2\2;\u01ae"+
		"\3\2\2\2=\u01b7\3\2\2\2?\u01b9\3\2\2\2A\u01bb\3\2\2\2C\u01bd\3\2\2\2E"+
		"\u01bf\3\2\2\2G\u01c1\3\2\2\2I\u01c3\3\2\2\2K\u01c5\3\2\2\2M\u01ce\3\2"+
		"\2\2O\u01d7\3\2\2\2Q\u01d9\3\2\2\2S\u01db\3\2\2\2U\u01dd\3\2\2\2WX\7k"+
		"\2\2XY\7p\2\2YZ\7v\2\2Z[\7g\2\2[\\\7k\2\2\\]\7t\2\2]p\7q\2\2^_\7n\2\2"+
		"_`\7k\2\2`a\7v\2\2ab\7g\2\2bc\7t\2\2cd\7c\2\2dp\7n\2\2ef\7t\2\2fg\7g\2"+
		"\2gh\7c\2\2hp\7n\2\2ij\7n\2\2jk\7q\2\2kl\7i\2\2lm\7k\2\2mn\7e\2\2np\7"+
		"q\2\2oW\3\2\2\2o^\3\2\2\2oe\3\2\2\2oi\3\2\2\2p\4\3\2\2\2qr\7n\2\2rs\7"+
		"g\2\2st\7k\2\2t}\7c\2\2uv\7g\2\2vw\7u\2\2wx\7e\2\2xy\7t\2\2yz\7g\2\2z"+
		"{\7x\2\2{}\7c\2\2|q\3\2\2\2|u\3\2\2\2}\6\3\2\2\2~\177\7f\2\2\177\u0080"+
		"\7g\2\2\u0080\u0081\7e\2\2\u0081\u0082\7n\2\2\u0082\u0083\7c\2\2\u0083"+
		"\u0084\7t\2\2\u0084\u00a5\7g\2\2\u0085\u0086\7c\2\2\u0086\u0087\7n\2\2"+
		"\u0087\u0088\7i\2\2\u0088\u0089\7q\2\2\u0089\u008a\7t\2\2\u008a\u008b"+
		"\7k\2\2\u008b\u008c\7v\2\2\u008c\u008d\7o\2\2\u008d\u00a5\7q\2\2\u008e"+
		"\u008f\7h\2\2\u008f\u0090\7k\2\2\u0090\u0091\7o\2\2\u0091\u0092\7a\2\2"+
		"\u0092\u0093\7c\2\2\u0093\u0094\7n\2\2\u0094\u0095\7i\2\2\u0095\u0096"+
		"\7q\2\2\u0096\u0097\7t\2\2\u0097\u0098\7k\2\2\u0098\u0099\7v\2\2\u0099"+
		"\u009a\7o\2\2\u009a\u00a5\7q\2\2\u009b\u009c\7e\2\2\u009c\u009d\7q\2\2"+
		"\u009d\u009e\7p\2\2\u009e\u009f\7u\2\2\u009f\u00a0\7v\2\2\u00a0\u00a1"+
		"\7c\2\2\u00a1\u00a2\7p\2\2\u00a2\u00a3\7v\2\2\u00a3\u00a5\7g\2\2\u00a4"+
		"~\3\2\2\2\u00a4\u0085\3\2\2\2\u00a4\u008e\3\2\2\2\u00a4\u009b\3\2\2\2"+
		"\u00a5\b\3\2\2\2\u00a6\u00a7\7v\2\2\u00a7\u00a8\7k\2\2\u00a8\u00a9\7r"+
		"\2\2\u00a9\u00aa\7q\2\2\u00aa\n\3\2\2\2\u00ab\u00ac\7>\2\2\u00ac\u00ad"+
		"\7/\2\2\u00ad\f\3\2\2\2\u00ae\u00af\7\60\2\2\u00af\u00b0\7\60\2\2\u00b0"+
		"\16\3\2\2\2\u00b1\u00b2\t\2\2\2\u00b2\20\3\2\2\2\u00b3\u00bc\7?\2\2\u00b4"+
		"\u00b5\7>\2\2\u00b5\u00bc\7@\2\2\u00b6\u00b7\7@\2\2\u00b7\u00bc\7?\2\2"+
		"\u00b8\u00b9\7>\2\2\u00b9\u00bc\7?\2\2\u00ba\u00bc\t\3\2\2\u00bb\u00b3"+
		"\3\2\2\2\u00bb\u00b4\3\2\2\2\u00bb\u00b6\3\2\2\2\u00bb\u00b8\3\2\2\2\u00bb"+
		"\u00ba\3\2\2\2\u00bc\22\3\2\2\2\u00bd\u00be\t\4\2\2\u00be\24\3\2\2\2\u00bf"+
		"\u00c3\7g\2\2\u00c0\u00c1\7q\2\2\u00c1\u00c3\7w\2\2\u00c2\u00bf\3\2\2"+
		"\2\u00c2\u00c0\3\2\2\2\u00c3\26\3\2\2\2\u00c4\u00c5\7p\2\2\u00c5\u00c6"+
		"\7c\2\2\u00c6\u00c7\7q\2\2\u00c7\30\3\2\2\2\u00c8\u00c9\7x\2\2\u00c9\u00ca"+
		"\7g\2\2\u00ca\u00cb\7t\2\2\u00cb\u00cc\7f\2\2\u00cc\u00cd\7c\2\2\u00cd"+
		"\u00ce\7f\2\2\u00ce\u00cf\7g\2\2\u00cf\u00d0\7k\2\2\u00d0\u00d1\7t\2\2"+
		"\u00d1\u00d8\7q\2\2\u00d2\u00d3\7h\2\2\u00d3\u00d4\7c\2\2\u00d4\u00d5"+
		"\7n\2\2\u00d5\u00d6\7u\2\2\u00d6\u00d8\7q\2\2\u00d7\u00c8\3\2\2\2\u00d7"+
		"\u00d2\3\2\2\2\u00d8\32\3\2\2\2\u00d9\u00da\7x\2\2\u00da\u00db\7c\2\2"+
		"\u00db\u00dc\7t\2\2\u00dc\34\3\2\2\2\u00dd\u00de\7g\2\2\u00de\u00df\7"+
		"p\2\2\u00df\u00e0\7v\2\2\u00e0\u00e1\7c\2\2\u00e1\u00e2\7q\2\2\u00e2\36"+
		"\3\2\2\2\u00e3\u00e4\7u\2\2\u00e4\u00e5\7g\2\2\u00e5\u00e6\7p\2\2\u00e6"+
		"\u00e7\7c\2\2\u00e7\u00e8\7q\2\2\u00e8 \3\2\2\2\u00e9\u00ea\7u\2\2\u00ea"+
		"\u00f2\7g\2\2\u00eb\u00ec\7h\2\2\u00ec\u00ed\7k\2\2\u00ed\u00ee\7o\2\2"+
		"\u00ee\u00ef\7a\2\2\u00ef\u00f0\7u\2\2\u00f0\u00f2\7g\2\2\u00f1\u00e9"+
		"\3\2\2\2\u00f1\u00eb\3\2\2\2\u00f2\"\3\2\2\2\u00f3\u00f4\7e\2\2\u00f4"+
		"\u00f5\7c\2\2\u00f5\u00f6\7u\2\2\u00f6\u0104\7q\2\2\u00f7\u00f8\7u\2\2"+
		"\u00f8\u00f9\7g\2\2\u00f9\u00fa\7l\2\2\u00fa\u0104\7c\2\2\u00fb\u00fc"+
		"\7h\2\2\u00fc\u00fd\7k\2\2\u00fd\u00fe\7o\2\2\u00fe\u00ff\7a\2\2\u00ff"+
		"\u0100\7e\2\2\u0100\u0101\7c\2\2\u0101\u0102\7u\2\2\u0102\u0104\7q\2\2"+
		"\u0103\u00f3\3\2\2\2\u0103\u00f7\3\2\2\2\u0103\u00fb\3\2\2\2\u0104$\3"+
		"\2\2\2\u0105\u0106\7r\2\2\u0106\u0107\7c\2\2\u0107\u0108\7t\2\2\u0108"+
		"\u0119\7c\2\2\u0109\u010a\7c\2\2\u010a\u010b\7v\2\2\u010b\u0119\7g\2\2"+
		"\u010c\u010d\7h\2\2\u010d\u010e\7c\2\2\u010e\u010f\7e\2\2\u010f\u0119"+
		"\7c\2\2\u0110\u0111\7h\2\2\u0111\u0112\7k\2\2\u0112\u0113\7o\2\2\u0113"+
		"\u0114\7a\2\2\u0114\u0115\7r\2\2\u0115\u0116\7c\2\2\u0116\u0117\7t\2\2"+
		"\u0117\u0119\7c\2\2\u0118\u0105\3\2\2\2\u0118\u0109\3\2\2\2\u0118\u010c"+
		"\3\2\2\2\u0118\u0110\3\2\2\2\u0119&\3\2\2\2\u011a\u011b\7g\2\2\u011b\u011c"+
		"\7p\2\2\u011c\u011d\7s\2\2\u011d\u011e\7w\2\2\u011e\u011f\7c\2\2\u011f"+
		"\u0120\7p\2\2\u0120\u0121\7v\2\2\u0121\u012f\7q\2\2\u0122\u0123\7h\2\2"+
		"\u0123\u0124\7k\2\2\u0124\u0125\7o\2\2\u0125\u0126\7a\2\2\u0126\u0127"+
		"\7g\2\2\u0127\u0128\7p\2\2\u0128\u0129\7s\2\2\u0129\u012a\7w\2\2\u012a"+
		"\u012b\7c\2\2\u012b\u012c\7p\2\2\u012c\u012d\7v\2\2\u012d\u012f\7q\2\2"+
		"\u012e\u011a\3\2\2\2\u012e\u0122\3\2\2\2\u012f(\3\2\2\2\u0130\u0131\7"+
		"t\2\2\u0131\u0132\7g\2\2\u0132\u0133\7i\2\2\u0133\u0134\7k\2\2\u0134\u0135"+
		"\7u\2\2\u0135\u0136\7v\2\2\u0136\u0137\7t\2\2\u0137\u0145\7q\2\2\u0138"+
		"\u0139\7h\2\2\u0139\u013a\7k\2\2\u013a\u013b\7o\2\2\u013b\u013c\7a\2\2"+
		"\u013c\u013d\7t\2\2\u013d\u013e\7g\2\2\u013e\u013f\7i\2\2\u013f\u0140"+
		"\7k\2\2\u0140\u0141\7u\2\2\u0141\u0142\7v\2\2\u0142\u0143\7t\2\2\u0143"+
		"\u0145\7q\2\2\u0144\u0130\3\2\2\2\u0144\u0138\3\2\2\2\u0145*\3\2\2\2\u0146"+
		"\u0147\7r\2\2\u0147\u0148\7t\2\2\u0148\u0149\7q\2\2\u0149\u014a\7e\2\2"+
		"\u014a\u014b\7g\2\2\u014b\u014c\7f\2\2\u014c\u014d\7k\2\2\u014d\u014e"+
		"\7o\2\2\u014e\u014f\7g\2\2\u014f\u0150\7p\2\2\u0150\u0151\7v\2\2\u0151"+
		"\u0163\7q\2\2\u0152\u0153\7h\2\2\u0153\u0154\7k\2\2\u0154\u0155\7o\2\2"+
		"\u0155\u0156\7a\2\2\u0156\u0157\7r\2\2\u0157\u0158\7t\2\2\u0158\u0159"+
		"\7q\2\2\u0159\u015a\7e\2\2\u015a\u015b\7g\2\2\u015b\u015c\7f\2\2\u015c"+
		"\u015d\7k\2\2\u015d\u015e\7o\2\2\u015e\u015f\7g\2\2\u015f\u0160\7p\2\2"+
		"\u0160\u0161\7v\2\2\u0161\u0163\7q\2\2\u0162\u0146\3\2\2\2\u0162\u0152"+
		"\3\2\2\2\u0163,\3\2\2\2\u0164\u0165\7h\2\2\u0165\u0166\7w\2\2\u0166\u0167"+
		"\7p\2\2\u0167\u0168\7e\2\2\u0168\u0169\7c\2\2\u0169\u017c\7q\2\2\u016a"+
		"\u016b\7h\2\2\u016b\u016c\7k\2\2\u016c\u016d\7o\2\2\u016d\u016e\7a\2\2"+
		"\u016e\u016f\7h\2\2\u016f\u0170\7w\2\2\u0170\u0171\7p\2\2\u0171\u0172"+
		"\7e\2\2\u0172\u0173\7c\2\2\u0173\u017c\7q\2\2\u0174\u0175\7t\2\2\u0175"+
		"\u0176\7g\2\2\u0176\u0177\7v\2\2\u0177\u0178\7q\2\2\u0178\u0179\7t\2\2"+
		"\u0179\u017a\7p\2\2\u017a\u017c\7g\2\2\u017b\u0164\3\2\2\2\u017b\u016a"+
		"\3\2\2\2\u017b\u0174\3\2\2\2\u017c.\3\2\2\2\u017d\u0181\5S*\2\u017e\u0180"+
		"\5S*\2\u017f\u017e\3\2\2\2\u0180\u0183\3\2\2\2\u0181\u017f\3\2\2\2\u0181"+
		"\u0182\3\2\2\2\u0182\60\3\2\2\2\u0183\u0181\3\2\2\2\u0184\u0188\5S*\2"+
		"\u0185\u0187\5S*\2\u0186\u0185\3\2\2\2\u0187\u018a\3\2\2\2\u0188\u0186"+
		"\3\2\2\2\u0188\u0189\3\2\2\2\u0189\u018b\3\2\2\2\u018a\u0188\3\2\2\2\u018b"+
		"\u018c\7\60\2\2\u018c\u0190\5S*\2\u018d\u018f\5S*\2\u018e\u018d\3\2\2"+
		"\2\u018f\u0192\3\2\2\2\u0190\u018e\3\2\2\2\u0190\u0191\3\2\2\2\u0191\62"+
		"\3\2\2\2\u0192\u0190\3\2\2\2\u0193\u0196\5O(\2\u0194\u0196\7a\2\2\u0195"+
		"\u0193\3\2\2\2\u0195\u0194\3\2\2\2\u0196\u019c\3\2\2\2\u0197\u019b\5O"+
		"(\2\u0198\u019b\5S*\2\u0199\u019b\7a\2\2\u019a\u0197\3\2\2\2\u019a\u0198"+
		"\3\2\2\2\u019a\u0199\3\2\2\2\u019b\u019e\3\2\2\2\u019c\u019a\3\2\2\2\u019c"+
		"\u019d\3\2\2\2\u019d\64\3\2\2\2\u019e\u019c\3\2\2\2\u019f\u01a0\t\5\2"+
		"\2\u01a0\u01a1\b\33\2\2\u01a1\66\3\2\2\2\u01a2\u01a3\t\6\2\2\u01a38\3"+
		"\2\2\2\u01a4\u01a8\7}\2\2\u01a5\u01a7\n\7\2\2\u01a6\u01a5\3\2\2\2\u01a7"+
		"\u01aa\3\2\2\2\u01a8\u01a6\3\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01ab\3\2"+
		"\2\2\u01aa\u01a8\3\2\2\2\u01ab\u01ac\7\177\2\2\u01ac\u01ad\b\35\3\2\u01ad"+
		":\3\2\2\2\u01ae\u01b2\7}\2\2\u01af\u01b1\n\b\2\2\u01b0\u01af\3\2\2\2\u01b1"+
		"\u01b4\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3\u01b5\3\2"+
		"\2\2\u01b4\u01b2\3\2\2\2\u01b5\u01b6\t\6\2\2\u01b6<\3\2\2\2\u01b7\u01b8"+
		"\7.\2\2\u01b8>\3\2\2\2\u01b9\u01ba\7\60\2\2\u01ba@\3\2\2\2\u01bb\u01bc"+
		"\7*\2\2\u01bcB\3\2\2\2\u01bd\u01be\7+\2\2\u01beD\3\2\2\2\u01bf\u01c0\7"+
		"]\2\2\u01c0F\3\2\2\2\u01c1\u01c2\7_\2\2\u01c2H\3\2\2\2\u01c3\u01c4\7<"+
		"\2\2\u01c4J\3\2\2\2\u01c5\u01c9\7$\2\2\u01c6\u01c8\n\t\2\2\u01c7\u01c6"+
		"\3\2\2\2\u01c8\u01cb\3\2\2\2\u01c9\u01c7\3\2\2\2\u01c9\u01ca\3\2\2\2\u01ca"+
		"\u01cc\3\2\2\2\u01cb\u01c9\3\2\2\2\u01cc\u01cd\7$\2\2\u01cdL\3\2\2\2\u01ce"+
		"\u01d2\7$\2\2\u01cf\u01d1\n\n\2\2\u01d0\u01cf\3\2\2\2\u01d1\u01d4\3\2"+
		"\2\2\u01d2\u01d0\3\2\2\2\u01d2\u01d3\3\2\2\2\u01d3\u01d5\3\2\2\2\u01d4"+
		"\u01d2\3\2\2\2\u01d5\u01d6\t\6\2\2\u01d6N\3\2\2\2\u01d7\u01d8\t\13\2\2"+
		"\u01d8P\3\2\2\2\u01d9\u01da\4c|\2\u01daR\3\2\2\2\u01db\u01dc\4\62;\2\u01dc"+
		"T\3\2\2\2\u01dd\u01de\13\2\2\2\u01deV\3\2\2\2\32\2o|\u00a4\u00bb\u00c2"+
		"\u00d7\u00f1\u0103\u0118\u012e\u0144\u0162\u017b\u0181\u0188\u0190\u0195"+
		"\u019a\u019c\u01a8\u01b2\u01c9\u01d2\4\3\33\2\3\35\3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}