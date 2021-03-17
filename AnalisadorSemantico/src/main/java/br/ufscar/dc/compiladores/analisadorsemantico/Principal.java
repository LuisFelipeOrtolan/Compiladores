package br.ufscar.dc.compiladores.analisadorsemantico;

import java.io.IOException;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import br.ufscar.dc.compiladores.analisadorsemantico.laParser.ProgramaContext;
import java.io.File;
import java.io.PrintWriter;

public class Principal {
    public static void main(String args[]) throws IOException {
        try(PrintWriter pw = new PrintWriter(new File(args[1]))){
            CharStream cs = CharStreams.fromFileName(args[0]);
            laLexer lexer = new laLexer(cs);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            laParser parser = new laParser(tokens);
            ProgramaContext arvore = parser.programa();
            Programa as = new Programa();
            as.visitPrograma(arvore);
            Utils.errosSemanticos.forEach((s) -> pw.println(s));
            pw.println("Fim da compilacao");
        }
    }
}