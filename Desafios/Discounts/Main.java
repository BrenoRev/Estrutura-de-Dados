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

        int quantityOfChocolates = scanner.nextInt();
        long chocolatesPrice[] = new long[quantityOfChocolates];
        long sum = 0;
        for (int index = 0; index < chocolatesPrice.length; index++) {
            chocolatesPrice[index] = scanner.nextLong();
            sum += chocolatesPrice[index];
        }

        quickSort(chocolatesPrice,0,chocolatesPrice.length-1);

        long coupons = scanner.nextLong();
        for (int index = 0; index < coupons; index++) {
            int couponIndex = scanner.nextInt();
            System.out.println(sum - chocolatesPrice[quantityOfChocolates - couponIndex]);
        }

    }

    private static void quickSort(long[] vetor, int inicio, int fim) {
        if (inicio < fim) {
               int posicaoPivo = separar(vetor, inicio, fim);
               quickSort(vetor, inicio, posicaoPivo - 1);
               quickSort(vetor, posicaoPivo + 1, fim);
        }
  }

  private static int separar(long[] vetor, int inicio, int fim) {
        long pivo = vetor[inicio];
        int index = inicio + 1, end = fim;
        while (index <= end) {
               if (vetor[index] <= pivo)
                      index++;
               else if (pivo < vetor[end])
                      end--;
               else {
                      long troca = vetor[index];
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