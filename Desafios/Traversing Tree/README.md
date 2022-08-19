https://www.spoj.com/problems/TREEVERSE/

Because you just finished your course in Binary Search Tree, your teacher gave you a very simple problem.

First, you are given some data and you should insert them to a binary search tree. Datas that are smaller than the current node go to the left sub-tree. Otherwise, they go to the right sub-tree.

Then, you should print all data in the tree by traversing it pre-orderly, in-orderly, and post-orderly.

Input

First line contains a number n (0 < n <= 100).

Second line contains n datas pi (0 < pi <= 50000) that have to be inserted into the tree.

Output
Output consists of 3 lines.

First line starts with 'Pre order :' and is continued by printing the data pre-orderly.

Second line starts with 'In order  :' and is continued by printing the data in-orderly.

Third line starts with 'Post order:' and is continued by printing the data post-orderly.

Example

Input:
<hr>
7

5 3 7 2 4 6 8
<hr>

Output:
<hr>
Pre order : 5 3 2 4 7 6 8

In order  : 2 3 4 5 6 7 8

Post order: 2 4 3 6 8 7 5
<hr>

Warning!

There is 1 space right after 'Pre order'.

There are 2 spaces right after 'In order'.

There is no space right after 'Post order'.

There is no space (enter immediately) right after the last number is printed.