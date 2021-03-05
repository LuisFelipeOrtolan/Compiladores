
package br.ufscar.dc.compiladores.lasintatico;

import br.ufscar.dc.compiladores.laSintatico.laLexer;
import br.ufscar.dc.compiladores.laSintatico.laParser;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

public class Principal {
    public static void main(String args[]) throws IOException{
        try(PrintWriter pw = new PrintWriter(new File(args[1]))){
            CharStream cs = CharStreams.fromFileName(args[0]);
            laLexer lexer = new laLexer(cs);

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            laParser parser = new laParser(tokens);

            // Registrar o error lister personalizado aqui  
            ErroCustom mcel = new ErroCustom(pw);
            parser.addErrorListener(mcel);

            parser.programa();
        }
    }
}
