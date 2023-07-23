package LinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        // coded by
        // Breno Silva

        FastReader reader = new FastReader();
        List<Integer> lista = new List<>();
        int cases = reader.nextInt();
        for (int index = 0; index < cases; index++) {
            int operations = reader.nextInt();
            for (int j = 0; j < operations; j++) {
                String input = reader.next();
                if (input.equals("insert")) {
                    int value = reader.nextInt();
                    lista.insert(value);
                } else if (input.equals("remove")) {
                    lista.remove();
                } else if (input.equals("prev")) {
                    lista.prev();
                } else if (input.equals("next")) {
                    lista.next();
                } else if (input.equals("count")) {
                    int value = reader.nextInt();
                    System.out.println(lista.countValues(value));
                }
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