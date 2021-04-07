// Generated from br/ufscar/dc/compiladores/sistematatico/linguagemTatica.g4 by ANTLR 4.7.2
package br.ufscar.dc.compiladores.sistematatico;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link linguagemTaticaParser}.
 */
public interface linguagemTaticaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link linguagemTaticaParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(linguagemTaticaParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link linguagemTaticaParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(linguagemTaticaParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link linguagemTaticaParser#formacao}.
	 * @param ctx the parse tree
	 */
	void enterFormacao(linguagemTaticaParser.FormacaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link linguagemTaticaParser#formacao}.
	 * @param ctx the parse tree
	 */
	void exitFormacao(linguagemTaticaParser.FormacaoContext ctx);
	/**
	 * Enter a parse tree produced by {@link linguagemTaticaParser#decl_jogador}.
	 * @param ctx the parse tree
	 */
	void enterDecl_jogador(linguagemTaticaParser.Decl_jogadorContext ctx);
	/**
	 * Exit a parse tree produced by {@link linguagemTaticaParser#decl_jogador}.
	 * @param ctx the parse tree
	 */
	void exitDecl_jogador(linguagemTaticaParser.Decl_jogadorContext ctx);
	/**
	 * Enter a parse tree produced by {@link linguagemTaticaParser#papel}.
	 * @param ctx the parse tree
	 */
	void enterPapel(linguagemTaticaParser.PapelContext ctx);
	/**
	 * Exit a parse tree produced by {@link linguagemTaticaParser#papel}.
	 * @param ctx the parse tree
	 */
	void exitPapel(linguagemTaticaParser.PapelContext ctx);
}