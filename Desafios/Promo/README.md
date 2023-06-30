https://vjudge.net/problem/CodeForces-1697B

The store sells 𝑛 items, the price of the 𝑖-th item is 𝑝𝑖. The store's management is going to hold a promotion: if a customer purchases at least 𝑥 items, 𝑦 cheapest of them are free.

The management has not yet decided on the exact values of 𝑥 and 𝑦. Therefore, they ask you to process 𝑞 queries: for the given values of 𝑥 and 𝑦, determine the maximum total value of items received for free if a customer makes one purchase.

Note that all queries are independent; they don't affect the store's stock.

Input:
The first line contains two integers 𝑛 and 𝑞 (1 ≤ 𝑛, 𝑞 ≤ 2 * 10^5) — the number of items in the store and the number of queries, respectively.

The second line contains 𝑛 integers 𝑝₁, 𝑝₂, ..., 𝑝𝑛 (1 ≤ 𝑝𝑖 ≤ 10^6), where 𝑝𝑖 — the price of the 𝑖-th item.

The following 𝑞 lines contain two integers 𝑥𝑖 and 𝑦𝑖 each (1 ≤ 𝑦𝑖 ≤ 𝑥𝑖 ≤ 𝑛) — the values of the parameters 𝑥 and 𝑦 in the 𝑖-th query.

Output:
For each query, print a single integer — the maximum total value of items received for free for one purchase.

Note: In the first query, a customer can buy three items worth 5, 3, 5. The two cheapest of them are 3 + 5 = 8.

In the second query, a customer can buy two items worth 5 and 5. The cheapest of them is 5.

In the third query, a customer has to buy all the items to receive the three cheapest of them for free. Their total price is 1 + 2 + 3 = 6.

Inputs:
5 3
5 3 1 5 2
3 2
1 1
5 3

Outputs: 
8
5
6