package Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        // coded by
        // Breno Silva

        FastReader reader = new FastReader();
        BST<Integer, Integer> map = new BST<Integer, Integer>();

            int operations = reader.nextInt();
            for(int indexJ = 0; indexJ < operations; indexJ++) {
                String input = reader.next();
                if(input.equals("insert")) {
                    int value = reader.nextInt();
                    map.insert(map, map.getNodeCount(), value);
                } else if(input.equals("pre")) {
                    map.preOrder(map.getRoot());
                }
                else if(input.equals("in")) {
                    map.inOrder(map.getRoot());
                } else if(input.equals("post")) {
                    map.postOrder(map.getRoot());
                }
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