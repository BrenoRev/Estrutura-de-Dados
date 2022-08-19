https://vjudge.net/problem/SPOJ-HASHIT

Your task is to calculate the result of the hashing process in a table of 101 elements, containing keys that are strings of length at most 15 letters (ASCII codes 'A',...,'z'). Implement the following operations:

find the index of the element defined by the key (ignore, if no such element),

insert a new key into the table (ignore insertion of the key that already exists),

delete a key from the table (without moving the others), by marking the position in table as empty (ignore non-existing keys in the table)

When performing find, insert and delete operations define the following function:

integer Hash(string key),

which for a string key=a1...an returns the value:

Hash(key)=h(key) mod 101, where

h(key)=19 *(ASCII(a1)*1+...+ASCII(an)*n).

Resolve collisions using the open addressing method, i.e. try to insert the key into the table at the first free position: (Hash(key)+j2+23*j) mod 101, for j=1,...,19. After examining of at least 20 table entries, we assume that the insert operation cannot be performed.

Input
<hr>
t [the number of test cases <= 100]

n1 [the number of operations (one per line)[<= 1000]

ADD:string

[or]

DEL:string [other test cases, without empty lines betwee series]
<hr>

Output
<hr>

For every test case you have to create a new table, insert or delete keys, and write to the output:

the number of keys in the table [first line]

index:key [sorted by indices]

Example

Input:

1

11

ADD:marsz

ADD:marsz

ADD:Dabrowski

ADD:z

ADD:ziemii

ADD:wloskiej

ADD:do

ADD:Polski

DEL:od

DEL:do

DEL:wloskiej
<hr>

Output:

5

34:Dabrowski

46:Polski

63:marsz

76:ziemii

96:z