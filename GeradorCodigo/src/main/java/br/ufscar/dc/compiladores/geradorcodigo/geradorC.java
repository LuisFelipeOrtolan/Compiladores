package br.ufscar.dc.compiladores.geradorcodigo;

import br.ufscar.dc.compiladores.analisadorsemantico.laBaseVisitor;
import br.ufscar.dc.compiladores.analisadorsemantico.laParser;
import java.util.List;

public class geradorC extends laBaseVisitor<Tipos>{
    StringBuilder saida;
    TabelaDeSimbolos tabela;
    TabelaDeFuncoes funcs;
    Escopos aninhados = new Escopos();
    
    boolean func = false;
    
    public geradorC(){
        saida = new StringBuilder();
        this.tabela = new TabelaDeSimbolos();
        this.funcs = new TabelaDeFuncoes();
    }
    
    @Override
    public Tipos visitPrograma(laParser.ProgramaContext ctx){
        aninhados.criarNovoEscopo();
        saida.append("#include <stdio.h>\n");
        saida.append("#include <stdlib.h>\n");
        
        visitDeclaracoes(ctx.decls);
        
        saida.append("\n");
        saida.append("int main(){\n");
        
        aninhados.criarNovoEscopo();
        visitCorpo(ctx.c);
        aninhados.abandonarEscopo();
        
        saida.append("return 0;\n}\n");
        aninhados.abandonarEscopo();
        return null;    
    }
    
    @Override
    public Tipos visitDeclaracao_local(laParser.Declaracao_localContext ctx){
        if(ctx.decl != null){
            if(ctx.vars.tip.reg != null)
                aninhados.criarNovoEscopo();
            visitVariavel(ctx.vars);
            if(ctx.vars.tip.reg != null){
                TabelaDeSimbolos ts = aninhados.obterEscopoAtual();
                aninhados.abandonarEscopo();
                aninhados.obterEscopoAtual().inserir(ctx.vars.ident1.getText(), Tipos.Struct, ts);
                for(int i = 0; i < ctx.vars.outrosIdents.size(); i++)
                    aninhados.obterEscopoAtual().inserir(ctx.vars.outrosIdents.get(i).getText(), Tipos.Struct, ts);
            }
            saida.append(";\n");
        }
        else if (ctx.con != null){
            saida.append("const ");
            visitTipo_basico(ctx.tbas);
            Tipos aux = Utils.verificarTipo(aninhados.percorrerEscoposAninhados(), ctx.tbas);
            if(aux == Tipos.Literal){
                saida.append("[80]");
            }
            saida.append(" ");
            saida.append(ctx.id.getText());
            saida.append(" = ");
            visitValor_constante(ctx.val);
            saida.append(";\n");
        } else {
            saida.append("typedef ");
            aninhados.criarNovoEscopo();
            visitTipo(ctx.t);
            TabelaDeSimbolos ts = aninhados.obterEscopoAtual();
            aninhados.abandonarEscopo();
            saida.append(ctx.id.getText());
            aninhados.obterEscopoAtual().inserir(ctx.id.getText(), Tipos.Struct, ts);
            saida.append(";\n");
        }
        
        return null;
    }
    
    @Override
    public Tipos visitVariavel(laParser.VariavelContext ctx){
        Tipos variavel = visitTipo(ctx.tip);
        saida.append(" ");
        
        TabelaDeSimbolos struct = null;
        
        for(TabelaDeSimbolos ts : aninhados.percorrerEscoposAninhados())
                if(ts.verificar(ctx.tip.getText()) != null)
                    struct = ts.verificar(ctx.tip.getText()).tabelaParaStruct;

        aninhados.obterEscopoAtual().inserir(ctx.ident1.text.getText(), variavel, struct);
        
        visitIdentificador(ctx.ident1);

        if(variavel == Tipos.Literal)
            saida.append("[80]");

        for(int i = 0; i < ctx.outrosIdents.size(); i++){
            saida.append(", ");
            visitIdentificador(ctx.outrosIdents.get(i));
            if(variavel == Tipos.Literal)
                saida.append("[80]");
            
            
            for(TabelaDeSimbolos ts : aninhados.percorrerEscoposAninhados()){
                struct = null;
                if(ts.verificar(ctx.tip.getText()) != null)
                    struct = ts.verificar(ctx.tip.getText()).tabelaParaStruct;
            }
            aninhados.obterEscopoAtual().inserir(ctx.outrosIdents.get(i).getText(), variavel, struct);
        }

        return null;
    }
    
