package br.ufscar.dc.compiladores.sistematatico;

public class Jogador {
    int nro;
    int linha;
    String funcao = ""; 
    String nome;
    
    int x;
    int y;
    
    Jogador(int nro, int linha, String nome, int nroLinhas, int nroJogadoresLinha){
        this.nro = nro;
        this.linha = linha;
        this.nome = nome;
        
        this.x = (1800 / nroLinhas) * linha;
        this.y = Utils.getY(nro, nroJogadoresLinha);
    }
}
