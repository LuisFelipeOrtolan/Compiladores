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

programa: 'sistema_tatico' f=formacao jg1=decl_jogador jg2=decl_jogador jg3=decl_jogador jg4=decl_jogador
            jg5=decl_jogador jg6=decl_jogador jg7=decl_jogador jg8=decl_jogador jg9=decl_jogador jg10=decl_jogador 
            jg11=decl_jogador (p+=papel)* 'fim_sistema_tatico'; 

formacao: 'formacao' ':' nro1=NUMEROS ',' nro2=NUMEROS ',' nro3=NUMEROS (',' outrosnros+=NUMEROS)*;

decl_jogador: pos=POSICOES ':' n=NOMES;

papel: n=NOMES ':' (d='defender' | a='atacar');