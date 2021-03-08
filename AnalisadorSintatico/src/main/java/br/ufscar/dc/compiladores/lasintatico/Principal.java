/*
 * Classe Principal para o analisador sintático da Linguagem Algorítmica
 * Autor: Luís Felipe Corrêa Ortolan - RA 759375
 */
package br.ufscar.dc.compiladores.lasintatico;

import br.ufscar.dc.compiladores.laSintatico.laLexer;
import br.ufscar.dc.compiladores.laSintatico.laParser;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Principal {
    public static void main(String args[]) throws IOException{
        try(PrintWriter pw = new PrintWriter(new File(args[1]))){ // Cria um arquivo para saída com o argumento 1.
            CharStream cs = CharStreams.fromFileName(args[0]); // Lê o programa a partir do argumento 0.
            laLexer lexer = new laLexer(cs); // Realiza a análise léxica do código.

            CommonTokenStream tokens = new CommonTokenStream(lexer); // Gera os tokens a partir da análise léxica.
            laParser parser = new laParser(tokens); // Cria as regras para a análise sintática do código.

            // Cria as respostas de erros personalizados. 
            ErroCustom mcel = new ErroCustom(pw);
            parser.addErrorListener(mcel);

            parser.programa(); // Realiza a análise sintática.
        }
    }
}
