### QUESTÃO 1
Implemente um grafo não-dirigido e não-ponderado utilizando uma matriz de adjacências.

ENTRADA

A primeira linha da entrada contém os inteiros n (1 ≤ n ≤ 500) e q (1 ≤ q ≤ 105), a quantidade de vértices do grafo e o número de operações que devem ser realizadas sobre o grafo. Cada uma das próximas q linhas contém um comando que pode ser de três tipos:

add u v -- insira uma aresta entre os vértices u e v (0 ≤ u, v < n). Lembre que o grafo não é dirigido.

BSF v -- percorra o grafo em largura, iniciando a busca no vértice v (0 ≤ v < n). Dado um vértice arbitrário u, lembre de considerar os vértices alcançáveis a partir de u em ordem numérica crescente.

DFS v - percorra o grafo em profundidade, iniciando a busca no vértice v (0 ≤ v < n). Dado um vértice arbitrário u, lembre de considerar os vértices alcançáveis a partir de u em ordem numérica crescente.

5 8

add 0 1

add 1 3

add 0 3

add 3 4

add 3 2

add 2 4

BFS 0

DFS 3

SAÍDA

Para cada comando do tipo BFS ou DFS, imprima todos os vértices do grafo, na ordem em que foram visitados durante a travessia.

0 1 3 2 4

3 0 1 2 4

### QUESTÃO 2

Dado um grafo acíclico, dirigido e não-ponderado, encontre uma ordenação topológica para ele, utilizando o algoritmo toposort. Implemente o grafo como uma lista de adjacências.

ENTRADA

A primeira linha de entrada contém os inteiros n (1 ≤ n ≤ 500) e m (1 ≤ m ≤ 105), o número de vértices e o número de arestas do grafo. As próximas m linhas contêm, cada uma, os inteiros u e v (0 ≤ u, v < n), indicando que existe uma aresta entre os vértices u e v.

7 8

0 1

0 2

1 3

1 4

1 5

2 3

3 4

4 6

SAÍDA

Imprima uma linha com todos os vértices do grafo separados por espaço. A ordem dos vértices na saída deve corresponder a uma ordenação topológica do grafo da entrada.

0 2 1 5 3 4 6
