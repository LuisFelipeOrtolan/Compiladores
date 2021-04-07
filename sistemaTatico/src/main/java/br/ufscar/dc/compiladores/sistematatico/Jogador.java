package br.ufscar.dc.compiladores.sistematatico;

public class Jogador {
    int nro; // Posicão do jogador na linha.
    int linha; // Número da linha que o jogador joga.
    String funcao = "";  // Funcão (atacar, defender ou "" caso não seja especificada).
    String nome; // Nome do jogador.
    
    // Posicão do jogador na imagem.
    int x; 
    int y;
    
    // Construtor da classe.
    // Parâmetros: número do jogador na linha, a linha que o jogador joga, o nome dele, o número de linhas
    // no esquema tático e o número de jogadores na linha que o jogador joga.
    Jogador(int nro, int linha, String nome, int nroLinhas, int nroJogadoresLinha){
        // Coloca os parâmetros corretos.
        this.nro = nro;
        this.linha = linha;
        this.nome = nome;
        
        // Calcula a posicão do jogador na imagem.
        this.x = (1800 / nroLinhas) * linha;
        this.y = Utils.getY(nro, nroJogadoresLinha);
    }
}
