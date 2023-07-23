Implemente o tipo abstrato de dados Dicionário utilizando tabelas de dispersão. A tabela tem tamanho m e a função hash é a seguinte: h(k) = k − (m * floor(k/m)), onde o símbolo / denota a divisão entre números reais e floor denota a função piso. A política de resolução de colisões é baseada em pseudo-random probing, conforme p(k,i) = perm[i-1], onde perm é o array de permutações.

Input Specification

A entrada consiste em múltiplos casos. Cada caso inicia com um inteiro m >= 0 (exceto o valor 1). O valor m = 0 representa o final da entrada. Nos casos onde m > 1, inicialmente, são apresentados (m-1) números, separados por espaço, referentes ao array perm; ou seja, uma permutação dos valores compreendidos entre [1, m-1]. Em seguida, tem-se um valor inteiro n > 0, indicando que o caso consiste em realizar n operações. As operações possíveis são: inserção (add key value) e busca (find key); key e value são números inteiros. Ao tentar inserir uma entrada em um dicionário cheio (todas as posições da tabela de dispersão estiverem ocupadas), não faça nada. Ao tentar inserir uma entrada indexada por uma chave key já existente no dicionário, não faça nada.

Output Specification

Para cada operação de busca (find key), imprima o índice da tabela de dispersão no qual se encontra key. Se não existir no dicionário um valor indexado por key, imprima -1.

Time Limit
1 second

Memory Limit
768 MB

Output Limit
4 MB

Sample Input:

    7
    3 4 1 6 2 5
    19
    add 10 5
    add -7 -3
    add 3 1
    add -5 -2
    add 5 2
    add -8 -4
    find 10
    find -7
    find 3
    find -5
    find 5
    find -8
    find 100
    add 100 50
    find 100
    add 10 6
    find 10
    add 200 100
    find 200
    0

Sample Output:

    3
    0
    6
    2
    5
    1
    -1
    4
    3
    -1