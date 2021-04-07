package br.ufscar.dc.compiladores.sistematatico;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;

public class ErrosSemanticos {
    public static List<String> errosSemanticos = new ArrayList<>(); // Lista com os erros semânticos.
    
    public static void adicionarErroSemantico(Token t, String mensagem){
        int linha = t.getLine(); // Obtém a linha.
        errosSemanticos.add(String.format("Linha %d: %s", linha, mensagem)); // Adiciona a mensagem de erro na lista de erros.
    }
}
