package br.ufscar.dc.compiladores.geradorcodigo;

import br.ufscar.dc.compiladores.analisadorsemantico.laBaseVisitor;
import br.ufscar.dc.compiladores.analisadorsemantico.laParser;
import java.util.List;

public class geradorC extends laBaseVisitor<Tipos>{
    
    Escopos aninhados = new Escopos(); // Escopos do programa.
    boolean func = false; // Variável que indica se está tratando uma funcão ou não.
    TabelaDeFuncoes funcs; // Tabela com as funcões.
    StringBuilder saida; // Onde será escrito o programa em C.
    
    public geradorC(){
        saida = new StringBuilder(); // Inicia o StringBuilder.
        this.funcs = new TabelaDeFuncoes(); // Inicia a tabela de funcões.
    }
    
    @Override
    public Tipos visitPrograma(laParser.ProgramaContext ctx){
        aninhados.criarNovoEscopo(); // Cria escopo das variáveis globais.
        saida.append("#include <stdio.h>\n"); // Escreve as bibliotecas básicas.
        saida.append("#include <stdlib.h>\n");
        
        visitDeclaracoes(ctx.decls); // Escreve declaracões globais.
        
        saida.append("\n");
        saida.append("int main(){\n"); // Inicia a funcão main.
        
        aninhados.criarNovoEscopo(); // Cria o escopo da funcão main.
        visitCorpo(ctx.c); // Visita o conteúdo do main.
        aninhados.abandonarEscopo(); // Encerra o escopo da funcão main.
        
        saida.append("return 0;\n}\n"); // Encerra a funcão.
        aninhados.abandonarEscopo(); // Encerra o escopo global.
        return null;    
    }
    
    @Override
    public Tipos visitDeclaracao_local(laParser.Declaracao_localContext ctx){
        if(ctx.decl != null){ // Se for um declare.
            if(ctx.vars.tip.reg != null) // Verifica se é a declaracão de um registro.
                aninhados.criarNovoEscopo(); // Se for, cria o escopo do registro.
            visitVariavel(ctx.vars); // Visita as declaracões de variáveis.
            if(ctx.vars.tip.reg != null){ // Se for declaracão de um registro,
                TabelaDeSimbolos ts = aninhados.obterEscopoAtual(); // Obtém os escopo do registro.
                aninhados.abandonarEscopo(); // Descarta da pilha de escopos atual.
                aninhados.obterEscopoAtual().inserir(ctx.vars.ident1.getText(), Tipos.Struct, ts); // E insere o escopo na variável que é do tipo struct.
                for(int i = 0; i < ctx.vars.outrosIdents.size(); i++) // Para cada um dos outros identificadores, 
                    aninhados.obterEscopoAtual().inserir(ctx.vars.outrosIdents.get(i).getText(), Tipos.Struct, ts); // Também insere o escopo.
            }
            saida.append(";\n"); // Encerra declaracão.
        }
        else if (ctx.con != null){ // Se for uma variável constante.
            saida.append("const "); // Declara como constante.
            Tipos aux = visitTipo_basico(ctx.tbas); // Escreve o tipo dela.
            if(aux == Tipos.Literal){ // Se for uma variável do tipo string,
                saida.append("[80]"); // Coloca um tamanho de 80 caracteres pra ela.
            }
            saida.append(" "); 
            saida.append(ctx.id.getText()); // Imprime o identificador da variável.
            saida.append(" = "); // Atribuicão.
            visitValor_constante(ctx.val); // O valor atribuído.
            saida.append(";\n"); // Encerra o comando.
        } else { // Declarando tipo de struct.
            saida.append("typedef ");
            aninhados.criarNovoEscopo(); // Cria o escopo do struct.
            visitTipo(ctx.t); // Escreve as variáveis do struct.
            TabelaDeSimbolos ts = aninhados.obterEscopoAtual(); // Obtém o escopo do struct.
            aninhados.abandonarEscopo(); // Descarta o escopo do struct.
            saida.append(ctx.id.getText()); // Escreve o nome do tipo de struct.
            aninhados.obterEscopoAtual().inserir(ctx.id.getText(), Tipos.Struct, ts); // Adiciona o tipo nos escopos, junto com o escopo do struct.
            saida.append(";\n"); // Encerra declaracão.
        }
        
        return null;
    }
    
