lexer grammar lalgoritmica;

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

OPRELACIONAL:
   ('=' | '<>' | '>=' | '<=' | '>' | '<'); 

OPS:
    '+' | '-' | '*' | '/' |  '%';

OPLOGICO:
    'e' | 'ou';

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

IGNORAR:
    (' ' | '\t') {skip();};

PULA_LINHA:
    '\n' | '\r';

COMENTARIOS:
    '{' (~('}' | '\n' | '\r'))* '}' {skip();};

COMENTARIOS_ERRADOS:
    '{' (~('}'))* ('\n' | '\r');

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