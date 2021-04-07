package br.ufscar.dc.compiladores.sistematatico;

import java.util.HashMap;

public class Programa extends linguagemTaticaBaseVisitor<Void>{
    
    // Variáveis com o número de jogadores por posicão.
    int nroGoleiro = 1;
    int nroLaterais = 0;
    int nroZagueiros = 0;
    int nroVolantes = 0;
    int nroMeias = 0;
    int nroAtacantes = 0;
    
    HashMap<String,String> jogadores = new HashMap<String, String>();
    
    @Override
    public Void visitFormacao(linguagemTaticaParser.FormacaoContext ctx){
        
        int nroJogadores = 0;
        
        // Transforma cada um dos números da formacão em inteiros.
        nroJogadores += Integer.parseInt(ctx.nro1.getText()); 
        nroJogadores += Integer.parseInt(ctx.nro2.getText()); 
        nroJogadores += Integer.parseInt(ctx.nro3.getText()); 
        for(int i = 0; i < ctx.outrosnros.size(); i++)
            nroJogadores += Integer.parseInt(ctx.outrosnros.get(i).getText());
        
        // Se os números na formacão não somarem 10, houve um erro.
        if(nroJogadores != 10)
            ErrosSemanticos.adicionarErroSemantico(ctx.start, "A sua formacão tem " + nroJogadores + "jogadores, mas deve ter 11");
        
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
        String posicao = ctx.pos.getText(); // Obtém a posicão do jogador.
        
        if(null != posicao) 
            switch (posicao) {
            case "goleiro": // Se for um goleiro, 
                if(nroGoleiro > 0){ // Verifica se ainda tem espaco pra mais um jogador naquela posicão.
                    nroGoleiro--; // Diminui o número de espacos pra jogadores naquela posicão, 
                    jogadores.put(ctx.n.getText(), posicao); // Coloca na lista de jogadores.
                }
                else // Caso não tenha, emite erro.
                    ErrosSemanticos.adicionarErroSemantico(ctx.start, "Erro, goleiro já declarado.");
                break;
            case "lateral": // Se for um lateral, 
                if(nroLaterais > 0){ // Verifica se ainda tem espaco pra mais um jogador naquela posicão.
                    nroLaterais--; // Diminui o número de espacos pra jogadores naquela posicão,
                    jogadores.put(ctx.n.getText(), posicao); // Coloca na lista de jogadores.
                }
                else // Caso não tenha, emite erro.
                    ErrosSemanticos.adicionarErroSemantico(ctx.start,"Erro, todos laterias já declarados");
                break;
            case "zagueiro": // Se for um zagueiro,
                if(nroZagueiros > 0){ // Verifica se ainda tem espaco pra mais um jogador naquela posicão.
                    nroZagueiros--; // Diminui o número de espacos pra jogadores naquela posicão,
                    jogadores.put(ctx.n.getText(), posicao); // Coloca na lista de jogadores.
                }
                else // Caso não tenha, emite erro.
                    ErrosSemanticos.adicionarErroSemantico(ctx.start,"Erro, todos os zagueiros já declarados");
                break;
            case "volante": // Se for um volante,
                if(nroVolantes > 0){ // Verifica se ainda tem espaco pra mais um jogador naquela posicão.
                    nroVolantes--; // Diminui o número de espacos pra jogadores naquela posicão,
                    jogadores.put(ctx.n.getText(), posicao); // Coloca na lista de jogadores.
                }
                else // Caso não tenha, emite erro.
                    ErrosSemanticos.adicionarErroSemantico(ctx.start,"Erro, todos os volantes já declarados");
                break;
            case "meia": // Se for um meia,
                if(nroMeias > 0){ // Verifica se ainda tem espaco pra mais um jogador naquela posicão.
                    nroMeias--; // Diminui o número de espacos pra jogadores naquela posicão,
                    jogadores.put(ctx.n.getText(), posicao); // Coloca na lista de jogadores.
                }
                else  // Caso não tenha, emite erro.
                    ErrosSemanticos.adicionarErroSemantico(ctx.start,"Erro, todos os meias já declarados");
                break;
            case "atacante": // Se for um atacante,
                if(nroAtacantes > 0){ // Verifica se ainda tem espaco pra mais um jogador naquela posicão.
                    nroAtacantes--; // Diminui o número de espacos pra jogadores naquela posicão,
                    jogadores.put(ctx.n.getText(), posicao); // Coloca na lista de jogadores.
                }
                else // Caso não tenha, emite erro.
                    ErrosSemanticos.adicionarErroSemantico(ctx.start,"Erro, todos os atacantes já declarados");
                break;
            default:
                break;
        }
        
        return null;
    }
    
    @Override
    public Void visitPapel(linguagemTaticaParser.PapelContext ctx){
        
        String posicao = jogadores.get(ctx.n.getText()); // Obtém posicão do jogador.
        if(posicao == null) // Se posicão for nula, jogador não foi declarado.
            ErrosSemanticos.adicionarErroSemantico(ctx.start, "Atleta "+ctx.n.getText() + " não declarado");
        
        // Faz verificacões se o papel do jogador corresponde com sua posicão.
        // Restricões: goleiros só defendem, atacantes só atacam e zagueiros só defendem.
        if(null != posicao)switch (posicao) {
            case "goleiro":
                if(ctx.a != null)
                    ErrosSemanticos.adicionarErroSemantico(ctx.start,"Goleiros tem a funcão primária de defender,");
                break;
            case "atacante":
                if(ctx.d != null)
                    ErrosSemanticos.adicionarErroSemantico(ctx.start,"Atacantes tem a funcão primária de atacar");
                break;
            case "zagueiro":
                if(ctx.a != null)
                    ErrosSemanticos.adicionarErroSemantico(ctx.start,"Zagueiros tem a funcão primária de defender");
                break;
            default:
                break;
        }
        return null;
    }
}