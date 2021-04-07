package br.ufscar.dc.compiladores.sistematatico;

import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;


public class Interpretador extends linguagemTaticaBaseVisitor<Void>{
    
    int nroLinhas = 0; // Variável com o número de linhas que o sistema tático vai ter.
    
    // Variáveis com o número de jogadores por posicão.
    int nroGoleiro = 1; 
    int nroLaterais = 0;
    int nroZagueiros = 0;
    int nroVolantes = 0;
    int nroMeias = 0;
    int nroAtacantes = 0;

    // Variáveis que indicam o número de atletas já declarados naquela posicão.
    int posAtualZagueiro = 0;
    int posAtualLateral = 0;
    int posAtualVolante = 0;
    int posAtualMeia = 0;
    int posAtualAtacante = 0;
    
    ArrayList<Jogador> jogs = new ArrayList(); // Vetor com todos os jogadores daquele esquema tático, usado para impressão.
    int[] jogadorPorLinha; // Vetor que indica quantos jogadores existem em cada linha do sistema tático.
    
    class CustomPaintComponent extends Component { // Classe responsável pela impressão dos jogadores na imagem.
        public void paint(Graphics g){
            Graphics2D g2d = (Graphics2D)g;
            
            for(Jogador j : jogs){ // Para cada jogador,
                if(j.funcao.equals("defender")) // Se a funcão dele for defender, a cor do círculo que o representa é azul.
                    g2d.setColor(Color.BLUE);
                else if(j.funcao.equals("atacar")) // Se a funcão dele for atacar, a cor do círculo que o representa é vermelho.
                    g2d.setColor(Color.RED);
                else // Caso a funcão não seja especificada, marca como vermelho.
                    g2d.setColor(Color.BLACK);
                g2d.fillOval(j.x,j.y,50,50); // X e Y são as posicões do jogador na imagem e 50x50 é o tamanho do círculo.
                g2d.drawString(j.nome, j.x, j.y + 80); // Escreve o nome do jogador ao lado do círulo que o representa.
            }
           
        }
        
    }
    
    @Override
    public Void visitPrograma(linguagemTaticaParser.ProgramaContext ctx){
        
        // Visita os filhos de programa.
        visitFormacao(ctx.f);
        visitDecl_jogador(ctx.jg1);
        visitDecl_jogador(ctx.jg2);
        visitDecl_jogador(ctx.jg3);
        visitDecl_jogador(ctx.jg4);
        visitDecl_jogador(ctx.jg5);
        visitDecl_jogador(ctx.jg6);
        visitDecl_jogador(ctx.jg7);
        visitDecl_jogador(ctx.jg8);
        visitDecl_jogador(ctx.jg9);
        visitDecl_jogador(ctx.jg10);
        visitDecl_jogador(ctx.jg11);
        for(int i = 0; i < ctx.p.size(); i++)
            visitPapel(ctx.p.get(i));
        
        // Cria a imagem.
        Frame imagem = new Frame();
        
        // Adiciona os jogadores na imagem.
        imagem.add(new CustomPaintComponent());
        
        // Define o tamanho e mostra a imagem.
        imagem.setSize(1920, 1080);
        imagem.setVisible(true);

        return null;
    }
    
    @Override
    public Void visitFormacao(linguagemTaticaParser.FormacaoContext ctx){
        
        nroLinhas = 3 + ctx.outrosnros.size(); // O número de linhas são as três obrigatórias mais o número das linhas adicionais.

        jogadorPorLinha = new int [nroLinhas+1]; // Aloca um espaco para cada linha + 1, que é a linha do goleiro (0).
        jogadorPorLinha[0] = 1; // A linha do goleiro só possui um jogador.
        jogadorPorLinha[1] = Integer.parseInt(ctx.nro1.getText()); // Obtém os valores digitados e atribui a cada parte do vetor.
        jogadorPorLinha[2] = Integer.parseInt(ctx.nro2.getText());
        jogadorPorLinha[3] = Integer.parseInt(ctx.nro3.getText());
        for(int i = 0; i < ctx.outrosnros.size(); i++)
            jogadorPorLinha[i+4] = Integer.parseInt(ctx.outrosnros.get(i).getText());
        
        // Determinando o número de jogadores por posicão.
        if(Integer.parseInt(ctx.nro1.getText()) >= 4){ // Zagueiros e Laterais.
            nroLaterais = 2;
            nroZagueiros = Integer.parseInt(ctx.nro1.getText()) - 2; // Número de zagueiros é o número da linha menos os dois laterais.
        } else // Caso tenha 3 ou menos jogadores, o esquema não tem laterais.
            nroZagueiros = Integer.parseInt(ctx.nro1.getText());
        
        // Meias e atacantes.
        if(ctx.outrosnros.isEmpty()){ // Caso sejam apenas três linhas, o esuqmea só possui meias e todos na segunda linha.
            nroMeias = Integer.parseInt(ctx.nro2.getText());
            nroAtacantes = Integer.parseInt(ctx.nro3.getText());
        } else { // Caso tenha mais que três linhas, a primeira do meio de campo (2) fica para os volantes e as demais para os meias.
            nroVolantes = Integer.parseInt(ctx.nro2.getText());
            nroMeias = Integer.parseInt(ctx.nro3.getText());
            for(int i = 0; i < ctx.outrosnros.size() - 1; i++){
                nroMeias += Integer.parseInt(ctx.outrosnros.get(i).getText());
            }
            nroAtacantes = Integer.parseInt(ctx.outrosnros.get(ctx.outrosnros.size() - 1).getText());
        }
        
        return null;
    }
    
