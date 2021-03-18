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
    
    public void inserir(String nome, Tipos tipo, TabelaDeSimbolos subtabela){
        EntradaTabelaSimbolos ets = new EntradaTabelaSimbolos();
        ets.nome = nome;
        ets.tipo = tipo;
        ets.tabelaParaStruct = subtabela;
        tabelaDeSimbolos.put(nome,ets);
    }
    
    public EntradaTabelaSimbolos verificar(String nome){
        return tabelaDeSimbolos.get(nome);
    }
    
    public void imprimir(){
        System.out.println();
        System.out.println("Tabela: ");
        System.out.println();
        for (String key: tabelaDeSimbolos.keySet()){
            System.out.println("Nome: " + tabelaDeSimbolos.get(key).nome);
            System.out.println("Tipo: " + tabelaDeSimbolos.get(key).tipo);
            HashMap<String, EntradaTabelaSimbolos> a = tabelaDeSimbolos.get(key).tabelaParaStruct.tabelaDeSimbolos;
            System.out.println("Campos da sub tabela");
            for(String chave: a.keySet()){
                System.out.println("Nome: " + a.get(chave).nome);
                System.out.println("Tipo: " + a.get(chave).tipo);
                System.out.println("-");
            }
            System.out.println("Proximo");
                
        }
        
        
        System.out.println("Encerrada");
        System.out.println();
                    
    }
}