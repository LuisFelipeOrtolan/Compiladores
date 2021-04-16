# Sistema Tático

Aluno: Luís Felipe Corrêa Ortolan
RA: 759375

## Como funciona a linguagem?

Todo código da linguagem deve ser iniciado com o discriminador "sistema_tatico" e encerrado com "fim_sistema_tatico". Depois de iniciado o código, deve vir a informação de qual a formação que vai ser usada, isso é feito por escrever "formacao:" e em sequencia, pelo menos três números entre 1 e 5 com vírgulas entre eles, cuja soma deve dar 10. Depois da declaração da formação, devem se declarar os atletas, para isso, deve-se escrever a posição (que pode ser: "goleiro", "lateral", "zagueiro", "volante", "meia" ou "atacante"), dois pontos e o nome do jogador. Esssa declaração deve ser feita 11 vezes, uma para cada jogador. 

As posições declaradas devem bater com as declaradas no sistema tático, e elas são da seguinte forma: se o primeiro número da formação for maior que três, devem haver dois laterais e o restante deve ser declarado como zagueiro, caso contrário, todos são zagueiros. Se a formação possuir mais que três números, deve-se declarar o número de volantes igual o número do segundo número da formação, em sequência o número de meias que deve ser a soma de todos os números em sequência menos o último. Caso não haja mais que três números na formação, devem ser declarados meias igual ao segundo número da formação. Por fim, devem ser declarados atacantes iguais ao último número da formação.

Também é possível dizer se um jogador deve atacar ou defender. Para isso, basta colocar o nome de um jogador declarado, colocar dois pontos e em sequência escrever "atacar" ou "defender". Entretanto, na linguagem, goleiros e zagueiros não podem atacar e atacantes não podem defender. Esta parte de atribuir funções aos jogadores é opcional no código.

Um vídeo onde executo o código: https://youtu.be/qZE74-ZJTZM

## Explicação do código
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
