# Analisador Sintático

Nesta pasta se encontra o código fonte para o uso do Analisador Sintático da Linguagem Algorítmica (LA).  Trabalho realizado pelo aluno Luís Felipe Corrêa Ortolan - RA: 759375.

O código usa dois argumentos, o caminho de um o arquivo de entrada com a linguagem LA e o segundo o endereço de um arquivo onde será escrita a saída.
Para usar o analisador sintático, use o comando "java -jar ./target/laSintatico-1.0-jar-with-dependencies.jar  caminho-arquivo-entrada-em-la caminho-arquivo-saida".

Caso se deseje ampliar a função atual, o arquivo Java que lida com o ANTLR se encontra em "Compiladores/AnalisadorSinatico/src/main/java/br/ufscar/dc/compiladores/lasintatico/Principal.java", enquanto a linguagem algorítmica está implementada no arquivo "Compiladores/AnalisadorSintatico/src/main/antlr4/cjava/br/ufscar/dc/compiladores/lasintatico/la.g4". Além disso, existe um código em java para tratar os erros gerados pelo Antlr de forma personalizada, ele se encontra em "Compiladores/AnalisadorSinatico/src/main/java/br/ufscar/dc/compiladores/lasintatico/ErroCustom.java"
