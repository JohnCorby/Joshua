grammar Grammar;

program: statements+=statement* EOF;

statement: cCode
         | funcDeclare
         | funcCall
         | varDeclare
         | varAssign
         ;

cCode: 'c' code=STR_LITERAL;

funcDeclare: type=IDENT name=IDENT '(' (args+=varDeclare (',' args+=varDeclare)*)? ')' block;
block: '{' statements+=statement* '}';

funcCall: name=IDENT '(' (args+=expr (',' args+=expr)*)? ')';

varDeclare: type=IDENT name=IDENT ('=' value=expr)?;
varAssign: name=IDENT '=' value=expr;

expr: '(' expr ')' #parenExpr
    | left=expr op=('*'|'/'|'%') right=expr #binExpr
    | left=expr op=('+'|'-') right=expr #binExpr
    | call=funcCall #funcExpr
    | name=IDENT #varExpr
    | value=INT_LITERAL #intExpr
    | value=FLOAT_LITERAL #floatExpr
    | value=CHAR_LITERAL #charExpr
    | value=STR_LITERAL #strExpr
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
