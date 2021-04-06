package br.ufscar.dc.compiladores.sistematatico;

import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class Interpretador extends linguagemTaticaBaseVisitor<Void>{
    
    int nroLinhas = 0;
    
    int nroGoleiro = 1;
    int nroLaterais = 0;
    int nroZagueiros = 0;
    int nroVolantes = 0;
    int nroMeias = 0;
    int nroAtacantes = 0;

    int posAtualZagueiro = 0;
    int posAtualLateral = 0;
    int posAtualVolante = 0;
    int posAtualMeia = 0;
    int posAtualAtacante = 0;
    
    ArrayList<Jogador> jogs = new ArrayList();
    int[] jogadorPorLinha;
    
    class CustomPaintComponent extends Component {
        public void paint(Graphics g){
            Graphics2D g2d = (Graphics2D)g;
            
            for(Jogador j : jogs){
                if(j.funcao.equals("defender"))
                    g2d.setColor(Color.BLUE);
                else if(j.funcao.equals("atacar"))
                    g2d.setColor(Color.RED);
                else
                    g2d.setColor(Color.BLACK);
                g2d.fillOval(j.x,j.y,50,50);
                g2d.drawString(j.nome, j.x, j.y + 80);
            }
           
        }
        
    }
    
    @Override
    public Void visitPrograma(linguagemTaticaParser.ProgramaContext ctx){
        visitFormacao(ctx.f);
        for(int i = 0; i < ctx.d.size(); i++)
            visitDecl_jogador(ctx.d.get(i));
        
        for(int i = 0; i < ctx.p.size(); i++)
            visitPapel(ctx.p.get(i));
        
        
        Frame imagem = new Frame();
        
        imagem.add(new CustomPaintComponent());
        
        imagem.setSize(1920, 1080);
        imagem.setVisible(true);

        for(Jogador j : jogs){
            System.out.println("Nome: " + j.nome + " Funcao: "+ j.funcao + " pos: " + j.nro + " linha: " + j.linha);
        }
        
        return null;
    }
    
    @Override
    public Void visitFormacao(linguagemTaticaParser.FormacaoContext ctx){
        
        int linha = 3 + ctx.outrosnros.size();
        nroLinhas = linha;
        
        jogadorPorLinha = new int [nroLinhas+1];
        jogadorPorLinha[0] = 1;
        jogadorPorLinha[1] = Integer.parseInt(ctx.nro1.getText());
        jogadorPorLinha[2] = Integer.parseInt(ctx.nro2.getText());
        jogadorPorLinha[3] = Integer.parseInt(ctx.nro3.getText());
        for(int i = 0; i < ctx.outrosnros.size(); i++)
            jogadorPorLinha[i+4] = Integer.parseInt(ctx.outrosnros.get(i).getText());
        
        // Determinando o número de jogadores por posicão.
        if(Integer.parseInt(ctx.nro1.getText()) >= 4){ // Zagueiros e Laterais.
            nroLaterais = 2;
            nroZagueiros = Integer.parseInt(ctx.nro1.getText()) - 2;
        } else
            nroZagueiros = Integer.parseInt(ctx.nro1.getText());
        
        // Meias e atacantes.
        if(ctx.outrosnros.isEmpty()){
            nroMeias = Integer.parseInt(ctx.nro2.getText());
            nroAtacantes = Integer.parseInt(ctx.nro3.getText());
        } else {
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
        int nro = 0;
        int linhaAtleta = 0;
        
        if(ctx.pos.getText().equals("goleiro")){
            nro = 1;
            linhaAtleta = 0;
        }
        else if(ctx.pos.getText().equals("lateral")){
            if(posAtualLateral == 0){
                posAtualLateral = 1;
                nro = 1;
            } else{
                nro = jogadorPorLinha[1];
            }
            linhaAtleta = 1;
        }
        else if(ctx.pos.getText().equals("zagueiro")){
            nro = posAtualZagueiro + 2;
            posAtualZagueiro++;
            linhaAtleta = 1;
        }
        else if(ctx.pos.getText().equals("volante")){
            nro = posAtualVolante + 1;
            posAtualVolante++;
            linhaAtleta = 2;
        }
        else if(ctx.pos.getText().equals("meia")){
            if(nroVolantes != 0){
                if(posAtualMeia >= jogadorPorLinha[3]){
                    int soma = jogadorPorLinha[3];
                    for(int i = 4; i < nroLinhas; i++){
                        if(posAtualMeia >= soma + jogadorPorLinha[i])
                            soma = soma + jogadorPorLinha[i];
                        else{
                            nro = 1 + posAtualMeia - soma;
                            linhaAtleta = i;
                            posAtualMeia++;
                            break;
                        }
                            
                    }   
                }
                else{
                    nro = 1 + posAtualMeia;
                    posAtualMeia++;
                    linhaAtleta = 3;
                }
            } else{
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
        
        //Jgador(int nro, int linha, String funcao, String nome, int nroLinhas, int nroJogadoresLinha)
        Jogador atual = new Jogador(nro, linhaAtleta, ctx.n.getText(), nroLinhas, jogadorPorLinha[linhaAtleta]);

        jogs.add(atual);    
        return null;
    }
    
    @Override
    public Void visitPapel(linguagemTaticaParser.PapelContext ctx){
        Jogador a;
        
        for(Jogador p : jogs){
            if(p.nome.equals(ctx.n.getText()))
                if(ctx.d != null)
                    p.funcao = "defender";
                else
                    p.funcao = "atacar";
                    
        }
        
        return null;
    }
}