    @Override
    public Tipos visitVariavel(laParser.VariavelContext ctx){
        Tipos variavel = visitTipo(ctx.tip); // Escreve o tipo das variáveis.
        saida.append(" ");
        
        TabelaDeSimbolos struct = null; // Cria uma tabela para o escopo de um struct.
        
        for(TabelaDeSimbolos ts : aninhados.percorrerEscoposAninhados()) // Para cada escopo,
                if(ts.verificar(ctx.tip.getText()) != null) // Verifica se o tipo está nos escopos, caso esteja, é um tipo de struct.
                    struct = ts.verificar(ctx.tip.getText()).tabelaParaStruct; // Copia o escopo do tipo pra essa variável.

        aninhados.obterEscopoAtual().inserir(ctx.ident1.text.getText(), variavel, struct); // Insere a variável no escopo atual.
        
        visitIdentificador(ctx.ident1); // Escreve a primeira variável.

        if(variavel == Tipos.Literal) // Se for uma variável string, adiciona um tamanho de 80 para ela.
            saida.append("[80]");

        // Refaz esse processo para as demais variáveis.
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
        Tipos t = visitTipo_basico_ident(ctx.t); // Escreve o tipo/
        if(ctx.chapeu != null) // Se for um ponteiro, adiciona o *.
            saida.append(" *");
        
        if(func){ // Se for uma funcão e for uma string adiciona o símbolo de ponteiro.
            if(Utils.verificarTipo(aninhados.percorrerEscoposAninhados(), ctx.t) == Tipos.Literal)
                saida.append(" *");
        }
        
        return t; // Retorna o tipo da variável.
    }
    
    @Override
    public Tipos visitTipo_basico_ident(laParser.Tipo_basico_identContext ctx){
        if(ctx.id != null){ // Se for um identificador.
            saida.append(ctx.id.getText()); // Escreve o identificador.
            for(TabelaDeSimbolos ts : aninhados.percorrerEscoposAninhados()){ // Percorre em cada escopo.
                if(ts.verificar(ctx.id.getText()) != null) // Se encontrar o identificador,
                    return ts.verificar(ctx.id.getText()).tipo; // Retorna o tipo dele.
            }
        }
        else
            return visitTipo_basico(ctx.tbas); // Escreve o tipo dele.
       
        return null;
    }
    
    @Override
    public Tipos visitTipo_basico(laParser.Tipo_basicoContext ctx){
        // Escreve e retorna o tipo de acordo.
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
        saida.append(ctx.text.getText()); // Escreve o identificador.
            
        for(int i = 0; i < ctx.text1.size(); i++){ // Para cada campo que ele tiver, escreve.
            saida.append(".");
            saida.append(ctx.text1.get(i).getText());
        }
        visitDimensao(ctx.d); // Escreve a dimensao dele.
        
        for(TabelaDeSimbolos ts : aninhados.percorrerEscoposAninhados()){ // Procura em cada escopo.
            if(ts.verificar(ctx.text.getText()) != null) // Se achar a variável.
                if(!ctx.text1.isEmpty()) // Se ela tiver campo, retorna o tipo do campo.
                    return ts.verificar(ctx.text.getText()).tabelaParaStruct.verificar(ctx.text1.get(0).getText()).tipo;
                else // Caso contrário, retorna o tipo dela.
                    return ts.verificar(ctx.text.getText()).tipo;
        }
        
        return null;
    } 
    
