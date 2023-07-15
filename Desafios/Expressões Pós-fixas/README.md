## Expressões Pós-fixas

Ao representar expressões na notação pós-fixa, os operadores aparecem após os operandos. Por exemplo, a expressão infixa 3 + (4 * 2) é equivalente à expressão pós-fixa 3 4 2 * +. Já a expressão infixa (3 + 4) * 2 é equivalente à expressão pós-fixa 3 4 + 2 *.

A avaliação de uma expressão em notação pós-fixa pode ser realizada com o apoio de uma pilha. Os elementos da expressão são processados da esquerda para a direita. Ao encontrar um operando, esse é empilhado (push). Ao encontrar um operador binário, os dois elementos do topo da pilha são retirados (ou seja, são realizados dois pops), realiza-se a operação em questão sobre os dois valores retirados da pilha e, por fim, coloca-se na pilha o resultado da operação.

Por exemplo, ao avaliar a expressão 3 4 2 * +, as seguintes operações são realizadas em sequência: push(s,3); push(s,4); push(s,2); v2 = pop(s); v1 = pop(s); push(s,v1*v2); v2 = pop(s); v1 = pop(s); push(s,v1+v2); onde s representa a pilha, e v1 e v2 são variáveis auxiliares para salvar o valor dos operandos retirados da pilha.
Input Specification
A entrada consiste em múltiplas expressões em notação pós-fixa, uma por linha. Todas as expressões são bem formadas. Em cada expressão, os operandos e operadores são separados por espaços. Os operandos são números inteiros. Os operadores são +, - ou * e todos são binários (atuam sobre dois operandos). O final de uma expressão é representado pela string “END”. O final da entrada é representado pela string “EOF”.
Output Specification
Para cada expressão, imprima o valor resultante da sua avaliação. O tipo inteiro (32 bits) tem precisão suficiente para armazenar o resultado da avaliação de qualquer expressão da entrada.

Notes:

Em C/C++, declare a main retornando "int". Considere usar a função int strcmp (const char* str1, const char* str2); para comparar strings. Essa função retorna 0 se ambas as strings forem iguais e está declarada no arquivo string.h. Considere usar a função int atoi(const char *str); para converter strings em inteiros. Essa função está declarada no arquivo stdlib.h. Veja o exemplo abaixo, que imprime o valor -20 na saída padrão. #include <stdio.h> #include <stdlib.h> int main() { int v1 = atoi("-10"); int v2 = atoi("2"); printf("%d\n", v1*v2); return 0; }

Sample Input #1

    1  = 3 4 2 * + END

    2  = 3 4 + 2 * END

    3  = 3 4 2 * - END

    4  = 3 4 - 2 * END

    5  = -10 -2 * -10 - END

    6  = EOF

Sample Output #1

    1 = 11

    2 = 14

    3 = -5

    4 = -2

    5 = 30

Time Limit

    1 second

Memory Limit

    768 MB

Output Limit

    4 MB