package br.ufscar.dc.compiladores.sistematatico;

public class Utils {
    
    // Funcão que calcula a coordenada Y de um jogador na imagem com base
    // na sua posicão na linha e o número de jogadores na linha.
    public static int getY(int pos, int nroJogadoresNaLinha){
        switch (nroJogadoresNaLinha) {
            case 1: // Se houver um jogador na linha.
                return (900/2);
            case 2: // Se houverem dois jogadores na linha.
                if(pos == 1) // Retorna um valor de acordo com a posicão do atleta na linha.
                    return (900/2 -100);
                else
                    return(900/2 + 100);
            case 3: // Se houverem três jogadores na linha.
                switch (pos) { // Retorna um valor de acordo com a posicão do atleta na linha.
                    case 1:
                        return (900/2 + 300);
                    case 2:
                        return (900/2);
                    default:
                        return (900/2 - 300);
                }

            case 4:  // Se houverem quatro jogadores na linha.
                switch (pos) { // Retorna um valor de acordo com a posicão do atleta na linha.
                    case 1:
                        return (900 / 2 - 350);
                    case 2:
                        return (900 / 2 - 150);
                    case 3:
                        return (900 / 2 + 150);
                    default:
                        return (900 / 2 + 350);
                }

            default:  // Se houverem cinco jogadores na linha.
                switch (pos) { // Retorna um valor de acordo com a posicão do atleta na linha.
                    case 1:
                        return (900 / 2 - 400);
                    case 2:
                        return (900 / 2 - 200);
                    case 3:
                        return (900 / 2);
                    case 4:
                        return (900 / 2 + 200);
                    default:
                        return (900 / 2 + 400);
                }
        }
    }

}
