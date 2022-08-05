import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // coded by
    // Breno Silva
    public static void main(String[] args)
            throws IOException {

        FastReader scanner = new FastReader();

        int quantityOfInputs = scanner.nextInt();
        int differenceNumber = scanner.nextInt();

        int numbers[] = new int[quantityOfInputs];

        for (int index = 0; index < quantityOfInputs; index++) {
            numbers[index] = scanner.nextInt();
        }

        quickSort(numbers, 0, numbers.length - 1);

        int output = 0;
        for (int index = 0; index < quantityOfInputs; index++) {
            if(binarySearch(numbers, numbers[index] - differenceNumber , 0, numbers.length - 1)){
                output++;
            }
        }

        System.out.println(output);
    }

    private static void quickSort(int[] vetor, int inicio, int fim) {
        if (inicio < fim) {
               int posicaoPivo = separar(vetor, inicio, fim);
               quickSort(vetor, inicio, posicaoPivo - 1);
               quickSort(vetor, posicaoPivo + 1, fim);
        }
  }

  private static int separar(int[] vetor, int inicio, int fim) {
        int pivo = vetor[inicio];
        int index = inicio + 1, end = fim;
        while (index <= end) {
               if (vetor[index] <= pivo)
                      index++;
               else if (pivo < vetor[end])
                      end--;
               else {
                      int troca = vetor[index];
                      vetor[index] = vetor[end];
                      vetor[end] = troca;
                      index++;
                      end--;
               }
        }
        vetor[inicio] = vetor[end];
        vetor[end] = pivo;
        return end;
  }

    public static boolean binarySearch(int[] sortedArray, int key, int low, int high) {
        int middle = low + ((high - low) / 2);

        if (high < low) {
            return false;
        }

        if (key == sortedArray[middle]) {
            return true;
        } else if (key < sortedArray[middle]) {
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
