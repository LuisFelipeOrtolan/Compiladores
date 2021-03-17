// Generated from br/ufscar/dc/compiladores/analisadorsemantico/la.g4 by ANTLR 4.7.2
package br.ufscar.dc.compiladores.analisadorsemantico;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class laParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, TIPOS=47, IO=48, RESERVADAS=49, DEFINICAO=50, ATRIBUICAO=51, 
		INTERVALO=52, ENDERECOS=53, NOT=54, VERDADEIRO_FALSO=55, VAR=56, THEN=57, 
		ELSE=58, IF=59, CASE=60, FOR=61, WHILE=62, STRUCT=63, PROCEDURE=64, FUNCTION=65, 
		NUM_INT=66, NUM_REAL=67, IDENT=68, COMENTARIOS=69, COMENTARIOS_ERRADOS=70, 
		IGNORAR=71, PULA_LINHA=72, VIRGULA=73, CAMPO=74, ABREPAR=75, FECHAPAR=76, 
		ABRECOL=77, FECHACOL=78, DOISP=79, CADEIA=80, CADEIA_ERRADA=81, LETRA=82, 
		LETRAMIN=83, DIGITO=84, ERRO=85, FIMARQUIVO=86;
	public static final int
		RULE_op_logico_1 = 0, RULE_op_logico_2 = 1, RULE_registro = 2, RULE_programa = 3, 
		RULE_declaracoes = 4, RULE_decl_local_global = 5, RULE_declaracao_local = 6, 
		RULE_variavel = 7, RULE_identificador = 8, RULE_dimensao = 9, RULE_tipo = 10, 
		RULE_tipo_basico = 11, RULE_tipo_basico_ident = 12, RULE_tipo_estendido = 13, 
		RULE_valor_constante = 14, RULE_declaracao_global = 15, RULE_parametro = 16, 
		RULE_parametros = 17, RULE_corpo = 18, RULE_cmd = 19, RULE_cmdLeia = 20, 
		RULE_cmdEscreva = 21, RULE_cmdSe = 22, RULE_cmdCaso = 23, RULE_cmdPara = 24, 
		RULE_cmdEnquanto = 25, RULE_cmdFaca = 26, RULE_cmdAtribuicao = 27, RULE_cmdChamada = 28, 
		RULE_cmdRetorne = 29, RULE_selecao = 30, RULE_item_selecao = 31, RULE_constantes = 32, 
		RULE_numero_intervalo = 33, RULE_op_unario = 34, RULE_exp_aritmetica = 35, 
		RULE_termo = 36, RULE_fator = 37, RULE_op1 = 38, RULE_op2 = 39, RULE_op3 = 40, 
		RULE_parcela = 41, RULE_parcela_unario = 42, RULE_parcela_nao_unario = 43, 
		RULE_exp_relacional = 44, RULE_op_relacional = 45, RULE_expressao = 46, 
		RULE_termo_logico = 47, RULE_fator_logico = 48, RULE_parcela_logica = 49;
	private static String[] makeRuleNames() {
		return new String[] {
			"op_logico_1", "op_logico_2", "registro", "programa", "declaracoes", 
			"decl_local_global", "declaracao_local", "variavel", "identificador", 
			"dimensao", "tipo", "tipo_basico", "tipo_basico_ident", "tipo_estendido", 
			"valor_constante", "declaracao_global", "parametro", "parametros", "corpo", 
			"cmd", "cmdLeia", "cmdEscreva", "cmdSe", "cmdCaso", "cmdPara", "cmdEnquanto", 
			"cmdFaca", "cmdAtribuicao", "cmdChamada", "cmdRetorne", "selecao", "item_selecao", 
			"constantes", "numero_intervalo", "op_unario", "exp_aritmetica", "termo", 
			"fator", "op1", "op2", "op3", "parcela", "parcela_unario", "parcela_nao_unario", 
			"exp_relacional", "op_relacional", "expressao", "termo_logico", "fator_logico", 
			"parcela_logica"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'ou'", "'e'", "'registro'", "'fim_registro'", "'algoritmo'", "'fim_algoritmo'", 
			"'declare'", "'constante'", "'='", "'literal'", "'inteiro'", "'real'", 
			"'logico'", "'^'", "'verdadeiro'", "'falso'", "'procedimento'", "'fim_procedimento'", 
			"'funcao'", "'fim_funcao'", "'leia'", "'escreva'", "'se'", "'fim_se'", 
			"'caso'", "'seja'", "'fim_caso'", "'para'", "'<-'", "'ate'", "'faca'", 
			"'fim_para'", "'enquanto'", "'fim_enquanto'", "'retorne'", "'-'", "'+'", 
			"'*'", "'/'", "'%'", "'&'", "'<>'", "'>='", "'<='", "'>'", "'<'", null, 
			null, null, "'tipo'", null, "'..'", null, "'nao'", null, "'var'", "'entao'", 
			"'senao'", null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "','", "'.'", "'('", "')'", "'['", "']'", "':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "TIPOS", 
			"IO", "RESERVADAS", "DEFINICAO", "ATRIBUICAO", "INTERVALO", "ENDERECOS", 
			"NOT", "VERDADEIRO_FALSO", "VAR", "THEN", "ELSE", "IF", "CASE", "FOR", 
			"WHILE", "STRUCT", "PROCEDURE", "FUNCTION", "NUM_INT", "NUM_REAL", "IDENT", 
			"COMENTARIOS", "COMENTARIOS_ERRADOS", "IGNORAR", "PULA_LINHA", "VIRGULA", 
			"CAMPO", "ABREPAR", "FECHAPAR", "ABRECOL", "FECHACOL", "DOISP", "CADEIA", 
			"CADEIA_ERRADA", "LETRA", "LETRAMIN", "DIGITO", "ERRO", "FIMARQUIVO"
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
	public String getGrammarFileName() { return "la.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public laParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class Op_logico_1Context extends ParserRuleContext {
		public Op_logico_1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_logico_1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterOp_logico_1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitOp_logico_1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitOp_logico_1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_logico_1Context op_logico_1() throws RecognitionException {
		Op_logico_1Context _localctx = new Op_logico_1Context(_ctx, getState());
		enterRule(_localctx, 0, RULE_op_logico_1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__0);
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

	public static class Op_logico_2Context extends ParserRuleContext {
		public Op_logico_2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_logico_2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterOp_logico_2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitOp_logico_2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitOp_logico_2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_logico_2Context op_logico_2() throws RecognitionException {
		Op_logico_2Context _localctx = new Op_logico_2Context(_ctx, getState());
		enterRule(_localctx, 2, RULE_op_logico_2);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
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

	public static class RegistroContext extends ParserRuleContext {
		public VariavelContext variavel;
		public List<VariavelContext> vars = new ArrayList<VariavelContext>();
		public List<VariavelContext> variavel() {
			return getRuleContexts(VariavelContext.class);
		}
		public VariavelContext variavel(int i) {
			return getRuleContext(VariavelContext.class,i);
		}
		public RegistroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_registro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterRegistro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitRegistro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitRegistro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RegistroContext registro() throws RecognitionException {
		RegistroContext _localctx = new RegistroContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_registro);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(T__2);
			setState(108);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENT) {
				{
				{
				setState(105);
				((RegistroContext)_localctx).variavel = variavel();
				((RegistroContext)_localctx).vars.add(((RegistroContext)_localctx).variavel);
				}
				}
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(111);
			match(T__3);
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

	public static class ProgramaContext extends ParserRuleContext {
		public DeclaracoesContext declaracoes() {
			return getRuleContext(DeclaracoesContext.class,0);
		}
		public CorpoContext corpo() {
			return getRuleContext(CorpoContext.class,0);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitPrograma(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitPrograma(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			declaracoes();
			setState(114);
			match(T__4);
			setState(115);
			corpo();
			setState(116);
			match(T__5);
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

	public static class DeclaracoesContext extends ParserRuleContext {
		public List<Decl_local_globalContext> decl_local_global() {
			return getRuleContexts(Decl_local_globalContext.class);
		}
		public Decl_local_globalContext decl_local_global(int i) {
			return getRuleContext(Decl_local_globalContext.class,i);
		}
		public DeclaracoesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracoes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterDeclaracoes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitDeclaracoes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitDeclaracoes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclaracoesContext declaracoes() throws RecognitionException {
		DeclaracoesContext _localctx = new DeclaracoesContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_declaracoes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << T__16) | (1L << T__18) | (1L << DEFINICAO))) != 0)) {
				{
				{
				setState(118);
				decl_local_global();
				}
				}
				setState(123);
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

	public static class Decl_local_globalContext extends ParserRuleContext {
		public Declaracao_localContext declaracao_local() {
			return getRuleContext(Declaracao_localContext.class,0);
		}
		public Declaracao_globalContext declaracao_global() {
			return getRuleContext(Declaracao_globalContext.class,0);
		}
		public Decl_local_globalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_local_global; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterDecl_local_global(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitDecl_local_global(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitDecl_local_global(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Decl_local_globalContext decl_local_global() throws RecognitionException {
		Decl_local_globalContext _localctx = new Decl_local_globalContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_decl_local_global);
		try {
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
			case T__7:
			case DEFINICAO:
				enterOuterAlt(_localctx, 1);
				{
				setState(124);
				declaracao_local();
				}
				break;
			case T__16:
			case T__18:
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				declaracao_global();
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

	public static class Declaracao_localContext extends ParserRuleContext {
		public Token decl;
		public VariavelContext vars;
		public Token con;
		public Token id;
		public Tipo_basicoContext tbas;
		public Valor_constanteContext val;
		public Token tip;
		public TipoContext t;
		public VariavelContext variavel() {
			return getRuleContext(VariavelContext.class,0);
		}
		public TerminalNode DOISP() { return getToken(laParser.DOISP, 0); }
		public TerminalNode IDENT() { return getToken(laParser.IDENT, 0); }
		public Tipo_basicoContext tipo_basico() {
			return getRuleContext(Tipo_basicoContext.class,0);
		}
		public Valor_constanteContext valor_constante() {
			return getRuleContext(Valor_constanteContext.class,0);
		}
		public TerminalNode DEFINICAO() { return getToken(laParser.DEFINICAO, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public Declaracao_localContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao_local; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterDeclaracao_local(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitDeclaracao_local(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitDeclaracao_local(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaracao_localContext declaracao_local() throws RecognitionException {
		Declaracao_localContext _localctx = new Declaracao_localContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_declaracao_local);
		try {
			setState(141);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				enterOuterAlt(_localctx, 1);
				{
				setState(128);
				((Declaracao_localContext)_localctx).decl = match(T__6);
				setState(129);
				((Declaracao_localContext)_localctx).vars = variavel();
				}
				break;
			case T__7:
				enterOuterAlt(_localctx, 2);
				{
				setState(130);
				((Declaracao_localContext)_localctx).con = match(T__7);
				setState(131);
				((Declaracao_localContext)_localctx).id = match(IDENT);
				setState(132);
				match(DOISP);
				setState(133);
				((Declaracao_localContext)_localctx).tbas = tipo_basico();
				setState(134);
				match(T__8);
				setState(135);
				((Declaracao_localContext)_localctx).val = valor_constante();
				}
				break;
			case DEFINICAO:
				enterOuterAlt(_localctx, 3);
				{
				setState(137);
				((Declaracao_localContext)_localctx).tip = match(DEFINICAO);
				setState(138);
				((Declaracao_localContext)_localctx).id = match(IDENT);
				setState(139);
				match(DOISP);
				setState(140);
				((Declaracao_localContext)_localctx).t = tipo();
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

	public static class VariavelContext extends ParserRuleContext {
		public IdentificadorContext ident1;
		public IdentificadorContext identificador;
		public List<IdentificadorContext> outrosIdents = new ArrayList<IdentificadorContext>();
		public TipoContext tip;
		public TerminalNode DOISP() { return getToken(laParser.DOISP, 0); }
		public List<IdentificadorContext> identificador() {
			return getRuleContexts(IdentificadorContext.class);
		}
		public IdentificadorContext identificador(int i) {
			return getRuleContext(IdentificadorContext.class,i);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<TerminalNode> VIRGULA() { return getTokens(laParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(laParser.VIRGULA, i);
		}
		public VariavelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variavel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterVariavel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitVariavel(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitVariavel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariavelContext variavel() throws RecognitionException {
		VariavelContext _localctx = new VariavelContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_variavel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			((VariavelContext)_localctx).ident1 = identificador();
			setState(148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(144);
				match(VIRGULA);
				setState(145);
				((VariavelContext)_localctx).identificador = identificador();
				((VariavelContext)_localctx).outrosIdents.add(((VariavelContext)_localctx).identificador);
				}
				}
				setState(150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(151);
			match(DOISP);
			setState(152);
			((VariavelContext)_localctx).tip = tipo();
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

	public static class IdentificadorContext extends ParserRuleContext {
		public Token text;
		public DimensaoContext dimensao() {
			return getRuleContext(DimensaoContext.class,0);
		}
		public List<TerminalNode> IDENT() { return getTokens(laParser.IDENT); }
		public TerminalNode IDENT(int i) {
			return getToken(laParser.IDENT, i);
		}
		public List<TerminalNode> CAMPO() { return getTokens(laParser.CAMPO); }
		public TerminalNode CAMPO(int i) {
			return getToken(laParser.CAMPO, i);
		}
		public IdentificadorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identificador; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterIdentificador(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitIdentificador(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitIdentificador(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentificadorContext identificador() throws RecognitionException {
		IdentificadorContext _localctx = new IdentificadorContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_identificador);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			((IdentificadorContext)_localctx).text = match(IDENT);
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CAMPO) {
				{
				{
				setState(155);
				match(CAMPO);
				setState(156);
				match(IDENT);
				}
				}
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(162);
			dimensao();
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

	public static class DimensaoContext extends ParserRuleContext {
		public List<TerminalNode> ABRECOL() { return getTokens(laParser.ABRECOL); }
		public TerminalNode ABRECOL(int i) {
			return getToken(laParser.ABRECOL, i);
		}
		public List<Exp_aritmeticaContext> exp_aritmetica() {
			return getRuleContexts(Exp_aritmeticaContext.class);
		}
		public Exp_aritmeticaContext exp_aritmetica(int i) {
			return getRuleContext(Exp_aritmeticaContext.class,i);
		}
		public List<TerminalNode> FECHACOL() { return getTokens(laParser.FECHACOL); }
		public TerminalNode FECHACOL(int i) {
			return getToken(laParser.FECHACOL, i);
		}
		public DimensaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimensao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterDimensao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitDimensao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitDimensao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DimensaoContext dimensao() throws RecognitionException {
		DimensaoContext _localctx = new DimensaoContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_dimensao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ABRECOL) {
				{
				{
				setState(164);
				match(ABRECOL);
				setState(165);
				exp_aritmetica();
				setState(166);
				match(FECHACOL);
				}
				}
				setState(172);
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

	public static class TipoContext extends ParserRuleContext {
		public RegistroContext reg;
		public Tipo_estendidoContext ext;
		public RegistroContext registro() {
			return getRuleContext(RegistroContext.class,0);
		}
		public Tipo_estendidoContext tipo_estendido() {
			return getRuleContext(Tipo_estendidoContext.class,0);
		}
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterTipo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitTipo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitTipo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tipo);
		try {
			setState(175);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(173);
				((TipoContext)_localctx).reg = registro();
				}
				break;
			case T__9:
			case T__10:
			case T__11:
			case T__12:
			case T__13:
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(174);
				((TipoContext)_localctx).ext = tipo_estendido();
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

	public static class Tipo_basicoContext extends ParserRuleContext {
		public Token l;
		public Token i;
		public Token r;
		public Token log;
		public Tipo_basicoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_basico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterTipo_basico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitTipo_basico(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitTipo_basico(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_basicoContext tipo_basico() throws RecognitionException {
		Tipo_basicoContext _localctx = new Tipo_basicoContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_tipo_basico);
		try {
			setState(181);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(177);
				((Tipo_basicoContext)_localctx).l = match(T__9);
				}
				break;
			case T__10:
				enterOuterAlt(_localctx, 2);
				{
				setState(178);
				((Tipo_basicoContext)_localctx).i = match(T__10);
				}
				break;
			case T__11:
				enterOuterAlt(_localctx, 3);
				{
				setState(179);
				((Tipo_basicoContext)_localctx).r = match(T__11);
				}
				break;
			case T__12:
				enterOuterAlt(_localctx, 4);
				{
				setState(180);
				((Tipo_basicoContext)_localctx).log = match(T__12);
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

	public static class Tipo_basico_identContext extends ParserRuleContext {
		public Tipo_basicoContext tbas;
		public Token id;
		public Tipo_basicoContext tipo_basico() {
			return getRuleContext(Tipo_basicoContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(laParser.IDENT, 0); }
		public Tipo_basico_identContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_basico_ident; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterTipo_basico_ident(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitTipo_basico_ident(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitTipo_basico_ident(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_basico_identContext tipo_basico_ident() throws RecognitionException {
		Tipo_basico_identContext _localctx = new Tipo_basico_identContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_tipo_basico_ident);
		try {
			setState(185);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
			case T__10:
			case T__11:
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(183);
				((Tipo_basico_identContext)_localctx).tbas = tipo_basico();
				}
				break;
			case IDENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(184);
				((Tipo_basico_identContext)_localctx).id = match(IDENT);
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

	public static class Tipo_estendidoContext extends ParserRuleContext {
		public Tipo_basico_identContext tipo_basico_ident() {
			return getRuleContext(Tipo_basico_identContext.class,0);
		}
		public Tipo_estendidoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_estendido; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterTipo_estendido(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitTipo_estendido(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitTipo_estendido(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_estendidoContext tipo_estendido() throws RecognitionException {
		Tipo_estendidoContext _localctx = new Tipo_estendidoContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_tipo_estendido);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(187);
				match(T__13);
				}
			}

			setState(190);
			tipo_basico_ident();
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

	public static class Valor_constanteContext extends ParserRuleContext {
		public Token cad;
		public Token in;
		public Token re;
		public Token tr;
		public Token fa;
		public TerminalNode CADEIA() { return getToken(laParser.CADEIA, 0); }
		public TerminalNode NUM_INT() { return getToken(laParser.NUM_INT, 0); }
		public TerminalNode NUM_REAL() { return getToken(laParser.NUM_REAL, 0); }
		public Valor_constanteContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valor_constante; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterValor_constante(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitValor_constante(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitValor_constante(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Valor_constanteContext valor_constante() throws RecognitionException {
		Valor_constanteContext _localctx = new Valor_constanteContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_valor_constante);
		try {
			setState(197);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CADEIA:
				enterOuterAlt(_localctx, 1);
				{
				setState(192);
				((Valor_constanteContext)_localctx).cad = match(CADEIA);
				}
				break;
			case NUM_INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(193);
				((Valor_constanteContext)_localctx).in = match(NUM_INT);
				}
				break;
			case NUM_REAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(194);
				((Valor_constanteContext)_localctx).re = match(NUM_REAL);
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 4);
				{
				setState(195);
				((Valor_constanteContext)_localctx).tr = match(T__14);
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 5);
				{
				setState(196);
				((Valor_constanteContext)_localctx).fa = match(T__15);
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

	public static class Declaracao_globalContext extends ParserRuleContext {
		public Token proc;
		public Token id;
		public ParametrosContext par;
		public Declaracao_localContext declaracao_local;
		public List<Declaracao_localContext> decl = new ArrayList<Declaracao_localContext>();
		public CmdContext cmd;
		public List<CmdContext> lcmd = new ArrayList<CmdContext>();
		public Token func;
		public Tipo_estendidoContext tip;
		public TerminalNode ABREPAR() { return getToken(laParser.ABREPAR, 0); }
		public TerminalNode FECHAPAR() { return getToken(laParser.FECHAPAR, 0); }
		public TerminalNode IDENT() { return getToken(laParser.IDENT, 0); }
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public List<Declaracao_localContext> declaracao_local() {
			return getRuleContexts(Declaracao_localContext.class);
		}
		public Declaracao_localContext declaracao_local(int i) {
			return getRuleContext(Declaracao_localContext.class,i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public TerminalNode DOISP() { return getToken(laParser.DOISP, 0); }
		public Tipo_estendidoContext tipo_estendido() {
			return getRuleContext(Tipo_estendidoContext.class,0);
		}
		public Declaracao_globalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracao_global; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterDeclaracao_global(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitDeclaracao_global(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitDeclaracao_global(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Declaracao_globalContext declaracao_global() throws RecognitionException {
		Declaracao_globalContext _localctx = new Declaracao_globalContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_declaracao_global);
		int _la;
		try {
			setState(242);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__16:
				enterOuterAlt(_localctx, 1);
				{
				setState(199);
				((Declaracao_globalContext)_localctx).proc = match(T__16);
				setState(200);
				((Declaracao_globalContext)_localctx).id = match(IDENT);
				setState(201);
				match(ABREPAR);
				setState(203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VAR || _la==IDENT) {
					{
					setState(202);
					((Declaracao_globalContext)_localctx).par = parametros();
					}
				}

				setState(205);
				match(FECHAPAR);
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << DEFINICAO))) != 0)) {
					{
					{
					setState(206);
					((Declaracao_globalContext)_localctx).declaracao_local = declaracao_local();
					((Declaracao_globalContext)_localctx).decl.add(((Declaracao_globalContext)_localctx).declaracao_local);
					}
					}
					setState(211);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(215);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & ((1L << (T__13 - 14)) | (1L << (T__20 - 14)) | (1L << (T__21 - 14)) | (1L << (T__22 - 14)) | (1L << (T__24 - 14)) | (1L << (T__27 - 14)) | (1L << (T__30 - 14)) | (1L << (T__32 - 14)) | (1L << (T__34 - 14)) | (1L << (IDENT - 14)))) != 0)) {
					{
					{
					setState(212);
					((Declaracao_globalContext)_localctx).cmd = cmd();
					((Declaracao_globalContext)_localctx).lcmd.add(((Declaracao_globalContext)_localctx).cmd);
					}
					}
					setState(217);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(218);
				match(T__17);
				}
				break;
			case T__18:
				enterOuterAlt(_localctx, 2);
				{
				setState(219);
				((Declaracao_globalContext)_localctx).func = match(T__18);
				setState(220);
				((Declaracao_globalContext)_localctx).id = match(IDENT);
				setState(221);
				match(ABREPAR);
				setState(223);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==VAR || _la==IDENT) {
					{
					setState(222);
					((Declaracao_globalContext)_localctx).par = parametros();
					}
				}

				setState(225);
				match(FECHAPAR);
				setState(226);
				match(DOISP);
				setState(227);
				((Declaracao_globalContext)_localctx).tip = tipo_estendido();
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << DEFINICAO))) != 0)) {
					{
					{
					setState(228);
					((Declaracao_globalContext)_localctx).declaracao_local = declaracao_local();
					((Declaracao_globalContext)_localctx).decl.add(((Declaracao_globalContext)_localctx).declaracao_local);
					}
					}
					setState(233);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(237);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & ((1L << (T__13 - 14)) | (1L << (T__20 - 14)) | (1L << (T__21 - 14)) | (1L << (T__22 - 14)) | (1L << (T__24 - 14)) | (1L << (T__27 - 14)) | (1L << (T__30 - 14)) | (1L << (T__32 - 14)) | (1L << (T__34 - 14)) | (1L << (IDENT - 14)))) != 0)) {
					{
					{
					setState(234);
					((Declaracao_globalContext)_localctx).cmd = cmd();
					((Declaracao_globalContext)_localctx).lcmd.add(((Declaracao_globalContext)_localctx).cmd);
					}
					}
					setState(239);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(240);
				match(T__19);
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

	public static class ParametroContext extends ParserRuleContext {
		public IdentificadorContext id1;
		public IdentificadorContext identificador;
		public List<IdentificadorContext> outrosids = new ArrayList<IdentificadorContext>();
		public Tipo_estendidoContext tip;
		public TerminalNode DOISP() { return getToken(laParser.DOISP, 0); }
		public List<IdentificadorContext> identificador() {
			return getRuleContexts(IdentificadorContext.class);
		}
		public IdentificadorContext identificador(int i) {
			return getRuleContext(IdentificadorContext.class,i);
		}
		public Tipo_estendidoContext tipo_estendido() {
			return getRuleContext(Tipo_estendidoContext.class,0);
		}
		public TerminalNode VAR() { return getToken(laParser.VAR, 0); }
		public List<TerminalNode> VIRGULA() { return getTokens(laParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(laParser.VIRGULA, i);
		}
		public ParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterParametro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitParametro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitParametro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametroContext parametro() throws RecognitionException {
		ParametroContext _localctx = new ParametroContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_parametro);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAR) {
				{
				setState(244);
				match(VAR);
				}
			}

			setState(247);
			((ParametroContext)_localctx).id1 = identificador();
			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(248);
				match(VIRGULA);
				setState(249);
				((ParametroContext)_localctx).identificador = identificador();
				((ParametroContext)_localctx).outrosids.add(((ParametroContext)_localctx).identificador);
				}
				}
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(255);
			match(DOISP);
			setState(256);
			((ParametroContext)_localctx).tip = tipo_estendido();
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

	public static class ParametrosContext extends ParserRuleContext {
		public ParametroContext par1;
		public ParametroContext parametro;
		public List<ParametroContext> outrospar = new ArrayList<ParametroContext>();
		public List<ParametroContext> parametro() {
			return getRuleContexts(ParametroContext.class);
		}
		public ParametroContext parametro(int i) {
			return getRuleContext(ParametroContext.class,i);
		}
		public List<TerminalNode> VIRGULA() { return getTokens(laParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(laParser.VIRGULA, i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterParametros(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitParametros(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitParametros(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			((ParametrosContext)_localctx).par1 = parametro();
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(259);
				match(VIRGULA);
				setState(260);
				((ParametrosContext)_localctx).parametro = parametro();
				((ParametrosContext)_localctx).outrospar.add(((ParametrosContext)_localctx).parametro);
				}
				}
				setState(265);
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

	public static class CorpoContext extends ParserRuleContext {
		public List<Declaracao_localContext> declaracao_local() {
			return getRuleContexts(Declaracao_localContext.class);
		}
		public Declaracao_localContext declaracao_local(int i) {
			return getRuleContext(Declaracao_localContext.class,i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CorpoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_corpo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterCorpo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitCorpo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitCorpo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CorpoContext corpo() throws RecognitionException {
		CorpoContext _localctx = new CorpoContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_corpo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__6) | (1L << T__7) | (1L << DEFINICAO))) != 0)) {
				{
				{
				setState(266);
				declaracao_local();
				}
				}
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & ((1L << (T__13 - 14)) | (1L << (T__20 - 14)) | (1L << (T__21 - 14)) | (1L << (T__22 - 14)) | (1L << (T__24 - 14)) | (1L << (T__27 - 14)) | (1L << (T__30 - 14)) | (1L << (T__32 - 14)) | (1L << (T__34 - 14)) | (1L << (IDENT - 14)))) != 0)) {
				{
				{
				setState(272);
				cmd();
				}
				}
				setState(277);
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

	public static class CmdContext extends ParserRuleContext {
		public CmdLeiaContext cmdLeia() {
			return getRuleContext(CmdLeiaContext.class,0);
		}
		public CmdEscrevaContext cmdEscreva() {
			return getRuleContext(CmdEscrevaContext.class,0);
		}
		public CmdSeContext cmdSe() {
			return getRuleContext(CmdSeContext.class,0);
		}
		public CmdCasoContext cmdCaso() {
			return getRuleContext(CmdCasoContext.class,0);
		}
		public CmdParaContext cmdPara() {
			return getRuleContext(CmdParaContext.class,0);
		}
		public CmdEnquantoContext cmdEnquanto() {
			return getRuleContext(CmdEnquantoContext.class,0);
		}
		public CmdFacaContext cmdFaca() {
			return getRuleContext(CmdFacaContext.class,0);
		}
		public CmdAtribuicaoContext cmdAtribuicao() {
			return getRuleContext(CmdAtribuicaoContext.class,0);
		}
		public CmdChamadaContext cmdChamada() {
			return getRuleContext(CmdChamadaContext.class,0);
		}
		public CmdRetorneContext cmdRetorne() {
			return getRuleContext(CmdRetorneContext.class,0);
		}
		public CmdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterCmd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitCmd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitCmd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdContext cmd() throws RecognitionException {
		CmdContext _localctx = new CmdContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_cmd);
		try {
			setState(288);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(278);
				cmdLeia();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(279);
				cmdEscreva();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(280);
				cmdSe();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(281);
				cmdCaso();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(282);
				cmdPara();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(283);
				cmdEnquanto();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(284);
				cmdFaca();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(285);
				cmdAtribuicao();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(286);
				cmdChamada();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(287);
				cmdRetorne();
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

	public static class CmdLeiaContext extends ParserRuleContext {
		public IdentificadorContext id1;
		public IdentificadorContext identificador;
		public List<IdentificadorContext> outrosids = new ArrayList<IdentificadorContext>();
		public TerminalNode ABREPAR() { return getToken(laParser.ABREPAR, 0); }
		public TerminalNode FECHAPAR() { return getToken(laParser.FECHAPAR, 0); }
		public List<IdentificadorContext> identificador() {
			return getRuleContexts(IdentificadorContext.class);
		}
		public IdentificadorContext identificador(int i) {
			return getRuleContext(IdentificadorContext.class,i);
		}
		public List<TerminalNode> VIRGULA() { return getTokens(laParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(laParser.VIRGULA, i);
		}
		public CmdLeiaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdLeia; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterCmdLeia(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitCmdLeia(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitCmdLeia(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdLeiaContext cmdLeia() throws RecognitionException {
		CmdLeiaContext _localctx = new CmdLeiaContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_cmdLeia);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(290);
			match(T__20);
			setState(291);
			match(ABREPAR);
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(292);
				match(T__13);
				}
			}

			setState(295);
			((CmdLeiaContext)_localctx).id1 = identificador();
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(296);
				match(VIRGULA);
				setState(298);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(297);
					match(T__13);
					}
				}

				setState(300);
				((CmdLeiaContext)_localctx).identificador = identificador();
				((CmdLeiaContext)_localctx).outrosids.add(((CmdLeiaContext)_localctx).identificador);
				}
				}
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(306);
			match(FECHAPAR);
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

	public static class CmdEscrevaContext extends ParserRuleContext {
		public ExpressaoContext exp1;
		public ExpressaoContext expressao;
		public List<ExpressaoContext> outrosexp = new ArrayList<ExpressaoContext>();
		public TerminalNode ABREPAR() { return getToken(laParser.ABREPAR, 0); }
		public TerminalNode FECHAPAR() { return getToken(laParser.FECHAPAR, 0); }
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public List<TerminalNode> VIRGULA() { return getTokens(laParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(laParser.VIRGULA, i);
		}
		public CmdEscrevaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEscreva; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterCmdEscreva(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitCmdEscreva(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitCmdEscreva(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdEscrevaContext cmdEscreva() throws RecognitionException {
		CmdEscrevaContext _localctx = new CmdEscrevaContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_cmdEscreva);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			match(T__21);
			setState(309);
			match(ABREPAR);
			setState(310);
			((CmdEscrevaContext)_localctx).exp1 = expressao();
			setState(315);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(311);
				match(VIRGULA);
				setState(312);
				((CmdEscrevaContext)_localctx).expressao = expressao();
				((CmdEscrevaContext)_localctx).outrosexp.add(((CmdEscrevaContext)_localctx).expressao);
				}
				}
				setState(317);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(318);
			match(FECHAPAR);
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

	public static class CmdSeContext extends ParserRuleContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode THEN() { return getToken(laParser.THEN, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(laParser.ELSE, 0); }
		public CmdSeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdSe; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterCmdSe(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitCmdSe(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitCmdSe(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdSeContext cmdSe() throws RecognitionException {
		CmdSeContext _localctx = new CmdSeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_cmdSe);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(320);
			match(T__22);
			setState(321);
			expressao();
			setState(322);
			match(THEN);
			setState(326);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & ((1L << (T__13 - 14)) | (1L << (T__20 - 14)) | (1L << (T__21 - 14)) | (1L << (T__22 - 14)) | (1L << (T__24 - 14)) | (1L << (T__27 - 14)) | (1L << (T__30 - 14)) | (1L << (T__32 - 14)) | (1L << (T__34 - 14)) | (1L << (IDENT - 14)))) != 0)) {
				{
				{
				setState(323);
				cmd();
				}
				}
				setState(328);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(329);
				match(ELSE);
				setState(333);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & ((1L << (T__13 - 14)) | (1L << (T__20 - 14)) | (1L << (T__21 - 14)) | (1L << (T__22 - 14)) | (1L << (T__24 - 14)) | (1L << (T__27 - 14)) | (1L << (T__30 - 14)) | (1L << (T__32 - 14)) | (1L << (T__34 - 14)) | (1L << (IDENT - 14)))) != 0)) {
					{
					{
					setState(330);
					cmd();
					}
					}
					setState(335);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(338);
			match(T__23);
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

	public static class CmdCasoContext extends ParserRuleContext {
		public Exp_aritmeticaContext exp_aritmetica() {
			return getRuleContext(Exp_aritmeticaContext.class,0);
		}
		public SelecaoContext selecao() {
			return getRuleContext(SelecaoContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(laParser.ELSE, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdCasoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdCaso; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterCmdCaso(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitCmdCaso(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitCmdCaso(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdCasoContext cmdCaso() throws RecognitionException {
		CmdCasoContext _localctx = new CmdCasoContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_cmdCaso);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(340);
			match(T__24);
			setState(341);
			exp_aritmetica();
			setState(342);
			match(T__25);
			setState(343);
			selecao();
			setState(351);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(344);
				match(ELSE);
				setState(348);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & ((1L << (T__13 - 14)) | (1L << (T__20 - 14)) | (1L << (T__21 - 14)) | (1L << (T__22 - 14)) | (1L << (T__24 - 14)) | (1L << (T__27 - 14)) | (1L << (T__30 - 14)) | (1L << (T__32 - 14)) | (1L << (T__34 - 14)) | (1L << (IDENT - 14)))) != 0)) {
					{
					{
					setState(345);
					cmd();
					}
					}
					setState(350);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(353);
			match(T__26);
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

	public static class CmdParaContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(laParser.IDENT, 0); }
		public List<Exp_aritmeticaContext> exp_aritmetica() {
			return getRuleContexts(Exp_aritmeticaContext.class);
		}
		public Exp_aritmeticaContext exp_aritmetica(int i) {
			return getRuleContext(Exp_aritmeticaContext.class,i);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdParaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdPara; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterCmdPara(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitCmdPara(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitCmdPara(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdParaContext cmdPara() throws RecognitionException {
		CmdParaContext _localctx = new CmdParaContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_cmdPara);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			match(T__27);
			setState(356);
			match(IDENT);
			setState(357);
			match(T__28);
			setState(358);
			exp_aritmetica();
			setState(359);
			match(T__29);
			setState(360);
			exp_aritmetica();
			setState(361);
			match(T__30);
			setState(365);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & ((1L << (T__13 - 14)) | (1L << (T__20 - 14)) | (1L << (T__21 - 14)) | (1L << (T__22 - 14)) | (1L << (T__24 - 14)) | (1L << (T__27 - 14)) | (1L << (T__30 - 14)) | (1L << (T__32 - 14)) | (1L << (T__34 - 14)) | (1L << (IDENT - 14)))) != 0)) {
				{
				{
				setState(362);
				cmd();
				}
				}
				setState(367);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(368);
			match(T__31);
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

	public static class CmdEnquantoContext extends ParserRuleContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdEnquantoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdEnquanto; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterCmdEnquanto(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitCmdEnquanto(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitCmdEnquanto(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdEnquantoContext cmdEnquanto() throws RecognitionException {
		CmdEnquantoContext _localctx = new CmdEnquantoContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_cmdEnquanto);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			match(T__32);
			setState(371);
			expressao();
			setState(372);
			match(T__30);
			setState(376);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & ((1L << (T__13 - 14)) | (1L << (T__20 - 14)) | (1L << (T__21 - 14)) | (1L << (T__22 - 14)) | (1L << (T__24 - 14)) | (1L << (T__27 - 14)) | (1L << (T__30 - 14)) | (1L << (T__32 - 14)) | (1L << (T__34 - 14)) | (1L << (IDENT - 14)))) != 0)) {
				{
				{
				setState(373);
				cmd();
				}
				}
				setState(378);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(379);
			match(T__33);
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

	public static class CmdFacaContext extends ParserRuleContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public CmdFacaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdFaca; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterCmdFaca(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitCmdFaca(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitCmdFaca(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdFacaContext cmdFaca() throws RecognitionException {
		CmdFacaContext _localctx = new CmdFacaContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_cmdFaca);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(381);
			match(T__30);
			setState(385);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & ((1L << (T__13 - 14)) | (1L << (T__20 - 14)) | (1L << (T__21 - 14)) | (1L << (T__22 - 14)) | (1L << (T__24 - 14)) | (1L << (T__27 - 14)) | (1L << (T__30 - 14)) | (1L << (T__32 - 14)) | (1L << (T__34 - 14)) | (1L << (IDENT - 14)))) != 0)) {
				{
				{
				setState(382);
				cmd();
				}
				}
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(388);
			match(T__29);
			setState(389);
			expressao();
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

	public static class CmdAtribuicaoContext extends ParserRuleContext {
		public Token chap;
		public IdentificadorContext id;
		public ExpressaoContext exp;
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public CmdAtribuicaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdAtribuicao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterCmdAtribuicao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitCmdAtribuicao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitCmdAtribuicao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdAtribuicaoContext cmdAtribuicao() throws RecognitionException {
		CmdAtribuicaoContext _localctx = new CmdAtribuicaoContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_cmdAtribuicao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(392);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__13) {
				{
				setState(391);
				((CmdAtribuicaoContext)_localctx).chap = match(T__13);
				}
			}

			setState(394);
			((CmdAtribuicaoContext)_localctx).id = identificador();
			setState(395);
			match(T__28);
			setState(396);
			((CmdAtribuicaoContext)_localctx).exp = expressao();
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

	public static class CmdChamadaContext extends ParserRuleContext {
		public Token id1;
		public ExpressaoContext exp1;
		public ExpressaoContext expressao;
		public List<ExpressaoContext> outrasexp = new ArrayList<ExpressaoContext>();
		public TerminalNode ABREPAR() { return getToken(laParser.ABREPAR, 0); }
		public TerminalNode FECHAPAR() { return getToken(laParser.FECHAPAR, 0); }
		public TerminalNode IDENT() { return getToken(laParser.IDENT, 0); }
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public List<TerminalNode> VIRGULA() { return getTokens(laParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(laParser.VIRGULA, i);
		}
		public CmdChamadaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdChamada; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterCmdChamada(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitCmdChamada(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitCmdChamada(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdChamadaContext cmdChamada() throws RecognitionException {
		CmdChamadaContext _localctx = new CmdChamadaContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_cmdChamada);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
			((CmdChamadaContext)_localctx).id1 = match(IDENT);
			setState(399);
			match(ABREPAR);
			setState(400);
			((CmdChamadaContext)_localctx).exp1 = expressao();
			setState(405);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(401);
				match(VIRGULA);
				setState(402);
				((CmdChamadaContext)_localctx).expressao = expressao();
				((CmdChamadaContext)_localctx).outrasexp.add(((CmdChamadaContext)_localctx).expressao);
				}
				}
				setState(407);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(408);
			match(FECHAPAR);
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

	public static class CmdRetorneContext extends ParserRuleContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public CmdRetorneContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cmdRetorne; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterCmdRetorne(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitCmdRetorne(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitCmdRetorne(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CmdRetorneContext cmdRetorne() throws RecognitionException {
		CmdRetorneContext _localctx = new CmdRetorneContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_cmdRetorne);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(410);
			match(T__34);
			setState(411);
			expressao();
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

	public static class SelecaoContext extends ParserRuleContext {
		public List<Item_selecaoContext> item_selecao() {
			return getRuleContexts(Item_selecaoContext.class);
		}
		public Item_selecaoContext item_selecao(int i) {
			return getRuleContext(Item_selecaoContext.class,i);
		}
		public SelecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterSelecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitSelecao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitSelecao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SelecaoContext selecao() throws RecognitionException {
		SelecaoContext _localctx = new SelecaoContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_selecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(416);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__35 || _la==NUM_INT) {
				{
				{
				setState(413);
				item_selecao();
				}
				}
				setState(418);
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

	public static class Item_selecaoContext extends ParserRuleContext {
		public ConstantesContext constantes() {
			return getRuleContext(ConstantesContext.class,0);
		}
		public TerminalNode DOISP() { return getToken(laParser.DOISP, 0); }
		public List<CmdContext> cmd() {
			return getRuleContexts(CmdContext.class);
		}
		public CmdContext cmd(int i) {
			return getRuleContext(CmdContext.class,i);
		}
		public Item_selecaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_item_selecao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterItem_selecao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitItem_selecao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitItem_selecao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Item_selecaoContext item_selecao() throws RecognitionException {
		Item_selecaoContext _localctx = new Item_selecaoContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_item_selecao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(419);
			constantes();
			setState(420);
			match(DOISP);
			setState(424);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 14)) & ~0x3f) == 0 && ((1L << (_la - 14)) & ((1L << (T__13 - 14)) | (1L << (T__20 - 14)) | (1L << (T__21 - 14)) | (1L << (T__22 - 14)) | (1L << (T__24 - 14)) | (1L << (T__27 - 14)) | (1L << (T__30 - 14)) | (1L << (T__32 - 14)) | (1L << (T__34 - 14)) | (1L << (IDENT - 14)))) != 0)) {
				{
				{
				setState(421);
				cmd();
				}
				}
				setState(426);
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

	public static class ConstantesContext extends ParserRuleContext {
		public List<Numero_intervaloContext> numero_intervalo() {
			return getRuleContexts(Numero_intervaloContext.class);
		}
		public Numero_intervaloContext numero_intervalo(int i) {
			return getRuleContext(Numero_intervaloContext.class,i);
		}
		public List<TerminalNode> VIRGULA() { return getTokens(laParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(laParser.VIRGULA, i);
		}
		public ConstantesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterConstantes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitConstantes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitConstantes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantesContext constantes() throws RecognitionException {
		ConstantesContext _localctx = new ConstantesContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_constantes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			numero_intervalo();
			setState(432);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VIRGULA) {
				{
				{
				setState(428);
				match(VIRGULA);
				setState(429);
				numero_intervalo();
				}
				}
				setState(434);
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

	public static class Numero_intervaloContext extends ParserRuleContext {
		public List<TerminalNode> NUM_INT() { return getTokens(laParser.NUM_INT); }
		public TerminalNode NUM_INT(int i) {
			return getToken(laParser.NUM_INT, i);
		}
		public List<Op_unarioContext> op_unario() {
			return getRuleContexts(Op_unarioContext.class);
		}
		public Op_unarioContext op_unario(int i) {
			return getRuleContext(Op_unarioContext.class,i);
		}
		public TerminalNode INTERVALO() { return getToken(laParser.INTERVALO, 0); }
		public Numero_intervaloContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numero_intervalo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterNumero_intervalo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitNumero_intervalo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitNumero_intervalo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Numero_intervaloContext numero_intervalo() throws RecognitionException {
		Numero_intervaloContext _localctx = new Numero_intervaloContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_numero_intervalo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(436);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__35) {
				{
				setState(435);
				op_unario();
				}
			}

			setState(438);
			match(NUM_INT);
			setState(444);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INTERVALO) {
				{
				setState(439);
				match(INTERVALO);
				setState(441);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__35) {
					{
					setState(440);
					op_unario();
					}
				}

				setState(443);
				match(NUM_INT);
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

	public static class Op_unarioContext extends ParserRuleContext {
		public Op_unarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_unario; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterOp_unario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitOp_unario(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitOp_unario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_unarioContext op_unario() throws RecognitionException {
		Op_unarioContext _localctx = new Op_unarioContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_op_unario);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			match(T__35);
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

	public static class Exp_aritmeticaContext extends ParserRuleContext {
		public TermoContext termo1;
		public TermoContext termo;
		public List<TermoContext> outrostermos = new ArrayList<TermoContext>();
		public List<TermoContext> termo() {
			return getRuleContexts(TermoContext.class);
		}
		public TermoContext termo(int i) {
			return getRuleContext(TermoContext.class,i);
		}
		public List<Op1Context> op1() {
			return getRuleContexts(Op1Context.class);
		}
		public Op1Context op1(int i) {
			return getRuleContext(Op1Context.class,i);
		}
		public Exp_aritmeticaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_aritmetica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterExp_aritmetica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitExp_aritmetica(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitExp_aritmetica(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp_aritmeticaContext exp_aritmetica() throws RecognitionException {
		Exp_aritmeticaContext _localctx = new Exp_aritmeticaContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_exp_aritmetica);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			((Exp_aritmeticaContext)_localctx).termo1 = termo();
			setState(454);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(449);
					op1();
					setState(450);
					((Exp_aritmeticaContext)_localctx).termo = termo();
					((Exp_aritmeticaContext)_localctx).outrostermos.add(((Exp_aritmeticaContext)_localctx).termo);
					}
					} 
				}
				setState(456);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
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

	public static class TermoContext extends ParserRuleContext {
		public FatorContext fator1;
		public FatorContext fator;
		public List<FatorContext> outrosfatores = new ArrayList<FatorContext>();
		public List<FatorContext> fator() {
			return getRuleContexts(FatorContext.class);
		}
		public FatorContext fator(int i) {
			return getRuleContext(FatorContext.class,i);
		}
		public List<Op2Context> op2() {
			return getRuleContexts(Op2Context.class);
		}
		public Op2Context op2(int i) {
			return getRuleContext(Op2Context.class,i);
		}
		public TermoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterTermo(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitTermo(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitTermo(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermoContext termo() throws RecognitionException {
		TermoContext _localctx = new TermoContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_termo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(457);
			((TermoContext)_localctx).fator1 = fator();
			setState(463);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__37 || _la==T__38) {
				{
				{
				setState(458);
				op2();
				setState(459);
				((TermoContext)_localctx).fator = fator();
				((TermoContext)_localctx).outrosfatores.add(((TermoContext)_localctx).fator);
				}
				}
				setState(465);
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

	public static class FatorContext extends ParserRuleContext {
		public ParcelaContext parcela1;
		public ParcelaContext parcela;
		public List<ParcelaContext> outrasparcelas = new ArrayList<ParcelaContext>();
		public List<ParcelaContext> parcela() {
			return getRuleContexts(ParcelaContext.class);
		}
		public ParcelaContext parcela(int i) {
			return getRuleContext(ParcelaContext.class,i);
		}
		public List<Op3Context> op3() {
			return getRuleContexts(Op3Context.class);
		}
		public Op3Context op3(int i) {
			return getRuleContext(Op3Context.class,i);
		}
		public FatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterFator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitFator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitFator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FatorContext fator() throws RecognitionException {
		FatorContext _localctx = new FatorContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_fator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(466);
			((FatorContext)_localctx).parcela1 = parcela();
			setState(472);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__39) {
				{
				{
				setState(467);
				op3();
				setState(468);
				((FatorContext)_localctx).parcela = parcela();
				((FatorContext)_localctx).outrasparcelas.add(((FatorContext)_localctx).parcela);
				}
				}
				setState(474);
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

	public static class Op1Context extends ParserRuleContext {
		public Op1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterOp1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitOp1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitOp1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op1Context op1() throws RecognitionException {
		Op1Context _localctx = new Op1Context(_ctx, getState());
		enterRule(_localctx, 76, RULE_op1);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(475);
			_la = _input.LA(1);
			if ( !(_la==T__35 || _la==T__36) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Op2Context extends ParserRuleContext {
		public Op2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op2; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterOp2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitOp2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitOp2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op2Context op2() throws RecognitionException {
		Op2Context _localctx = new Op2Context(_ctx, getState());
		enterRule(_localctx, 78, RULE_op2);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			_la = _input.LA(1);
			if ( !(_la==T__37 || _la==T__38) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Op3Context extends ParserRuleContext {
		public Op3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op3; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterOp3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitOp3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitOp3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op3Context op3() throws RecognitionException {
		Op3Context _localctx = new Op3Context(_ctx, getState());
		enterRule(_localctx, 80, RULE_op3);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
			match(T__39);
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

	public static class ParcelaContext extends ParserRuleContext {
		public Op_unarioContext opuna;
		public Parcela_unarioContext puna;
		public Parcela_nao_unarioContext pnuna;
		public Parcela_unarioContext parcela_unario() {
			return getRuleContext(Parcela_unarioContext.class,0);
		}
		public Op_unarioContext op_unario() {
			return getRuleContext(Op_unarioContext.class,0);
		}
		public Parcela_nao_unarioContext parcela_nao_unario() {
			return getRuleContext(Parcela_nao_unarioContext.class,0);
		}
		public ParcelaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parcela; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterParcela(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitParcela(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitParcela(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParcelaContext parcela() throws RecognitionException {
		ParcelaContext _localctx = new ParcelaContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_parcela);
		int _la;
		try {
			setState(486);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__13:
			case T__35:
			case NUM_INT:
			case NUM_REAL:
			case IDENT:
			case ABREPAR:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(482);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__35) {
					{
					setState(481);
					((ParcelaContext)_localctx).opuna = op_unario();
					}
				}

				setState(484);
				((ParcelaContext)_localctx).puna = parcela_unario();
				}
				}
				break;
			case T__40:
			case CADEIA:
				enterOuterAlt(_localctx, 2);
				{
				setState(485);
				((ParcelaContext)_localctx).pnuna = parcela_nao_unario();
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

	public static class Parcela_unarioContext extends ParserRuleContext {
		public Token chapeu;
		public IdentificadorContext iden;
		public Token id;
		public ExpressaoContext exp1;
		public ExpressaoContext expressao;
		public List<ExpressaoContext> outrasexps = new ArrayList<ExpressaoContext>();
		public Token inte;
		public Token real;
		public ExpressaoContext exp_par;
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public TerminalNode ABREPAR() { return getToken(laParser.ABREPAR, 0); }
		public TerminalNode FECHAPAR() { return getToken(laParser.FECHAPAR, 0); }
		public TerminalNode IDENT() { return getToken(laParser.IDENT, 0); }
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public List<TerminalNode> VIRGULA() { return getTokens(laParser.VIRGULA); }
		public TerminalNode VIRGULA(int i) {
			return getToken(laParser.VIRGULA, i);
		}
		public TerminalNode NUM_INT() { return getToken(laParser.NUM_INT, 0); }
		public TerminalNode NUM_REAL() { return getToken(laParser.NUM_REAL, 0); }
		public Parcela_unarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parcela_unario; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterParcela_unario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitParcela_unario(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitParcela_unario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parcela_unarioContext parcela_unario() throws RecognitionException {
		Parcela_unarioContext _localctx = new Parcela_unarioContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_parcela_unario);
		int _la;
		try {
			setState(510);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				{
				setState(489);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__13) {
					{
					setState(488);
					((Parcela_unarioContext)_localctx).chapeu = match(T__13);
					}
				}

				setState(491);
				((Parcela_unarioContext)_localctx).iden = identificador();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(492);
				((Parcela_unarioContext)_localctx).id = match(IDENT);
				setState(493);
				match(ABREPAR);
				setState(494);
				((Parcela_unarioContext)_localctx).exp1 = expressao();
				setState(499);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==VIRGULA) {
					{
					{
					setState(495);
					match(VIRGULA);
					setState(496);
					((Parcela_unarioContext)_localctx).expressao = expressao();
					((Parcela_unarioContext)_localctx).outrasexps.add(((Parcela_unarioContext)_localctx).expressao);
					}
					}
					setState(501);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(502);
				match(FECHAPAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(504);
				((Parcela_unarioContext)_localctx).inte = match(NUM_INT);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(505);
				((Parcela_unarioContext)_localctx).real = match(NUM_REAL);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(506);
				match(ABREPAR);
				setState(507);
				((Parcela_unarioContext)_localctx).exp_par = expressao();
				setState(508);
				match(FECHAPAR);
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

	public static class Parcela_nao_unarioContext extends ParserRuleContext {
		public Token comercial;
		public Token cad;
		public IdentificadorContext identificador() {
			return getRuleContext(IdentificadorContext.class,0);
		}
		public TerminalNode CADEIA() { return getToken(laParser.CADEIA, 0); }
		public Parcela_nao_unarioContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parcela_nao_unario; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterParcela_nao_unario(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitParcela_nao_unario(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitParcela_nao_unario(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parcela_nao_unarioContext parcela_nao_unario() throws RecognitionException {
		Parcela_nao_unarioContext _localctx = new Parcela_nao_unarioContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_parcela_nao_unario);
		try {
			setState(515);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__40:
				enterOuterAlt(_localctx, 1);
				{
				setState(512);
				((Parcela_nao_unarioContext)_localctx).comercial = match(T__40);
				setState(513);
				identificador();
				}
				break;
			case CADEIA:
				enterOuterAlt(_localctx, 2);
				{
				setState(514);
				((Parcela_nao_unarioContext)_localctx).cad = match(CADEIA);
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

	public static class Exp_relacionalContext extends ParserRuleContext {
		public Exp_aritmeticaContext exp1;
		public Op_relacionalContext oprel;
		public Exp_aritmeticaContext exp_aritmetica;
		public List<Exp_aritmeticaContext> outrasexp = new ArrayList<Exp_aritmeticaContext>();
		public List<Exp_aritmeticaContext> exp_aritmetica() {
			return getRuleContexts(Exp_aritmeticaContext.class);
		}
		public Exp_aritmeticaContext exp_aritmetica(int i) {
			return getRuleContext(Exp_aritmeticaContext.class,i);
		}
		public Op_relacionalContext op_relacional() {
			return getRuleContext(Op_relacionalContext.class,0);
		}
		public Exp_relacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exp_relacional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterExp_relacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitExp_relacional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitExp_relacional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exp_relacionalContext exp_relacional() throws RecognitionException {
		Exp_relacionalContext _localctx = new Exp_relacionalContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_exp_relacional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(517);
			((Exp_relacionalContext)_localctx).exp1 = exp_aritmetica();
			setState(521);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45))) != 0)) {
				{
				setState(518);
				((Exp_relacionalContext)_localctx).oprel = op_relacional();
				setState(519);
				((Exp_relacionalContext)_localctx).exp_aritmetica = exp_aritmetica();
				((Exp_relacionalContext)_localctx).outrasexp.add(((Exp_relacionalContext)_localctx).exp_aritmetica);
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

	public static class Op_relacionalContext extends ParserRuleContext {
		public Op_relacionalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_relacional; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterOp_relacional(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitOp_relacional(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitOp_relacional(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_relacionalContext op_relacional() throws RecognitionException {
		Op_relacionalContext _localctx = new Op_relacionalContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_op_relacional);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(523);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << T__41) | (1L << T__42) | (1L << T__43) | (1L << T__44) | (1L << T__45))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class ExpressaoContext extends ParserRuleContext {
		public Termo_logicoContext tl;
		public Termo_logicoContext termo_logico;
		public List<Termo_logicoContext> outrostl = new ArrayList<Termo_logicoContext>();
		public List<Termo_logicoContext> termo_logico() {
			return getRuleContexts(Termo_logicoContext.class);
		}
		public Termo_logicoContext termo_logico(int i) {
			return getRuleContext(Termo_logicoContext.class,i);
		}
		public List<Op_logico_1Context> op_logico_1() {
			return getRuleContexts(Op_logico_1Context.class);
		}
		public Op_logico_1Context op_logico_1(int i) {
			return getRuleContext(Op_logico_1Context.class,i);
		}
		public ExpressaoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressao; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterExpressao(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitExpressao(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitExpressao(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressaoContext expressao() throws RecognitionException {
		ExpressaoContext _localctx = new ExpressaoContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_expressao);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(525);
			((ExpressaoContext)_localctx).tl = termo_logico();
			setState(531);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(526);
				op_logico_1();
				setState(527);
				((ExpressaoContext)_localctx).termo_logico = termo_logico();
				((ExpressaoContext)_localctx).outrostl.add(((ExpressaoContext)_localctx).termo_logico);
				}
				}
				setState(533);
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

	public static class Termo_logicoContext extends ParserRuleContext {
		public Fator_logicoContext f1;
		public Fator_logicoContext fator_logico;
		public List<Fator_logicoContext> outrosf = new ArrayList<Fator_logicoContext>();
		public List<Fator_logicoContext> fator_logico() {
			return getRuleContexts(Fator_logicoContext.class);
		}
		public Fator_logicoContext fator_logico(int i) {
			return getRuleContext(Fator_logicoContext.class,i);
		}
		public List<Op_logico_2Context> op_logico_2() {
			return getRuleContexts(Op_logico_2Context.class);
		}
		public Op_logico_2Context op_logico_2(int i) {
			return getRuleContext(Op_logico_2Context.class,i);
		}
		public Termo_logicoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_termo_logico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterTermo_logico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitTermo_logico(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitTermo_logico(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Termo_logicoContext termo_logico() throws RecognitionException {
		Termo_logicoContext _localctx = new Termo_logicoContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_termo_logico);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(534);
			((Termo_logicoContext)_localctx).f1 = fator_logico();
			setState(540);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__1) {
				{
				{
				setState(535);
				op_logico_2();
				setState(536);
				((Termo_logicoContext)_localctx).fator_logico = fator_logico();
				((Termo_logicoContext)_localctx).outrosf.add(((Termo_logicoContext)_localctx).fator_logico);
				}
				}
				setState(542);
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

	public static class Fator_logicoContext extends ParserRuleContext {
		public Token not;
		public Parcela_logicaContext plogica;
		public Parcela_logicaContext parcela_logica() {
			return getRuleContext(Parcela_logicaContext.class,0);
		}
		public TerminalNode NOT() { return getToken(laParser.NOT, 0); }
		public Fator_logicoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fator_logico; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterFator_logico(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitFator_logico(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitFator_logico(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fator_logicoContext fator_logico() throws RecognitionException {
		Fator_logicoContext _localctx = new Fator_logicoContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_fator_logico);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(544);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NOT) {
				{
				setState(543);
				((Fator_logicoContext)_localctx).not = match(NOT);
				}
			}

			setState(546);
			((Fator_logicoContext)_localctx).plogica = parcela_logica();
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

	public static class Parcela_logicaContext extends ParserRuleContext {
		public Token v;
		public Token f;
		public Exp_relacionalContext exp;
		public Exp_relacionalContext exp_relacional() {
			return getRuleContext(Exp_relacionalContext.class,0);
		}
		public Parcela_logicaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parcela_logica; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).enterParcela_logica(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof laListener ) ((laListener)listener).exitParcela_logica(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof laVisitor ) return ((laVisitor<? extends T>)visitor).visitParcela_logica(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parcela_logicaContext parcela_logica() throws RecognitionException {
		Parcela_logicaContext _localctx = new Parcela_logicaContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_parcela_logica);
		try {
			setState(551);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__14:
				enterOuterAlt(_localctx, 1);
				{
				setState(548);
				((Parcela_logicaContext)_localctx).v = match(T__14);
				}
				break;
			case T__15:
				enterOuterAlt(_localctx, 2);
				{
				setState(549);
				((Parcela_logicaContext)_localctx).f = match(T__15);
				}
				break;
			case T__13:
			case T__35:
			case T__40:
			case NUM_INT:
			case NUM_REAL:
			case IDENT:
			case ABREPAR:
			case CADEIA:
				enterOuterAlt(_localctx, 3);
				{
				setState(550);
				((Parcela_logicaContext)_localctx).exp = exp_relacional();
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3X\u022c\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\3\2\3\2"+
		"\3\3\3\3\3\4\3\4\7\4m\n\4\f\4\16\4p\13\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\6\7\6z\n\6\f\6\16\6}\13\6\3\7\3\7\5\7\u0081\n\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u0090\n\b\3\t\3\t\3\t\7\t\u0095\n\t"+
		"\f\t\16\t\u0098\13\t\3\t\3\t\3\t\3\n\3\n\3\n\7\n\u00a0\n\n\f\n\16\n\u00a3"+
		"\13\n\3\n\3\n\3\13\3\13\3\13\3\13\7\13\u00ab\n\13\f\13\16\13\u00ae\13"+
		"\13\3\f\3\f\5\f\u00b2\n\f\3\r\3\r\3\r\3\r\5\r\u00b8\n\r\3\16\3\16\5\16"+
		"\u00bc\n\16\3\17\5\17\u00bf\n\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\5"+
		"\20\u00c8\n\20\3\21\3\21\3\21\3\21\5\21\u00ce\n\21\3\21\3\21\7\21\u00d2"+
		"\n\21\f\21\16\21\u00d5\13\21\3\21\7\21\u00d8\n\21\f\21\16\21\u00db\13"+
		"\21\3\21\3\21\3\21\3\21\3\21\5\21\u00e2\n\21\3\21\3\21\3\21\3\21\7\21"+
		"\u00e8\n\21\f\21\16\21\u00eb\13\21\3\21\7\21\u00ee\n\21\f\21\16\21\u00f1"+
		"\13\21\3\21\3\21\5\21\u00f5\n\21\3\22\5\22\u00f8\n\22\3\22\3\22\3\22\7"+
		"\22\u00fd\n\22\f\22\16\22\u0100\13\22\3\22\3\22\3\22\3\23\3\23\3\23\7"+
		"\23\u0108\n\23\f\23\16\23\u010b\13\23\3\24\7\24\u010e\n\24\f\24\16\24"+
		"\u0111\13\24\3\24\7\24\u0114\n\24\f\24\16\24\u0117\13\24\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0123\n\25\3\26\3\26\3\26\5\26"+
		"\u0128\n\26\3\26\3\26\3\26\5\26\u012d\n\26\3\26\7\26\u0130\n\26\f\26\16"+
		"\26\u0133\13\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\7\27\u013c\n\27\f\27"+
		"\16\27\u013f\13\27\3\27\3\27\3\30\3\30\3\30\3\30\7\30\u0147\n\30\f\30"+
		"\16\30\u014a\13\30\3\30\3\30\7\30\u014e\n\30\f\30\16\30\u0151\13\30\5"+
		"\30\u0153\n\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u015d\n\31"+
		"\f\31\16\31\u0160\13\31\5\31\u0162\n\31\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\7\32\u016e\n\32\f\32\16\32\u0171\13\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\33\7\33\u0179\n\33\f\33\16\33\u017c\13\33\3\33\3\33"+
		"\3\34\3\34\7\34\u0182\n\34\f\34\16\34\u0185\13\34\3\34\3\34\3\34\3\35"+
		"\5\35\u018b\n\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\7\36\u0196"+
		"\n\36\f\36\16\36\u0199\13\36\3\36\3\36\3\37\3\37\3\37\3 \7 \u01a1\n \f"+
		" \16 \u01a4\13 \3!\3!\3!\7!\u01a9\n!\f!\16!\u01ac\13!\3\"\3\"\3\"\7\""+
		"\u01b1\n\"\f\"\16\"\u01b4\13\"\3#\5#\u01b7\n#\3#\3#\3#\5#\u01bc\n#\3#"+
		"\5#\u01bf\n#\3$\3$\3%\3%\3%\3%\7%\u01c7\n%\f%\16%\u01ca\13%\3&\3&\3&\3"+
		"&\7&\u01d0\n&\f&\16&\u01d3\13&\3\'\3\'\3\'\3\'\7\'\u01d9\n\'\f\'\16\'"+
		"\u01dc\13\'\3(\3(\3)\3)\3*\3*\3+\5+\u01e5\n+\3+\3+\5+\u01e9\n+\3,\5,\u01ec"+
		"\n,\3,\3,\3,\3,\3,\3,\7,\u01f4\n,\f,\16,\u01f7\13,\3,\3,\3,\3,\3,\3,\3"+
		",\3,\5,\u0201\n,\3-\3-\3-\5-\u0206\n-\3.\3.\3.\3.\5.\u020c\n.\3/\3/\3"+
		"\60\3\60\3\60\3\60\7\60\u0214\n\60\f\60\16\60\u0217\13\60\3\61\3\61\3"+
		"\61\3\61\7\61\u021d\n\61\f\61\16\61\u0220\13\61\3\62\5\62\u0223\n\62\3"+
		"\62\3\62\3\63\3\63\3\63\5\63\u022a\n\63\3\63\2\2\64\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVXZ\\^`bd\2\5"+
		"\3\2&\'\3\2()\4\2\13\13,\60\2\u0246\2f\3\2\2\2\4h\3\2\2\2\6j\3\2\2\2\b"+
		"s\3\2\2\2\n{\3\2\2\2\f\u0080\3\2\2\2\16\u008f\3\2\2\2\20\u0091\3\2\2\2"+
		"\22\u009c\3\2\2\2\24\u00ac\3\2\2\2\26\u00b1\3\2\2\2\30\u00b7\3\2\2\2\32"+
		"\u00bb\3\2\2\2\34\u00be\3\2\2\2\36\u00c7\3\2\2\2 \u00f4\3\2\2\2\"\u00f7"+
		"\3\2\2\2$\u0104\3\2\2\2&\u010f\3\2\2\2(\u0122\3\2\2\2*\u0124\3\2\2\2,"+
		"\u0136\3\2\2\2.\u0142\3\2\2\2\60\u0156\3\2\2\2\62\u0165\3\2\2\2\64\u0174"+
		"\3\2\2\2\66\u017f\3\2\2\28\u018a\3\2\2\2:\u0190\3\2\2\2<\u019c\3\2\2\2"+
		">\u01a2\3\2\2\2@\u01a5\3\2\2\2B\u01ad\3\2\2\2D\u01b6\3\2\2\2F\u01c0\3"+
		"\2\2\2H\u01c2\3\2\2\2J\u01cb\3\2\2\2L\u01d4\3\2\2\2N\u01dd\3\2\2\2P\u01df"+
		"\3\2\2\2R\u01e1\3\2\2\2T\u01e8\3\2\2\2V\u0200\3\2\2\2X\u0205\3\2\2\2Z"+
		"\u0207\3\2\2\2\\\u020d\3\2\2\2^\u020f\3\2\2\2`\u0218\3\2\2\2b\u0222\3"+
		"\2\2\2d\u0229\3\2\2\2fg\7\3\2\2g\3\3\2\2\2hi\7\4\2\2i\5\3\2\2\2jn\7\5"+
		"\2\2km\5\20\t\2lk\3\2\2\2mp\3\2\2\2nl\3\2\2\2no\3\2\2\2oq\3\2\2\2pn\3"+
		"\2\2\2qr\7\6\2\2r\7\3\2\2\2st\5\n\6\2tu\7\7\2\2uv\5&\24\2vw\7\b\2\2w\t"+
		"\3\2\2\2xz\5\f\7\2yx\3\2\2\2z}\3\2\2\2{y\3\2\2\2{|\3\2\2\2|\13\3\2\2\2"+
		"}{\3\2\2\2~\u0081\5\16\b\2\177\u0081\5 \21\2\u0080~\3\2\2\2\u0080\177"+
		"\3\2\2\2\u0081\r\3\2\2\2\u0082\u0083\7\t\2\2\u0083\u0090\5\20\t\2\u0084"+
		"\u0085\7\n\2\2\u0085\u0086\7F\2\2\u0086\u0087\7Q\2\2\u0087\u0088\5\30"+
		"\r\2\u0088\u0089\7\13\2\2\u0089\u008a\5\36\20\2\u008a\u0090\3\2\2\2\u008b"+
		"\u008c\7\64\2\2\u008c\u008d\7F\2\2\u008d\u008e\7Q\2\2\u008e\u0090\5\26"+
		"\f\2\u008f\u0082\3\2\2\2\u008f\u0084\3\2\2\2\u008f\u008b\3\2\2\2\u0090"+
		"\17\3\2\2\2\u0091\u0096\5\22\n\2\u0092\u0093\7K\2\2\u0093\u0095\5\22\n"+
		"\2\u0094\u0092\3\2\2\2\u0095\u0098\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097"+
		"\3\2\2\2\u0097\u0099\3\2\2\2\u0098\u0096\3\2\2\2\u0099\u009a\7Q\2\2\u009a"+
		"\u009b\5\26\f\2\u009b\21\3\2\2\2\u009c\u00a1\7F\2\2\u009d\u009e\7L\2\2"+
		"\u009e\u00a0\7F\2\2\u009f\u009d\3\2\2\2\u00a0\u00a3\3\2\2\2\u00a1\u009f"+
		"\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a4\3\2\2\2\u00a3\u00a1\3\2\2\2\u00a4"+
		"\u00a5\5\24\13\2\u00a5\23\3\2\2\2\u00a6\u00a7\7O\2\2\u00a7\u00a8\5H%\2"+
		"\u00a8\u00a9\7P\2\2\u00a9\u00ab\3\2\2\2\u00aa\u00a6\3\2\2\2\u00ab\u00ae"+
		"\3\2\2\2\u00ac\u00aa\3\2\2\2\u00ac\u00ad\3\2\2\2\u00ad\25\3\2\2\2\u00ae"+
		"\u00ac\3\2\2\2\u00af\u00b2\5\6\4\2\u00b0\u00b2\5\34\17\2\u00b1\u00af\3"+
		"\2\2\2\u00b1\u00b0\3\2\2\2\u00b2\27\3\2\2\2\u00b3\u00b8\7\f\2\2\u00b4"+
		"\u00b8\7\r\2\2\u00b5\u00b8\7\16\2\2\u00b6\u00b8\7\17\2\2\u00b7\u00b3\3"+
		"\2\2\2\u00b7\u00b4\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b7\u00b6\3\2\2\2\u00b8"+
		"\31\3\2\2\2\u00b9\u00bc\5\30\r\2\u00ba\u00bc\7F\2\2\u00bb\u00b9\3\2\2"+
		"\2\u00bb\u00ba\3\2\2\2\u00bc\33\3\2\2\2\u00bd\u00bf\7\20\2\2\u00be\u00bd"+
		"\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\5\32\16\2"+
		"\u00c1\35\3\2\2\2\u00c2\u00c8\7R\2\2\u00c3\u00c8\7D\2\2\u00c4\u00c8\7"+
		"E\2\2\u00c5\u00c8\7\21\2\2\u00c6\u00c8\7\22\2\2\u00c7\u00c2\3\2\2\2\u00c7"+
		"\u00c3\3\2\2\2\u00c7\u00c4\3\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c6\3\2"+
		"\2\2\u00c8\37\3\2\2\2\u00c9\u00ca\7\23\2\2\u00ca\u00cb\7F\2\2\u00cb\u00cd"+
		"\7M\2\2\u00cc\u00ce\5$\23\2\u00cd\u00cc\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00cf\u00d3\7N\2\2\u00d0\u00d2\5\16\b\2\u00d1\u00d0\3\2"+
		"\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4"+
		"\u00d9\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6\u00d8\5(\25\2\u00d7\u00d6\3\2"+
		"\2\2\u00d8\u00db\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da"+
		"\u00dc\3\2\2\2\u00db\u00d9\3\2\2\2\u00dc\u00f5\7\24\2\2\u00dd\u00de\7"+
		"\25\2\2\u00de\u00df\7F\2\2\u00df\u00e1\7M\2\2\u00e0\u00e2\5$\23\2\u00e1"+
		"\u00e0\3\2\2\2\u00e1\u00e2\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e4\7N"+
		"\2\2\u00e4\u00e5\7Q\2\2\u00e5\u00e9\5\34\17\2\u00e6\u00e8\5\16\b\2\u00e7"+
		"\u00e6\3\2\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2"+
		"\2\2\u00ea\u00ef\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ee\5(\25\2\u00ed"+
		"\u00ec\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef\u00ed\3\2\2\2\u00ef\u00f0\3\2"+
		"\2\2\u00f0\u00f2\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f2\u00f3\7\26\2\2\u00f3"+
		"\u00f5\3\2\2\2\u00f4\u00c9\3\2\2\2\u00f4\u00dd\3\2\2\2\u00f5!\3\2\2\2"+
		"\u00f6\u00f8\7:\2\2\u00f7\u00f6\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00f9"+
		"\3\2\2\2\u00f9\u00fe\5\22\n\2\u00fa\u00fb\7K\2\2\u00fb\u00fd\5\22\n\2"+
		"\u00fc\u00fa\3\2\2\2\u00fd\u0100\3\2\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00ff"+
		"\3\2\2\2\u00ff\u0101\3\2\2\2\u0100\u00fe\3\2\2\2\u0101\u0102\7Q\2\2\u0102"+
		"\u0103\5\34\17\2\u0103#\3\2\2\2\u0104\u0109\5\"\22\2\u0105\u0106\7K\2"+
		"\2\u0106\u0108\5\"\22\2\u0107\u0105\3\2\2\2\u0108\u010b\3\2\2\2\u0109"+
		"\u0107\3\2\2\2\u0109\u010a\3\2\2\2\u010a%\3\2\2\2\u010b\u0109\3\2\2\2"+
		"\u010c\u010e\5\16\b\2\u010d\u010c\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d"+
		"\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0115\3\2\2\2\u0111\u010f\3\2\2\2\u0112"+
		"\u0114\5(\25\2\u0113\u0112\3\2\2\2\u0114\u0117\3\2\2\2\u0115\u0113\3\2"+
		"\2\2\u0115\u0116\3\2\2\2\u0116\'\3\2\2\2\u0117\u0115\3\2\2\2\u0118\u0123"+
		"\5*\26\2\u0119\u0123\5,\27\2\u011a\u0123\5.\30\2\u011b\u0123\5\60\31\2"+
		"\u011c\u0123\5\62\32\2\u011d\u0123\5\64\33\2\u011e\u0123\5\66\34\2\u011f"+
		"\u0123\58\35\2\u0120\u0123\5:\36\2\u0121\u0123\5<\37\2\u0122\u0118\3\2"+
		"\2\2\u0122\u0119\3\2\2\2\u0122\u011a\3\2\2\2\u0122\u011b\3\2\2\2\u0122"+
		"\u011c\3\2\2\2\u0122\u011d\3\2\2\2\u0122\u011e\3\2\2\2\u0122\u011f\3\2"+
		"\2\2\u0122\u0120\3\2\2\2\u0122\u0121\3\2\2\2\u0123)\3\2\2\2\u0124\u0125"+
		"\7\27\2\2\u0125\u0127\7M\2\2\u0126\u0128\7\20\2\2\u0127\u0126\3\2\2\2"+
		"\u0127\u0128\3\2\2\2\u0128\u0129\3\2\2\2\u0129\u0131\5\22\n\2\u012a\u012c"+
		"\7K\2\2\u012b\u012d\7\20\2\2\u012c\u012b\3\2\2\2\u012c\u012d\3\2\2\2\u012d"+
		"\u012e\3\2\2\2\u012e\u0130\5\22\n\2\u012f\u012a\3\2\2\2\u0130\u0133\3"+
		"\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0134\3\2\2\2\u0133"+
		"\u0131\3\2\2\2\u0134\u0135\7N\2\2\u0135+\3\2\2\2\u0136\u0137\7\30\2\2"+
		"\u0137\u0138\7M\2\2\u0138\u013d\5^\60\2\u0139\u013a\7K\2\2\u013a\u013c"+
		"\5^\60\2\u013b\u0139\3\2\2\2\u013c\u013f\3\2\2\2\u013d\u013b\3\2\2\2\u013d"+
		"\u013e\3\2\2\2\u013e\u0140\3\2\2\2\u013f\u013d\3\2\2\2\u0140\u0141\7N"+
		"\2\2\u0141-\3\2\2\2\u0142\u0143\7\31\2\2\u0143\u0144\5^\60\2\u0144\u0148"+
		"\7;\2\2\u0145\u0147\5(\25\2\u0146\u0145\3\2\2\2\u0147\u014a\3\2\2\2\u0148"+
		"\u0146\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u0152\3\2\2\2\u014a\u0148\3\2"+
		"\2\2\u014b\u014f\7<\2\2\u014c\u014e\5(\25\2\u014d\u014c\3\2\2\2\u014e"+
		"\u0151\3\2\2\2\u014f\u014d\3\2\2\2\u014f\u0150\3\2\2\2\u0150\u0153\3\2"+
		"\2\2\u0151\u014f\3\2\2\2\u0152\u014b\3\2\2\2\u0152\u0153\3\2\2\2\u0153"+
		"\u0154\3\2\2\2\u0154\u0155\7\32\2\2\u0155/\3\2\2\2\u0156\u0157\7\33\2"+
		"\2\u0157\u0158\5H%\2\u0158\u0159\7\34\2\2\u0159\u0161\5> \2\u015a\u015e"+
		"\7<\2\2\u015b\u015d\5(\25\2\u015c\u015b\3\2\2\2\u015d\u0160\3\2\2\2\u015e"+
		"\u015c\3\2\2\2\u015e\u015f\3\2\2\2\u015f\u0162\3\2\2\2\u0160\u015e\3\2"+
		"\2\2\u0161\u015a\3\2\2\2\u0161\u0162\3\2\2\2\u0162\u0163\3\2\2\2\u0163"+
		"\u0164\7\35\2\2\u0164\61\3\2\2\2\u0165\u0166\7\36\2\2\u0166\u0167\7F\2"+
		"\2\u0167\u0168\7\37\2\2\u0168\u0169\5H%\2\u0169\u016a\7 \2\2\u016a\u016b"+
		"\5H%\2\u016b\u016f\7!\2\2\u016c\u016e\5(\25\2\u016d\u016c\3\2\2\2\u016e"+
		"\u0171\3\2\2\2\u016f\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0172\3\2"+
		"\2\2\u0171\u016f\3\2\2\2\u0172\u0173\7\"\2\2\u0173\63\3\2\2\2\u0174\u0175"+
		"\7#\2\2\u0175\u0176\5^\60\2\u0176\u017a\7!\2\2\u0177\u0179\5(\25\2\u0178"+
		"\u0177\3\2\2\2\u0179\u017c\3\2\2\2\u017a\u0178\3\2\2\2\u017a\u017b\3\2"+
		"\2\2\u017b\u017d\3\2\2\2\u017c\u017a\3\2\2\2\u017d\u017e\7$\2\2\u017e"+
		"\65\3\2\2\2\u017f\u0183\7!\2\2\u0180\u0182\5(\25\2\u0181\u0180\3\2\2\2"+
		"\u0182\u0185\3\2\2\2\u0183\u0181\3\2\2\2\u0183\u0184\3\2\2\2\u0184\u0186"+
		"\3\2\2\2\u0185\u0183\3\2\2\2\u0186\u0187\7 \2\2\u0187\u0188\5^\60\2\u0188"+
		"\67\3\2\2\2\u0189\u018b\7\20\2\2\u018a\u0189\3\2\2\2\u018a\u018b\3\2\2"+
		"\2\u018b\u018c\3\2\2\2\u018c\u018d\5\22\n\2\u018d\u018e\7\37\2\2\u018e"+
		"\u018f\5^\60\2\u018f9\3\2\2\2\u0190\u0191\7F\2\2\u0191\u0192\7M\2\2\u0192"+
		"\u0197\5^\60\2\u0193\u0194\7K\2\2\u0194\u0196\5^\60\2\u0195\u0193\3\2"+
		"\2\2\u0196\u0199\3\2\2\2\u0197\u0195\3\2\2\2\u0197\u0198\3\2\2\2\u0198"+
		"\u019a\3\2\2\2\u0199\u0197\3\2\2\2\u019a\u019b\7N\2\2\u019b;\3\2\2\2\u019c"+
		"\u019d\7%\2\2\u019d\u019e\5^\60\2\u019e=\3\2\2\2\u019f\u01a1\5@!\2\u01a0"+
		"\u019f\3\2\2\2\u01a1\u01a4\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a2\u01a3\3\2"+
		"\2\2\u01a3?\3\2\2\2\u01a4\u01a2\3\2\2\2\u01a5\u01a6\5B\"\2\u01a6\u01aa"+
		"\7Q\2\2\u01a7\u01a9\5(\25\2\u01a8\u01a7\3\2\2\2\u01a9\u01ac\3\2\2\2\u01aa"+
		"\u01a8\3\2\2\2\u01aa\u01ab\3\2\2\2\u01abA\3\2\2\2\u01ac\u01aa\3\2\2\2"+
		"\u01ad\u01b2\5D#\2\u01ae\u01af\7K\2\2\u01af\u01b1\5D#\2\u01b0\u01ae\3"+
		"\2\2\2\u01b1\u01b4\3\2\2\2\u01b2\u01b0\3\2\2\2\u01b2\u01b3\3\2\2\2\u01b3"+
		"C\3\2\2\2\u01b4\u01b2\3\2\2\2\u01b5\u01b7\5F$\2\u01b6\u01b5\3\2\2\2\u01b6"+
		"\u01b7\3\2\2\2\u01b7\u01b8\3\2\2\2\u01b8\u01be\7D\2\2\u01b9\u01bb\7\66"+
		"\2\2\u01ba\u01bc\5F$\2\u01bb\u01ba\3\2\2\2\u01bb\u01bc\3\2\2\2\u01bc\u01bd"+
		"\3\2\2\2\u01bd\u01bf\7D\2\2\u01be\u01b9\3\2\2\2\u01be\u01bf\3\2\2\2\u01bf"+
		"E\3\2\2\2\u01c0\u01c1\7&\2\2\u01c1G\3\2\2\2\u01c2\u01c8\5J&\2\u01c3\u01c4"+
		"\5N(\2\u01c4\u01c5\5J&\2\u01c5\u01c7\3\2\2\2\u01c6\u01c3\3\2\2\2\u01c7"+
		"\u01ca\3\2\2\2\u01c8\u01c6\3\2\2\2\u01c8\u01c9\3\2\2\2\u01c9I\3\2\2\2"+
		"\u01ca\u01c8\3\2\2\2\u01cb\u01d1\5L\'\2\u01cc\u01cd\5P)\2\u01cd\u01ce"+
		"\5L\'\2\u01ce\u01d0\3\2\2\2\u01cf\u01cc\3\2\2\2\u01d0\u01d3\3\2\2\2\u01d1"+
		"\u01cf\3\2\2\2\u01d1\u01d2\3\2\2\2\u01d2K\3\2\2\2\u01d3\u01d1\3\2\2\2"+
		"\u01d4\u01da\5T+\2\u01d5\u01d6\5R*\2\u01d6\u01d7\5T+\2\u01d7\u01d9\3\2"+
		"\2\2\u01d8\u01d5\3\2\2\2\u01d9\u01dc\3\2\2\2\u01da\u01d8\3\2\2\2\u01da"+
		"\u01db\3\2\2\2\u01dbM\3\2\2\2\u01dc\u01da\3\2\2\2\u01dd\u01de\t\2\2\2"+
		"\u01deO\3\2\2\2\u01df\u01e0\t\3\2\2\u01e0Q\3\2\2\2\u01e1\u01e2\7*\2\2"+
		"\u01e2S\3\2\2\2\u01e3\u01e5\5F$\2\u01e4\u01e3\3\2\2\2\u01e4\u01e5\3\2"+
		"\2\2\u01e5\u01e6\3\2\2\2\u01e6\u01e9\5V,\2\u01e7\u01e9\5X-\2\u01e8\u01e4"+
		"\3\2\2\2\u01e8\u01e7\3\2\2\2\u01e9U\3\2\2\2\u01ea\u01ec\7\20\2\2\u01eb"+
		"\u01ea\3\2\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ed\3\2\2\2\u01ed\u0201\5\22"+
		"\n\2\u01ee\u01ef\7F\2\2\u01ef\u01f0\7M\2\2\u01f0\u01f5\5^\60\2\u01f1\u01f2"+
		"\7K\2\2\u01f2\u01f4\5^\60\2\u01f3\u01f1\3\2\2\2\u01f4\u01f7\3\2\2\2\u01f5"+
		"\u01f3\3\2\2\2\u01f5\u01f6\3\2\2\2\u01f6\u01f8\3\2\2\2\u01f7\u01f5\3\2"+
		"\2\2\u01f8\u01f9\7N\2\2\u01f9\u0201\3\2\2\2\u01fa\u0201\7D\2\2\u01fb\u0201"+
		"\7E\2\2\u01fc\u01fd\7M\2\2\u01fd\u01fe\5^\60\2\u01fe\u01ff\7N\2\2\u01ff"+
		"\u0201\3\2\2\2\u0200\u01eb\3\2\2\2\u0200\u01ee\3\2\2\2\u0200\u01fa\3\2"+
		"\2\2\u0200\u01fb\3\2\2\2\u0200\u01fc\3\2\2\2\u0201W\3\2\2\2\u0202\u0203"+
		"\7+\2\2\u0203\u0206\5\22\n\2\u0204\u0206\7R\2\2\u0205\u0202\3\2\2\2\u0205"+
		"\u0204\3\2\2\2\u0206Y\3\2\2\2\u0207\u020b\5H%\2\u0208\u0209\5\\/\2\u0209"+
		"\u020a\5H%\2\u020a\u020c\3\2\2\2\u020b\u0208\3\2\2\2\u020b\u020c\3\2\2"+
		"\2\u020c[\3\2\2\2\u020d\u020e\t\4\2\2\u020e]\3\2\2\2\u020f\u0215\5`\61"+
		"\2\u0210\u0211\5\2\2\2\u0211\u0212\5`\61\2\u0212\u0214\3\2\2\2\u0213\u0210"+
		"\3\2\2\2\u0214\u0217\3\2\2\2\u0215\u0213\3\2\2\2\u0215\u0216\3\2\2\2\u0216"+
		"_\3\2\2\2\u0217\u0215\3\2\2\2\u0218\u021e\5b\62\2\u0219\u021a\5\4\3\2"+
		"\u021a\u021b\5b\62\2\u021b\u021d\3\2\2\2\u021c\u0219\3\2\2\2\u021d\u0220"+
		"\3\2\2\2\u021e\u021c\3\2\2\2\u021e\u021f\3\2\2\2\u021fa\3\2\2\2\u0220"+
		"\u021e\3\2\2\2\u0221\u0223\78\2\2\u0222\u0221\3\2\2\2\u0222\u0223\3\2"+
		"\2\2\u0223\u0224\3\2\2\2\u0224\u0225\5d\63\2\u0225c\3\2\2\2\u0226\u022a"+
		"\7\21\2\2\u0227\u022a\7\22\2\2\u0228\u022a\5Z.\2\u0229\u0226\3\2\2\2\u0229"+
		"\u0227\3\2\2\2\u0229\u0228\3\2\2\2\u022ae\3\2\2\2=n{\u0080\u008f\u0096"+
		"\u00a1\u00ac\u00b1\u00b7\u00bb\u00be\u00c7\u00cd\u00d3\u00d9\u00e1\u00e9"+
		"\u00ef\u00f4\u00f7\u00fe\u0109\u010f\u0115\u0122\u0127\u012c\u0131\u013d"+
		"\u0148\u014f\u0152\u015e\u0161\u016f\u017a\u0183\u018a\u0197\u01a2\u01aa"+
		"\u01b2\u01b6\u01bb\u01be\u01c8\u01d1\u01da\u01e4\u01e8\u01eb\u01f5\u0200"+
		"\u0205\u020b\u0215\u021e\u0222\u0229";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}