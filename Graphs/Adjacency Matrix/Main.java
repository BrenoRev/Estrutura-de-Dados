import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    // coded by
    // Breno Silva
    public static void main(String[] args) {
        FastReader scanner = new FastReader();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Graph graph = new Graph(m);

        for( int i = 0; i< n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            graph.setEdge(x, y, i);
        }

        Stack<Integer> stack = new Stack<>();
        graph.topologicalSort(0, stack);
        for(int i = 0; i < stack.capacity(); i++) {
            System.out.println(stack.pop());
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