    @Override
    public Tipos visitTipo_estendido(laParser.Tipo_estendidoContext ctx){
        visitTipo_basico_ident(ctx.t);
        if(ctx.chapeu != null)
            saida.append(" *");
        
        if(func){
            if(Utils.verificarTipo(aninhados.percorrerEscoposAninhados(), ctx.t) == Tipos.Literal)
                saida.append(" *");
        }
        
        return Utils.verificarTipo(aninhados.percorrerEscoposAninhados(), ctx.t);
    }
    
    @Override
    public Tipos visitTipo_basico_ident(laParser.Tipo_basico_identContext ctx){
        if(ctx.id != null){
            saida.append(ctx.id.getText());
            List<TabelaDeSimbolos> escopos = aninhados.percorrerEscoposAninhados();
            for(TabelaDeSimbolos ts : escopos){
                if(ts.verificar(ctx.id.getText()) != null)
                    return ts.verificar(ctx.id.getText()).tipo;
            }
        }
        else
            return visitTipo_basico(ctx.tbas);
       
        return null;
    }
    
    @Override
    public Tipos visitTipo_basico(laParser.Tipo_basicoContext ctx){
        if(ctx.i != null){
            saida.append("int");
            return Tipos.Inteiro;
        }
        else if(ctx.r != null){
            saida.append("float");
            return Tipos.Real;
        }
        else if(ctx.log != null){
            saida.append("bool");
            return Tipos.Logico;
        }
        else{
            saida.append("char");
            return Tipos.Literal;
        }
    }
    
    @Override
    public Tipos visitIdentificador(laParser.IdentificadorContext ctx){
        saida.append(ctx.text.getText());
            
        for(int i = 0; i < ctx.text1.size(); i++){
            saida.append(".");
            saida.append(ctx.text1.get(i).getText());
        }
        visitDimensao(ctx.d);
        
        for(TabelaDeSimbolos ts : aninhados.percorrerEscoposAninhados()){
            if(ts.verificar(ctx.text.getText()) != null)
                if(!ctx.text1.isEmpty())
                    return ts.verificar(ctx.text.getText()).tabelaParaStruct.verificar(ctx.text1.get(0).getText()).tipo;
                else
                    return ts.verificar(ctx.text.getText()).tipo;
        }
        
        return null;
    } 
    
