https://vjudge.net/problem/SPOJ-HACKRNDM

You recently wrote a random number generator code for a web application and now you notice that some cracker has cracked it. It now gives numbers at a difference of some given value k more predominantly. You being a hacker decide to write a code that will take in n numbers as input and a value k and find the total number of pairs of numbers whose absolute difference is equal to k, in order to assist you in your random number generator testing.

NOTE: All values fit in the range of a signed integer, n, k>=1

Input
<hr>
1st line contains n & k.

2nd line contains n numbers of the set. All the n numbers are assured to be distinct.

<hr>

(Edited: n <= 10^5)

Output

One integer saying the no of pairs of numbers that have a diff k.

Example

Input:

<hr>
5 2

1 5 3 4 2
<hr>
Output:

3
