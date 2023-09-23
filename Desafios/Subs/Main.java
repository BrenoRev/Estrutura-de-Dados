import java.io.*;
import java.util.*;

public class Main {
    // Coded by
    // Breno Silva

    static int[] elementos;
    static int quantidadeElementos, somaDesejada, contadorSubconjuntos;

    public static void main(String[] args) {
        FastReader leitor = new FastReader();
        StringBuilder saida = new StringBuilder();

        int quantidadeCasos = leitor.nextInt();

        for (int casoAtual = 0; casoAtual < quantidadeCasos; casoAtual++) {
            quantidadeElementos = leitor.nextInt();
            elementos = new int[quantidadeElementos];

            for (int i = 0; i < quantidadeElementos; i++) {
                elementos[i] = leitor.nextInt();
            }

            somaDesejada = leitor.nextInt();
            contadorSubconjuntos = 0;

            explorarSubconjuntos(0, 0);

            saida.append(contadorSubconjuntos).append("\n");
        }
        System.out.print(saida);
    }

    public static void explorarSubconjuntos(int indiceAtual, int somaAtual) {
        if (somaAtual == somaDesejada) {
            contadorSubconjuntos++;
            return;
        }

        if (indiceAtual == quantidadeElementos || somaAtual > somaDesejada) {
            return;
        }

        explorarSubconjuntos(indiceAtual + 1, somaAtual + elementos[indiceAtual]);

        explorarSubconjuntos(indiceAtual + 1, somaAtual);
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