    @Override
    public Tipos visitCmdLeia(laParser.CmdLeiaContext ctx){
        Tipos leia = null;
        List<TabelaDeSimbolos> escopos = aninhados.percorrerEscoposAninhados();
        String nomesVariaveis = "";
        
        for(TabelaDeSimbolos ts: escopos)
            if(ts.verificar(ctx.id1.text.getText()) != null){
                leia = ts.verificar(ctx.id1.text.getText()).tipo;
                if(leia == Tipos.Struct){
                    TabelaDeSimbolos struct = ts.verificar(ctx.id1.text.getText()).tabelaParaStruct;
                    leia = struct.verificar(ctx.id1.text1.get(0).getText()).tipo;
                }
            }
        
        if(leia == Tipos.Literal){
            saida.append("gets(");
            saida.append(ctx.id1.text.getText());
            if(ctx.id1.ponto != null){
                saida.append(".");
                saida.append(ctx.outrosids.get(0).getText());
            }
            saida.append(");\n");
            return null;
        }
        
        saida.append("scanf(\"%");
        
        for(TabelaDeSimbolos ts: escopos)
            if(ts.verificar(ctx.id1.text.getText()) != null){
                leia = ts.verificar(ctx.id1.text.getText()).tipo;
                if(leia != Tipos.Struct){
                    saida.append(Utils.letraTipo(leia));
                    nomesVariaveis = nomesVariaveis + "&" + ctx.id1.text.getText() + " ,";
                }
                else{
                    TabelaDeSimbolos struct = ts.verificar(ctx.id1.text.getText()).tabelaParaStruct;
                    saida.append(Utils.letraTipo(struct.verificar(ctx.id1.text1.get(0).getText()).tipo));
                    nomesVariaveis = nomesVariaveis + "&" + ctx.id1.text1.get(0).getText() + " ,";
                }
                
            }
        
        for(int i = 0; i < ctx.outrosids.size(); i++){
            for(TabelaDeSimbolos ts : escopos)
                if(ts.verificar(ctx.outrosids.get(i).text.getText()) != null){
                    leia = ts.verificar(ctx.outrosids.get(i).text.getText()).tipo;
                    if(leia != Tipos.Struct){
                        saida.append(" %");
                        saida.append(Utils.letraTipo(leia));
                        nomesVariaveis = nomesVariaveis + "&" + ctx.outrosids.get(i).text.getText() + " ,";
                    }
                    else{
                        TabelaDeSimbolos struct = ts.verificar(ctx.outrosids.get(i).text.getText()).tabelaParaStruct;
                        saida.append(" %");
                        saida.append(Utils.letraTipo(struct.verificar(ctx.outrosids.get(i).text1.get(0).getText()).tipo));
                        nomesVariaveis = nomesVariaveis + "&" + ctx.outrosids.get(i).text1.get(0).getText() + " ,";
                    }
                }
        }
        
        saida.append("\", ");
        saida.append(nomesVariaveis.substring(0,nomesVariaveis.length() -2));
        saida.append(");\n");

        return null;
    }
    
    @Override
    public Tipos visitCmdEscreva(laParser.CmdEscrevaContext ctx){
        boolean algumIdentificador = false;
        
        int inicio = 0;
        int fim = 0;
        
        saida.append("printf(\"");
        if(Utils.cadeia(ctx.exp1)){
            if(ctx.exp1.getText().charAt(0) == '\"')
                inicio = 1;
            
            if(ctx.exp1.getText().charAt(ctx.exp1.getText().length() - 1) == '\"')
                fim = ctx.exp1.getText().length() - 1;
            else
                fim = ctx.exp1.getText().length();
            
            saida.append(ctx.exp1.getText().substring(inicio, fim));
        }
        else{
            List<TabelaDeSimbolos> escopos = aninhados.percorrerEscoposAninhados();
            saida.append("%");
            saida.append(Utils.letraTipo(Utils.verificarTipo(escopos, ctx.exp1)));
            algumIdentificador = true;
        }

        for(int i = 0; i < ctx.outrosexp.size(); i++){
            if(!Utils.cadeia(ctx.outrosexp.get(i))){    
                if(saida.charAt(saida.length() -1) != ' ')
                    saida.append(" %");
                else
                    saida.append("%");
                saida.append(Utils.letraTipo(Utils.verificarTipo(aninhados.percorrerEscoposAninhados(), ctx.outrosexp.get(i))));
                algumIdentificador = true;
            }
            else{
                if(ctx.outrosexp.get(i).getText().charAt(0) == '\"')
                    inicio = 1;
            
                if(ctx.outrosexp.get(i).getText().charAt(ctx.outrosexp.get(i).getText().length() - 1) == '\"')
                    fim = ctx.outrosexp.get(i).getText().length() - 1;
                else{
                    fim = ctx.outrosexp.get(i).getText().length();
                }
                saida.append(ctx.outrosexp.get(i).getText().substring(inicio,fim));
            }
            
        }
        
        saida.append("\"");
        if(algumIdentificador){
            
        
            if(!Utils.cadeia(ctx.exp1)){
                saida.append(", ");
                visitExpressao(ctx.exp1);
            }

            for(int i = 0; i < ctx.outrosexp.size(); i++)
                if(!Utils.cadeia(ctx.outrosexp.get(i))){
                    saida.append(", ");
                    visitExpressao(ctx.outrosexp.get(i));
                
                }
        }
        
        saida.append(");\n");
        return null;
    }
    
