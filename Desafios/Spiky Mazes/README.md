Jarmtin is interested in cultures and the history behind them. Of course this interest has a reason: as he studies the choivans' past he discovers the hidden entrances of mazes he knows contain valuable information. However there is a catch: the mazes contain spiky traps! Jarmtin is quite the agile type, but there is a limit to everyone, thus he will only be able to avoid a number of traps. This motivates the question can he make it through the mazes?

Input

The first line of a test case contains three integers n, m and j. n (2<=n<=40) the number of rows, m (2<=n<=40) the width of each row and j (0<=j<=20) the number of times Jarmtin can avoid spikes. Then n lines containing m characters; The character 'x' will be used for the place of the treasure, '@' for an entrance (which is also an exit), '#' for walls, '.' for a safe walking tile and 's' for spikes. Note that you cannot walk into walls and the maze is completely surrounded by walls outside what you can see. There is always at least one entrance/exit and always an x where the treasure is.

Output
You should output "SUCCESS" if Jarmtin can make it in and out alive, and "IMPOSSIBLE" if there is no way you can make it out alive.

Sample Input / Output

Example 1:

Input:

3 3 2

#@#

#s#

#x#

Output:

SUCCESS

Example 2:

Input:

4 4 3

####

@.s#

##.#

#xs#

Output:

IMPOSSIBLE