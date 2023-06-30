import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// Coded by
// Breno
public class Main {
    public static void main(String[] args) {
        FastReader scanner = new FastReader();

        int quantityOfInputs = scanner.nextInt();

        String[] names = new String[quantityOfInputs];

        for(int index = 0; index < quantityOfInputs; index++) {
            names[index] = scanner.next();
        }

        int quantityOfConsults = scanner.nextInt();

        for(int index = 0; index < quantityOfConsults; index++) {
            String searchName = scanner.next();
            if(binarySearch(names, searchName, 0, names.length -1)) {
               System.out.println("+");
            } else {
                System.out.println("-");
            }
        }
    }

    public static boolean binarySearch(String[] sortedArray, String key, int low, int high) {
        int middle = low + ((high - low) / 2);

        if (high < low) {
            return false;
        }

        if (key.equals(sortedArray[middle])) {
            return true;
        } else if (key.compareTo(sortedArray[middle]) < 0) {
            return binarySearch(sortedArray, key, low, middle - 1);
        } else {
            return binarySearch(sortedArray, key, middle + 1, high);
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