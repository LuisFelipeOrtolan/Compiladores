grammar la;

TIPOS:
    'inteiro' | 'literal' | 'real' | 'logico';

IO:
    'leia' | 'escreva';

RESERVADAS:
    'declare' | 'algoritmo' | 'fim_algoritmo' | 'constante';

DEFINICAO:
    'tipo';

ATRIBUICAO:
    ('<''-');

INTERVALO:
    '..';

ENDERECOS:
    '^' | '&';

op_logico_1:
    'ou';

op_logico_2:
    'e';

NOT:
    'nao';

VERDADEIRO_FALSO:
    'verdadeiro' | 'falso';

VAR:
    'var';

THEN:
    'entao';

ELSE:
    'senao';

IF:
    'se' | 'fim_se';

CASE:
    'caso' | 'seja' | 'fim_caso';

FOR:
    'para' | 'ate' | 'faca' | 'fim_para';

WHILE:
    'enquanto' | 'fim_enquanto';    

STRUCT:
    'registro' | 'fim_registro'; 

PROCEDURE:
    'procedimento' | 'fim_procedimento';

FUNCTION:
    'funcao' | 'fim_funcao' | 'retorne';


NUM_INT:
    DIGITO (DIGITO)*;


NUM_REAL:
    DIGITO (DIGITO)* '.' DIGITO (DIGITO)*;

IDENT:
    (LETRA | '_') (LETRA | DIGITO | '_')*;


COMENTARIOS:
    '{' (~('}' | '\n' | '\r'))* '}' {skip();};

COMENTARIOS_ERRADOS:
    '{' (~('}'))* ('\n' | '\r');

IGNORAR:
    (' ' | '\t') {skip();};

PULA_LINHA:
    ('\n' | '\r') {skip();};

VIRGULA:
    ',';

CAMPO:
    '.';

ABREPAR:
    '(';

FECHAPAR:
    ')';

ABRECOL:
    '[';
   
FECHACOL:
    ']';

DOISP:
    ':';

CADEIA:
    '"' (~('"' | '\n' | '\r'))* '"';

CADEIA_ERRADA:
    '"' (~('"'))* ('\n' | '\r'); 

LETRA:
    'a'..'z'| 'A'..'Z';

LETRAMIN:
    'a'..'z';

DIGITO:
    '0'..'9';

ERRO:
    .;

FIMARQUIVO:
    EOF;

programa:
    declaracoes 'algoritmo' corpo 'fim_algoritmo'|
    'algoritmo' corpo 'fim_algoritmo' |
    declaracoes 'algoritmo' 'fim_algoritmo' |
    'algoritmo' 'fim_algoritmo';
    
declaracoes:
    decl_local_global | 
    decl_local_global declaracoes;

decl_local_global:
    declaracao_local | declaracao_global;

declaracao_local:
    'declare' variavel | 
    'constante' IDENT ':' tipo_basico '=' valor_constante |
    'tipo' IDENT ':' tipo;

variavel:
    identificador ':' tipo| 
    identificador lista_variavel ':' tipo;

lista_variavel:
    ',' identificador |
    ',' identificador lista_variavel;

identificador:
    IDENT dimensao |
    IDENT | 
    IDENT lista_identificador dimensao |
    IDENT lista_identificador;

lista_identificador:
    '.' IDENT |
    '.' IDENT lista_identificador;

dimensao:
    '[' exp_aritmetica ']' |
    '[' exp_aritmetica ']' dimensao;

tipo:
    registro | tipo_estendido;

tipo_basico:
    'literal' | 'inteiro' | 'real' | 'logico';

tipo_basico_ident:
    tipo_basico | IDENT;

tipo_estendido:
    '^' tipo_basico_ident |
    tipo_basico_ident;

valor_constante:
    CADEIA | NUM_INT | NUM_REAL | 'verdadeiro' | 'falso';

registro:
    'registro' 'fim_registro' |
    'registro' lista_registro 'fim_registro';

lista_registro:
    variavel | variavel lista_registro;

declaracao_global:
    'procedimento' IDENT '(' parametros ')' lista_declaracao_global lista_cmd 'fim_procedimento' |
    'procedimento' IDENT '(' ')' lista_declaracao_global lista_cmd 'fim_procedimento' |
    'procedimento' IDENT '(' ')' lista_cmd 'fim_procedimento' |
    'procedimento' IDENT '(' ')' 'fim_procedimento' |
    'procedimento' IDENT '(' ')' lista_declaracao_global 'fim_procedimento' |
    'procedimento' IDENT '(' parametros ')' lista_cmd 'fim_procedimento' |
    'procedimento' IDENT '(' parametros ')' lista_declaracao_global 'fim_procedimento' |
    'procedimento' IDENT '(' parametros ')' 'fim_procedimento' |
    'funcao' IDENT '(' parametros ')' ':' tipo_estendido lista_declaracao_global lista_cmd 'fim_funcao' |
    'funcao' IDENT '(' ')' ':' tipo_estendido lista_declaracao_global lista_cmd 'fim_funcao' |
    'funcao' IDENT '(' ')' ':' tipo_estendido lista_cmd 'fim_funcao' |
    'funcao' IDENT '(' ')' ':' tipo_estendido 'fim_funcao' |
    'funcao' IDENT '(' ')' ':' tipo_estendido lista_declaracao_global 'fim_funcao' |
    'funcao' IDENT '(' parametros ')' ':' tipo_estendido lista_cmd 'fim_funcao' |
    'funcao' IDENT '(' parametros ')' ':' tipo_estendido lista_declaracao_global 'fim_funcao' |
    'funcao' IDENT '(' parametros ')' ':' tipo_estendido 'fim_funcao';

