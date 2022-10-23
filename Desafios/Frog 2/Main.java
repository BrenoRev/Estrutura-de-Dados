import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.util.InputMismatchException;
import java.util.OptionalInt;
import java.io.Writer;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) {
        // Coded By
        // Breno
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        OutputWriter out = new OutputWriter(outputStream);
        BFrog2 solver = new BFrog2();
        solver.solve(1, in, out);
        out.close();
    }

    static class BFrog2 {
        int n;
        int k;
        int[] height;
        OutputWriter out;

        public void solve(int testNumber, InputReader in, OutputWriter out) {
            n = in.readInt();
            k = in.readInt();
            height = in.readIntArray(n);
            this.out = out;
            solution();
        }

        private void solution() {
            int dp[] = new int[n];
            dp[0] = 0;
            for (int i = 1; i < n; i++) {
                int min_value = Integer.MAX_VALUE;
                for (int j = i - 1; (j >= i - k) && (j >= 0); j--) {
                    min_value = min(min_value, dp[j] + abs(height[j] - height[i]));
                }
                dp[i] = min_value;
            }
            out.printLine(dp[n - 1]);
        }

        int min(int... ar) {
            OptionalInt val = Arrays.stream(ar).min();
            return val.isPresent() ? val.getAsInt() : Integer.MAX_VALUE;
        }

        int abs(int a) {
            return Math.abs(a);
        }

    }

    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private InputReader.SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int[] readIntArray(int size) {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = readInt();
            }
            return array;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buf[curChar++];
        }

        public int readInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public boolean isSpaceChar(int c) {
            if (filter != null) {
                return filter.isSpaceChar(c);
            }
            return isWhitespace(c);
        }

        public static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);

        }

    }

    static class OutputWriter {
        private final PrintWriter writer;

        public OutputWriter(OutputStream outputStream) {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }

        public OutputWriter(Writer writer) {
            this.writer = new PrintWriter(writer);
        }

        public void close() {
            writer.close();
        }

        public void printLine(int i) {
            writer.println(i);
        }

    }
}