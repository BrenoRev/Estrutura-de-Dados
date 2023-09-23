Seja G um grafo dirigido ponderado e s um vértice de G, encontre os caminhos de menor custo a partir de s para todos os vértices do G (incluindo s).

Input Specification

A entrada consiste em múltiplos casos. A entrada inicia com um número inteiro c > 0, que indica a quantidade de casos. Cada caso inicia com dois números (0 < v <= 20000) e a >= 0. O primeiro número indica a quantidade de vértices do grafo. O segundo número indica a quantidade de arestas do grafo. As próximas a-linhas informam as arestas do grafo. Em cada uma das próximas a-linhas, têm-se três números 0 <= i, j < v e 0 < w <= 100 indicando uma aresta dirigida do vértice i para o vértice j com peso (custo) w. No final de cada caso, tem-se um número 0 <= s < v, que indica a origem dos caminhos de menor custo.

Output Specification

Para cada caso, imprima o cabeçalho “Caso k”, onde 1 <= k <= c. Em cada caso, imprima o custo dos menores caminhos a partir de s para todos os vértices do G (incluindo s), em ordem crescente dos vértices (ou seja, o custo do menor caminho de s para o vértice 0, depois o custo do menor caminho de s para o vértice 1 e assim por diante). Se não for possível chegar em um vértice a partir de s, imprima -1. O tipo inteiro (32 bits) tem precisão suficiente para armazenar o custo de cada menor caminho a partir de s.

Time Limit

1 second

Memory Limit

768 MB

Output Limit

4 MB

Sample Input

2

5 7

0 1 10

0 2 3

0 3 20

1 3 5

2 1 2

2 4 15

3 4 11

0

6 22

0 1 2

1 0 2

0 2 13

2 0 13

0 3 1

3 0 1

0 5 4

5 0 4

1 2 13

2 1 13

1 3 4

3 1 4

2 3 8

3 2 8

2 4 4

4 2 4

2 5 14

5 2 14

3 4 3

4 3 3

4 5 2

5 4 2

2

Sample Output

Caso 1

0

5

3

10

18

Caso 2

8

10

0

7

4

6