    @Override
    public Tipos visitExpressao(laParser.ExpressaoContext ctx){
        Tipos ladoEsquerdo = visitTermo_logico(ctx.tl);
        
        for(int i = 0; i < ctx.outrostl.size(); i++){ 
            saida.append(" ");
            visitOp_logico_1(ctx.op.get(i));
            saida.append(" ");
            Tipos termo_logico = visitTermo_logico(ctx.outrostl.get(i));
            ladoEsquerdo = Utils.tiposCompativeis(termo_logico, ladoEsquerdo);
        }
        
        return ladoEsquerdo;
    }
    
    @Override
    public Tipos visitOp_logico_1(laParser.Op_logico_1Context ctx){
        saida.append("||");
        return null;
    }

    @Override
    public Tipos visitTermo_logico(laParser.Termo_logicoContext ctx){
        Tipos ladoEsquerdo = visitFator_logico(ctx.f1);
        
        for(int i = 0; i < ctx.outrosf.size(); i++){
            saida.append(" ");
            visitOp_logico_2(ctx.op.get(i));
            saida.append(" ");
            Tipos fator_logico = visitFator_logico(ctx.outrosf.get(i));
            ladoEsquerdo = Utils.tiposCompativeis(fator_logico, ladoEsquerdo);
        }
        
        return ladoEsquerdo;
    }
    
    @Override
    public Tipos visitOp_logico_2(laParser.Op_logico_2Context ctx){
        saida.append("&&");
        return null;
    }

    @Override
    public Tipos visitFator_logico(laParser.Fator_logicoContext ctx){
        if(ctx.not != null)
            saida.append("!");
        
        
        Tipos resultado = visitParcela_logica(ctx.plogica);
        
        if(ctx.not != null)
            return Tipos.Logico;
        else
            return resultado;
    }
    
    @Override
    public Tipos visitParcela_logica(laParser.Parcela_logicaContext ctx){
        if(ctx.v != null){
            saida.append("true");
            return Tipos.Logico;
        }
        else if(ctx.f != null){
            saida.append("false");
            return Tipos.Logico;
        }
        else
            return visitExp_relacional(ctx.exp);
    }
    
    @Override
    public Tipos visitExp_relacional(laParser.Exp_relacionalContext ctx){
        Tipos ladoEsquerdo = visitExp_aritmetica(ctx.exp1);
        
        for(int i = 0; i < ctx.outrasexp.size(); i++){
            saida.append(" ");
            visitOp_relacional(ctx.oprel);
            saida.append(" ");
            ladoEsquerdo = Utils.tiposCompativeis(ladoEsquerdo, visitExp_aritmetica(ctx.outrasexp.get(i)));
        }
        
        return ladoEsquerdo;
    }
    
    @Override
    public Tipos visitOp_relacional(laParser.Op_relacionalContext ctx){
        if(ctx.maior != null)
            saida.append(">");
        else if(ctx.menor != null)
            saida.append("<");
        else if(ctx.maiori != null)
            saida.append(">=");
        else if(ctx.menori != null)
            saida.append("<=");
        else if(ctx.igual != null)
            saida.append("==");
        else
            saida.append("!=");
        
        return null;
                    
    }
    
    @Override
    public Tipos visitExp_aritmetica(laParser.Exp_aritmeticaContext ctx){
        Tipos ladoEsquerdo = visitTermo(ctx.termo1);
        
        for(int i = 0; i < ctx.outrostermos.size(); i++){
            saida.append(" ");
            visitOp1(ctx.op.get(i));
            saida.append(" ");
            Tipos t = visitTermo(ctx.outrostermos.get(i));
            ladoEsquerdo = Utils.tiposCompativeis(ladoEsquerdo, t);
        }
        
        return ladoEsquerdo;
    }
    
