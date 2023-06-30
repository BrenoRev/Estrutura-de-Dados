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

        int[] numbers = new int[quantityOfInputs];

        for (int index = 0; index < quantityOfInputs; index++) {
            numbers[index] = scanner.nextInt();
        }

        quickSort(numbers, 0, numbers.length - 1);

        for (int index = 0; index < numbers.length; index++) {
            System.out.println(numbers[index]);
        }
    }

    private static void quickSort(int[] numeros, int inicio, int fim) {
        if (inicio < fim) {
            int posicaoPivo = partition(numeros, inicio, fim);
            if (posicaoPivo - inicio < fim - posicaoPivo) {
                quickSort(numeros, inicio, posicaoPivo - 1);
                quickSort(numeros, posicaoPivo + 1, fim);
            } else {
                quickSort(numeros, posicaoPivo + 1, fim);
                quickSort(numeros, inicio, posicaoPivo - 1);
            }
        }
    }

    private static int partition(int[] numeros, int inicio, int fim) {
        int pivo = numeros[inicio];
        int i = inicio + 1;
        int j = fim;

        while (true) {
            while (i <= j && numeros[i] <= pivo) {
                i++;
            }
            while (i <= j && numeros[j] >= pivo) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(numeros, i, j);
        }

        swap(numeros, inicio, j);
        return j;
    }

    private static void swap(int[] numeros, int i, int j) {
        int temp = numeros[i];
        numeros[i] = numeros[j];
        numeros[j] = temp;
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
