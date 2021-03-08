/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

        if(erros == true)
            return;
        
        Token t = (Token) offendingSymbol;
        
        String nome = laLexer.VOCABULARY.getDisplayName(t.getType());
        
        if(t.getType() == -1){
            pw.println("Linha " + line + ": erro sintatico proximo a EOF");
        } else if("ERRO".equals(nome)){
            pw.println("Linha " + line + ": " + t.getText() + " - simbolo nao identificado");
        } else if("COMENTARIOS_ERRADOS".equals(nome)){
            pw.println("Linha " + line + ": comentario nao fechado");
        } else if("CADEIA_ERRADA".equals(nome)){
            pw.println("Linha " + line + ": cadeia literal nao fechada");
        }else{
            pw.println("Linha " + line + ": erro sintatico proximo a " + t.getText());
        }
        
        pw.println("Fim da compilacao");
        erros = true;
    }
}