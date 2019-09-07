grammar Grammar;

program: statement* EOF;

statement: funcDeclare
         | funcCall
         | varDeclare
         | varAssign
         | asm
         ;

funcDeclare: retType=IDENT name=IDENT '(' (funcArg (',' funcArg)*)? ')' (';' | block);
funcArg: argType=IDENT name=IDENT;
block: '{' statement* '}';

funcCall: name=IDENT '(' args=funcCallArgs ')' ';';
funcCallArgs: (expr (',' expr)*)?;

varDeclare: varType=IDENT name=IDENT ('=' val=expr)? ';';
varAssign: name=IDENT '=' val=expr ';';

asm: 'asm' code=STR_LITERAL ';';

expr: '(' expr ')' #parenExpr
    | left=expr op=('*'|'/'|'%') right=expr #binExpr
    | left=expr op=('+'|'-') right=expr #binExpr
    | name=IDENT '(' args=funcCallArgs ')' #funcExpr
    | IDENT #varExpr
    | INT_LITERAL #intExpr
    | FLOAT_LITERAL #floatExpr
    | CHAR_LITERAL #charExpr
    | STR_LITERAL #strExpr
    | 'asm' code=STR_LITERAL #asmExpr
    ;


INT_LITERAL: '-'? DIGIT+;
FLOAT_LITERAL: INT_LITERAL | '-'? DIGIT* '.' DIGIT+;
CHAR_LITERAL: '\'' . '\'';
STR_LITERAL: '"' .*? '"';

IDENT: (LETTER | '_') (DIGIT | LETTER | '_')*;

WHITESPACE: ([ \t] | NEWLINE)+ -> skip;
COMMENT: '//' .*? NEWLINE -> skip;
BLOCK_COMMENT: '/*' .*? '*/' -> skip;

fragment DIGIT: [0-9];
fragment LETTER: [a-zA-Z];
fragment NEWLINE: [\r\n];
