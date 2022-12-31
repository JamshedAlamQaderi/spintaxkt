grammar Spintaxkt;

spintax
    :   element+
    ;

element
    :   TEXT
    |   choice
    ;

choice
    :   '{' element ( '|' element )* '}'
    ;

ESCAPED_CHAR
    :   '\\' ( '{' | '|' | '}' )
    ;

TEXT
    :   (ESCAPED_CHAR | ~[{}|])+
    ;

WS
    :   [ \t\r\n]+ -> skip
    ;
