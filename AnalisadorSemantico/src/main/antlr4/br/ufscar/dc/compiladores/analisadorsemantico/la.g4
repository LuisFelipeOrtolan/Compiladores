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

registro:
    'registro' (vars+=variavel)* 'fim_registro';

programa:
    declaracoes 'algoritmo' corpo 'fim_algoritmo';
    
declaracoes:
    (decl_local_global)*;

decl_local_global:
    declaracao_local | declaracao_global;

declaracao_local:
    decl='declare' vars=variavel | 
    con='constante' id=IDENT ':' tbas=tipo_basico '=' val=valor_constante |
    tip='tipo' id=IDENT ':' t=tipo;

variavel:
    ident1=identificador (',' outrosIdents+=identificador)* ':' tip=tipo;

identificador:
    text=IDENT (ponto='.' text1+=IDENT)* dimensao;

dimensao:
    ('[' exp_aritmetica ']')*;

tipo:
    reg=registro | ext=tipo_estendido;

tipo_basico:
    l='literal' | i='inteiro' | r='real' | log='logico';

tipo_basico_ident:
    tbas=tipo_basico | id=IDENT;

tipo_estendido:
    ('^')? tipo_basico_ident;

valor_constante:
    cad=CADEIA | in=NUM_INT | re=NUM_REAL | tr='verdadeiro' | fa='falso';

declaracao_global:
    proc='procedimento' id=IDENT '(' (par=parametros)? ')' (decl+=declaracao_local)* (lcmd+=cmd)* 'fim_procedimento' |
    func='funcao' id=IDENT '(' (par=parametros)? ')' ':' tip=tipo_estendido (decl+=declaracao_local)* (lcmd+=cmd)* 'fim_funcao';

parametro:
    ('var')? id1=identificador (',' outrosids+=identificador)* ':' tip=tipo_estendido;

parametros:
    par1 = parametro (',' outrospar+=parametro)*;

corpo:
    (declaracao_local)* (cmd)*;

cmd:
    cmdLeia | cmdEscreva | cmdSe | cmdCaso | cmdPara | cmdEnquanto| cmdFaca | cmdAtribuicao | cmdChamada | cmdRetorne;

cmdLeia:
    'leia' '(' ('^')? id1=identificador (vir=',' ('^')? outrosids+=identificador)* ')';

cmdEscreva:
    'escreva' '(' exp1=expressao (',' outrosexp+=expressao)*  ')';

cmdSe:
    'se' expressao 'entao' (cmd)* ('senao' (cmd)*)? 'fim_se';

cmdCaso:
    'caso' exp_aritmetica 'seja' selecao ('senao' (cmd)*)? 'fim_caso';

cmdPara:
    'para' IDENT '<-' exp_aritmetica 'ate' exp_aritmetica 'faca' (cmd)* 'fim_para';

cmdEnquanto:
    'enquanto' expressao 'faca' (cmd)* 'fim_enquanto';

cmdFaca:
    'faca' (cmd)* 'ate' expressao;

cmdAtribuicao:
    (chap='^')? id=identificador '<-' exp=expressao;

cmdChamada:
    id1=IDENT '(' exp1=expressao (',' outrasexp+=expressao)* ')';

cmdRetorne:
    'retorne' expressao;

selecao:
    (item_selecao)*;
   
item_selecao:
    constantes ':' (cmd)*;

constantes:
    numero_intervalo (',' numero_intervalo)*;

numero_intervalo:
    (op_unario)? NUM_INT ('..' (op_unario)? NUM_INT)? ;

op_unario:
    '-';

exp_aritmetica:
    termo1=termo (op1 outrostermos+=termo)*;

termo:
    fator1=fator (op2 outrosfatores+=fator)*;

fator:
    parcela1=parcela (op3 outrasparcelas+=parcela)*;

op1:
    '+' | '-';

op2: 
    '*' | '/';

op3:
    '%';

parcela:
    ((opuna=op_unario)?  puna=parcela_unario) | pnuna=parcela_nao_unario;

parcela_unario:
    ((chapeu='^')? iden=identificador) |
    id=IDENT '(' exp1=expressao (',' outrasexps+=expressao)* ')'|
    inte=NUM_INT | real=NUM_REAL | '(' exp_par=expressao ')';

parcela_nao_unario:
    comercial='&' identificador | cad=CADEIA;

exp_relacional:
    exp1=exp_aritmetica (oprel=op_relacional outrasexp+=exp_aritmetica)?;

op_relacional:
    '=' | '<>' | '>=' | '<=' | '>' | '<';

expressao:
    tl=termo_logico (op_logico_1 outrostl+=termo_logico)*;

termo_logico:
    f1=fator_logico (op_logico_2 outrosf+=fator_logico)*;

fator_logico:
    (not='nao')? plogica=parcela_logica;

parcela_logica:
    v='verdadeiro' | f='falso' | exp=exp_relacional;