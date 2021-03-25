package br.ufscar.dc.compiladores.geradorcodigo;

import br.ufscar.dc.compiladores.analisadorsemantico.laBaseVisitor;
import br.ufscar.dc.compiladores.analisadorsemantico.laParser;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Programa extends laBaseVisitor<Tipos>{
    
    Escopos aninhados; // Classe que contém os escopos da aplicacão.
    List<String> constantes = new ArrayList(); // Lista com funcoes, procedimentos e variáveis constantes (serve para não sobrescrever em escopos locais).
    Utils opts = new Utils(); // Classe com algumas funcões úteis.
    List<Tipos> pars = new LinkedList<>(); // Lista que contém tipos dos argumentos de uma funcão (serve para inserir em uma tabela futuramente).
    boolean retorneValido = false; // Variável que indica se o comando retorno é válido naquele momento.
    TabelaDeFuncoes tdf = new TabelaDeFuncoes(); // Classe com as funcões e procedimentos do programa.
    
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
        if(ctx.decl != null){ // Se for uma declaracão que comece com 'declare'
            if(ctx.vars.tip.reg != null){ // Se houver um registro sendo declarado,
                aninhados.criarNovoEscopo(); // Cria um escopo do registro.
                visitTipo(ctx.vars.tip); // Faz as verificacões das variáveis dos registros e as colocas no escopo.
                TabelaDeSimbolos tsRegistro = aninhados.obterEscopoAtual(); // Faz uma cóia do escopo do registro.
                aninhados.abandonarEscopo(); // Remove o escopo do registro.
                TabelaDeSimbolos atual = aninhados.obterEscopoAtual(); // Obtém o escopo atual.
                atual.inserir(ctx.vars.ident1.getText(), Tipos.Struct , tsRegistro); // E insere o registro no escopo, com as variáveis do registro em tsRegistro.
                for(int i = 0; i < ctx.vars.outrosIdents.size(); i++){ // Repete o mesmo processo para os demais campos.
                    atual.inserir(ctx.vars.outrosIdents.get(i).getText(), Tipos.Struct, tsRegistro);
                }
            }else // Caso nao seja um registro,
                visitVariavel(ctx.vars); // Segue para tratar as variáveis.
            
        } else if(ctx.con != null){ // Caso seja uma declaracão constante.
            Tipos tipoValor = visitValor_constante(ctx.val); // Obtém o valor atribuído.
            Tipos tipoBase = visitTipo_basico(ctx.tbas); // Obtém o tipo da variável sendo declarada.
            
            if(Utils.tiposCompativeis(tipoValor,tipoBase) != Tipos.Erro){ // Se eles forem compatíveis,
                TabelaDeSimbolos atual = aninhados.obterEscopoAtual(); // Obtém o escopo atual.
                String nome = ctx.id.getText(); // Obtém o nome da variável constante.
                if(atual.verificar(nome) == null){ // Verifica se o nome ainda não foi inserido.
                    atual.inserir(ctx.id.getText(), tipoBase); // Insere na tabela de símbolos.
                    constantes.add(ctx.id.getText()); // Insere na lista de constantes.
                }
                else // Caso já tenha sido inserido, emite erro.
                    Utils.adicionarErroSemantico(ctx.id, "identificador " + nome + " ja declarado anteriormente");
            }else // Caso não seja compatível, emite erro.
                Utils.adicionarErroSemantico(ctx.id ,"Atribuicao nao compativel para " + ctx.id.getText());
            
        } else if(ctx.tip != null){ // Caso seja a declaracão de um tipo.
            TabelaDeSimbolos atual = aninhados.obterEscopoAtual(); // Obtém o escopo atual.
            String nomeStruct = ctx.id.getText(); // Obtém o nome do struct sendo declarado como tipo.
            if(atual.verificar(nomeStruct) == null) // Se a variável não tiver sido declarada.
                if(constantes.indexOf(nomeStruct) >= 0) // Se ela não estiver na lista de constantes, emite erro.
                    Utils.adicionarErroSemantico(ctx.id, "identificador " + nomeStruct + " ja declarado anteriormente");
                else{ // Caso não esteja na lista de constantes.
                    aninhados.criarNovoEscopo(); // Cria um novo escopo.
                    visitTipo(ctx.t); // Adiciona as variáveis ao novo escopo.
                    TabelaDeSimbolos tsRegistro = aninhados.obterEscopoAtual(); // Copia o escopo para inserir na TabelaDeSimbolos.
                    aninhados.abandonarEscopo(); // Abandona o escopo auxiliar.
                    atual.inserir(nomeStruct, Tipos.Struct, tsRegistro); // Insere o struct na TabelaDeSimbolos.
                }
            else // Caso a variável tenha sido declarada, emite erro.
                Utils.adicionarErroSemantico(ctx.id, "identificador " + nomeStruct + " ja declarado anteriormente");
        }
        return null;
    }
    
    
    @Override
    public Tipos visitVariavel(laParser.VariavelContext ctx){
        TabelaDeSimbolos local = aninhados.obterEscopoAtual(); // Obtém o escopo atual.
        Tipos tipo = visitTipo(ctx.tip); // Obtém o tipo das variáveis declaradas.
        
        String nome = ctx.ident1.text.getText(); // Identificador da primeira variável.
        
        if(local.verificar(nome) == null) // Se o identificador ainda não foi inserido no escopo atual.
            if(constantes.indexOf(nome) >= 0) // Se estiver na lista de constantes, emite erro.
                Utils.adicionarErroSemantico(ctx.ident1.start, "identificador " + nome + " ja declarado anteriormente");
            else 
                if(tipo == Tipos.Struct){ // Se for uma struct sendo declarada, 
                    List<TabelaDeSimbolos> ts = aninhados.percorrerEscoposAninhados(); // Obtém todos os escopos
                    for(TabelaDeSimbolos t : ts) // E passa por cada um deles.
                        if(t.verificar(ctx.tip.getText()) != null){ // Encontra o tipo do struct que está buscando.
                            TabelaDeSimbolos copia = t.verificar(ctx.tip.getText()).tabelaParaStruct; // Obtém o escopo do tipo do struct
                            local.inserir(nome, tipo, copia); // Insere as variáveis daquele tipo de struct com o escopo do struct declarado.
                        }
                }   
                else // Caso não seja um struct é só inserir as variáveis no escopo.
                    local.inserir(nome,tipo);
                
        else // Se o identificador já tiver sido declarado, emite erro.
            Utils.adicionarErroSemantico(ctx.ident1.start, "identificador " + nome + " ja declarado anteriormente");
        
        // Repete o processo para cada um dos demais identificadores.
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
        if (ctx.ext != null) // Se é um tipo extendido.
            return visitTipo_estendido(ctx.ext);
        else // Se é um registro.
            return visitRegistro(ctx.reg);
  
    }
    
    @Override
    public Tipos visitTipo_basico_ident(laParser.Tipo_basico_identContext ctx){
        if(ctx.tbas != null) // Se for um tipo básico.
            return visitTipo_basico(ctx.tbas);
        else{ // Se for um identificador,
            List<TabelaDeSimbolos> tabelas = aninhados.percorrerEscoposAninhados(); // Obtém todos os escopos.
            
            for(TabelaDeSimbolos ts : tabelas) // Procura em cada escopo,
                if(ts.verificar(ctx.id.getText()) != null) // Se aquele escopo possui aquele identificador.
                    return ts.verificar(ctx.id.getText()).tipo; // Se sim, retorna o tipo.

            // Se não, emite um erro.
            Utils.adicionarErroSemantico(ctx.id, "tipo " + ctx.id.getText() + " nao declarado");
            return Tipos.Erro;
        }   
    }
    
    
    @Override
    public Tipos visitTipo_basico(laParser.Tipo_basicoContext ctx){
        // Retorna os tipos básicos.
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
        aninhados.criarNovoEscopo(); // Cria um escopo para o corpo do programa.
        super.visitCorpo(ctx);
        aninhados.abandonarEscopo();
        
        return null;
    }
    
    @Override
    public Tipos visitValor_constante(laParser.Valor_constanteContext ctx){
        // Retorna o tipo de um valor.
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
        List<TabelaDeSimbolos> escopos = aninhados.percorrerEscoposAninhados(); // Obtém todos os escopos.
        
        String nome = ctx.id1.text.getText(); // Obtém o primeiro identificador (antes do ponto, se houver).
        String campo = ""; // String que vai conter o identificador depois do ponto, se houver.
        
        if(ctx.id1.ponto != null) // Se houver ponto, obtém o identificador.
            campo = ctx.id1.text1.get(0).getText(); 

        boolean achou = false; // Bool que vai dizer se a variável foi achada.
        for(TabelaDeSimbolos ts : escopos) // Para cada escopo,
            if(ts.verificar(nome) != null) // Verifica se aquele identificador está naquele escopo.
                if(ts.verificar(nome).tipo == Tipos.Struct){ // Verifica se o tipo daquele identificador é um struct.
                    if(ctx.id1.ponto != null){ // Se for, e tiver um ponto, 
                        TabelaDeSimbolos aux = ts.verificar(nome).tabelaParaStruct; // Copia o escopo daquele struct.
                        if (aux.verificar(campo) != null) // Verifica se ele tem o campo que foi informado.
                            achou = true; // Se tiver, marca.
                    } else // Se não tiver o ponto, já encontrou.
                        achou = true;
                } 
                else // Se não for um struct, já encontrou.
                    achou = true;

        if(!achou) // Se não achou, emite erro.
            Utils.adicionarErroSemantico(ctx.id1.start, "identificador " + ctx.id1.getText() + " nao declarado");
        
        // Repete o processo para os demais identificadores do comando.
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
        List<TabelaDeSimbolos> escopos = aninhados.percorrerEscoposAninhados(); // Obtém todos os escopos.
        Tipos variavel = visitExpressao(ctx.exp1); // Obtém o tipo da expressão do comando escreva.
        
        boolean achou = false; // Booleano que informa se achou um identificador.
        
        if(variavel != Tipos.Erro){ // Se o tipo da expressão é válido,
            if(variavel != Tipos.Literal && Utils.isNumeric(ctx.exp1.getText())){ // Cadeias e números não são identificadores, então são ignorados.
                for(TabelaDeSimbolos ts : escopos) // Olha em cada escopo.
                    if(ts.verificar(ctx.exp1.getText()) != null) // Se aquele identificador está naquele escopo, marca que foi encontrado.
                        achou = true;
                if(!achou){ // Se não foi encontrado em nenhum escopo, emite erro.
                    Utils.adicionarErroSemantico(ctx.exp1.start,"Variavel " + ctx.exp1.getText() + " nao declarada");
                }
            }
        } else // Se o tipo da expressão é inválida, retorna.
            return null;
        
        // Repete o mesmo com demais expressões do comando.
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
        Tipos tipoLadoEsquerdo = visitTermo_logico(ctx.tl); // Obtém o tipo do lado esquerdo da expressão
        if(tipoLadoEsquerdo == Tipos.Erro) // Se for um erro, retorna.
            return Tipos.Erro;
        
        boolean erro = false; // Boolean que vai dizer se erros foram encontrados.
        
        for(int i = 0; i < ctx.outrostl.size(); i++){ // Para cada termo do lado direito,
            Tipos termo_logico = visitTermo_logico(ctx.outrostl.get(i)); // Obtém o tipo,
            if(termo_logico == Tipos.Erro) // Verifica se tem erro.
                return Tipos.Erro;
            
            if(Utils.tiposCompativeis(termo_logico, tipoLadoEsquerdo) == Tipos.Erro) // Verifica se os tipos de cada lado são compatíveis.
                erro = true;
            else
                tipoLadoEsquerdo = Utils.tiposCompativeis(termo_logico, tipoLadoEsquerdo); // Se não houve erro, obtém se o novo tipo, por exemplo float + int = float.
        }
        
        if(!erro) // Se não houve erro, retorna o tipo resultante.
            return tipoLadoEsquerdo;
        else
            return Tipos.Erro;
    }
    
    @Override
    public Tipos visitTermo_logico(laParser.Termo_logicoContext ctx){
        Tipos tipoLadoEsquerdo = visitFator_logico(ctx.f1); // Obtém o tipo do lado esquerdo da expressão
        if(tipoLadoEsquerdo == Tipos.Erro) // Se for um erro, retorna.
            return Tipos.Erro;
        
        boolean erro = false; // Boolean que vai dizer se erros foram encontrados.
        
        for(int i = 0; i < ctx.outrosf.size(); i++){ // Para cada termo do lado direito,
            Tipos fator_logico = visitFator_logico(ctx.outrosf.get(i)); // Obtém o tipo,
            if(fator_logico == Tipos.Erro)  // Verifica se tem erro.
                return Tipos.Erro;
            
            if(Utils.tiposCompativeis(fator_logico, tipoLadoEsquerdo) == Tipos.Erro) // Verifica se os tipos de cada lado são compatíveis.
                erro = true;
            else
                tipoLadoEsquerdo = Utils.tiposCompativeis(fator_logico, tipoLadoEsquerdo); // Se não houve erro, obtém se o novo tipo, por exemplo float + int = float.
        }
        
        if(!erro) // Se não houve erro, retorna o tipo resultante.
            return tipoLadoEsquerdo;
        else
            return Tipos.Erro;
    }
    
    @Override
    public Tipos visitFator_logico(laParser.Fator_logicoContext ctx){
        if(ctx.not != null) // Se houver um não, o fator é lógico.
            return Tipos.Logico;
        else
            return visitParcela_logica(ctx.plogica);
    }
    
    @Override
    public Tipos visitParcela_logica(laParser.Parcela_logicaContext ctx){
        if(ctx.v != null || ctx.f != null) // Se houver um verdadeiro ou falso, a parcela é lógica.
            return Tipos.Logico;
        else
            return visitExp_relacional(ctx.exp);
    }
    
    @Override
    public Tipos visitExp_relacional(laParser.Exp_relacionalContext ctx){
        Tipos ladoEsquerdo = visitExp_aritmetica(ctx.exp1); // Obtém o tipo do lado esquerdo da expressão
        if(ladoEsquerdo == Tipos.Erro) // Se for um erro, retorna.
            return Tipos.Erro;
        
        boolean erro = false; // Boolean que vai dizer se erros foram encontrados.
        boolean logico = false; // Boolean que vai dizer se o tipo é lógico.
        
        for(int i = 0; i < ctx.outrasexp.size(); i++){ // Para cada termo do lado direito,
            logico = true; // Se existem termos do lado direito, existem operadores lógicos e portanto a exp é lógica.
            Tipos exp_aritmetica = visitExp_aritmetica(ctx.outrasexp.get(i)); // Obtém o tipo,
            if(exp_aritmetica == Tipos.Erro) // Verifica se tem erro.
                return Tipos.Erro;
            
            if(Utils.tiposCompativeis(ladoEsquerdo, exp_aritmetica) == Tipos.Erro) // Verifica se os tipos de cada lado são compatíveis.
                erro = true;
            else
                ladoEsquerdo = Utils.tiposCompativeis(ladoEsquerdo, exp_aritmetica); // Se não houve erro, obtém se o novo tipo, por exemplo float + int = float.
        }
        
        if(!erro) // Se não hoouve erro, retorna o tipo resultante.
            if(logico == false)
                return ladoEsquerdo;
            else
                return Tipos.Logico;
        else
            return Tipos.Erro;
        
    }
    
    @Override
    public Tipos visitExp_aritmetica(laParser.Exp_aritmeticaContext ctx){
        Tipos ladoEsquerdo = visitTermo(ctx.termo1); // Obtém o tipo do lado esquerdo da expressão
        if(ladoEsquerdo == Tipos.Erro) // Se for um erro, retorna.
            return Tipos.Erro;
        
        boolean erro = false; // Boolean que vai dizer se erros foram encontrados.
        
        for(int i = 0; i < ctx.outrostermos.size(); i++){ // Para cada termo do lado direito,
            Tipos termo = visitTermo(ctx.outrostermos.get(i)); // Obtém o tipo,
            if(termo == Tipos.Erro) // Verifica se tem erro.
                return Tipos.Erro;
            
            if(Utils.tiposCompativeis(termo, ladoEsquerdo) == Tipos.Erro) // Verifica se os tipos de cada lado são compatíveis.
                erro = true;
            else
                ladoEsquerdo = Utils.tiposCompativeis(termo, ladoEsquerdo); // Se não houve erro, obtém se o novo tipo, por exemplo float + int = float.
        }
        
        if(!erro) // Se não hoouve erro, retorna o tipo resultante.
            return ladoEsquerdo;
        else
            return Tipos.Erro;
    }
    
    @Override
    public Tipos visitTermo(laParser.TermoContext ctx){
        Tipos ladoEsquerdo = visitFator(ctx.fator1); // Obtém o tipo do lado esquerdo da expressão
        if(ladoEsquerdo == Tipos.Erro) // Se for um erro, retorna.
            return Tipos.Erro;
        
        boolean erro = false; // Boolean que vai dizer se erros foram encontrados.
        
        for(int i = 0; i < ctx.outrosfatores.size(); i++){ // Para cada termo do lado direito,
            Tipos fator = visitFator(ctx.outrosfatores.get(i)); // Obtém o tipo,
            if(fator == Tipos.Erro) // Verifica se tem erro.
                return Tipos.Erro;
            
            if(Utils.tiposCompativeis(fator, ladoEsquerdo) == Tipos.Erro) // Verifica se os tipos de cada lado são compatíveis.
                erro = true;
            else
                ladoEsquerdo = Utils.tiposCompativeis(fator, ladoEsquerdo); // Se não houve erro, obtém se o novo tipo, por exemplo float + int = float.
        }
        
        if(!erro) // Se não hoouve erro, retorna o tipo resultante.
            return ladoEsquerdo;
        else
            return Tipos.Erro;
    }
    
    @Override
    public Tipos visitFator(laParser.FatorContext ctx){
        Tipos ladoEsquerdo = visitParcela(ctx.parcela1);  // Obtém o tipo do lado esquerdo da expressão
        if(ladoEsquerdo == Tipos.Erro) // Se for um erro, retorna.
            return Tipos.Erro;
        
        boolean erro = false;// Boolean que vai dizer se erros foram encontrados.
        
        for(int i = 0; i < ctx.outrasparcelas.size(); i++){ // Para cada termo do lado direito,
            Tipos parcela = visitParcela(ctx.outrasparcelas.get(i)); // Obtém o tipo,
            if(parcela == Tipos.Erro) // Verifica se tem erro.
                return Tipos.Erro;
            if(Utils.tiposCompativeis(parcela, ladoEsquerdo) == Tipos.Erro){ // Verifica se os tipos de cada lado são compatíveis.
                erro = true;
            } else
                ladoEsquerdo = Utils.tiposCompativeis(parcela, ladoEsquerdo); // Se não houve erro, obtém se o novo tipo, por exemplo float + int = float.
        }
        
        if(!erro) // Se não hoouve erro, retorna o tipo resultante.
            return ladoEsquerdo;
        else
            return Tipos.Erro;
    }
    
    @Override
    public Tipos visitParcela(laParser.ParcelaContext ctx){
        if(ctx.pnuna != null) // Se for uma parcela não unária
            return visitParcela_nao_unario(ctx.pnuna); 
        else{ // Se for uma parcela unária
            Tipos tipo = visitParcela_unario(ctx.puna);
            if(ctx.opuna != null){ // Se tiver um operador unário
                if(tipo == Tipos.Logico || tipo == Tipos.Literal){ // E não for inteiro ou real, reporta o erro.
                    Utils.adicionarErroSemantico(ctx.puna.start, "Erro, operador - nao compatível com tipo " + tipo);
                    return Tipos.Erro;
                }
                else // Se for, retorna o tipo.
                    return tipo;
            } else // Se não tiver o operador, retorna o tipo.
                return tipo;
        }
    }
    
    @Override
    public Tipos visitParcela_nao_unario(laParser.Parcela_nao_unarioContext ctx){
        if(ctx.comercial != null) // Se houver um &, o tipo é inteiro pois é ponteiro.
            return Tipos.Inteiro;
        else // Se não, é uma cadeia.
            return Tipos.Literal;
    }
    
    @Override
    public Tipos visitParcela_unario(laParser.Parcela_unarioContext ctx){
        if(ctx.inte != null) // Se for um inteiro.
            return Tipos.Inteiro;
        else if(ctx.real != null) // Se for um número real.
            return Tipos.Real;
        else if(ctx.exp_par != null) // Se houevr uma expressão entre parênteses.
            return visitExpressao(ctx.exp_par);
        else if(ctx.iden != null){ // Se houver um identificador.
            String var = ctx.iden.text.getText(); // Obtém o nome do identificador.
            List<TabelaDeSimbolos> escopos = aninhados.percorrerEscoposAninhados(); // Obtém todos os escopos.
            for(TabelaDeSimbolos ts : escopos) // Para cada escopo.
                if(ts.verificar(var) != null) // Se encontrou aquele identificador nesse escopo.
                    if(ctx.iden.ponto != null) // Verifica se é um campo de struct.
                        return ts.verificar(var).tabelaParaStruct.verificar(ctx.iden.text1.get(0).getText()).tipo; // Se for, busca o tipo do campo no struct correspondente.
                    else // Caso não seja um campo, retorna o tipo.
                        return ts.verificar(var).tipo;
                  
            Utils.adicionarErroSemantico(ctx.start, "identificador " + ctx.iden.getText() + " nao declarado"); // Se não achar, reporta o erro.
            return Tipos.Erro;        
        }else{ // Se for uma funcão ou procedimento.
            if(tdf.verificar(ctx.id.getText()) == null) // Verifica se já foi declarada.
                return Tipos.Erro;
            
            List<Tipos> tipo = tdf.verificar(ctx.id.getText()).parametros; // Obtém os tipos dos parâmetros da funcão.
            List<Tipos> exps = new LinkedList<>(); // Lista para armazenar os tipos dos parâmetros usados na chamada da funcão.
            
            if(ctx.exp1 != null)
                exps.add(visitExpressao(ctx.exp1)); // Adiciona o tipo do primeiro argumento.
            for(int i = 0; i < ctx.outrasexps.size(); i++) // Para cada um dos demais argumentos adiciona na lista.
                exps.add(visitExpressao(ctx.outrasexps.get(i)));
            
            if(tipo.size() != exps.size()){ // Se não tiverem o mesmo número de parâmetros, reporta erro.
                Utils.adicionarErroSemantico(ctx.exp1.start, "incompatibilidade de parametros na chamada de " + ctx.id.getText());
                return Tipos.Erro;
            }else{ // Se tiverem o mesmo número de parâmetros,
                for(int i = 0; i < exps.size(); i++){ // Para cada um dos parâmetros, 
                    if(tipo.get(i) != exps.get(i)){ // Compara o tipo dos parâmetros.
                        if(i == 0) // Retorna o erro.
                            Utils.adicionarErroSemantico(ctx.exp1.start, "incompatibilidade de parametros na chamada de " + ctx.id.getText());
                        else
                            Utils.adicionarErroSemantico(ctx.outrasexps.get(i-1).start, "incompatibilidade de parametros na chamada de " + ctx.id.getText());
                        return Tipos.Erro;
                    }
                }
                if(tdf.verificar(ctx.id.getText()).procOrfunc) // Caso seja funcão, retorna o tipo da funcão.
                    return tdf.verificar(ctx.id.getText()).tipo;
            }
        } 
        return Tipos.Erro;
    }
    
    @Override
    public Tipos visitCmdAtribuicao(laParser.CmdAtribuicaoContext ctx){
        Tipos identificador = visitIdentificador(ctx.id); // Obtém o tipo do identificador.
        
        if(identificador == null){ // Se o identificador não foi declarado reporta o erro.
            Utils.adicionarErroSemantico(ctx.id.start, "identificador " + ctx.id.getText() + " nao declarado");
            return Tipos.Erro;
        }    
            
        Tipos atribuicao = visitExpressao(ctx.exp); // Obtém o tipo da expressão sendo atribuída.
        
        if (identificador == Tipos.Real){ // Se identificador for real
            if(atribuicao != Tipos.Real && atribuicao != Tipos.Inteiro) // Ele só pode receber real ou inteiro, caso contrário, reporta erro.
                Utils.adicionarErroSemantico(ctx.id.start, "atribuicao nao compativel para " + ctx.id.getText());
        }else if(identificador != atribuicao) // Os demais tem tipos devem ser iguais.
            if(ctx.chap != null) // Se há um ^, reporta.
                Utils.adicionarErroSemantico(ctx.id.start, "atribuicao nao compativel para ^" + ctx.id.getText());
            else
                Utils.adicionarErroSemantico(ctx.id.start, "atribuicao nao compativel para " + ctx.id.getText());
        return null;
    }
    
    @Override
    public Tipos visitIdentificador(laParser.IdentificadorContext ctx){
        List<TabelaDeSimbolos> ts = aninhados.percorrerEscoposAninhados(); // Obtém todos os escopos.
    
        for(TabelaDeSimbolos t : ts){ // Para cada escopo,
            if(t.verificar(ctx.text.getText()) != null){ // Verifica se o identificador foi declarado naquele escopo
                if(t.verificar(ctx.text.getText()).tipo == Tipos.Struct ){ // Verifica se ele é um struct.
                    if(ctx.ponto != null){ // Se ele tiver um campo sendo referenciado,
                        TabelaDeSimbolos aux = t.verificar(ctx.text.getText()).tabelaParaStruct; // Obtém o escopo do registro.
                        return aux.verificar(ctx.text1.get(0).getText()).tipo; // Retorna o tipo do campo do registro.
                    }else // Caso não tenha campos, é um struct.
                        return Tipos.Struct;
                } else{ // Caso não seja um struct, retorna o tipo.
                    return t.verificar(ctx.text.getText()).tipo;
                }
            }
        }
        return null;
    }
    
    @Override
    public Tipos visitDeclaracao_global(laParser.Declaracao_globalContext ctx){
        if(ctx.func != null){ // Se for uma declaracão de funcão.
            retorneValido = true; // É possível ter um retorno.
            Tipos tipo = visitTipo_estendido(ctx.tip); // Obtém o tipo da funcão.
            TabelaDeSimbolos ts = aninhados.obterEscopoAtual(); // Obtém o escopo atual.
            if(constantes.indexOf(ctx.id.getText()) >= 0) // Se aquele identificador já tiver sido declarado, reporta erro.
                Utils.adicionarErroSemantico(ctx.id, "identificador " + ctx.id.getText() + " ja declarado anteriormente");
            else{ // Caso não tenha sido declarado,
                ts.inserir(ctx.id.getText(), tipo); // Insere a funcão na tabela de símbolos, 
                constantes.add(ctx.id.getText()); // E na lista de identificadores constantes.
            } 

            if(ctx.par != null){ // Se houverem parâmetros.
                visitParametros(ctx.par); // Visita os parâmetros.
                List<Tipos> listaRetorno = new LinkedList<Tipos>(pars); // Obtém os parâmetros gerados pela vista através da variável pars.
                tdf.inserir(ctx.id.getText(), true, listaRetorno, tipo); // Insere na lista de funcões o nome, tipo (true = func), a lista dos parametros e o tipo da funcão.
                pars.clear(); // Limpa a lista de argumentos global.
            }
            else{ // Se não tiverem parâmetros, insere com uma lista vazia.
                List<Tipos> listaVazia = new LinkedList<>();
                tdf.inserir(ctx.id.getText(), true, listaVazia, tipo);
            }
            
            aninhados.criarNovoEscopo(); // Cria um novo escopo para a funcão,
            for(int i = 0; i < ctx.decl.size(); i++) // E visita cada uma das declaracões de identificadores da funcão.
                visitDeclaracao_local(ctx.decl.get(i));
            
            for(int i = 0; i < ctx.lcmd.size(); i++) // Visita cada um dos comandos também.
                visitCmd(ctx.lcmd.get(i));
            aninhados.abandonarEscopo(); // Abandona o escopo da funcão.
            retorneValido = false; // Retorno volta a ser inválido.
            return tipo; // Retorna o tipo da funcão.
  
        } else{
            retorneValido = false; // Retorno inválido pois é procedimento.
            TabelaDeSimbolos ts = aninhados.obterEscopoAtual(); // Obtém o escopo atual.
            if(constantes.indexOf(ctx.id.getText()) >= 0) 
                Utils.adicionarErroSemantico(ctx.id, "identificador " + ctx.id.getText() + " ja declarado anteriormente"); // Se aquele identificador já tiver sido declarado, reporta erro.
            else { // Caso não tenha sido declarado,
                ts.inserir(ctx.id.getText(), Tipos.Procedure); // Insere o procedimento na tabela de símbolos,
                constantes.add(ctx.id.getText()); // E na lista de identificadores constantes.
            }
            
            if(ctx.par != null){ // Se houverem parâmetros.
                visitParametros(ctx.par); // Visita os parâmetros.
                List<Tipos> listaRetorno = new LinkedList<Tipos>(pars);  // Obtém os parâmetros gerados pela vista através da variável pars.
                tdf.inserir(ctx.id.getText(), false, listaRetorno, Tipos.Procedure); // Insere na lista de funcões o nome, tipo (false = procc), a lista dos parametros e o tipo procedure.
                pars.clear();
            }
            else{ // Se não tiverem parâmetros, insere com uma lista vazia.
                List<Tipos> listaVazia = new Stack<Tipos>();
                tdf.inserir(ctx.id.getText(), false, listaVazia, Tipos.Procedure);
            }
            aninhados.criarNovoEscopo();  // Cria um novo escopo para o procedmento,
            for(int i = 0; i < ctx.decl.size(); i++) // E visita cada uma das declaracões de identificadores do procedimento.
                visitDeclaracao_local(ctx.decl.get(i));
            
            for(int i = 0; i < ctx.lcmd.size(); i++) // Visita cada um dos comandos também.
                visitCmd(ctx.lcmd.get(i));
            aninhados.abandonarEscopo(); // Abandona o escopo do procedimento.
            return Tipos.Procedure; // Retorna que é um procedimento.
        }
    }

    @Override
    public Tipos visitParametro(laParser.ParametroContext ctx){
        int nroParametros = 1 + ctx.outrosids.size(); // Calcula o número de parâmtros de um mesmo tipo.
        
        Tipos tipoParametros = visitTipo_estendido(ctx.tip); // Obtém o tipo dos parâmetros.
        
        TabelaDeSimbolos ts = aninhados.obterEscopoAtual(); // Obtém o escopo atual.
        
        if(tipoParametros == Tipos.Struct){ // Se for um struct, 
            String tipoStruct = ctx.tip.getText(); // Obtém o tipo de Struct desejado.
            List<TabelaDeSimbolos> lista = aninhados.percorrerEscoposAninhados(); // Obtém todos os escopos.
            TabelaDeSimbolos parametros = null; // 
            for(TabelaDeSimbolos tabela : lista) // Para cada escopo,
                if(tabela.verificar(tipoStruct) != null) // Verifica se o tipo de struct está lá.
                    parametros = tabela.verificar(tipoStruct).tabelaParaStruct; // Copia os campos do struct declarado.
            
            if(parametros != null) // Se eles não forem nulos, insere com os parâmetros.
                ts.inserir(ctx.id1.getText(), tipoParametros, parametros);
            else // Insere sem a tabela de símbolos.
                ts.inserir(ctx.id1.getText(), tipoParametros);
        } else // Caso não seja um struct, insere normalmente no escopo atual.
            ts.inserir(ctx.id1.getText(), tipoParametros);
        
        // Repete para cada um dos outros identificadores
        for(int i = 0; i < ctx.outrosids.size(); i++)
            ts.inserir(ctx.outrosids.get(i).getText(), tipoParametros);
        
        for(int i = 0; i < nroParametros; i++) // Adiciona os tipos dos parâmetros para cada um dos parâmetros.
            pars.add(tipoParametros);

        return tipoParametros; // Retorna o tipo dos parâmetros.
    } 

    @Override 
    public Tipos visitCmdRetorne(laParser.CmdRetorneContext ctx){   
        if(!retorneValido){ // Se o retorno é inválido, reporta o erro.
            Utils.adicionarErroSemantico(ctx.start, "comando retorne nao permitido nesse escopo");
        }
        return null;
    }
    
    @Override
    public Tipos visitRegistro(laParser.RegistroContext ctx){
        for(int i = 0; i < ctx.vars.size(); i++) // Visita cada uma das variáveis do struct.
            visitVariavel(ctx.vars.get(i));

        return Tipos.Struct; // Retorna que é um struct.
    }
}
