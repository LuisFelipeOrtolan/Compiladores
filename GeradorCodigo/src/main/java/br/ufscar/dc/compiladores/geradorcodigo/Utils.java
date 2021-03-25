package br.ufscar.dc.compiladores.geradorcodigo;

import br.ufscar.dc.compiladores.analisadorsemantico.laParser;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.Token;

public class Utils {
    
    public static List<String> errosSemanticos = new ArrayList<>();
    
    // Verifica se um tipo é compatível com outro para operacões.
    public static Tipos tiposCompativeis(Tipos tipo1, Tipos tipo2){
        if(tipo1 == Tipos.Inteiro) // Inteiros podem ser combinados com real ou inteiro.
            if(tipo2 == Tipos.Inteiro)
                return Tipos.Inteiro;
            else if(tipo2 == Tipos.Real)
                return Tipos.Real;
            else
                return Tipos.Erro;
        
        else if(tipo1 == Tipos.Real) // Reais podem ser combinados com inteiros ou reais.
            if(tipo2 == Tipos.Inteiro || tipo2 == Tipos.Real)
                return Tipos.Real;
            else
                return Tipos.Erro;
        
        else if(tipo1 == Tipos.Literal) // Literais só podem ser combinados com literais.
            if(tipo2 == Tipos.Literal)
                return Tipos.Literal;
            else
                return Tipos.Erro;
        else if(tipo1 == Tipos.Logico) // Lógicos só podem ser combinados com lógicos.
            if(tipo2 == Tipos.Logico)
                return Tipos.Logico;
            else
                return Tipos.Erro;
        else if(tipo1 == Tipos.Struct) // Estrututras só podem ser combinados com estruturas.
            if(tipo2 == Tipos.Struct)
                return Tipos.Struct;
            else
                return Tipos.Erro;
        else
            return Tipos.Erro;
    } 
    
    // Adiciona um erro a ser reportado.
    public static void adicionarErroSemantico(Token t, String mensagem){
        int linha = t.getLine();
        errosSemanticos.add(String.format("Linha %d: %s", linha, mensagem));
    }
    
    // Verifica se uma string é um número.
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
    
    // Retorna qual a letra associada ao tipo em printfs e scanfs.
    public static String letraTipo(Tipos tipo){
        if(tipo == Tipos.Inteiro)
            return "d";
        else if (tipo == Tipos.Real)
            return "f";
        else if(tipo == Tipos.Literal)
            return "s";
        else
            return "";
    }
    
    // Verifica o tipo de um determinado context.
    public static Tipos verificarTipo(List<TabelaDeSimbolos> escopos, laParser.ExpressaoContext ctx){
        Tipos ladoEsquerdo = verificarTipo(escopos, ctx.tl);
        
        for(int i = 0; i < ctx.outrostl.size(); i++){ 
            Tipos termo_logico = verificarTipo(escopos, ctx.outrostl.get(i));
            ladoEsquerdo = Utils.tiposCompativeis(termo_logico, ladoEsquerdo);
        }
        
        return ladoEsquerdo;
    }
    
    public static Tipos verificarTipo(List<TabelaDeSimbolos> escopos, laParser.Termo_logicoContext ctx){
        Tipos ladoEsquerdo = verificarTipo(escopos, ctx.f1);
        for(int i = 0; i < ctx.outrosf.size(); i++){
            Tipos fator_logico = verificarTipo(escopos, ctx.outrosf.get(i));
            ladoEsquerdo = Utils.tiposCompativeis(fator_logico, ladoEsquerdo);
        }
        
        return ladoEsquerdo;
    }
    
    public static Tipos verificarTipo(List<TabelaDeSimbolos> escopos, laParser.Fator_logicoContext ctx){
        if(ctx.not != null)
            return Tipos.Logico;
        
        return verificarTipo(escopos, ctx.plogica);
    }
    
    public static Tipos verificarTipo(List<TabelaDeSimbolos> escopos, laParser.Parcela_logicaContext ctx){
        if(ctx.v != null || ctx.f != null)
            return Tipos.Logico;

        return verificarTipo(escopos, ctx.exp);
    }
    