    @Override
    public Tipos visitOp1(laParser.Op1Context ctx){
        if(ctx.mais != null)
            saida.append("+");
        else
            saida.append("-");
        return null;
    }
    
    @Override
    public Tipos visitTermo(laParser.TermoContext ctx){
        Tipos ladoEsquerdo = visitFator(ctx.fator1);
        
        for(int i = 0; i < ctx.outrosfatores.size(); i++){
            saida.append(" ");
            visitOp2(ctx.op.get(i));
            saida.append(" ");
            
            Tipos t  = visitFator(ctx.outrosfatores.get(i));
            ladoEsquerdo = Utils.tiposCompativeis(ladoEsquerdo, t);
        }
        
        return ladoEsquerdo;
    }
    
    @Override
    public Tipos visitOp2(laParser.Op2Context ctx){
        if(ctx.vezes != null)
            saida.append("*");
        else
            saida.append("/");
        
        return null;
    }
    
    @Override
    public Tipos visitFator(laParser.FatorContext ctx){
        Tipos ladoEsquerdo = visitParcela(ctx.parcela1);
        
        for(int i = 0; i < ctx.outrasparcelas.size(); i++){
            saida.append(" ");
            visitOp3(ctx.op3);
            saida.append(" ");
            
            Tipos t = visitParcela(ctx.outrasparcelas.get(i));
            ladoEsquerdo = Utils.tiposCompativeis(ladoEsquerdo, t);
        }
        
        return ladoEsquerdo;
    }
    
    @Override
    public Tipos visitOp3(laParser.Op3Context ctx){
        saida.append("%");
        return null;
    }
    
    @Override
    public Tipos visitParcela(laParser.ParcelaContext ctx){
        if(ctx.opuna != null)
            saida.append("(-1) *");
        
        Tipos t;
        
        if(ctx.puna != null)
            t = visitParcela_unario(ctx.puna);
        else
            t = visitParcela_nao_unario(ctx.pnuna);
        
        return t;
    }
    
    @Override
    public Tipos visitParcela_unario(laParser.Parcela_unarioContext ctx){
        Tipos t = null;
        if(ctx.iden != null){
            if(ctx.chapeu != null)
                saida.append("*");
            t = visitIdentificador(ctx.iden);
        }
        else if(ctx.inte != null){
            saida.append(ctx.inte.getText());
            t = Tipos.Inteiro;
        }
        else if(ctx.real != null){
            saida.append(ctx.real.getText());
            t = Tipos.Real;
        }
        else if(ctx.exp_par != null){
            saida.append("(");
            t = visitExpressao(ctx.exp_par);
            saida.append(")");
        }
        else if(ctx.id != null){
            List<TabelaDeSimbolos> escopos = aninhados.percorrerEscoposAninhados();
            for(TabelaDeSimbolos ts: escopos){
                if(ts.verificar(ctx.id.getText()) != null)
                    t = ts.verificar(ctx.id.getText()).tipo;
            }
            
            saida.append(ctx.id.getText());
            saida.append("(");
            visitExpressao(ctx.exp1);
            for(int i = 0; i < ctx.outrasexps.size(); i++){
                saida.append(", ");
                visitExpressao(ctx.outrasexps.get(i));
            }
            saida.append(")");
        }
        
        return t;
    }
    
    @Override
    public Tipos visitCmdAtribuicao(laParser.CmdAtribuicaoContext ctx){
        if(ctx.chap != null)
            saida.append("*");
        
        if(Utils.verificarTipo(aninhados.percorrerEscoposAninhados(), ctx.id) != Tipos.Literal){
            visitIdentificador(ctx.id);
            saida.append(" = ");
            visitExpressao(ctx.exp);
        }
        else{
            saida.append("strcpy(");
            visitIdentificador(ctx.id);
            saida.append(", ");
            visitExpressao(ctx.exp);
            saida.append(")");
        }
        saida.append(";\n");
        
        return null;
    }
    
