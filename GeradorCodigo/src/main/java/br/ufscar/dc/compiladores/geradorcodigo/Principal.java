package br.ufscar.dc.compiladores.geradorcodigo;

import br.ufscar.dc.compiladores.analisadorsemantico.laLexer;
import br.ufscar.dc.compiladores.analisadorsemantico.laParser;
import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import br.ufscar.dc.compiladores.analisadorsemantico.laParser.ProgramaContext;
import java.io.File;
import java.io.PrintWriter;

public class Principal {
    public static void main(String args[]) throws IOException {
        try(PrintWriter pw = new PrintWriter(new File(args[1]))){ // Abre o arquivo com o caminho escrito no argumento 1.
            CharStream cs = CharStreams.fromFileName(args[0]); // Lê documento a partir do caminho no argumento 0. 
            laLexer lexer = new laLexer(cs); //Gera os tokens para análise.
            CommonTokenStream tokens = new CommonTokenStream(lexer); 
            laParser parser = new laParser(tokens); // Gera a análise sintática.
            ProgramaContext arvore = parser.programa();
            Programa as = new Programa();
            as.visitPrograma(arvore); // Visita fazendo a análise semântica.
            Utils.errosSemanticos.forEach((s) -> pw.println(s)); // Reporta os erros.
            
            if(Utils.errosSemanticos.isEmpty()){
                geradorC gc = new geradorC();
                gc.visitPrograma(arvore);
                System.out.print(gc.saida.toString());
            }
        }
    }
}