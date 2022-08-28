Implemente uma árvore AVL para números inteiros.

ENTRADA

A primeira linha de entrada contém o inteiro n (1 ≤ n ≤ 105), o número de operações que devem ser realizadas sobre a árvore. Cada uma das próximas n linhas contém um comando que pode ser de quatro tipos:

insert x -- insira o inteiro x (0 ≤ x ≤ 109) na árvore.

pre -- realize uma travessia em pré-ordem na árvore.

in -- realize uma travessia em ordem na árvore.

post -- realize uma travessia em pós-ordem na árvore.

9

insert 4

insert 6

insert 8

insert 3

insert 2

insert 5

pre

in

post

SAÍDA

Para cada comando pre, in ou post, imprima os números armazenados na árvore, na ordem em que foram visitados, separados por espaço.

4 3 2 6 5 8

2 3 4 5 6 8

2 3 5 8 6 4
