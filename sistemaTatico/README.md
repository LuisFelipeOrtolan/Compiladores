# Sistema Tático

Aluno: Luís Felipe Corrêa Ortolan
RA: 759375

Aqui se encontra o compilador para a linguagem sistema tático, criada pelo aluno. A pasta CasosDeTestes contém casos de teste para testar a análise léxica, sintática e semântica, além de casos corretor para verifica a imagem gerada. Para o acesso aos códigos fontes, basta acessar a pasta src/main/java/br/ufscar/dc/compiladores/sistematatico , ali estão as classes:

ErroSintatico, que implementa a geração de erros sintáticos e léxicos.

ErrosSemanticos, que implementa a geração de erros semânticos.

Interpretador, que o código gera a imagem do sistama tático.

Jogador, que implementa a classe com todas as informações de um jogador para imprimir na imagem.

Principal, que faz o gerenciamento do  uso de todas as classes e é a classe principal.

Programa, que faz a análise semântica do código inserido.

Utils, com funções auxiliares para o programa.

Além disso, na pasta src/main/antlr4/br/ufscar/dc/compiladores/sistematatico está o arquivo sistematatico.g4 com a linguagem implementada pelo antlr.

Para usar o programa, basta usar o comando "java -jar /target/sistemaTatico-1.0-jar-with-dependencies.jar caminho-para-arquivo-entrada caminho-para-arquivo-saida" onde o primeiro argumento é o caminho para o arquivo de entrada, em linguagem sistemaTatico e o segundo argumento é o caminho para um arquivo de saída txt onde, caso haja um erro no código, será descrito o erro. Caso a compilação seja bem sucedida, a imagem irá aparecer na tela.