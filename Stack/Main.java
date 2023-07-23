package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // coded by
    // Breno Silva

    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        Stack<Integer> stack = new Stack();
        int cases = scanner.nextInt();
        for (int i = 0; i < cases; i++) {
            String entrada = scanner.next();
            do {
                if (entrada.equals("push")) {
                    int value = scanner.nextInt();
                    stack.push(value);
                } else if (entrada.equals("pop")) {
                    int value = scanner.nextInt();
                    int sum = 0;
                    if (value <= stack.length()) {
                        for (int j = 0; j < value; j++) {
                            sum += stack.pop();
                        }
                    }
                    System.out.println(sum);
                }
                entrada = scanner.next();
            } while (!(entrada.equals("end")));
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
