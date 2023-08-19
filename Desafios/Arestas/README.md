Seja G um grafo dirigido não-ponderado, encontre a menor quantidade de arestas que separam dois vértices de G.

Input Specification

A entrada consiste em múltiplos casos. A entrada inicia com um número inteiro c > 0, que indica a quantidade de casos. Cada caso inicia com dois números v > 0 e a >= 0. O primeiro número indica a quantidade de vértices do grafo. O segundo número indica a quantidade de arestas do grafo. As próximas a-linhas informam as arestas do grafo. Em cada uma das próximas a-linhas, têm-se dois números 0 <= i, j < v, indicando uma aresta dirigida do vértice i para o vértice j. Em seguida, tem-se um número n > 0, que indica a quantidade de perguntas que serão feitas sobre o grafo em questão. Nas próximas n-linhas, têm-se dois números 0 <= s, t < v, que indicam a origem (source) e o destino (target) do caminho desejado, respectivamente.

Output Specification

Para cada caso, imprima o cabeçalho "Caso k", onde 1 <= k <= c. Em cada caso, para cada pergunta, imprima a menor quantidade de arestas que separam o vértice s do vértice t. Se não for possível chegar em t a partir de s, imprima -1.

Time Limit
1 second

Memory Limit
768 MB

Output Limit
4 MB

- Sample Input:

  
  2
  
  6 16
  
  0 2
  
  2 0
  
  0 4
  
  4 0
  
  2 1
  
  1 2
  
  2 3
  
  3 2
  
  2 5
  
  5 2
  
  1 5
  
  5 1
  
  3 5
  
  5 3
  
  4 5
  
  5 4
  
  2
  
  0 5
  
  5 0
  
  7 8
  
  0 1
  
  0 2
  
  1 5
  
  1 4
  
  1 3
  
  2 3
  
  3 4
  
  4 6
  
  4
  
  0 1
  
  0 5
  
  0 4
  
  0 6


- Sample Output:

  
  Caso 1
  
  2
  
  2
  
  Caso 2
  
  1
  
  2
  
  2
  
  3
