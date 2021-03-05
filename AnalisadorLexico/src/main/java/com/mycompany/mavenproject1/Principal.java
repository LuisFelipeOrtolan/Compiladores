/*
 * Classe Principal para o analisador léxico da Linguagem Algorítmica
 * Autor: Luís Felipe Corrêa Ortolan - RA 759375
 */
package com.mycompany.mavenproject1;

import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

public class Principal {
    public static void main(String args[]){
        try {
            // Cria arquivo de saída com o args[1];
            FileWriter saida = new FileWriter(args[1]); 
            PrintWriter gravar = new PrintWriter(saida);
            
            // Lê do arquivo vindo de args[1];
            CharStream cs = CharStreams.fromFileName(args[0]);
            lalgoritmica lex = new lalgoritmica(cs);
            
            Token t = null;
            
            int linha = 1; // Variável para indicar a linha atual em que o programa está.
            
            while (Token.EOF != (t = lex.nextToken()).getType()) { // Lê os tokens do antlr um a um até o fim do arquvio.
                // Obtém o nome do tipo do Token.
                String nome = lalgoritmica.VOCABULARY.getDisplayName(t.getType());
                
                // Checa se houve algum tipo de erro, se houve, exibe e encerra execucão.
                if("ERRO".equals(nome)){
                    gravar.println("Linha " + linha + ": " + t.getText() + " - simbolo nao identificado");
                    break;
                } else if("COMENTARIOS_ERRADOS".equals(nome)){
                    gravar.println("Linha " + linha + ": comentario nao fechado");
                    break;
                } else if("CADEIA_ERRADA".equals(nome)){
                    gravar.println("Linha " + linha + ": cadeia literal nao fechada");
                    break;
                }
                
                // Identifica se o tipo ou o conteúdo deve ser mostrado.
                if("IDENT".equals(nome) || "CADEIA".equals(nome) || "NUM_INT".equals(nome) || "NUM_REAL".equals(nome)){ // Se for o tipo.
                    gravar.println("<'" + t.getText() + "'," + lalgoritmica.VOCABULARY.getDisplayName(t.getType()) + ">");
                }else if("PULA_LINHA".equals(nome)){ // Caso seja um pula linha, contabiliza.
                    linha++;
                }else{ // Se for o conteúdo.
                    gravar.println("<'" + t.getText() + "','" + t.getText() + "'>");
                }
            }
            
            // Fecha os arquivos de escrita.
            gravar.close();
            saida.close();
        } catch (IOException ex) {
        }
    }
}