// Generated from br/ufscar/dc/compiladores/sistematatico/linguagemTatica.g4 by ANTLR 4.7.2
package br.ufscar.dc.compiladores.sistematatico;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class linguagemTaticaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, NUMEROS=6, POSICOES=7, DOISP=8, 
		VIRGULA=9, RESERVADAS=10, NOMES=11, DESCARTE=12, PULA_LINHA=13, ERROS=14;
	public static final int
		RULE_programa = 0, RULE_formacao = 1, RULE_decl_jogador = 2, RULE_papel = 3;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "formacao", "decl_jogador", "papel"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'sistema_tatico'", "'fim_sistema_tatico'", "'formacao'", "'defender'", 
			"'atacar'", null, null, "':'", "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, "NUMEROS", "POSICOES", "DOISP", "VIRGULA", 
			"RESERVADAS", "NOMES", "DESCARTE", "PULA_LINHA", "ERROS"
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
	public String getGrammarFileName() { return "linguagemTatica.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public linguagemTaticaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramaContext extends ParserRuleContext {
		public FormacaoContext f;
		public Decl_jogadorContext jg1;
		public Decl_jogadorContext jg2;
		public Decl_jogadorContext jg3;
		public Decl_jogadorContext jg4;
		public Decl_jogadorContext jg5;
		public Decl_jogadorContext jg6;
		public Decl_jogadorContext jg7;
		public Decl_jogadorContext jg8;
		public Decl_jogadorContext jg9;
		public Decl_jogadorContext jg10;
		public Decl_jogadorContext jg11;
		public PapelContext papel;
		public List<PapelContext> p = new ArrayList<PapelContext>();
		public FormacaoContext formacao() {
			return getRuleContext(FormacaoContext.class,0);
		}
		public List<Decl_jogadorContext> decl_jogador() {
			return getRuleContexts(Decl_jogadorContext.class);
		}
		public Decl_jogadorContext decl_jogador(int i) {
			return getRuleContext(Decl_jogadorContext.class,i);
		}
		public List<PapelContext> papel() {
			return getRuleContexts(PapelContext.class);
		}
		public PapelContext papel(int i) {
			return getRuleContext(PapelContext.class,i);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemTaticaListener ) ((linguagemTaticaListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemTaticaListener ) ((linguagemTaticaListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof linguagemTaticaVisitor ) return ((linguagemTaticaVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8);
			match(T__0);
			setState(9);
			((ProgramaContext)_localctx).f = formacao();
			setState(10);
			((ProgramaContext)_localctx).jg1 = decl_jogador();
			setState(11);
			((ProgramaContext)_localctx).jg2 = decl_jogador();
			setState(12);
			((ProgramaContext)_localctx).jg3 = decl_jogador();
			setState(13);
			((ProgramaContext)_localctx).jg4 = decl_jogador();
			setState(14);
			((ProgramaContext)_localctx).jg5 = decl_jogador();
			setState(15);
			((ProgramaContext)_localctx).jg6 = decl_jogador();
			setState(16);
			((ProgramaContext)_localctx).jg7 = decl_jogador();
			setState(17);
			((ProgramaContext)_localctx).jg8 = decl_jogador();
			setState(18);
			((ProgramaContext)_localctx).jg9 = decl_jogador();
			setState(19);
			((ProgramaContext)_localctx).jg10 = decl_jogador();
			setState(20);
			((ProgramaContext)_localctx).jg11 = decl_jogador();
			setState(24);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NOMES) {
				{
				{
				setState(21);
				((ProgramaContext)_localctx).papel = papel();
				((ProgramaContext)_localctx).p.add(((ProgramaContext)_localctx).papel);
				}
				}
				setState(26);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(27);
			match(T__1);
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

	public static class FormacaoContext extends ParserRuleContext {
		public Token nro1;
		public Token nro2;
		public Token nro3;
		public Token NUMEROS;
		public List<Token> outrosnros = new ArrayList<Token>();
		public TerminalNode DOISP() { return getToken(linguagemTaticaParser.DOISP, 0); }
		public List<TerminalNode> VIRGULA() { return getTokens(linguagemTaticaParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(linguagemTaticaParser.VIRGULA, i);
		}
		public List<TerminalNode> NUMEROS() { return getTokens(linguagemTaticaParser.NUMEROS); }
		public TerminalNode NUMEROS(int i) {
			return getToken(linguagemTaticaParser.NUMEROS, i);
		}
		public FormacaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formacao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemTaticaListener ) ((linguagemTaticaListener)listener).enterFormacao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemTaticaListener ) ((linguagemTaticaListener)listener).exitFormacao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof linguagemTaticaVisitor ) return ((linguagemTaticaVisitor<? extends T>)visitor).visitFormacao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormacaoContext formacao() throws RecognitionException {
		FormacaoContext _localctx = new FormacaoContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_formacao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			match(T__2);
			setState(30);
			match(DOISP);
			setState(31);
			((FormacaoContext)_localctx).nro1 = match(NUMEROS);
			setState(32);
			match(VIRGULA);
			setState(33);
			((FormacaoContext)_localctx).nro2 = match(NUMEROS);
			setState(34);
			match(VIRGULA);
			setState(35);
			((FormacaoContext)_localctx).nro3 = match(NUMEROS);
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(36);
				match(VIRGULA);
				setState(37);
				((FormacaoContext)_localctx).NUMEROS = match(NUMEROS);
				((FormacaoContext)_localctx).outrosnros.add(((FormacaoContext)_localctx).NUMEROS);
				}
				}
				setState(42);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class Decl_jogadorContext extends ParserRuleContext {
		public Token pos;
		public Token n;
		public TerminalNode DOISP() { return getToken(linguagemTaticaParser.DOISP, 0); }
		public TerminalNode POSICOES() { return getToken(linguagemTaticaParser.POSICOES, 0); }
		public TerminalNode NOMES() { return getToken(linguagemTaticaParser.NOMES, 0); }
		public Decl_jogadorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_jogador; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemTaticaListener ) ((linguagemTaticaListener)listener).enterDecl_jogador(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemTaticaListener ) ((linguagemTaticaListener)listener).exitDecl_jogador(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof linguagemTaticaVisitor ) return ((linguagemTaticaVisitor<? extends T>)visitor).visitDecl_jogador(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Decl_jogadorContext decl_jogador() throws RecognitionException {
		Decl_jogadorContext _localctx = new Decl_jogadorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl_jogador);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			((Decl_jogadorContext)_localctx).pos = match(POSICOES);
			setState(44);
			match(DOISP);
			setState(45);
			((Decl_jogadorContext)_localctx).n = match(NOMES);
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

	public static class PapelContext extends ParserRuleContext {
		public Token n;
		public Token d;
		public Token a;
		public TerminalNode DOISP() { return getToken(linguagemTaticaParser.DOISP, 0); }
		public TerminalNode NOMES() { return getToken(linguagemTaticaParser.NOMES, 0); }
		public PapelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_papel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemTaticaListener ) ((linguagemTaticaListener)listener).enterPapel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof linguagemTaticaListener ) ((linguagemTaticaListener)listener).exitPapel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof linguagemTaticaVisitor ) return ((linguagemTaticaVisitor<? extends T>)visitor).visitPapel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PapelContext papel() throws RecognitionException {
		PapelContext _localctx = new PapelContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_papel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			((PapelContext)_localctx).n = match(NOMES);
			setState(48);
			match(DOISP);
			setState(51);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				{
				setState(49);
				((PapelContext)_localctx).d = match(T__3);
				}
				break;
			case T__4:
				{
				setState(50);
				((PapelContext)_localctx).a = match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\208\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\7\2\31\n\2\f\2\16\2\34\13\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\7\3)\n\3\f\3\16\3,\13\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\5\5\66"+
		"\n\5\3\5\2\2\6\2\4\6\b\2\2\2\66\2\n\3\2\2\2\4\37\3\2\2\2\6-\3\2\2\2\b"+
		"\61\3\2\2\2\n\13\7\3\2\2\13\f\5\4\3\2\f\r\5\6\4\2\r\16\5\6\4\2\16\17\5"+
		"\6\4\2\17\20\5\6\4\2\20\21\5\6\4\2\21\22\5\6\4\2\22\23\5\6\4\2\23\24\5"+
		"\6\4\2\24\25\5\6\4\2\25\26\5\6\4\2\26\32\5\6\4\2\27\31\5\b\5\2\30\27\3"+
		"\2\2\2\31\34\3\2\2\2\32\30\3\2\2\2\32\33\3\2\2\2\33\35\3\2\2\2\34\32\3"+
		"\2\2\2\35\36\7\4\2\2\36\3\3\2\2\2\37 \7\5\2\2 !\7\n\2\2!\"\7\b\2\2\"#"+
		"\7\13\2\2#$\7\b\2\2$%\7\13\2\2%*\7\b\2\2&\'\7\13\2\2\')\7\b\2\2(&\3\2"+
		"\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\5\3\2\2\2,*\3\2\2\2-.\7\t\2\2./\7"+
		"\n\2\2/\60\7\r\2\2\60\7\3\2\2\2\61\62\7\r\2\2\62\65\7\n\2\2\63\66\7\6"+
		"\2\2\64\66\7\7\2\2\65\63\3\2\2\2\65\64\3\2\2\2\66\t\3\2\2\2\5\32*\65";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}