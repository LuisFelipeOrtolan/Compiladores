/*
 * Implementacão do erro personalizado para o analisador léxico da linguagem algorítmica.
 * Realizado pelo aluno Luís Felipe Ortolan, RA: 759375.
 */
package br.ufscar.dc.compiladores.sistematatico;

import br.ufscar.dc.compiladores.sistematatico.linguagemTaticaLexer;
import java.io.PrintWriter;
import java.util.BitSet;
import org.antlr.v4.runtime.ANTLRErrorListener;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;


public class ErroSintatico implements ANTLRErrorListener {
    PrintWriter pw;
    boolean erros = false;
    
    public ErroSintatico(PrintWriter pw){
        this.pw = pw;
    }
    
    @Override
    public void	reportAmbiguity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, boolean exact, BitSet ambigAlts, ATNConfigSet configs) {
        // Não necessário para essa aplicacão.
    }
    
    @Override
    public void reportAttemptingFullContext(Parser recognizer, DFA dfa, int startIndex, int stopIndex, BitSet conflictingAlts, ATNConfigSet configs) {
         // Não necessário para essa aplicacão.
    }

    @Override
    public void reportContextSensitivity(Parser recognizer, DFA dfa, int startIndex, int stopIndex, int prediction, ATNConfigSet configs) {
         // Não necessário para essa aplicacão.
    }

    @Override
    public void	syntaxError(Recognizer<?,?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
        // Aqui vamos colocar o tratamento de erro customizado

        if(erros == true) // Se já foi encontrado um erro, não devem ser reportados novos erros, portanto retorna.
            return;
        
        Token t = (Token) offendingSymbol; // Obtém o token que gerou o problema.
        
        pw.println("Linha " + line + ": erro proximo a " + t.getText());
        
        
        pw.println("Fim da compilacao"); // Comunica o fim do programa por algum erro gerado.
        erros = true; // Marca que um erro foi encontrado e portanto, o programa não deve mais reconhecer novos erros.
    }
}