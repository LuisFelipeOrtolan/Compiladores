package br.ufscar.dc.compiladores.analisadorsemantico;

import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;

public class Utils {
    
    public static List<String> errosSemanticos = new ArrayList<>();
    
    Tipos tiposCompativeis(Tipos tipo1, Tipos tipo2){
        if(tipo1 == Tipos.Inteiro)
            if(tipo2 == Tipos.Inteiro)
                return Tipos.Inteiro;
            else if(tipo2 == Tipos.Real)
                return Tipos.Real;
            else
                return Tipos.Erro;
        
        else if(tipo1 == Tipos.Real)
            if(tipo2 == Tipos.Inteiro || tipo2 == Tipos.Real)
                return Tipos.Real;
            else
                return Tipos.Erro;
        
        else if(tipo1 == Tipos.Literal)
            if(tipo2 == Tipos.Literal)
                return Tipos.Literal;
            else
                return Tipos.Erro;
        else if(tipo1 == Tipos.Logico)
            if(tipo2 == Tipos.Logico)
                return Tipos.Logico;
            else
                return Tipos.Erro;
        else if(tipo1 == Tipos.Struct)
            if(tipo2 == Tipos.Struct)
                return Tipos.Struct;
            else
                return Tipos.Erro;
        else
            return Tipos.Erro;
    } 
    
    public static void adicionarErroSemantico(Token t, String mensagem){
        int linha = t.getLine();
        errosSemanticos.add(String.format("Linha %d: %s", linha, mensagem));
    }
    
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
    
}
