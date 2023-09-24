import java.io.*;
import java.util.StringTokenizer;

public class Main {
        // Coded By
        // Breno Silva

    public static void main(String[] args) {
        FastReader in = new FastReader();
        StringBuilder out = new StringBuilder();
        BFrog solver = new BFrog();
        solver.solve(in, out);
        System.out.print(out);
    }

    static class BFrog {
        int n;
        int k;
        int[] height;

        public void solve(FastReader in, StringBuilder out) {
            n = in.nextInt();
            k = in.nextInt();
            height = new int[n];
            for (int i = 0; i < n; i++) {
                height[i] = in.nextInt();
            }

            int[] dp = new int[n];
            dp[0] = 0;
            
            for (int i = 1; i < n; i++) {
                int min_value = Integer.MAX_VALUE;
                for (int j = i - 1; j >= Math.max(0, i - k); j--) {
                    min_value = Math.min(min_value, dp[j] + Math.abs(height[j] - height[i]));
                }
                dp[i] = min_value;
            }
            out.append(dp[n - 1]).append("\n");
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
    }
}
