// Generated from br/ufscar/dc/compiladores/sistematatico/linguagemTatica.g4 by ANTLR 4.7.2
package br.ufscar.dc.compiladores.sistematatico;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link linguagemTaticaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface linguagemTaticaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link linguagemTaticaParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(linguagemTaticaParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link linguagemTaticaParser#formacao}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormacao(linguagemTaticaParser.FormacaoContext ctx);
	/**
	 * Visit a parse tree produced by {@link linguagemTaticaParser#decl_jogador}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl_jogador(linguagemTaticaParser.Decl_jogadorContext ctx);
	/**
	 * Visit a parse tree produced by {@link linguagemTaticaParser#papel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPapel(linguagemTaticaParser.PapelContext ctx);
}