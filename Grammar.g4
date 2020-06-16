grammar Grammar;

program: statements+=statement* EOF;

statement: cCode
         | funcDeclare
         | funcCall
         | varDeclare
         | varAssign
         //| if
         ;

cCode: C_CODE;
C_CODE: '<<' .+? '>>';

funcDeclare: type=IDENT name=IDENT '(' (args+=varDeclare (',' args+=varDeclare)*)? ')' block;
block: '{' statements+=statement* '}';

funcCall: name=IDENT '(' (args+=expr (',' args+=expr)*)? ')';

varDeclare: type=IDENT name=IDENT ('=' value=expr)?;
varAssign: name=IDENT '=' value=expr;

//if: 'if' '(' expr ')'

expr: cCode #cExpr
    | INT_LITERAL #litExpr
    | FLOAT_LITERAL #litExpr
    | BOOL_LITERAL #litExpr
    | CHAR_LITERAL #litExpr
    | STR_LITERAL #litExpr
    | IDENT #varExpr
    | funcCall #funcExpr
    | '(' expr ')' #parenExpr
    | op=('-'|'!') expr #unExpr
    | left=expr op=('*'|'/'|'%') right=expr #binExpr
    | left=expr op=('+'|'-') right=expr #binExpr
    | left=expr op=('<'|'<='|'>'|'>=') right=expr #binExpr
    | left=expr op=('=='|'!=') right=expr #binExpr
    ;

INT_LITERAL: '-'? DIGIT+;
FLOAT_LITERAL: INT_LITERAL | '-'? DIGIT* '.' DIGIT+;
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