    public static Tipos verificarTipo(List<TabelaDeSimbolos> escopos, laParser.Exp_relacionalContext ctx){
        Tipos ladoEsquerdo = verificarTipo(escopos, ctx.exp1);
        for(int i = 0; i < ctx.outrasexp.size(); i++)
            ladoEsquerdo = Utils.tiposCompativeis(ladoEsquerdo, verificarTipo(escopos, ctx.outrasexp.get(i)));
 
        return ladoEsquerdo;
    }
    
    public static Tipos verificarTipo(List<TabelaDeSimbolos> escopos, laParser.Exp_aritmeticaContext ctx){
        Tipos ladoEsquerdo = verificarTipo(escopos, ctx.termo1);
        for(int i = 0; i < ctx.outrostermos.size(); i++){
            Tipos t = verificarTipo(escopos, ctx.outrostermos.get(i));
            ladoEsquerdo = Utils.tiposCompativeis(ladoEsquerdo, t);
        }
            
        return ladoEsquerdo;
    }
    
    public static Tipos verificarTipo(List<TabelaDeSimbolos> escopos, laParser.TermoContext ctx){
        Tipos ladoEsquerdo = verificarTipo(escopos, ctx.fator1);
        
        for(int i = 0; i < ctx.outrosfatores.size(); i++){
            Tipos t  = verificarTipo(escopos, ctx.outrosfatores.get(i));
            ladoEsquerdo = Utils.tiposCompativeis(ladoEsquerdo, t);
        }
        
        return ladoEsquerdo;
    }
    
    public static Tipos verificarTipo(List<TabelaDeSimbolos> escopos, laParser.FatorContext ctx){
        Tipos ladoEsquerdo = verificarTipo(escopos, ctx.parcela1);
        for(int i = 0; i < ctx.outrasparcelas.size(); i++){
            Tipos t = verificarTipo(escopos, ctx.outrasparcelas.get(i));
            ladoEsquerdo = Utils.tiposCompativeis(ladoEsquerdo, t);
        }
        
        return ladoEsquerdo;
    }
    
    public static Tipos verificarTipo(List<TabelaDeSimbolos> escopos, laParser.ParcelaContext ctx){
        if(ctx.puna != null)
            return verificarTipo(escopos, ctx.puna);
        else
            return verificarTipo(escopos, ctx.pnuna);
    }
    
    public static Tipos verificarTipo(List<TabelaDeSimbolos> escopos, laParser.Parcela_unarioContext ctx){
        if(ctx.iden != null)
            return verificarTipo(escopos, ctx.iden);
        else if(ctx.id != null){
            for(TabelaDeSimbolos ts : escopos)
                if(ts.verificar(ctx.id.getText()) != null)
                    return ts.verificar(ctx.id.getText()).tipo;
        }
        else if(ctx.inte != null)
            return Tipos.Inteiro;
        else if(ctx.real != null)
            return Tipos.Real;
        else if (ctx.exp_par != null)
            return verificarTipo(escopos, ctx.exp_par);
        return null;
    }
    
    public static Tipos verificarTipo(List<TabelaDeSimbolos> escopos, laParser.Parcela_nao_unarioContext ctx){
        if(ctx.cad != null)
            return Tipos.Literal;
        return null;
    }
    
    public static Tipos verificarTipo(List<TabelaDeSimbolos> escopos, laParser.IdentificadorContext ctx){
        for(TabelaDeSimbolos ts: escopos)
            if(ts.verificar(ctx.text.getText()) != null){
                if(ts.verificar(ctx.text.getText()).tipo != Tipos.Struct)
                    return ts.verificar(ctx.text.getText()).tipo;
                else
                    if(ctx.ponto != null){
                        TabelaDeSimbolos struct = ts.verificar(ctx.text.getText()).tabelaParaStruct;
                        return struct.verificar(ctx.text1.get(0).getText()).tipo;
                    }
                    else
                        return Tipos.Struct;
            }
        return null;
    }
    
