grammar Grammar;

program: defines+=define* EOF;

define: varDefine
      | funcDefine
      | structDefine
      ;

statement: funcCall
         | varDefine
         | varAssign
         | iff
         | until
         | forr
         | ret
         | breakk
         | continuee
         ;

block: statements+=statement | '{' statements+=statement* '}';

funcDefine: type=IDENT name=IDENT '(' (args+=varDefine (',' args+=varDefine)*)? ')' block;
ret: 'return' value=expr?;
funcCall: name=IDENT '(' (args+=expr (',' args+=expr)*)? ')';

varDefine: type=IDENT name=IDENT ('=' init=expr)?;
varAssign: name=IDENT '=' value=expr;

structDefine: 'struct' name=IDENT '{' defines+=define* '}' ;

iff: 'if' '(' cond=expr ')' thenBlock=block ('else' elseBlock=block)?;
until: 'until' '(' cond=expr ')' block;
forr: 'for' '(' init=varDefine ';' cond=expr ';' update=statement ')' block;
breakk: 'break';
continuee: 'continue';

expr: INT_LITERAL #litExpr
    | FLOAT_LITERAL #litExpr
    | BOOL_LITERAL #litExpr
    | CHAR_LITERAL #litExpr
    | STR_LITERAL #litExpr
    | IDENT #varExpr
    | funcCall #funcExpr
    | '(' expr ')' #parenExpr
    | <assoc=right> 'cast' '(' type=IDENT ')' expr #castExpr
    | <assoc=right> op=('-'|'!') expr #unExpr
    | left=expr op=('*'|'/'|'%') right=expr #binExpr
    | left=expr op=('+'|'-') right=expr #binExpr
    | left=expr op=('<'|'<='|'>'|'>=') right=expr #binExpr
    | left=expr op=('=='|'!=') right=expr #binExpr
    ;


INT_LITERAL: DIGIT+;
FLOAT_LITERAL: DIGIT* '.' DIGIT*;
BOOL_LITERAL: 'true' | 'false';
CHAR_LITERAL: '\'' . '\'';
STR_LITERAL: '"' .*? '"';

IDENT: (LETTER | '_') (DIGIT | LETTER | '_')*;

WHITESPACE: ([ \t] | NEWLINE)+ -> skip;
COMMENT: '//' .*? NEWLINE -> skip;
BLOCK_COMMENT: '/*' .*? '*/' -> skip;

fragment DIGIT: [0-9];
fragment LETTER: [a-zA-Z];
fragment NEWLINE: [\r\n];