    @Override
    public Tipos visitCmdSe(laParser.CmdSeContext ctx){
        saida.append("if( ");
        visitExpressao(ctx.exp);
        saida.append(" ){\n");
        for(int i = 0; i < ctx.cmds.size(); i++)
            visitCmd(ctx.cmds.get(i));
        saida.append("}\n");
        if(ctx.els != null){
            saida.append("else{\n");
            for(int i = 0; i < ctx.elsecmd.size(); i++){
                visitCmd(ctx.elsecmd.get(i));
            }
            saida.append("}\n"); 
        }
        
        return null;
    }
    
    @Override
    public Tipos visitCmdCaso(laParser.CmdCasoContext ctx){
        saida.append("switch (");
        visitExp_aritmetica(ctx.exp);
        saida.append(") {\n");
        visitSelecao(ctx.sel);
        if(ctx.els != null){
            saida.append("default:\n");
            for(int i = 0; i < ctx.cmds.size(); i++)
                visitCmd(ctx.cmds.get(i));
        }
        
        saida.append("}\n");
        return null;
    }
    
    @Override
    public Tipos visitItem_selecao(laParser.Item_selecaoContext ctx){
        List<String> intervalos = Utils.intervalos(ctx.cte);
        
        for(int i = 0; i < intervalos.size(); i = i + 2){
            int comeco = Integer.parseInt(intervalos.get(i));
            if(!intervalos.get(i+1).equals("-")){
                int fim = Integer.parseInt(intervalos.get(i+1));
                
                for(int j = comeco; j < fim+1; j++){
                    saida.append("case ");
                    saida.append(j);
                    saida.append(":\n");
                } 
            }
            else{
               saida.append("case ");
               saida.append(comeco);
               saida.append(":\n");
            }
        }
        
        for(int i = 0; i < ctx.cmds.size(); i++)
            visitCmd(ctx.cmds.get(i));
        
        if(ctx.cmds.size() != 0)
            saida.append("break;\n");
        
        return null;
    }
    
    @Override
    public Tipos visitCmdPara(laParser.CmdParaContext ctx){
        saida.append("for(");
        saida.append(ctx.id.getText());
        saida.append(" = ");
        visitExp_aritmetica(ctx.exp1);
        saida.append("; ");
        saida.append(ctx.id.getText());
        saida.append(" <= ");
        visitExp_aritmetica(ctx.exp2);
        saida.append("; ");
        saida.append(ctx.id.getText());
        saida.append("++) {\n");
        for(int i = 0; i < ctx.cmds.size(); i++)
            visitCmd(ctx.cmds.get(i));
        saida.append("}\n");
        
        return null;
    }
    
    @Override
    public Tipos visitCmdEnquanto(laParser.CmdEnquantoContext ctx){
        
        saida.append("while (");
        visitExpressao(ctx.exp);
        saida.append(") {\n");
        for(int i = 0; i < ctx.lcmd.size(); i++)
            visitCmd(ctx.lcmd.get(i));
        
        saida.append("}\n");
        
        return null;
    }
    
    @Override
    public Tipos visitCmdFaca(laParser.CmdFacaContext ctx){
        saida.append("do {\n");
        for(int i = 0; i < ctx.lcmd.size(); i++)
            visitCmd(ctx.lcmd.get(i));
        saida.append("} while(");
        visitExpressao(ctx.exp);
        saida.append(");\n");
        
        return null;
    }
    
    @Override
    public Tipos visitParcela_nao_unario(laParser.Parcela_nao_unarioContext ctx){
        if(ctx.comercial != null)
            saida.append("&");
        
        if(ctx.cad != null){
            saida.append(ctx.cad.getText().substring(0, ctx.cad.getText().length()));
            return Tipos.Literal;
        }
        else
            return visitIdentificador(ctx.id);
    }
    
