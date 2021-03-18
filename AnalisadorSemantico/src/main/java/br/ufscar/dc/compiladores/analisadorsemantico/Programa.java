package br.ufscar.dc.compiladores.analisadorsemantico;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Programa extends laBaseVisitor<Tipos>{
    
    String help = "";
    
    Escopos aninhados;
    Utils opts = new Utils();
    
    boolean retorneValido = false;
    
    TabelaDeFuncoes tdf = new TabelaDeFuncoes();
    List<Tipos> pars = new LinkedList<>();
    
    List<String> constantes = new ArrayList();

    @Override 
    public Tipos visitPrograma(laParser.ProgramaContext ctx){
        aninhados = new Escopos(); // Inicia o programa criando a variável que armazena os escopos.
        
        aninhados.criarNovoEscopo(); // Cria o escopo global.
        super.visitPrograma(ctx); // Visita as classes filhas.
        aninhados.abandonarEscopo(); // Destrói o escopo global no fim do programa.
        
        return null;
    }
    
    @Override
    public Tipos visitDeclaracao_local(laParser.Declaracao_localContext ctx){
        if(ctx.decl != null){
            if(ctx.vars.tip.reg != null){
                aninhados.criarNovoEscopo();
                visitTipo(ctx.vars.tip);
                TabelaDeSimbolos tsRegistro = aninhados.obterEscopoAtual();
                aninhados.abandonarEscopo();
                TabelaDeSimbolos atual = aninhados.obterEscopoAtual();
                atual.inserir(ctx.vars.ident1.getText(), Tipos.Struct , tsRegistro);
                for(int i = 0; i < ctx.vars.outrosIdents.size(); i++){
                    atual.inserir(ctx.vars.outrosIdents.get(i).getText(), Tipos.Struct, tsRegistro);
                }
            }else
                visitVariavel(ctx.vars);
            return null;
        } else if(ctx.con != null){
            Tipos tipoValor = visitValor_constante(ctx.val);
            Tipos tipoBase = visitTipo_basico(ctx.tbas);
            
            if(tipoValor == tipoBase){
                TabelaDeSimbolos atual = aninhados.obterEscopoAtual();
                String nome = ctx.id.getText();
                if(atual.verificar(nome) == null){
                    atual.inserir(ctx.id.getText(), tipoBase);
                    constantes.add(ctx.id.getText());
                }
                else
                    Utils.adicionarErroSemantico(ctx.id, "identificador " + nome + " ja declarado anteriormente");
            }else
                Utils.adicionarErroSemantico(ctx.id ,"Atribuicao nao compativel para " + ctx.id.getText());
            
        } else if(ctx.tip != null){
            TabelaDeSimbolos atual = aninhados.obterEscopoAtual();
            String nomeStruct = ctx.id.getText();
            if(atual.verificar(nomeStruct) == null)
                if(constantes.indexOf(nomeStruct) >= 0)
                    Utils.adicionarErroSemantico(ctx.id, "identificador " + nomeStruct + " ja declarado anteriormente");
                else{
                    aninhados.criarNovoEscopo(); // Cria um novo escopo.
                    visitTipo(ctx.t); // Adiciona as variáveis ao novo escopo.
                    TabelaDeSimbolos tsRegistro = aninhados.obterEscopoAtual(); // Copia o escopo para inserir na TabelaDeSimbolos.
                    aninhados.abandonarEscopo(); // Abandona o escopo auxiliar.
                    atual.inserir(nomeStruct, Tipos.Struct, tsRegistro); // Insere o struct na TabelaDeSimbolos.
                    //for(TabelaDeSimbolos ts : aninhados.percorrerEscoposAninhados())
                       //ts.imprimir();
                }
            else
                Utils.adicionarErroSemantico(ctx.id, "identificador " + nomeStruct + " ja declarado anteriormente");
        }
        
        return null;
    }
    
    
    @Override
    public Tipos visitVariavel(laParser.VariavelContext ctx){
        TabelaDeSimbolos local = aninhados.obterEscopoAtual();

        Tipos tipo = visitTipo(ctx.tip);
        //System.out.println("t "+tipo);
        
        String nome = ctx.ident1.text.getText();
        
        if(local.verificar(nome) == null)
            if(constantes.indexOf(nome) >= 0)
                Utils.adicionarErroSemantico(ctx.ident1.start, "identificador " + nome + " ja declarado anteriormente");
            else
                if(tipo == Tipos.Struct){
                    List<TabelaDeSimbolos> ts = aninhados.percorrerEscoposAninhados();
                    for(TabelaDeSimbolos t : ts)
                        if(t.verificar(ctx.tip.getText()) != null){
                            TabelaDeSimbolos copia = t.verificar(ctx.tip.getText()).tabelaParaStruct;
                            local.inserir(nome, tipo, copia);
                            //for(TabelaDeSimbolos ts1 : aninhados.percorrerEscoposAninhados())
                                //ts1.imprimir();
                        }
                }   
                else
                    local.inserir(nome,tipo);
                
        else
            Utils.adicionarErroSemantico(ctx.ident1.start, "identificador " + nome + " ja declarado anteriormente");
        
        
        for(int i = 0; i < ctx.outrosIdents.size(); i++){
            nome = ctx.outrosIdents.get(i).text.getText();
            if(local.verificar(nome) == null)
                if(constantes.indexOf(nome) >= 0)
                    Utils.adicionarErroSemantico(ctx.outrosIdents.get(i).start, "identificador " + nome + " ja declarado anteriormente");
                else
                    if(tipo == Tipos.Struct){
                        List<TabelaDeSimbolos> ts = aninhados.percorrerEscoposAninhados();
                        for(TabelaDeSimbolos t : ts)
                            if(t.verificar(ctx.tip.getText()) != null){
                                TabelaDeSimbolos copia = t.verificar(ctx.tip.getText()).tabelaParaStruct;
                                local.inserir(nome, tipo, copia);
                                //for(TabelaDeSimbolos ts1 : aninhados.percorrerEscoposAninhados())
                                    //ts1.imprimir();
                            }
                    } else
                        local.inserir(nome,tipo);
            else
                Utils.adicionarErroSemantico(ctx.outrosIdents.get(i).start, "identificador " + nome + " ja declarado anteriormente");
        }
       
        return null;
    }
    
    @Override
    public Tipos visitTipo(laParser.TipoContext ctx){
        if (ctx.ext != null)
            return visitTipo_estendido(ctx.ext);
        else
            return visitRegistro(ctx.reg);
  
    }
    
    @Override
    public Tipos visitTipo_basico_ident(laParser.Tipo_basico_identContext ctx){
        if(ctx.tbas != null)
            return visitTipo_basico(ctx.tbas);
        else{
            List<TabelaDeSimbolos> tabelas = aninhados.percorrerEscoposAninhados();
            
            for(TabelaDeSimbolos ts : tabelas)
                if(ts.verificar(ctx.id.getText()) != null)
                    return ts.verificar(ctx.id.getText()).tipo;

            Utils.adicionarErroSemantico(ctx.id, "tipo " + ctx.id.getText() + " nao declarado");
            return Tipos.Erro;
        }   
    }
    
    
    @Override
    public Tipos visitTipo_basico(laParser.Tipo_basicoContext ctx){
        if(ctx.log != null)
            return Tipos.Logico;
        if(ctx.r != null)
            return Tipos.Real;
        if(ctx.i != null)
            return Tipos.Inteiro;
        else
            return Tipos.Literal;
    }
   
    @Override
    public Tipos visitCorpo(laParser.CorpoContext ctx){
        aninhados.criarNovoEscopo();
        super.visitCorpo(ctx);
        aninhados.abandonarEscopo();
        
        return null;
    }
    
    @Override
    public Tipos visitValor_constante(laParser.Valor_constanteContext ctx){
        if(ctx.cad != null)
            return Tipos.Literal;
        else if(ctx.in != null)
            return Tipos.Inteiro;
        else if(ctx.fa != null || ctx.tr != null)
            return Tipos.Logico;
        else
            return Tipos.Real;
    }
    
    @Override
    public Tipos visitCmdLeia(laParser.CmdLeiaContext ctx){
        List<TabelaDeSimbolos> escopos = aninhados.percorrerEscoposAninhados();
        
        String nome = ctx.id1.text.getText();
        String campo = "";
        
        if(ctx.id1.ponto != null)
            campo = ctx.id1.text1.get(0).getText();

        boolean achou = false;
        for(TabelaDeSimbolos ts : escopos)
            if(ts.verificar(nome) != null)
                if(ts.verificar(nome).tipo == Tipos.Struct){
                    System.out.println(campo);
                    if(ctx.id1.ponto != null){
                        ts.imprimir();
                        TabelaDeSimbolos aux = ts.verificar(nome).tabelaParaStruct;
                        if (aux.verificar(campo) != null)
                            achou = true;
                    } else
                        achou = true;
                } 
                else
                    achou = true;

        if(!achou)
            Utils.adicionarErroSemantico(ctx.id1.start, "identificador " + ctx.id1.getText() + " nao declarado");
        
        for(int i = 0; i < ctx.outrosids.size(); i++){
            achou = false;
            nome = ctx.outrosids.get(i).text.getText();
            
            if(ctx.outrosids.get(i).ponto != null)
                campo = ctx.outrosids.get(i).text1.get(0).getText();
            else
                campo = "";
            for(TabelaDeSimbolos ts : escopos)
                if(ts.verificar(nome) != null)
                    if(ts.verificar(nome).tipo == Tipos.Struct){
                        if(ctx.outrosids.get(i).ponto != null){
                            TabelaDeSimbolos aux = ts.verificar(nome).tabelaParaStruct;
                            if(aux.verificar(campo) != null)
                                achou = true;
                        } else
                            achou = true;
                    }else
                        achou = true;
            if(!achou)
                Utils.adicionarErroSemantico(ctx.outrosids.get(i).start, "identificador " + ctx.outrosids.get(i).getText() + " nao declarado");
        }
        return null;
    }
    
    @Override
    public Tipos visitCmdEscreva(laParser.CmdEscrevaContext ctx){
        List<TabelaDeSimbolos> escopos = aninhados.percorrerEscoposAninhados();
        Tipos variavel = visitExpressao(ctx.exp1);
        
        boolean achou = false;
        
        if(variavel != Tipos.Erro){
            if(variavel != Tipos.Literal && Utils.isNumeric(ctx.exp1.getText())){
                for(TabelaDeSimbolos ts : escopos)
                    if(ts.verificar(ctx.exp1.getText()) != null)
                        achou = true;
                if(!achou){
                    Utils.adicionarErroSemantico(ctx.exp1.start,"Variavel " + ctx.exp1.getText() + " nao declarada");
                }
            }
        } else
            return null;
        
        for(int i = 0; i < ctx.outrosexp.size(); i++){
            achou = false;
            variavel = visitExpressao(ctx.outrosexp.get(i));
            if(variavel != Tipos.Erro){
                if(variavel != Tipos.Literal && Utils.isNumeric(ctx.exp1.getText())){
                    for(TabelaDeSimbolos ts : escopos)
                        if(ts.verificar(ctx.outrosexp.get(i).getText()) != null)
                            achou = true;
                    if(!achou)
                        Utils.adicionarErroSemantico(ctx.outrosexp.get(i).start,"Variavel " + ctx.outrosexp.get(i).getText() + " nao declarada");
                }
            } else
                return null;
        }
        return null;
    }
    
    @Override
    public Tipos visitExpressao(laParser.ExpressaoContext ctx){
        Tipos tipoLadoEsquerdo = visitTermo_logico(ctx.tl);
        if(tipoLadoEsquerdo == Tipos.Erro)
            return Tipos.Erro;
        
        boolean erro = false;
        
        for(int i = 0; i < ctx.outrostl.size(); i++){
            Tipos termo_logico = visitTermo_logico(ctx.outrostl.get(i));
            if(termo_logico == Tipos.Erro)
                return Tipos.Erro;
            
            if(opts.tiposCompativeis(termo_logico, tipoLadoEsquerdo) == Tipos.Erro){
                //System.out.println("Operacão com tipos diferentes");
                erro = true;
            } else
                tipoLadoEsquerdo = opts.tiposCompativeis(termo_logico, tipoLadoEsquerdo);
        }
        
        if(!erro)
            return tipoLadoEsquerdo;
        else
            return Tipos.Erro;
    }
    
    @Override
    public Tipos visitTermo_logico(laParser.Termo_logicoContext ctx){
        Tipos tipoLadoEsquerdo = visitFator_logico(ctx.f1);
        if(tipoLadoEsquerdo == Tipos.Erro)
            return Tipos.Erro;
        
        boolean erro = false;
        
        for(int i = 0; i < ctx.outrosf.size(); i++){
            Tipos fator_logico = visitFator_logico(ctx.outrosf.get(i));
            if(fator_logico == Tipos.Erro)
                return Tipos.Erro;
            
            if(opts.tiposCompativeis(fator_logico, tipoLadoEsquerdo) == Tipos.Erro){
                //System.out.println("Operacão com tipos diferentes");
                erro = true;
            } else
                tipoLadoEsquerdo = opts.tiposCompativeis(fator_logico, tipoLadoEsquerdo);
        }
        
        if(!erro)
            return tipoLadoEsquerdo;
        else
            return Tipos.Erro;
    }
    
    @Override
    public Tipos visitFator_logico(laParser.Fator_logicoContext ctx){
        if(ctx.not != null)
            return Tipos.Logico;
        else
            return visitParcela_logica(ctx.plogica);
    }
    
    @Override
    public Tipos visitParcela_logica(laParser.Parcela_logicaContext ctx){
        if(ctx.v != null || ctx.f != null)
            return Tipos.Logico;
        else
            return visitExp_relacional(ctx.exp);
    }
    
    @Override
    public Tipos visitExp_relacional(laParser.Exp_relacionalContext ctx){
        Tipos ladoEsquerdo = visitExp_aritmetica(ctx.exp1);
        if(ladoEsquerdo == Tipos.Erro)
            return Tipos.Erro;
        
        boolean erro = false;
        boolean logico = false;
        
        for(int i = 0; i < ctx.outrasexp.size(); i++){
            logico = true;
            Tipos exp_aritmetica = visitExp_aritmetica(ctx.outrasexp.get(i));
            if(exp_aritmetica == Tipos.Erro)
                return Tipos.Erro;
            
            if(opts.tiposCompativeis(ladoEsquerdo, exp_aritmetica) == Tipos.Erro){
                //System.out.println("Operacão com tipos diferentes");
                erro = true;
            } else
                ladoEsquerdo = opts.tiposCompativeis(ladoEsquerdo, exp_aritmetica);
        }
        
        if(!erro)
            if(logico == false)
                return ladoEsquerdo;
            else
                return Tipos.Logico;
        else
            return Tipos.Erro;
        
    }
    
    @Override
    public Tipos visitExp_aritmetica(laParser.Exp_aritmeticaContext ctx){
        Tipos ladoEsquerdo = visitTermo(ctx.termo1);
        if(ladoEsquerdo == Tipos.Erro)
            return Tipos.Erro;
        
        boolean erro = false;
        
        for(int i = 0; i < ctx.outrostermos.size(); i++){
            Tipos termo = visitTermo(ctx.outrostermos.get(i));
            if(termo == Tipos.Erro)
                return Tipos.Erro;
            
            if(opts.tiposCompativeis(termo, ladoEsquerdo) == Tipos.Erro){
                //System.out.println("Operacão com tipos diferentes");
                erro = true;
            }else
                ladoEsquerdo = opts.tiposCompativeis(termo, ladoEsquerdo);
        }
        
        if(!erro)
            return ladoEsquerdo;
        else
            return Tipos.Erro;
    }
    
    @Override
    public Tipos visitTermo(laParser.TermoContext ctx){
        Tipos ladoEsquerdo = visitFator(ctx.fator1);
        if(ladoEsquerdo == Tipos.Erro)
            return Tipos.Erro;
        
        boolean erro = false;
        
        for(int i = 0; i < ctx.outrosfatores.size(); i++){
            Tipos fator = visitFator(ctx.outrosfatores.get(i));
            if(fator == Tipos.Erro)
                return Tipos.Erro;
            
            if(opts.tiposCompativeis(fator, ladoEsquerdo) == Tipos.Erro){
                //System.out.println("Operacão com tipos diferentes");
                erro = true;
            } else
                ladoEsquerdo = opts.tiposCompativeis(fator, ladoEsquerdo);
        }
        
        if(!erro)
            return ladoEsquerdo;
        else
            return Tipos.Erro;
    }
    
    @Override
    public Tipos visitFator(laParser.FatorContext ctx){
        Tipos ladoEsquerdo = visitParcela(ctx.parcela1);
        if(ladoEsquerdo == Tipos.Erro)
            return Tipos.Erro;
        
        boolean erro = false;
        
        for(int i = 0; i < ctx.outrasparcelas.size(); i++){
            Tipos parcela = visitParcela(ctx.outrasparcelas.get(i));
            if(parcela == Tipos.Erro)
                return Tipos.Erro;
            if(opts.tiposCompativeis(parcela, ladoEsquerdo) == Tipos.Erro){
                erro = true;
            } else
                ladoEsquerdo = opts.tiposCompativeis(parcela, ladoEsquerdo);
        }
        
        if(!erro)
            return ladoEsquerdo;
        else
            return Tipos.Erro;
    }
    
    @Override
    public Tipos visitParcela(laParser.ParcelaContext ctx){
        if(ctx.pnuna != null)
            return visitParcela_nao_unario(ctx.pnuna);
        else{
            Tipos tipo = visitParcela_unario(ctx.puna);
            if(ctx.opuna != null){
                if(tipo == Tipos.Logico || tipo == Tipos.Literal){
                    Utils.adicionarErroSemantico(ctx.puna.start, "Erro, operador - nao compatível com tipo " + tipo);
                    return Tipos.Erro;
                }
                else
                    return tipo;
            } else
                return tipo;
        }
    }
    
    @Override
    public Tipos visitParcela_nao_unario(laParser.Parcela_nao_unarioContext ctx){
        if(ctx.comercial != null)
            return Tipos.Inteiro;
        else
            return Tipos.Literal;
    }
    
    @Override
    public Tipos visitParcela_unario(laParser.Parcela_unarioContext ctx){
        if(ctx.inte != null)
            return Tipos.Inteiro;
        else if(ctx.real != null)
            return Tipos.Real;
        else if(ctx.exp_par != null)
            return visitExpressao(ctx.exp_par);
        else if(ctx.iden != null){
            String var = ctx.iden.text.getText();
            List<TabelaDeSimbolos> escopos = aninhados.percorrerEscoposAninhados();
            for(TabelaDeSimbolos ts : escopos)
                if(ts.verificar(var) != null)
                    if(ctx.iden.ponto != null)
                        return ts.verificar(var).tabelaParaStruct.verificar(ctx.iden.text1.get(0).getText()).tipo;
                    else
                        return ts.verificar(var).tipo;
                  
            Utils.adicionarErroSemantico(ctx.start, "identificador " + ctx.iden.getText() + " nao declarado");
            return Tipos.Erro;        
        }else{
            if(tdf.verificar(ctx.id.getText()) == null)
                return Tipos.Erro;
            
            List<Tipos> tipo = tdf.verificar(ctx.id.getText()).parametros;
            List<Tipos> exps = new LinkedList<>();
            
            exps.add(visitExpressao(ctx.exp1));
            for(int i = 0; i < ctx.outrasexps.size(); i++)
                exps.add(visitExpressao(ctx.outrasexps.get(i)));
            
            if(tipo.size() != exps.size()){
                Utils.adicionarErroSemantico(ctx.exp1.start, "incompatibilidade de parametros na chamada de " + ctx.id.getText());
                return Tipos.Erro;
            }else{
                for(int i = 0; i < exps.size(); i++){
                    if(tipo.get(i) != exps.get(i)){
                        if(i == 0)
                            Utils.adicionarErroSemantico(ctx.exp1.start, "incompatibilidade de parametros na chamada de " + ctx.id.getText());
                        else
                            Utils.adicionarErroSemantico(ctx.outrasexps.get(i-1).start, "incompatibilidade de parametros na chamada de " + ctx.id.getText());
                        return Tipos.Erro;
                    }
                }
                if(tdf.verificar(ctx.id.getText()).procOrfunc)
                    return tdf.verificar(ctx.id.getText()).tipo;
            }
        } 
        return Tipos.Erro;
    }
    
    @Override
    public Tipos visitCmdAtribuicao(laParser.CmdAtribuicaoContext ctx){
        Tipos identificador = visitIdentificador(ctx.id);
        
        if(identificador == null){
            Utils.adicionarErroSemantico(ctx.id.start, "identificador " + ctx.id.getText() + " nao declarado");
            return Tipos.Erro;
        }    
            
        Tipos atribuicao = visitExpressao(ctx.exp);
        
        if (identificador == Tipos.Real){
            if(atribuicao != Tipos.Real && atribuicao != Tipos.Inteiro)
                Utils.adicionarErroSemantico(ctx.id.start, "atribuicao nao compativel para " + ctx.id.getText());
        }else if(identificador != atribuicao)
            if(ctx.chap != null)
                Utils.adicionarErroSemantico(ctx.id.start, "atribuicao nao compativel para ^" + ctx.id.getText());
            else
                Utils.adicionarErroSemantico(ctx.id.start, "atribuicao nao compativel para " + ctx.id.getText());
        return null;
    }
    
    @Override
    public Tipos visitIdentificador(laParser.IdentificadorContext ctx){
        List<TabelaDeSimbolos> ts = aninhados.percorrerEscoposAninhados();
    
        for(TabelaDeSimbolos t : ts){
            if(t.verificar(ctx.text.getText()) != null){
                if(t.verificar(ctx.text.getText()).tipo == Tipos.Struct ){
                    if(ctx.ponto != null){
                        TabelaDeSimbolos aux = t.verificar(ctx.text.getText()).tabelaParaStruct;
                        return aux.verificar(ctx.text1.get(0).getText()).tipo;
                    }else
                        return Tipos.Struct;
                } else{
                    return t.verificar(ctx.text.getText()).tipo;
                }
            }
        }
        return null;
    }
    
    @Override
    public Tipos visitDeclaracao_global(laParser.Declaracao_globalContext ctx){
        if(ctx.func != null){
            retorneValido = true;
            Tipos tipo = visitTipo_estendido(ctx.tip);
            TabelaDeSimbolos ts = aninhados.obterEscopoAtual();
            if(constantes.indexOf(ctx.id.getText()) >= 0)
                Utils.adicionarErroSemantico(ctx.id, "identificador " + ctx.id.getText() + " ja declarado anteriormente");
            else
                ts.inserir(ctx.id.getText(), tipo);

            if(ctx.par != null){
                visitParametros(ctx.par);
                List<Tipos> listaRetorno = new LinkedList<Tipos>(pars);
                tdf.inserir(ctx.id.getText(), true, listaRetorno, tipo);
                pars.clear();
            }
            else{
                List<Tipos> listaVazia = new LinkedList<>();
                tdf.inserir(ctx.id.getText(), true, listaVazia, tipo);
            }
            
            aninhados.criarNovoEscopo();
            for(int i = 0; i < ctx.decl.size(); i++)
                visitDeclaracao_local(ctx.decl.get(i));
            
            for(int i = 0; i < ctx.lcmd.size(); i++)
                visitCmd(ctx.lcmd.get(i));
            aninhados.abandonarEscopo();
            retorneValido = false;
            return tipo;
  
        } else{
            retorneValido = false;
            TabelaDeSimbolos ts = aninhados.obterEscopoAtual();
            if(constantes.indexOf(ctx.id.getText()) >= 0)
                Utils.adicionarErroSemantico(ctx.id, "identificador " + ctx.id.getText() + " ja declarado anteriormente");
            else
                ts.inserir(ctx.id.getText(), Tipos.Erro);
            
            if(ctx.par != null){
                visitParametros(ctx.par);
                List<Tipos> listaRetorno = new LinkedList<Tipos>(pars);
                tdf.inserir(ctx.id.getText(), false, listaRetorno, Tipos.Erro);
                pars.clear();
            }
            else{
                List<Tipos> listaVazia = new Stack<Tipos>();
                tdf.inserir(ctx.id.getText(), false, listaVazia, Tipos.Erro);
            }
            aninhados.criarNovoEscopo();
            for(int i = 0; i < ctx.decl.size(); i++)
                visitDeclaracao_local(ctx.decl.get(i));
            
            for(int i = 0; i < ctx.lcmd.size(); i++)
                visitCmd(ctx.lcmd.get(i));
            aninhados.abandonarEscopo();
            return null;
        }
    }
    
    @Override
    public Tipos visitParametros(laParser.ParametrosContext ctx){
        visitParametro(ctx.par1);
        for(int i = 0; i < ctx.outrospar.size(); i++)
            visitParametro(ctx.outrospar.get(i));
        
        return null;
    }
    
    @Override
    public Tipos visitParametro(laParser.ParametroContext ctx){
        int nroParametros = 1 + ctx.outrosids.size();
        
        Tipos tipoParametros = visitTipo_estendido(ctx.tip);
        
        TabelaDeSimbolos ts = aninhados.obterEscopoAtual();
        
        if(tipoParametros == Tipos.Struct){
            String tipoStruct = ctx.tip.getText();
            List<TabelaDeSimbolos> lista = aninhados.percorrerEscoposAninhados();
            TabelaDeSimbolos parametros = null;
            for(TabelaDeSimbolos tabela : lista)
                if(tabela.verificar(tipoStruct) != null)
                    parametros = tabela.verificar(tipoStruct).tabelaParaStruct;
            
            if(parametros != null)
                ts.inserir(ctx.id1.getText(), tipoParametros, parametros);
            else
                ts.inserir(ctx.id1.getText(), tipoParametros);
        } else
            ts.inserir(ctx.id1.getText(), tipoParametros);
        
        for(int i = 0; i < ctx.outrosids.size(); i++)
            ts.inserir(ctx.outrosids.get(i).getText(), tipoParametros);
        
        for(int i = 0; i < nroParametros; i++)
            pars.add(tipoParametros);

        return tipoParametros;
    } 

    @Override 
    public Tipos visitCmdRetorne(laParser.CmdRetorneContext ctx){   
        if(!retorneValido){
            Utils.adicionarErroSemantico(ctx.start, "comando retorne nao permitido nesse escopo");
        }
        return null;
    }
    
    @Override
    public Tipos visitRegistro(laParser.RegistroContext ctx){
        for(int i = 0; i < ctx.vars.size(); i++)
            visitVariavel(ctx.vars.get(i));

        return Tipos.Struct;
    }
}
