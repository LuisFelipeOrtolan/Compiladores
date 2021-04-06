grammar linguagemTatica;

NUMEROS: '1'..'5';

POSICOES: 'goleiro' | 'lateral' | 'zagueiro' | 'volante' | 'meia' | 'atacante';

DOISP: ':';

VIRGULA: ',';

RESERVADAS: 'funcao' | 'defender' | 'atacar';

NOMES: ('a'..'z' | 'A'..'Z')+;

DESCARTE: (' ' | '\t') {skip();};

PULA_LINHA: ('\r' | '\n') {skip();};

ERROS: .;

programa: 'sistema_tatico' f=formacao (d+=decl_jogador)+ (p+=papel)* 'fim_sistema_tatico'; 

formacao: 'formacao' ':' nro1=NUMEROS ',' nro2=NUMEROS ',' nro3=NUMEROS (',' outrosnros+=NUMEROS)*;

decl_jogador: pos=POSICOES ':' n=NOMES;

papel: n=NOMES ':' (d='defender' | a='atacar');