    @Override
    public Tipos visitCmdLeia(laParser.CmdLeiaContext ctx){
        Tipos leia = null;
        String nomesVariaveis = ""; // Todos os nomes das variáveis.
        
        for(TabelaDeSimbolos ts: aninhados.percorrerEscoposAninhados()) // Para cada escopo,
            if(ts.verificar(ctx.id1.text.getText()) != null){ // Encontra o identificador.
                leia = ts.verificar(ctx.id1.text.getText()).tipo; // Guarda o tipo do identificador.
                if(leia == Tipos.Struct){ // Se for uma struct, desobre o tipo do campo.
                    TabelaDeSimbolos struct = ts.verificar(ctx.id1.text.getText()).tabelaParaStruct;
                    leia = struct.verificar(ctx.id1.text1.get(0).getText()).tipo;
                }
            }
        
        if(leia == Tipos.Literal){ // Se a variável for uma string, tem que ser lido com o comando gets.
            saida.append("gets("); 
            saida.append(ctx.id1.text.getText()); // Escreve o identificador.
            if(ctx.id1.ponto != null){ // Escreve campos se houverem.
                saida.append(".");
                saida.append(ctx.outrosids.get(0).getText());
            }
            saida.append(");\n");
            return null;
        }
        
        saida.append("scanf(\"%"); // Caso não seja string, é lido com scanf.
        
        for(TabelaDeSimbolos ts: aninhados.percorrerEscoposAninhados()) // Procura em cada escopo.
            if(ts.verificar(ctx.id1.text.getText()) != null){ // Quando achar,
                leia = ts.verificar(ctx.id1.text.getText()).tipo; // Guarda o tipo da variável.
                if(leia != Tipos.Struct){ // Se não for um struct,
                    saida.append(Utils.letraTipo(leia)); // Escreve a letra que representa o tipo.
                    nomesVariaveis = nomesVariaveis + "&" + ctx.id1.text.getText() + " ,"; // Guarda na lista de variáveis o nome da variável atual.
                }
                else{ // Caso seja um strut, procura e escreve o tipo do campo.
                    TabelaDeSimbolos struct = ts.verificar(ctx.id1.text.getText()).tabelaParaStruct;
                    saida.append(Utils.letraTipo(struct.verificar(ctx.id1.text1.get(0).getText()).tipo));
                    nomesVariaveis = nomesVariaveis + "&" + ctx.id1.text1.get(0).getText() + " ,";
                }
                
            }
        // Faz o mesmo processo para os demais campos.
        for(int i = 0; i < ctx.outrosids.size(); i++){
            for(TabelaDeSimbolos ts : aninhados.percorrerEscoposAninhados())
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
        saida.append(nomesVariaveis.substring(0,nomesVariaveis.length() -2)); // Remove o espaco e a vírgula a mais do último campo.
        saida.append(");\n");

        return null;
    }
    
    @Override
    public Tipos visitCmdEscreva(laParser.CmdEscrevaContext ctx){
        boolean algumIdentificador = false;
        
        int inicio = 0; // Variável que vai indicar onde comeca a string a ser escrita.
        int fim = 0; // Variável que vai indicar onde termina a string a ser escrita.
        
        saida.append("printf(\""); // Escreve a funcão printf.
        if(Utils.cadeia(ctx.exp1)){ // Verifica se é uma cadeia.
            if(ctx.exp1.getText().charAt(0) == '\"') // Se o primeiro caracter for aspas,
                inicio = 1; // Marca para comecar depois das aspas.
            
            if(ctx.exp1.getText().charAt(ctx.exp1.getText().length() - 1) == '\"') // Se o último caracter for aspas,
                fim = ctx.exp1.getText().length() - 1; // Marca para terminar depois das aspas.
            else // Se não, termina no último caracter mesmo.
                fim = ctx.exp1.getText().length();
            
            saida.append(ctx.exp1.getText().substring(inicio, fim)); // Escreve a cadeia.
        }
        else{ // Se não for uma cadeia.
            List<TabelaDeSimbolos> escopos = aninhados.percorrerEscoposAninhados();
            saida.append("%"); // Escreve o porcento.
            saida.append(Utils.letraTipo(Utils.verificarTipo(escopos, ctx.exp1))); // Escreve a letra que representa o identificador.
            algumIdentificador = true; // Marca que existem identificadores sendo escritos.
        }
        
        // Repete o proesso para as demais expressões.
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
        
        saida.append("\""); // Fecha a cadeia sendo escrita.
        if(algumIdentificador){
            
            if(!Utils.cadeia(ctx.exp1)){ // Se não for uma cadeia, 
                saida.append(", ");
                visitExpressao(ctx.exp1); // Escreve a expressão.
            }
            
            // Repete par as demais expressões.
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
        Tipos ladoEsquerdo = visitTermo_logico(ctx.tl); // Escreve o termo lógico.
        
        for(int i = 0; i < ctx.outrostl.size(); i++){ 
            saida.append(" ");
            visitOp_logico_1(ctx.op.get(i)); // Escreve o sinal da operacão.
            saida.append(" ");
            Tipos termo_logico = visitTermo_logico(ctx.outrostl.get(i));  // Escreve o termo lógico.
            ladoEsquerdo = Utils.tiposCompativeis(termo_logico, ladoEsquerdo);
        }
        
        return ladoEsquerdo;
    }
    
    @Override
    public Tipos visitOp_logico_1(laParser.Op_logico_1Context ctx){
        saida.append("||"); // Escreve o sinal do operador ou.
        return null;
    }

    @Override
    public Tipos visitTermo_logico(laParser.Termo_logicoContext ctx){
        Tipos ladoEsquerdo = visitFator_logico(ctx.f1);  // Escreve o fator lógico.
        
        for(int i = 0; i < ctx.outrosf.size(); i++){
            saida.append(" ");
            visitOp_logico_2(ctx.op.get(i)); // Escreve o sinal da operacão.
            saida.append(" ");
            Tipos fator_logico = visitFator_logico(ctx.outrosf.get(i)); // Escreve o fator lógico.
            ladoEsquerdo = Utils.tiposCompativeis(fator_logico, ladoEsquerdo);
        }
        
        return ladoEsquerdo;
    }
    
    @Override
    public Tipos visitOp_logico_2(laParser.Op_logico_2Context ctx){
        saida.append("&&"); // Escreve o operador e.
        return null;
    }

    @Override
    public Tipos visitFator_logico(laParser.Fator_logicoContext ctx){
        if(ctx.not != null)
            saida.append("!"); // Escreve o sinal de not.
        
        
        Tipos resultado = visitParcela_logica(ctx.plogica); // Escreve a parcela lógica.
        
        if(ctx.not != null)
            return Tipos.Logico;
        else
            return resultado;
    }
    
    @Override
    public Tipos visitParcela_logica(laParser.Parcela_logicaContext ctx){
        if(ctx.v != null){
            saida.append("true"); // Escreve verdadeiro.
            return Tipos.Logico;
        }
        else if(ctx.f != null){
            saida.append("false"); // Escreve falso.
            return Tipos.Logico;
        }
        else
            return visitExp_relacional(ctx.exp); // Escreve as expressões relacionais.
    }
    
    @Override
    public Tipos visitExp_relacional(laParser.Exp_relacionalContext ctx){
        Tipos ladoEsquerdo = visitExp_aritmetica(ctx.exp1); // Escreve a expressão aritmética.
        
        for(int i = 0; i < ctx.outrasexp.size(); i++){
            saida.append(" ");
            visitOp_relacional(ctx.oprel); // Escreve o operador relacional.
            saida.append(" ");
            ladoEsquerdo = Utils.tiposCompativeis(ladoEsquerdo, visitExp_aritmetica(ctx.outrasexp.get(i))); // Escreve a expressão aritmética.
        }
        
        return ladoEsquerdo;
    }
    
    @Override
    public Tipos visitOp_relacional(laParser.Op_relacionalContext ctx){
        // Escreve o sinal relacional desejado.
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
        Tipos ladoEsquerdo = visitTermo(ctx.termo1); // Escreve o termo.
        
        for(int i = 0; i < ctx.outrostermos.size(); i++){
            saida.append(" ");
            visitOp1(ctx.op.get(i)); // Escreve o operador.
            saida.append(" ");
            Tipos t = visitTermo(ctx.outrostermos.get(i)); // Escreve o termo.
            ladoEsquerdo = Utils.tiposCompativeis(ladoEsquerdo, t);
        }
        
        return ladoEsquerdo;
    }
    
    @Override
    public Tipos visitOp1(laParser.Op1Context ctx){
        // Escreve o operador correspondente.
        if(ctx.mais != null)
            saida.append("+");
        else
            saida.append("-");
        return null;
    }
    
    @Override
    public Tipos visitTermo(laParser.TermoContext ctx){
        Tipos ladoEsquerdo = visitFator(ctx.fator1); // Escreve o fator.
        
        for(int i = 0; i < ctx.outrosfatores.size(); i++){
            saida.append(" ");
            visitOp2(ctx.op.get(i)); // Escreve o operador.
            saida.append(" ");
            
            Tipos t  = visitFator(ctx.outrosfatores.get(i)); // Escreve o fator.
            ladoEsquerdo = Utils.tiposCompativeis(ladoEsquerdo, t);
        }
        
        return ladoEsquerdo;
    }
    
    @Override
    public Tipos visitOp2(laParser.Op2Context ctx){
        // Escreve o operador correspondente.
        if(ctx.vezes != null)
            saida.append("*");
        else
            saida.append("/");
        
        return null;
    }
    
    @Override
    public Tipos visitFator(laParser.FatorContext ctx){
        Tipos ladoEsquerdo = visitParcela(ctx.parcela1); // Escreve a parcela.
        
        for(int i = 0; i < ctx.outrasparcelas.size(); i++){
            saida.append(" ");
            visitOp3(ctx.op3); // Escreve a operacão.
            saida.append(" ");
            
            Tipos t = visitParcela(ctx.outrasparcelas.get(i)); // Escreve a parcela.
            ladoEsquerdo = Utils.tiposCompativeis(ladoEsquerdo, t);
        }
        
        return ladoEsquerdo;
    }
    
    @Override
    public Tipos visitOp3(laParser.Op3Context ctx){
        saida.append("%"); // Escreve o operador de módulo.
        return null;
    }
    
    @Override
    public Tipos visitParcela(laParser.ParcelaContext ctx){
        if(ctx.opuna != null) // Se houver um número negativo, multiplica por menos 1.
            saida.append("(-1) *");
        
        Tipos t;
        
        if(ctx.puna != null)
            t = visitParcela_unario(ctx.puna); // Escreve Parcela unária se tiver.
        else
            t = visitParcela_nao_unario(ctx.pnuna); // Escreve Parcela não unária se tiver.
        
        return t;
    }
    
    @Override
    public Tipos visitParcela_unario(laParser.Parcela_unarioContext ctx){
        Tipos t = null;
        if(ctx.iden != null){ // Se for um identificador.
            if(ctx.chapeu != null) // Se for um ponteiro, escreve *.
                saida.append("*");
            t = visitIdentificador(ctx.iden); // Escreve o identificador.
        }
        else if(ctx.inte != null){ // Se for um inteiro.
            saida.append(ctx.inte.getText()); // Escreve o inteiro.
            t = Tipos.Inteiro;
        }
        else if(ctx.real != null){ // Se for um float.
            saida.append(ctx.real.getText()); // Escreve o float.
            t = Tipos.Real;
        }
        else if(ctx.exp_par != null){ // Se for uma expressão entre parênteses.
            saida.append("("); // Escreve os parênteses,
            t = visitExpressao(ctx.exp_par); // E a expressão.
            saida.append(")");
        }
        else if(ctx.id != null){ // Se for uma funcão.
            for(TabelaDeSimbolos ts: aninhados.percorrerEscoposAninhados()){
                if(ts.verificar(ctx.id.getText()) != null)
                    t = ts.verificar(ctx.id.getText()).tipo; // Verifica o tipo da funcão.
            }
            
            saida.append(ctx.id.getText()); // Escreve o identificador da funcão.
            saida.append("("); // Escreve os parênteses.
            visitExpressao(ctx.exp1); // Escreve os parâmetros.
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
        if(ctx.chap != null) // Se for um ponteiro, escreve *.
            saida.append("*");
        
        if(Utils.verificarTipo(aninhados.percorrerEscoposAninhados(), ctx.id) != Tipos.Literal){ // Se não for uma string,
            visitIdentificador(ctx.id); // Escreve o identificador.
            saida.append(" = "); // Atribui com o sinal de igual.
            visitExpressao(ctx.exp); // Escreve a expressão.
        }
        else{ // Se for uma string, faz o mesmo processo com o comando strcpy.
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
        saida.append("if( "); // Escreve o comando if.
        visitExpressao(ctx.exp); // Escreve a expressão do if.
        saida.append(" ){\n");
        for(int i = 0; i < ctx.cmds.size(); i++) // Escreve comandos do if.
            visitCmd(ctx.cmds.get(i)); 
        saida.append("}\n");
        if(ctx.els != null){ // Caso tenha um else, escreve o else.
            saida.append("else{\n");
            for(int i = 0; i < ctx.elsecmd.size(); i++){ // Escreve os comandos do else.
                visitCmd(ctx.elsecmd.get(i));
            }
            saida.append("}\n"); 
        }
        
        return null;
    }
    
    @Override
    public Tipos visitCmdCaso(laParser.CmdCasoContext ctx){
        saida.append("switch ("); // Escreve o comando switch.
        visitExp_aritmetica(ctx.exp); // Escreve a expressão do switch.
        saida.append(") {\n");
        visitSelecao(ctx.sel); // Escreve as selecões.
        if(ctx.els != null){ // Escreve o ocomando default caso haja.
            saida.append("default:\n");
            for(int i = 0; i < ctx.cmds.size(); i++) // Escreva os comandos do default.
                visitCmd(ctx.cmds.get(i));
        }
        
        saida.append("}\n");
        return null;
    }
    
    @Override
    public Tipos visitItem_selecao(laParser.Item_selecaoContext ctx){
        List<String> intervalos = Utils.intervalos(ctx.cte); // Lista com os intervalos da selecão.
        
        for(int i = 0; i < intervalos.size(); i = i + 2){
            int comeco = Integer.parseInt(intervalos.get(i)); // Insere o primeiro número do intervalo.
            if(!intervalos.get(i+1).equals("-")){ // Se for de fato um intervalo,
                int fim = Integer.parseInt(intervalos.get(i+1)); // Insere o último número do intervalo.
                
                for(int j = comeco; j < fim+1; j++){ // Para cada número do intervalo,
                    saida.append("case "); // Escre case.
                    saida.append(j); // E o número do item/
                    saida.append(":\n");
                } 
            }
            else{ // Caso precise escrever só uma vez.
               saida.append("case ");
               saida.append(comeco);
               saida.append(":\n");
            }
        }
        
        for(int i = 0; i < ctx.cmds.size(); i++) // Escreve os comandos para aquela selecão.
            visitCmd(ctx.cmds.get(i));
        
        if(ctx.cmds.size() != 0) // Se houver um comando, insere um break;
            saida.append("break;\n");
        
        return null;
    }
    
    @Override
    public Tipos visitCmdPara(laParser.CmdParaContext ctx){
        saida.append("for("); // Escreve o comando for.
        saida.append(ctx.id.getText()); // Escreve a variável do for.
        saida.append(" = "); // Comando de atribuicão.
        visitExp_aritmetica(ctx.exp1); // Escreve a expressão de atribuicão.
        saida.append("; "); // Encerra o primeiro campo do for.
        saida.append(ctx.id.getText()); // Escreve a variável.
        saida.append(" <= "); // Escreve o símbolo de até.
        visitExp_aritmetica(ctx.exp2); // Escreve a expressão do até.
        saida.append("; "); // Encerra o segundo campo do for.
        saida.append(ctx.id.getText()); // Escreve a variável.
        saida.append("++) {\n"); // Incrementa e abre o for.
        for(int i = 0; i < ctx.cmds.size(); i++) // Escreve os comandos do for.
            visitCmd(ctx.cmds.get(i));
        saida.append("}\n"); // Encerra o for.
        
        return null;
    }
    
    @Override
    public Tipos visitCmdEnquanto(laParser.CmdEnquantoContext ctx){
        
        saida.append("while ("); // Escreve o comando while.
        visitExpressao(ctx.exp); // Escreve a expressão do while.
        saida.append(") {\n");
        for(int i = 0; i < ctx.lcmd.size(); i++) // Escreve os comandos do while
            visitCmd(ctx.lcmd.get(i));
        
        saida.append("}\n");
        
        return null;
    }
    
    @Override
    public Tipos visitCmdFaca(laParser.CmdFacaContext ctx){
        saida.append("do {\n"); // Escreve o comando do.
        for(int i = 0; i < ctx.lcmd.size(); i++) // Escreve os comandos do do while.
            visitCmd(ctx.lcmd.get(i));
        saida.append("} while(");
        visitExpressao(ctx.exp); // Escreve a expressão.
        saida.append(");\n");
        
        return null;
    }
    
    @Override
    public Tipos visitParcela_nao_unario(laParser.Parcela_nao_unarioContext ctx){
        if(ctx.comercial != null) // Se tiver um e comercial, escreve.
            saida.append("&");
        
        if(ctx.cad != null){ // Se tiver uma cadeia, escreve cadeia.
            saida.append(ctx.cad.getText().substring(0, ctx.cad.getText().length()));
            return Tipos.Literal;
        }
        else
            return visitIdentificador(ctx.id); // Escreve identificador, se houver.
    }
    
    @Override
    public Tipos visitValor_constante(laParser.Valor_constanteContext ctx){
        if(ctx.cad != null){ // Se for uma cadeia, escreve a cadeia.
            saida.append(ctx.cad.getText());
            return Tipos.Literal;
        }
        else if(ctx.in != null){ // Se for um inteiro, escreve um inteiro.
            saida.append(ctx.in.getText());
            return Tipos.Inteiro;
        }
        else if(ctx.re != null){ // Se for um float, escreve o float.
            saida.append(ctx.re.getText());
            return Tipos.Real;
        }
        else if(ctx.fa != null){ // Se for false, escreve false.
            saida.append("false");
            return Tipos.Logico;
        }
        else{ // Se for true, escreve true.
            saida.append("true");
            return Tipos.Logico;
        }    
    }
    
    @Override
    public Tipos visitRegistro(laParser.RegistroContext ctx){
        saida.append("struct {\n"); // Escreve registro.
        for(int i = 0; i < ctx.vars.size(); i++){ // Escreve as variáveis do struct.
            visitVariavel(ctx.vars.get(i));
            saida.append(";\n");
        }
        saida.append("}");
        
        return Tipos.Struct;
    }
    
    @Override
    public Tipos visitDeclaracao_global(laParser.Declaracao_globalContext ctx){
        func = true; // Marca que está tratando uma funcão.
        saida.append("\n");
        if(ctx.proc != null){ // Se for um procedimento.
            saida.append("void "); // Marca que o retorno é void.
            saida.append(ctx.id.getText()); // Escreve o identificador do procedimento.
            aninhados.obterEscopoAtual().inserir(ctx.id.getText(), Tipos.Procedure); // Adiciona no escopo o procedimento.
            saida.append("(");
            aninhados.criarNovoEscopo(); // Cria o escopo do procedimento.
            if(ctx.par != null) // Escreve os parâmetros. 
                visitParametros(ctx.par);
            saida.append("){\n");
            for(int i = 0; i < ctx.decl.size(); i++){ // Escreve as declaracões local do procedimento.
                visitDeclaracao_local(ctx.decl.get(i));
                saida.append("\n");
            }
            for(int i = 0; i < ctx.lcmd.size(); i++){ // Escreve os comandos do procedimento.
                visitCmd(ctx.lcmd.get(i));
            }
            saida.append("}\n");
            aninhados.abandonarEscopo();
        }
        else{
            Tipos t = visitTipo_estendido(ctx.tip); // Escreve o tipo da funcão.
            saida.append(" ");
            saida.append(ctx.id.getText()); // Escreve o identificador da funcão.
            aninhados.obterEscopoAtual().inserir(ctx.id.getText(), t); // Insere a funcão no escopo.
            saida.append("(");
            aninhados.criarNovoEscopo(); // Cria o escopo da funcão.
            if(ctx.par != null) // Escreve os parâmetros da funcão.
                visitParametros(ctx.par);
            saida.append("){\n");
            for(int i = 0; i < ctx.decl.size(); i++){ // Escreve as declaracões da funcão.
                visitDeclaracao_local(ctx.decl.get(i));
                saida.append("\n");
            }
            for(int i = 0; i < ctx.lcmd.size(); i++){ // Escreve os comandos da funcão.
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
        Tipos tipo = visitTipo_estendido(ctx.tip); // Escreve o tipo.
        saida.append(" ");
        visitIdentificador(ctx.id1); // Escreve o identificador.
        aninhados.obterEscopoAtual().inserir(ctx.id1.text.getText(), tipo); // Insere o parâmetro no escopo.
        for(int i = 0; i < ctx.outrosids.size(); i++){ // Escreve os demais identificadores.
            saida.append(", ");
            visitIdentificador(ctx.outrosids.get(i));
            aninhados.obterEscopoAtual().inserir(ctx.outrosids.get(i).text.getText(), tipo);
        }
        
        return null;
    }
    
    @Override
    public Tipos visitCmdChamada(laParser.CmdChamadaContext ctx){
        saida.append(ctx.id1.getText()); // Escreve o identificador da chamada.
        saida.append("(");
        visitExpressao(ctx.exp1); // Escreve as expressões das chamadas (parâmetros).
        for(int i = 0; i < ctx.outrasexp.size(); i++){
            saida.append(", ");
            visitExpressao(ctx.outrasexp.get(i));
        }
        saida.append(");\n");
        
        for(TabelaDeSimbolos ts : aninhados.percorrerEscoposAninhados())
            if(ts.verificar(ctx.id1.getText()) != null)
                return ts.verificar(ctx.id1.getText()).tipo; // Retorna o tipo da funcão.
        
        return null;
    }
    
    @Override
    public Tipos visitDimensao(laParser.DimensaoContext ctx){
        for(int i = 0; i < ctx.exps.size(); i++){ // Escreve as dimensões.
            saida.append("[");
            visitExp_aritmetica(ctx.exps.get(i));
            saida.append("]");
        }
        
        return null;
    }
    
    @Override
    public Tipos visitCmdRetorne(laParser.CmdRetorneContext ctx){
        saida.append("return "); // Escreve o comando retorne.
        visitExpressao(ctx.expressao()); // Escreve a expressão do retorne.
        return null;
    }
}
