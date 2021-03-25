package br.ufscar.dc.compiladores.geradorcodigo;

import java.util.HashMap;

public class TabelaDeSimbolos {
    private HashMap<String, EntradaTabelaSimbolos> tabelaDeSimbolos;
    
    public TabelaDeSimbolos(){ // Inicializa a classe.
        tabelaDeSimbolos = new HashMap<>();
    }
    
    public void inserir(String nome, Tipos tipo){ // Insere um identificador e um tipo na tabela.
        EntradaTabelaSimbolos ets = new EntradaTabelaSimbolos();
        ets.nome = nome;
        ets.tipo = tipo;
        tabelaDeSimbolos.put(nome,ets);
    }
    
    // Insere um identificador, um tipo e uma tabela na tabela.
    // A subtabela é usada em contextos de struct, onde são guardadas as variáveis daquele tipo de struct.
    public void inserir(String nome, Tipos tipo, TabelaDeSimbolos subtabela){ 
        EntradaTabelaSimbolos ets = new EntradaTabelaSimbolos();
        ets.nome = nome;
        ets.tipo = tipo;
        ets.tabelaParaStruct = subtabela;
        tabelaDeSimbolos.put(nome,ets);
    }
    
    // Verifica se uma determinada string está naquela tabela.
    public EntradaTabelaSimbolos verificar(String nome){
        return tabelaDeSimbolos.get(nome);
    }
    
    // Imprime uma tabela com uma subtabela.
    public void imprimir(){
        System.out.println();
        System.out.println("Tabela: ");
        System.out.println();
        for (String key: tabelaDeSimbolos.keySet()){
            System.out.println("Nome: " + tabelaDeSimbolos.get(key).nome);
            System.out.println("Tipo: " + tabelaDeSimbolos.get(key).tipo);
            if(tabelaDeSimbolos.get(key).tabelaParaStruct != null){
                HashMap<String, EntradaTabelaSimbolos> a = tabelaDeSimbolos.get(key).tabelaParaStruct.tabelaDeSimbolos;
                System.out.println("Campos da sub tabela");
                for(String chave: a.keySet()){
                    System.out.println("Nome: " + a.get(chave).nome);
                    System.out.println("Tipo: " + a.get(chave).tipo);
                    System.out.println("-");
                }
                System.out.println("Proximo");
            }
                
        }
        
        
        System.out.println("Encerrada");
        System.out.println();
                    
    }
}