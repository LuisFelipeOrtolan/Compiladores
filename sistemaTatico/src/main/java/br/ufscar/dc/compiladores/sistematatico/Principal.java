package br.ufscar.dc.compiladores.sistematatico;


import br.ufscar.dc.compiladores.sistematatico.linguagemTaticaParser.ProgramaContext;
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
            linguagemTaticaLexer lexer = new linguagemTaticaLexer(cs); // Realiza a análise léxica do código.

            CommonTokenStream tokens = new CommonTokenStream(lexer); // Gera os tokens a partir da análise léxica.
            linguagemTaticaParser parser = new linguagemTaticaParser(tokens); // Cria as regras para a análise sintática do código.

            // Cria as respostas de erros personalizados. 
            ErroSintatico mcel = new ErroSintatico(pw);
            parser.addErrorListener(mcel);

            ProgramaContext arvore = parser.programa(); // Realiza a análise sintática.
            
            if(mcel.erros == true) // Se houverem erros sintáticos, encerra o programa.
                return;

            Programa as = new Programa(); // Faz a análise semântica dos dados.
            as.visitPrograma(arvore);
            
            ErrosSemanticos.errosSemanticos.forEach((s) -> pw.println(s)); // Reporta os erros.
            
            if(ErrosSemanticos.errosSemanticos.isEmpty()){ // Se não tiver erros, interpreta o código para geracão do esquema tático.
                Interpretador inter = new Interpretador();
                inter.visitPrograma(arvore);
            } else
                pw.println("Fim da compilacao");
        }
    }
}