    @Override
    public Void visitDecl_jogador(linguagemTaticaParser.Decl_jogadorContext ctx){
        int nro = 0; // Variável que indica a posicão do jogador na linha. O intervalo dele é [1..nroJogadoresNaKuinha]
        int linhaAtleta = 0; // Variável que indica a linha em que o atleta joga.
        
        if(ctx.pos.getText().equals("goleiro")){ // Se for um goleiro, posicão um e linha zero.
            nro = 1;
            linhaAtleta = 0;
        }
        else if(ctx.pos.getText().equals("lateral")){ // Se for um lateral,
            if(posAtualLateral == 0){ // Se esse for o primeiro lateral declarado, o esquerdo, 
                posAtualLateral = 1; // Ele é o primeiro na linha 1.
                nro = 1;
            } else{ // Se não for o primeiro lateral declarado, é o direito, e é o último jogador na linha 1.
                nro = jogadorPorLinha[1];
            }
            linhaAtleta = 1;
        }
        else if(ctx.pos.getText().equals("zagueiro")){ // Se for um zagueiro,
            if(jogadorPorLinha[1] > 3) // Se tiver lateral no esquema tático
                nro = posAtualZagueiro + 2; // O número dele na posicão é o número de zagueiro dele mais um, porque ele é depois do lateral na linha.
            else
                nro = posAtualZagueiro + 1;
            posAtualZagueiro++; // Aumenta o número de zagueiros declarados.
            linhaAtleta = 1; // Zagueiros ficam sempre na primeira linha.
        }
        else if(ctx.pos.getText().equals("volante")){ // Se for um volante,
            nro = posAtualVolante + 1; // A posicão dele é o número de volantes já declarados.
            posAtualVolante++; // Aumenta o número de volantes declarados.
            linhaAtleta = 2; // A linha dos volantes é sempre a 2.
        }
        else if(ctx.pos.getText().equals("meia")){ // Se for um meia,
            if(nroVolantes != 0){ // Se foram declarados volantes, a linha dos meias vai comećar na linha 3.
                if(posAtualMeia >= jogadorPorLinha[3]){ // Se o número de meias declarados já for maior que o número de meias que cabem na primeira linha,
                    int soma = jogadorPorLinha[3]; // Guarda o número de meias que já foram nas outras linhas.
                    for(int i = 4; i < nroLinhas; i++){ // Itera entre todas as linhas de meias.
                        if(posAtualMeia >= soma + jogadorPorLinha[i]) // Se não couber naquela linha, adiciona na soma o número de jogadores naquela linha,
                            soma = soma + jogadorPorLinha[i];
                        else{ // Caso caiba naquela linha,
                            nro = 1 + posAtualMeia - soma; // O número do jogador na linha vai ser a sua posicão de meia menos todos os meias em linhas anteriores.
                            linhaAtleta = i; // Marca a linha do meia.
                            posAtualMeia++; // Marca mais um meia declarado.
                            break;
                        }
                            
                    }   
                }
                else{ // Caso o número de meia declarado for menor que o número de meias na primeira linha, insere ele ali.
                    nro = 1 + posAtualMeia;
                    posAtualMeia++;
                    linhaAtleta = 3;
                }
            } else{ // Se não foram declarados volantes, a linha dos meias vai comećar na linha 2. Mesmo funcionamento do if anterior.
                if(posAtualMeia >= jogadorPorLinha[2]){
                    int soma = jogadorPorLinha[2];
                    for(int i = 0; i < nroLinhas; i++){
                        if(posAtualMeia >= soma + jogadorPorLinha[3+i])
                            soma = soma + jogadorPorLinha[3+i];
                        else{
                            linhaAtleta = i + 3;
                            nro = 1 + posAtualMeia;
                            posAtualMeia++;
                            break;
                        }
                    }
                }
                else{
                    nro = 1 + posAtualMeia;
                    posAtualMeia++;
                    linhaAtleta = 2;
                }
                
            }
                
        }
        else{
            nro = posAtualAtacante + 1;
            posAtualAtacante++;
            linhaAtleta = nroLinhas;
        }
        
        // Cria o jogador com as características dele: número na linha, linha em que joga, nome, número de linhas no esquema, 
        // e número de jogadores na linha dele.
        Jogador atual = new Jogador(nro, linhaAtleta, ctx.n.getText(), nroLinhas, jogadorPorLinha[linhaAtleta]);

        jogs.add(atual); // Adiciona o jogador na lista de jogadores.    
        return null;
    }
    
    @Override
    public Void visitPapel(linguagemTaticaParser.PapelContext ctx){
        Jogador a;
        
        for(Jogador p : jogs){ // Passa por todos os jogadores,
            if(p.nome.equals(ctx.n.getText())) // Buscando o jogador com o nome correto.
                if(ctx.d != null) // Se o papel for defender, marca na classe.
                    p.funcao = "defender";
                else // Caso contrário, marca que é atacar.
                    p.funcao = "atacar";
                    
        }
        
        return null;
    }
}
