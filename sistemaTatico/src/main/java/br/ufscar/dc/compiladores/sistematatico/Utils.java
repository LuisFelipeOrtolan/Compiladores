package br.ufscar.dc.compiladores.sistematatico;

public class Utils {
    public static int getY(int pos, int nroJogadoresNaLinha){
        switch (nroJogadoresNaLinha) {
            case 1:
                return (900/2);
            case 2:
                if(pos == 1)
                    return (900/2 -100);
                else
                    return(900/2 + 100);
            case 3:
                switch (pos) {
                    case 1:
                        return (900/2 + 300);
                    case 2:
                        return (900/2);
                    default:
                        return (900/2 - 300);
                }

            case 4:
                switch (pos) {
                    case 1:
                        return (900 / 2 - 350);
                    case 2:
                        return (900 / 2 - 150);
                    case 3:
                        return (900 / 2 + 150);
                    default:
                        return (900 / 2 + 350);
                }

            default:
                switch (pos) {
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