    public static Tipos verificarTipo(List<TabelaDeSimbolos> escopos, laParser.Tipo_basicoContext ctx){
        if(ctx.l != null)
            return Tipos.Literal;
        else if(ctx.i != null)
            return Tipos.Inteiro;
        else if(ctx.log != null)
            return Tipos.Logico;
        else
            return Tipos.Real;
    }
    
    public static Tipos verificarTipo(List<TabelaDeSimbolos> escopos, laParser.Tipo_basico_identContext ctx){
        if(ctx.id != null){
            for(TabelaDeSimbolos ts : escopos)
                if(ts.verificar(ctx.id.getText()) != null)
                        return ts.verificar(ctx.id.getText()).tipo; 
        }
        else{
            return verificarTipo(escopos, ctx.tbas);
        }
        
        return null;
    }
    
    public static Tipos verificarTipo(List<TabelaDeSimbolos> escopos, laParser.VariavelContext ctx){
        return verificarTipo(escopos, ctx.tip);
    }
    
    public static Tipos verificarTipo(List<TabelaDeSimbolos> escopos, laParser.TipoContext ctx){
        if(ctx.reg != null)
            return Tipos.Struct;
        return verificarTipo(escopos, ctx.ext);
    }
    
    public static Tipos verificarTipo(List<TabelaDeSimbolos> escopos, laParser.Tipo_estendidoContext ctx){
        return verificarTipo(escopos, ctx.t);
    }
    
    // Cria uma lista de intervalos a partir da linguagem algorítmica
    public static List<String> intervalos(laParser.ConstantesContext ctx){
        List<String> interv = new ArrayList();
        
        interv.add(ctx.int1.inicio.getText());
        if(ctx.int1.fim != null)
            interv.add(ctx.int1.fim.getText());
        else
            interv.add("-");
        
        for(int i = 0; i < ctx.outrosints.size(); i++){
            interv.add(ctx.outrosints.get(i).getText());
            if(ctx.outrosints.get(i).fim != null)
                interv.add(ctx.outrosints.get(i).fim.getText());
            else
                interv.add("-");
        }
        
        return interv;
    }
    
    // Retorna se é uma cadeia ou não baseado em um contexto.
    public static Boolean cadeia(laParser.ExpressaoContext ctx){
        if(!ctx.op.isEmpty())
            return false;
        return cadeia(ctx.tl);
    }
    
    public static Boolean cadeia(laParser.Termo_logicoContext ctx){
        if(!ctx.op.isEmpty())
            return false;
        return cadeia(ctx.f1);
    }
    
    public static Boolean cadeia(laParser.Fator_logicoContext ctx){
        if(ctx.not != null)
            return false;
        return cadeia(ctx.plogica);
    }
    
    public static Boolean cadeia(laParser.Parcela_logicaContext ctx){
        if(ctx.v != null || ctx.f != null)
            return false;
        return cadeia(ctx.exp);
    }
    
    public static Boolean cadeia(laParser.Exp_relacionalContext ctx){
        if(ctx.oprel != null)
            return false;
        return cadeia(ctx.exp1);
    }
    
    public static   Boolean cadeia(laParser.Exp_aritmeticaContext ctx){
        if(!ctx.op.isEmpty())
            return false;
        return cadeia(ctx.termo1);
    }
    
    public static Boolean cadeia(laParser.TermoContext ctx){
        if(!ctx.op.isEmpty())
            return false;
        return cadeia(ctx.fator1);
    }
    
    public static Boolean cadeia(laParser.FatorContext ctx){
        if(!ctx.op.isEmpty())
            return false;
        return cadeia(ctx.parcela1);
    }
    
    public static Boolean cadeia(laParser.ParcelaContext ctx){
        if(ctx.puna != null)
            return cadeia(ctx.puna);
        else
            return cadeia(ctx.pnuna);
    }
    
    public static Boolean cadeia(laParser.Parcela_nao_unarioContext ctx){
        if(ctx.cad != null)
            return true;
        return false;
    }
    
    public static Boolean cadeia(laParser.Parcela_unarioContext ctx){
        if(ctx.exp_par != null)
            return cadeia(ctx.exp_par);
        return false;
    }
    
    
}
