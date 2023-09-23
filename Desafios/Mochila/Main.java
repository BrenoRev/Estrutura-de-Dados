import java.io.*;
import java.util.*;

public class Main {
    // Coded by
    // Breno Silva

    public static void main(String[] args) {
        FastReader leitor = new FastReader();
        StringBuilder saida = new StringBuilder();

        int quantidadeCasos = leitor.nextInt();

        for (int casoAtual = 0; casoAtual < quantidadeCasos; casoAtual++) {
            int capacidadeMochila = leitor.nextInt();
            int quantidadeItens = leitor.nextInt();

            int[] pesos = new int[quantidadeItens];
            int[] valores = new int[quantidadeItens];

            for (int i = 0; i < quantidadeItens; i++) {
                pesos[i] = leitor.nextInt();
                valores[i] = leitor.nextInt();
            }

            saida.append(valorMaximoMochila(capacidadeMochila, pesos, valores, quantidadeItens)).append("\n");
        }

        System.out.print(saida);
    }

    public static int valorMaximoMochila(int capacidade, int pesos[], int valores[], int quantidadeItens) {
        int[][] tabela = new int[quantidadeItens + 1][capacidade + 1];

        for (int i = 0; i <= quantidadeItens; i++) {
            for (int w = 0; w <= capacidade; w++) {
                if (i == 0 || w == 0) {
                    tabela[i][w] = 0;
                } else if (pesos[i - 1] <= w) {
                    tabela[i][w] = Math.max(
                        valores[i - 1] + tabela[i - 1][w - pesos[i - 1]],
                        tabela[i - 1][w]);
                } else {
                    tabela[i][w] = tabela[i - 1][w];
                }
            }
        }

        return tabela[quantidadeItens][capacidade];
    }

static class FastReader {
        BufferedReader bufferLeitura;
        StringTokenizer tokenizer;

        public FastReader() {
            bufferLeitura = new BufferedReader(new InputStreamReader(System.in));
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                try {
                    tokenizer = new StringTokenizer(bufferLeitura.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }
    }
}