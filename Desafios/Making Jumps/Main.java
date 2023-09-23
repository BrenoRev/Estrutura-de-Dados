import java.io.*;
import java.util.*;

public class Main {
    // Coded By
    // Breno Silva

    private static final int[] KNIGHT_MOVES_X = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static final int[] KNIGHT_MOVES_Y = {-1, 1, -2, 2, -2, 2, -1, 1};

    private static int[][] board;
    private static int[][] visited;
    private static int totalSquares;
    private static int visitedCount;
    private static int boardSize;
    private static int maxVisited;

    public static void main(String[] args) {
        FastReader fastReader = new FastReader();
        int testCase = 0;

        while (true) {
            testCase++;
            boardSize = fastReader.nextInt();
            if (boardSize == 0) break;

            initializeBoardAndVariables(fastReader);

            exploreKnightMovements(0, board[0][0]);

            printResults(testCase);
        }
    }

    private static void initializeBoardAndVariables(FastReader fastReader) {
        board = new int[boardSize][2];
        totalSquares = 0;
        visitedCount = 0;
        maxVisited = Integer.MIN_VALUE;

        int maxY = Integer.MIN_VALUE;

        for (int i = 0; i < boardSize; i++) {
            int startX = fastReader.nextInt();
            int numberOfSquares = fastReader.nextInt();

            board[i][0] = startX;
            board[i][1] = startX + numberOfSquares - 1;

            totalSquares += numberOfSquares;

            if (startX + numberOfSquares > maxY) maxY = startX + numberOfSquares;
        }
        visited = new int[boardSize][maxY];
    }

    private static void exploreKnightMovements(int x, int y) {
        visited[x][y] = 1;
        visitedCount++;

        if (visitedCount > maxVisited) maxVisited = visitedCount;

        for (int i = 0; i < 8; i++) {
            int newX = x + KNIGHT_MOVES_X[i];
            int newY = y + KNIGHT_MOVES_Y[i];

            if (isValidMove(newX, newY)) {
                exploreKnightMovements(newX, newY);
            }
        }

        visited[x][y] = 0;
        visitedCount--;
    }

    private static boolean isValidMove(int x, int y) {
        return x >= 0 && x < boardSize &&
                y >= board[x][0] && y <= board[x][1] &&
                visited[x][y] == 0;
    }

    private static void printResults(int testCase) {
        int unreachableSquares = totalSquares - maxVisited;
        if (unreachableSquares == 1) {
            System.out.println("Case " + testCase + ", " + unreachableSquares + " square can not be reached.");
        } else {
            System.out.println("Case " + testCase + ", " + unreachableSquares + " squares can not be reached.");
        }
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
