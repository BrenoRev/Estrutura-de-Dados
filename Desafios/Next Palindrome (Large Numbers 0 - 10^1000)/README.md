The principle is pretty simple:

Given a integer (n)

Find the next palindromic number after (excluding) n

Implement this in the function nextPalin

However, due to some constraints, the implementation is not:

0 < n < 10^1000

0 < t < 0.175s

A.K.A

n is between 1 and 1001 digits

total time for all test cases should be less than 0.175s (175ms)

This means that you cannot do:

    def next_palin(n):
      while not is_palin(n): #is_palin() defined elsewhere
        n += 1
      return n


For example:

12345 -> 12421

11 -> 22

134 -> 141

9876543219123456789 -> 9876543220223456789

There are 322 test cases (excluding time constraint, which is not included in assertion), so optimization is very important