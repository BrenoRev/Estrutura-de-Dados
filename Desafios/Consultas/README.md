Dado um conjunto de nomes, use busca binária para consultar se um nome faz parte do conjunto.

Input Specification

A primeira linha da entrada contém o número 0 < t <= 100.000 que indica o tamanho do conjunto. Em cada uma das próximas t linhas, tem-se um nome n (0 < |n| <= 30 letras minúsculas, sem espaço). Os nomes são únicos e são listados em ordem alfabética (lexicográfica). Após listar t nomes, a entrada contém o número 0 < q <= 100.000 de consultas. Em cada uma das próximas q linhas, tem-se um nome n (0 < |n| <= 30 letras minúsculas, sem espaço).

Output Specification

Para cada consulta, imprima “+” se o nome em questão pertencer ao conjunto. Imprima “-”, caso contrário.
Notes

Em C/C++, declare a main retornando "int". Em C/C++, considere usar a função int strcmp (const char* str1, const char* str2); para comparar strings. Esta função retorna um número negativo se a primeira string for menor (considerando uma ordem lexicográfica) do que a segunda, 0 se ambas as strings forem iguais, ou um número positivo se a primeira string for maior do que a segunda. Esta função é definida no arquivo string.h. Veja o exemplo abaixo. Ao executar este código, os valores -3, 3 e 0 são impressos na saída padrão, respectivamente. #include <stdio.h> #include <string.h> void main() { char nome1[] = "abc"; char nome2[] = "def"; printf("%d\n", strcmp(nome1, nome2)); printf("%d\n", strcmp(nome2, nome1)); printf("%d\n", strcmp(nome1, nome1)); }

Input

5
amanda
emanoel
gustavo
lucas
pedro
4
alexandre
pedro
gustaov
gustavo


Output

-
+
-
+


Time Limit
1 second
Memory Limit
768 MB
Output Limit
4 MB