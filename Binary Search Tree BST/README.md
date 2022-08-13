Implemente uma árvore binária de busca para números inteiros.

ENTRADA

A primeira linha de entrada contém o inteiro n (1 ≤ n ≤ 105), o número de operações que devem ser realizadas sobre a árvore.

Cada uma das próximas n linhas contém um comando que pode ser de quatro tipos:

insert x -- insira o inteiro x (0 ≤ x ≤ 109) na árvore.

pre -- realize uma travessia em pré-ordem na árvore.

in -- realize uma travessia em ordem na árvore.

post -- realize uma travessia em pós-ordem na árvore.

<hr>

12

insert 37

insert 24

insert 7

insert 2

insert 32

insert 42

insert 40

insert 42

insert 120

pre

in

post

<hr>

SAÍDA

Para cada comando pre, in ou post, imprima os números armazenados na árvore, na ordem em que foram visitados, separados por espaço.

37 24 7 2 32 42 40 42 120

2 7 24 32 37 40 42 42 120

2 7 32 24 40 120 42 42 37

## SLIDE PARA ESTUDO 
https://drive.google.com/file/d/1aWAwg4-rgJuKCEVDH9tWLV9-hi3wIr3v/view