    @Override
    public Tipos visitValor_constante(laParser.Valor_constanteContext ctx){
        if(ctx.cad != null){
            saida.append(ctx.cad.getText());
            return Tipos.Literal;
        }
        else if(ctx.in != null){
            saida.append(ctx.in.getText());
            return Tipos.Inteiro;
        }
        else if(ctx.re != null){
            saida.append(ctx.re.getText());
            return Tipos.Real;
        }
        else if(ctx.fa != null){
            saida.append("false");
            return Tipos.Logico;
        }
        else{
            saida.append("true");
            return Tipos.Logico;
        }    
    }
    
    @Override
    public Tipos visitRegistro(laParser.RegistroContext ctx){
        saida.append("struct {\n");
        for(int i = 0; i < ctx.vars.size(); i++){
            visitVariavel(ctx.vars.get(i));
            saida.append(";\n");
        }
        saida.append("}");
        
        return Tipos.Struct;
    }
    
    @Override
    public Tipos visitDeclaracao_global(laParser.Declaracao_globalContext ctx){
        func = true;
        saida.append("\n");
        if(ctx.proc != null){
            saida.append("void ");
            saida.append(ctx.id.getText());
            aninhados.obterEscopoAtual().inserir(ctx.id.getText(), Tipos.Procedure);
            saida.append("(");
            aninhados.criarNovoEscopo();
            if(ctx.par != null)
                visitParametros(ctx.par);
            saida.append("){\n");
            for(int i = 0; i < ctx.decl.size(); i++){
                visitDeclaracao_local(ctx.decl.get(i));
                saida.append("\n");
            }
            for(int i = 0; i < ctx.lcmd.size(); i++){
                visitCmd(ctx.lcmd.get(i));
            }
            saida.append("}\n");
            aninhados.abandonarEscopo();
        }
        else{
            Tipos t = visitTipo_estendido(ctx.tip);
            saida.append(" ");
            saida.append(ctx.id.getText());
            aninhados.obterEscopoAtual().inserir(ctx.id.getText(), t);
            saida.append("(");
            aninhados.criarNovoEscopo();
            if(ctx.par != null)
                visitParametros(ctx.par);
            saida.append("){\n");
            for(int i = 0; i < ctx.decl.size(); i++){
                visitDeclaracao_local(ctx.decl.get(i));
                saida.append("\n");
            }
            for(int i = 0; i < ctx.lcmd.size(); i++){
                visitCmd(ctx.lcmd.get(i));
                saida.append(";\n");
            }
            saida.append("}\n");
            aninhados.abandonarEscopo();
        }
        
        func = false;
        return null;
    }
    
    @Override
    public Tipos visitParametro(laParser.ParametroContext ctx){
        Tipos tipo = visitTipo_estendido(ctx.tip);
        saida.append(" ");
        visitIdentificador(ctx.id1);
        aninhados.obterEscopoAtual().inserir(ctx.id1.text.getText(), tipo);
        for(int i = 0; i < ctx.outrosids.size(); i++){
            saida.append(", ");
            visitIdentificador(ctx.outrosids.get(i));
            aninhados.obterEscopoAtual().inserir(ctx.outrosids.get(i).text.getText(), tipo);
        }
        
        return null;
    }
    
    @Override
    public Tipos visitCmdChamada(laParser.CmdChamadaContext ctx){
        saida.append(ctx.id1.getText());
        saida.append("(");
        visitExpressao(ctx.exp1);
        for(int i = 0; i < ctx.outrasexp.size(); i++){
            saida.append(", ");
            visitExpressao(ctx.outrasexp.get(i));
        }
        saida.append(");\n");
        
        for(TabelaDeSimbolos ts : aninhados.percorrerEscoposAninhados())
            if(ts.verificar(ctx.id1.getText()) != null)
                return ts.verificar(ctx.id1.getText()).tipo;
        
        return null;
    }
    
    @Override
    public Tipos visitDimensao(laParser.DimensaoContext ctx){
        for(int i = 0; i < ctx.exps.size(); i++){
            saida.append("[");
            visitExp_aritmetica(ctx.exps.get(i));
            saida.append("]");
        }
        
        return null;
    }
}
