import java.io.*;
import java.util.*;

public class Main {

     // Coded by
     // Breno Silva

    private static char[][] grid;
    private static int numRows, numColumns;
    private static final int INFINITY = (int) 1e8;
    private static final int[] DIRECTION_X = {0, 1, 0, -1};
    private static final int[] DIRECTION_Y = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        FastReader reader = new FastReader();
        StringBuilder output = new StringBuilder();
        
        numRows = reader.nextInt();
        numColumns = reader.nextInt();
        int maxMovesAllowed = reader.nextInt();

        grid = new char[numRows][];
        int startX = 0, startY = 0, endX = 0, endY = 0;

        for (int i = 0; i < numRows; i++) {
            grid[i] = reader.next().toCharArray();
            for (int j = 0; j < numColumns; j++) {
                if (grid[i][j] == '@') {
                    startX = i;
                    startY = j;
                } else if (grid[i][j] == 'x') {
                    endX = i;
                    endY = j;
                }
            }
        }

        int movesRequired = calculateShortestPath(startX, startY, endX, endY) * 2;

        if (movesRequired <= maxMovesAllowed) {
            output.append("SUCCESS\n");
        } else {
            output.append("IMPOSSIBLE\n");
        }

        System.out.print(output);
    }

    private static boolean isValidCell(int x, int y) {
        return x >= 0 && x < numRows && y >= 0 && y < numColumns && grid[x][y] != '#';
    }

    private static int calculateShortestPath(int startX, int startY, int endX, int endY) {
        Deque<int[]> positionsQueue = new ArrayDeque<>();
        positionsQueue.addFirst(new int[] {startX, startY});
        
        int[][] distanceMatrix = new int[numRows][numColumns];
        for (int[] row : distanceMatrix) {
            Arrays.fill(row, INFINITY);
        }
        distanceMatrix[startX][startY] = 0;

        while (!positionsQueue.isEmpty()) {
            int[] currentPos = positionsQueue.pollFirst();
            int currentX = currentPos[0], currentY = currentPos[1];
            
            if (currentX == endX && currentY == endY) {
                return distanceMatrix[currentX][currentY];
            }

            for (int i = 0; i < 4; i++) {
                int newX = currentX + DIRECTION_X[i], newY = currentY + DIRECTION_Y[i];

                if (isValidCell(newX, newY)) {
                    int moveCost = (grid[newX][newY] == 's') ? 1 : 0;

                    if (distanceMatrix[newX][newY] > moveCost + distanceMatrix[currentX][currentY]) {
                        distanceMatrix[newX][newY] = distanceMatrix[currentX][currentY] + moveCost;
                        if (moveCost == 0) {
                            positionsQueue.addFirst(new int[] {newX, newY});
                        } else {
                            positionsQueue.addLast(new int[] {newX, newY});
                        }
                    }
                }
            }
        }

        return distanceMatrix[endX][endY];
    }

    static class FastReader {
        BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;

        public FastReader() {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
