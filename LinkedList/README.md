Implemente uma lista ligada de inteiros, conforme apresentado no livro de Shaffer e durante a aula.

ENTRADA

A entrada consiste de vários casos. A primeira linha contém c (1 ≤ c ≤ 10), o número de casos.

A seguir, tem-se c casos. A primeira linha de cada caso contém n (1 ≤ n ≤ 103), o número de operações a serem realizadas sobre a lista. Ao iniciar cada caso, a lista deve estar vazia. As próximas n linhas consistem em comandos de 3 tipos:

insert x – insira x (1 ≤ x ≤ 109) na lista, de acordo com o cursor.

remove – remova um elemento da lista, de acordo com o cursor. 

count x – conte o número de elementos iguais a x (1 ≤ x ≤ 109) na lista.

prev – move o cursor para uma posição à esquerda da lista.

next – move o cursor para uma posição à direita da lista.

<hr>

1

14

insert 2

insert 5

insert 2

insert 1

count 2

next

remove

count 2

remove

count 5

next

next

remove

count 1

<hr>

SAÍDA

A primeira linha de saı́da de cada caso deve ser “Caso n:” (sem aspas), onde n é o número do caso, começando de 1. Em seguida, para cada comando do tipo “count x”, imprima uma linha com o número de elementos iguais a x que estão na lista.

Caso 1:
2
1
0
1

## SLIDE PARA ESTUDO 
https://drive.google.com/file/d/1YEaJjmNIwypixPUME3Pxja-f_5c5NUih/view
