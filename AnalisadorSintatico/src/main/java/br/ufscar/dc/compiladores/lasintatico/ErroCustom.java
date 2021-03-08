/*
 * Implementacão do erro personalizado para o analisador léxico da linguagem algorítmica.
 * Realizado pelo aluno Luís Felipe Ortolan, RA: 759375.
 */
package br.ufscar.dc.compiladores.lasintatico;

import br.ufscar.dc.compiladores.laSintatico.laLexer;
import java.io.PrintWriter;
import java.util.BitSet;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;


public class ErroCustom implements ANTLRErrorListener {
    PrintWriter pw;
    boolean erros = false;
    
    public ErroCustom(PrintWriter pw){
        this.pw = pw;
    }
    
    @Override
    public void	reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
        // Não será necessário para o T2, pode deixar vazio
    }
    
    @Override
    public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) {
        // Não será necessário para o T2, pode deixar vazio
    }

    @Override
    public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {
        // Não será necessário para o T2, pode deixar vazio
    }

    @Override
    public void	syntaxError(Recognizer<?,?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        // Aqui vamos colocar o tratamento de erro customizado

        if(erros == true) // Se já foi encontrado um erro, não devem ser reportados novos erros, portanto retorna.
            return;
        
        Token t = (Token) offendingSymbol; // Obtém o token que gerou o problema.
        
        String nome = laLexer.VOCABULARY.getDisplayName(t.getType()); // Obtém o condteúdo do token que gerou o problema.
        
        if(t.getType() == -1){ // Se for um erro em um fim de arquivo.
            pw.println("Linha " + line + ": erro sintatico proximo a EOF");
        } else if("ERRO".equals(nome)){ // Se for um erro léxico com um símbolo desconhecido.
            pw.println("Linha " + line + ": " + t.getText() + " - simbolo nao identificado");
        } else if("COMENTARIOS_ERRADOS".equals(nome)){ // Se for um erro léxico com um comentário não fechado.
            pw.println("Linha " + line + ": comentario nao fechado");
        } else if("CADEIA_ERRADA".equals(nome)){ // Se for um erro léxico com uma cadeia literal não fechada.
            pw.println("Linha " + line + ": cadeia literal nao fechada");
        }else{ // Se for um erro sintático.
            pw.println("Linha " + line + ": erro sintatico proximo a " + t.getText());
        }
        
        pw.println("Fim da compilacao"); // Comunica o fim do programa por algum erro gerado.
        erros = true; // Marca que um erro foi encontrado e portanto, o programa não deve mais reconhecer novos erros.
    }
}