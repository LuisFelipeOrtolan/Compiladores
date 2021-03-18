package br.ufscar.dc.compiladores.analisadorsemantico;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;

public class Utils {
    
    public static List<String> errosSemanticos = new ArrayList<>();
    
    // Verifica se um tipo é compatível com outro para operacões.
    public static Tipos tiposCompativeis(Tipos tipo1, Tipos tipo2){
        if(tipo1 == Tipos.Inteiro) // Inteiros podem ser combinados com real ou inteiro.
            if(tipo2 == Tipos.Inteiro)
                return Tipos.Inteiro;
            else if(tipo2 == Tipos.Real)
                return Tipos.Real;
            else
                return Tipos.Erro;
        
        else if(tipo1 == Tipos.Real) // Reais podem ser combinados com inteiros ou reais.
            if(tipo2 == Tipos.Inteiro || tipo2 == Tipos.Real)
                return Tipos.Real;
            else
                return Tipos.Erro;
        
        else if(tipo1 == Tipos.Literal) // Literais só podem ser combinados com literais.
            if(tipo2 == Tipos.Literal)
                return Tipos.Literal;
            else
                return Tipos.Erro;
        else if(tipo1 == Tipos.Logico) // Lógicos só podem ser combinados com lógicos.
            if(tipo2 == Tipos.Logico)
                return Tipos.Logico;
            else
                return Tipos.Erro;
        else if(tipo1 == Tipos.Struct) // Estrututras só podem ser combinados com estruturas.
            if(tipo2 == Tipos.Struct)
                return Tipos.Struct;
            else
                return Tipos.Erro;
        else
            return Tipos.Erro;
    } 
    
    // Adiciona um erro a ser reportado.
    public static void adicionarErroSemantico(Token t, String mensagem){
        int linha = t.getLine();
        errosSemanticos.add(String.format("Linha %d: %s", linha, mensagem));
    }
    
    // Verifica se uma string é um número.
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
    
}
