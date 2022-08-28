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
        BST<Integer, Integer> avlTree = new BST<Integer, Integer>();

        int operations = reader.nextInt();

        for(int index = 0; index < operations; index++) {
            int command = reader.nextInt();
            if(command == 1){
                int value = reader.nextInt();
                avlTree.insert(avlTree, value, value);
            }
            else if(command == 2){
                int findKey = reader.nextInt();
                Integer result = avlTree.find(avlTree, findKey);
                if(result == null) {
                    System.out.println("Data tidak ada");
                }
                else {
                    System.out.println(result);
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