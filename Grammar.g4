grammar Grammar;

program: statements+=statement* EOF;

statement: cCode
         | funcDeclare
         | funcCall
         | varDeclare
         | varAssign
         ;

cCode: code=C_CODE;
C_CODE: '<<' .+? '>>';

funcDeclare: type=IDENT name=IDENT '(' (args+=varDeclare (',' args+=varDeclare)*)? ')' block;
block: '{' statements+=statement* '}';

funcCall: name=IDENT '(' (args+=expr (',' args+=expr)*)? ')';

varDeclare: type=IDENT name=IDENT ('=' value=expr)?;
varAssign: name=IDENT '=' value=expr;

expr: cCode #cExpr
    | value=INT_LITERAL #intExpr
    | value=FLOAT_LITERAL #floatExpr
    | value=CHAR_LITERAL #charExpr
    | value=STR_LITERAL #strExpr
    | name=IDENT #varExpr
    | call=funcCall #funcExpr
    | '(' expr ')' #parenExpr
    | left=expr op=('*'|'/'|'%') right=expr #binExpr
    | left=expr op=('+'|'-') right=expr #binExpr
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
