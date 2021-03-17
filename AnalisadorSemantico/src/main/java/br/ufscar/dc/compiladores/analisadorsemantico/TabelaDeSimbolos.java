package br.ufscar.dc.compiladores.analisadorsemantico;

import java.util.HashMap;

public class TabelaDeSimbolos {
    private HashMap<String, EntradaTabelaSimbolos> tabelaDeSimbolos;
    
    public TabelaDeSimbolos(){
        tabelaDeSimbolos = new HashMap<>();
    }
    
    public void inserir(String nome, Tipos tipo){
        EntradaTabelaSimbolos ets = new EntradaTabelaSimbolos();
        ets.nome = nome;
        ets.tipo = tipo;
        tabelaDeSimbolos.put(nome,ets);
    }
    
    public EntradaTabelaSimbolos verificar(String nome){
        return tabelaDeSimbolos.get(nome);
    }
}