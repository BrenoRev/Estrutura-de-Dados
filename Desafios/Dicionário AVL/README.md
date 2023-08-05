Implemente o tipo abstrato de dados Dicionário utilizando árvores AVL. As chaves são números inteiros. Pode haver chaves repetidas no dicionário. Essa questão fará uso exclusivamente das chaves do dicionário; ou seja, os valores mapeados às chaves não serão utilizados.

Input Specification

A entrada consiste em múltiplos casos. A entrada inicia com um número inteiro c > 0, que indica a quantidade de casos. Cada caso inicia com um número inteiro n > 0, que indica a quantidade de chaves que devem ser inseridas no dicionário. Na próxima linha, são apresentadas as n chaves separadas por espaço.
Output Specification

Para cada caso, imprima as chaves da árvore AVL (uma por linha) de acordo com uma travessia em pré-ordem. No final da travessia de cada árvore, imprima uma linha com a string “END”.

Notes

Em C/C++, declare a main retornando "int".

Time Limit
1 second
Memory Limit
768 MB
Output Limit
4 MB

Input

    2

    11

    20 10 15 30 25 9 7 8 12 6 5

    10

    50 25 10 40 30 60 5 32 29 28


Output

    9

    7

    6

    5

    8

    15

    10

    12

    25

    20

    30

    END

    30

    25

    10

    5

    29

    28

    40

    32

    50

    60

    END

