grammar miniJava;

@header {
    package ANTLR4;
}

program: mainClass classDecl*;

mainClass: CLASS IDENTIFIER LBRACE PUBLIC STATIC   VOID MAIN LPAREN STRING LBRACK RBRACK IDENTIFIER RPAREN LBRACE SOP LPAREN exp RPAREN SEMI RBRACE RBRACE;

classDecl:(coefClass)? CLASS IDENTIFIER (EXTENDS IDENTIFIER)? LBRACE varDecl* methodDecl* RBRACE;

coefClass : COEFCLASS | COEFSUBCLASS LPAREN DQ IDENTIFIER DQ RPAREN;

varDecl: type IDENTIFIER SEMI;

varDeclp: type IDENTIFIER ;

methodDecl: PUBLIC (STATIC)? type IDENTIFIER LPAREN (varDeclp ( COMMA varDeclp )*)? RPAREN LBRACE varDecl* statement* RETURN exp SEMI RBRACE;

type: IDENTIFIER LBRACK RBRACK
      | BOOLEAN LBRACK RBRACK
      | INT LBRACK RBRACK
      | BOOLEAN
      | INT
      | IDENTIFIER;

statement: LBRACE statement* RBRACE
            | IF LPAREN exp RPAREN statement ELSE statement
            | WHILE LPAREN exp RPAREN statement 
            | SOP LPAREN exp RPAREN SEMI
            | IDENTIFIER ASSIGN exp SEMI
            | IDENTIFIER LBRACK exp RBRACK ASSIGN exp SEMI;

exp:exp LBRACK exp RBRACK
	| exp INSTANCEOF IDENTIFIER 
    |(BANG | SUB) exp
    |exp DOT LENGTH
	|exp (MUL| DIV) exp
	|exp (ADD | SUB) exp
	|exp (AND | OR) exp
	|exp (GT| LT | ASSIGN) exp
    | exp DOT IDENTIFIER LPAREN (exp ( COMMA exp )*)? RPAREN
    | NEW IDENTIFIER LBRACK exp RBRACK
    | NEW BOOLEAN LBRACK exp RBRACK
    | NEW INT LBRACK exp RBRACK
    | NEW IDENTIFIER LPAREN RPAREN
    | LPAREN IDENTIFIER RPAREN exp
    | DECIMAL_LITERAL
    | BOOL_LITERAL
    | IDENTIFIER
    | THIS
    | LPAREN exp RPAREN;

//
BOOLEAN:            'boolean';
INSTANCEOF: 		'instanceof';
CLASS:              'class';
ELSE:               'else';
EXTENDS:            'extends';
IF:                 'if';
INT:                'int';
NEW:                'new';
PUBLIC:             'public';
RETURN:             'return';
STATIC:             'static';
THIS:               'this';
VOID:               'void';
WHILE:              'while';
MAIN:               'main';
STRING:             'String';
SOP:                'System.out.println';
LENGTH:             'lenght';
COEFCLASS :	 		'@CoeffectClass';
COEFSUBCLASS:   	'@CoeffectSubClass';

// Literals
DECIMAL_LITERAL:    ('0' | [1-9] (Digits? | '_'+ Digits)) [lL]?;
BOOL_LITERAL:       'true'
            |       'false'
            ;

// Separators
LPAREN:             '(';
RPAREN:             ')';
LBRACE:             '{';
RBRACE:             '}';
LBRACK:             '[';
RBRACK:             ']';
SEMI:               ';';
COMMA:              ',';
DOT:                '.';
// Operators
ASSIGN:             '=';
GT:                 '>';
LT:                 '<';
AND:                '&&';
OR:                 '||';
BANG:               '!';
ADD:                '+';
SUB:                '-';
MUL:                '*';
DIV:                '/';
DQ:					'"';

// Whitespace and comments
WS:                 [ \t\r\n\u000C]+ -> channel(HIDDEN);
COMMENT:            '/*' .*? '*/'    -> channel(HIDDEN);
LINE_COMMENT:       '//' ~[\r\n]*    -> channel(HIDDEN);

// Identifiers

IDENTIFIER:         Letter LetterOrDigit*;

// Fragment rules

fragment Digits
    : [0-9] ([0-9_]* [0-9])?
    ;
fragment LetterOrDigit
    : Letter
    | [0-9]
    ;
fragment Letter
    : [a-zA-Z$_] // these are the "java letters" below 0x7F
    | ~[\u0000-\u007F\uD800-\uDBFF] // covers all characters above 0x7F which are not a surrogate
    | [\uD800-\uDBFF] [\uDC00-\uDFFF] // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
    ;

