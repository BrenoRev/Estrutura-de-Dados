https://vjudge.net/problem/AtCoder-dp_b

There are NN stones, numbered 1, 2, \ldots, N1,2,…,N. For each ii (1 <= i <= N1≤i≤N), the height of Stone ii is h_ih 
i
​
 .

There is a frog who is initially on Stone 11. He will repeat the following action some number of times to reach Stone NN:

If the frog is currently on Stone ii, jump to one of the following: Stone i + 1, i + 2, \ldots, i + Ki+1,i+2,…,i+K. Here, a cost of |h_i - h_j|∣h 
i
​
 −h 
j
​
 ∣ is incurred, where jj is the stone to land on.
Find the minimum possible total cost incurred before the frog reaches Stone NN.

Constraints

All values in input are integers.

2 <= N <= 10^52≤N≤10 

5
 
1 <= K <= 10^5

1 <= K <= 100

1 <= K <= 10^4

INPUT

Input is given from Standard Input in the following format:

N K

​h1 h2 ...hn

​
OUTPUT

Print the minimum possible total cost incurred.

5 3

10 30 40 50 20

30

If we follow the path 11 → 22 → 55, the total cost incurred would be |10 - 30| + |30 - 20| = 30∣10−30∣+∣30−20∣=30.