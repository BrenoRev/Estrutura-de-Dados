https://vjudge.net/contest/515456#problem/A

A - Contestants Ranking Gym - 100952F 

Ahmad is one of the best students in HIAST, and also a very good problems Solver. In the time you will spend reading this problem statement Ahmad would have solved a problem. Maybe, even two... Ahmad participated so many times in programming contest (ACM-HCPC) with several teams. many of the former and present contestants at HIAST have known Ahmad for quite a few years. Some of them are proud to say that they either played in the same team with him or played in the same team with one of his teammates... Let us define ranking number as follows. Ahmad's ranking is 0, for people who played in the same team with him, the ranking is 1. For people who never played with Ahmad but played in the same team with one or more of his teammates, the ranking is 2, and so on. Your task is to automate the process of calculating the ranking numbers for each contestant at HIAST.

Input

<hr>

The first line of input file contains the number of test cases (0<T<10). Each test case will begin with one line containing the number of teams (1<N ≤ 100). In each of the following N lines you are given the names of the three members of the corresponding team. Each name is a nonempty string contains only English letters starts with capital letter, and its length is at most 20 symbols. Same student can be found in more than one team, but each student should have only one rank. Ahmad will be found in one team at least. The first letter of a name is capital and the other letters are lowercase and each name will consist of only one word.

Output

<hr>

For each test case output a line with the number of contestants, then for each contestant output a line with his name and his ranking. If the ranking is undefined, output “undefined” instead of it. The contestants must be ordered by rank from 0 to undefined and then lexicographical by name.

Example 1

Input:

2

1

Ahmad Mousaab Khalid

7

Ahmad Mousaab Khalid

Ali Mousaab Nizar

Ali Bassel Nizar

Kassem Ahmad Mousaab

Saeed Kassem Fadel

Salwa Saeed Samer

Mona Abdo Qussi


<hr>

Output:

3

Ahmad 0

Khalid 1

Mousaab 1

14

Ahmad 0

Kassem 1

Khalid 1

Mousaab 1

Ali 2

Fadel 2

Nizar 2

Saeed 2

Bassel 3

Salwa 3

Samer 3

Abdo undefined

Mona undefined

Qussi undefined