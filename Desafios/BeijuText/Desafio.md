Broken Keyboard (a.k.a. Beiju Text)
https://www.eolymp.com/en/problems/2048/statistics

You’re typing a long text with a broken keyboard. Well it’s not so badly broken. The only problem
with the keyboard is that sometimes the “home” key or the “end” key gets automatically pressed
(internally).
You’re not aware of this issue, since you’re focusing on the text and did not even turn on the
monitor! After you finished typing, you can see a text on the screen (if you turn on the monitor).
In Chinese, we can call it Beiju. Your task is to find the Beiju text.
Input
There are several test cases. Each test case is a single line containing at least one and at most 100,000
letters, underscores and two special characters ‘[’ and ‘]’. ‘[’ means the “Home” key is pressed
internally, and ‘]’ means the “End” key is pressed internally. The input is terminated by end-of-file
(EOF).
Output
For each case, print the Beiju text on the screen.
Sample Input
This_is_a_[Beiju]_text
[[]][][]Happy_Birthday_to_Tsinghua_University
Sample Output
BeijuThis_is_a__text
Happy_Birthday_to_Tsinghua_University