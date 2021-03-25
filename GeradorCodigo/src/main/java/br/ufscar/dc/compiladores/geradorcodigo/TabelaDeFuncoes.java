package br.ufscar.dc.compiladores.geradorcodigo;

import java.util.HashMap;
import java.util.List;

public class TabelaDeFuncoes {
    private HashMap<String, auxFuncoes> tabelaDeFuncoes;
    
    public TabelaDeFuncoes(){
        tabelaDeFuncoes = new HashMap<>();
    }
    
    public void inserir(String nome, boolean procOrfunc, List<Tipos> tipo, Tipos type){
        auxFuncoes auxFun = new auxFuncoes();
        auxFun.nomeFuncao = nome;
        auxFun.procOrfunc = procOrfunc;
        auxFun.parametros = tipo;
        auxFun.tipo = type;
        tabelaDeFuncoes.put(nome, auxFun);
    }
    
    public auxFuncoes verificar(String nome){
        return tabelaDeFuncoes.get(nome);
    }
}