lista_declaracao_global:
    declaracao_local |
    declaracao_local lista_declaracao_global;

lista_cmd:
    cmd |
    cmd lista_cmd;

parametro:
    'var' identificador lista_variavel ':' tipo_estendido |
    'var' identificador ':' tipo_estendido |
    identificador lista_variavel ':' tipo_estendido |
    identificador ':' tipo_estendido;

parametros:
    parametro lista_parametros |
    parametro;

lista_parametros:
    ',' parametro |
    ',' parametro lista_parametros;

corpo:
    lista_declaracao_global lista_cmd |
    lista_declaracao_global |
    lista_cmd;

cmd:
    cmdLeia | cmdEscreva | cmdSe | cmdCaso | cmdPara | cmdEnquanto| cmdFaca | cmdAtribuicao | cmdChamada | cmdRetorne;

cmdLeia:
    'leia' '(' '^' identificador lista_identificador_chapeu ')' |
    'leia' '(' identificador lista_identificador_chapeu ')' |
    'leia' '(' '^' identificador ')' |
    'leia' '(' identificador ')';

lista_identificador_chapeu:
    ',' '^' identificador |
    ',' '^' identificador lista_identificador_chapeu |
    ',' identificador |
    ',' identificador lista_identificador_chapeu;

cmdEscreva:
    'escreva' '(' expressao lista_expressao ')' |
    'escreva' '(' expressao ')';

lista_expressao:
    ',' expressao |
    ',' expressao lista_expressao;

cmdSe:
    'se' expressao 'entao' lista_cmd 'fim_se' |
    'se' expressao 'entao' 'fim_se' |
    'se' expressao 'entao' lista_cmd 'senao' lista_cmd 'fim_se' |
    'se' expressao 'entao' lista_cmd 'senao' 'fim_se' |
    'se' expressao 'entao' 'senao' lista_cmd 'fim_se'|
    'se' expressao 'entao' 'senao' 'fim_se';

cmdCaso:
    'caso' exp_aritmetica 'seja' selecao 'senao' lista_cmd 'fim_caso' |
    'caso' exp_aritmetica 'seja' 'senao' lista_cmd 'fim_caso' |
    'caso' exp_aritmetica 'seja' selecao 'senao' 'fim_caso' |
    'caso' exp_aritmetica 'seja' 'senao' 'fim_caso' |
    'caso' exp_aritmetica 'seja' selecao 'fim_caso' | 
    'caso' exp_aritmetica 'seja' 'fim_caso';

cmdPara:
    'para' IDENT '<-' exp_aritmetica 'ate' exp_aritmetica 'faca' lista_cmd 'fim_para' |
    'para' IDENT '<-' exp_aritmetica 'ate' exp_aritmetica 'faca' 'fim_para';

cmdEnquanto:
    'enquanto' expressao 'faca' lista_cmd 'fim_enquanto' |
    'enquanto' expressao 'faca' 'fim_enquanto';

cmdFaca:
    'faca' lista_cmd 'ate' expressao |
    'faca' 'ate' expressao;

cmdAtribuicao:
    '^' identificador '<-' expressao |
    identificador '<-' expressao;

cmdChamada:
    IDENT '(' expressao lista_expressao ')' |
    IDENT '(' expressao ')';

cmdRetorne:
    'retorne' expressao;

selecao:
    item_selecao |
    item_selecao selecao;
   
item_selecao:
    constantes ':' lista_cmd |
    constantes ':';

constantes:
    numero_intervalo lista_numero_intervalo |
    numero_intervalo;

lista_numero_intervalo:
    ',' numero_intervalo |
    ',' numero_intervalo lista_numero_intervalo;

numero_intervalo:
    op_unario NUM_INT '..' op_unario NUM_INT |
    op_unario NUM_INT '..' NUM_INT |
    op_unario NUM_INT |
    NUM_INT '..' op_unario NUM_INT |
    NUM_INT '..' NUM_INT |
    NUM_INT;

op_unario:
    '-';

exp_aritmetica:
    termo lista_op1_termo |
    termo;

lista_op1_termo:
    op1 termo |
    op1 termo lista_op1_termo;

termo:
    fator lista_op2_fator |
    fator;

lista_op2_fator:
    op2 fator |
    op2 fator lista_op2_fator;

fator:
    parcela |
    parcela lista_op3_parcela;

lista_op3_parcela:
    op3 parcela |
    op3 parcela lista_op3_parcela;

op1:
    '+' | '-';

op2: 
    '*' | '/';

op3:
    '%';

parcela:
    op_unario parcela_unario | parcela_nao_unario |
    parcela_unario | parcela_nao_unario;

parcela_unario:
    '^' identificador | identificador |
    IDENT '(' expressao lista_expressao ')' | IDENT '(' expressao ')' |
    NUM_INT | NUM_REAL | '(' expressao ')';

parcela_nao_unario:
    '&' identificador | CADEIA;

exp_relacional:
    exp_aritmetica |
    exp_aritmetica op_relacional exp_aritmetica;

op_relacional:
    '=' | '<>' | '>=' | '<=' | '>' | '<';

expressao:
    termo_logico |
    termo_logico op_logico_1 termo_logico;

termo_logico:
    fator_logico |
    fator_logico op_logico_2 fator_logico;

fator_logico:
    parcela_logica | 
    'nao' parcela_logica;

parcela_logica:
    'verdadeiro' | 'falso' | exp_relacional;