import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Coded by
        // Breno Silva

        // FastReader da classe que o professor indicou para evitar memory leak
        FastReader scanner = new FastReader();
        StringBuilder stringBuilder = new StringBuilder();

        int quantidadeCasos = scanner.nextInt();

        for (int caso = 1; caso <= quantidadeCasos; caso++) {
            int v = scanner.nextInt();
            int a = scanner.nextInt();

            Grafo grafo = new Grafo(v);

            for (int i = 0; i < a; i++) {
                int origem = scanner.nextInt();
                int destino = scanner.nextInt();
                int peso = scanner.nextInt();
                grafo.adicionarAresta(origem, destino, peso);
            }

            int origem = scanner.nextInt();

            int[] distancias = grafo.dijkstra(origem);

            stringBuilder.append("Caso ").append(caso).append("\n");
            for (int i = 0; i < v; i++) {
                if (distancias[i] == Integer.MAX_VALUE) {
                    stringBuilder.append("-1").append("\n");
                } else {
                    stringBuilder.append(distancias[i]).append("\n");
                }
            }
        }

        //removeLastWhiteLineFromStringBuilder(stringBuilder);

        System.out.println(stringBuilder.toString().trim());
    }

    public static void removeLastWhiteLineFromStringBuilder(StringBuilder stringBuilder) {
        if (stringBuilder.length() > 0) {
            int lastNewlineIndex = stringBuilder.lastIndexOf("\n");
            stringBuilder.delete(lastNewlineIndex, stringBuilder.length());
        }
    }

    public static class Aresta {
        int destino;
        int peso;

        public Aresta(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }
    }

    public static class Grafo {
        private int numeroVertices;
        private List<List<Aresta>> adjacencias;

        public Grafo(int numeroVertices) {
            this.numeroVertices = numeroVertices;
            adjacencias = new ArrayList<>(numeroVertices);
            for (int i = 0; i < numeroVertices; i++) {
                adjacencias.add(new ArrayList<>());
            }
        }

        public void adicionarAresta(int origem, int destino, int peso) {
            adjacencias.get(origem).add(new Aresta(destino, peso));
        }

        public int[] dijkstra(int origem) {
            int[] distancias = new int[numeroVertices];
            boolean[] visitados = new boolean[numeroVertices];

            Arrays.fill(distancias, Integer.MAX_VALUE);
            distancias[origem] = 0;

            // Comparar por peso
            PriorityQueue<Aresta> filaPrioridade = new PriorityQueue<>(Comparator.comparingInt(a -> a.peso));

            filaPrioridade.add(new Aresta(origem, 0));

            while (!filaPrioridade.isEmpty()) {
                Aresta atual = filaPrioridade.poll();

                if (visitados[atual.destino]) continue;

                visitados[atual.destino] = true;

                for (Aresta vizinho : adjacencias.get(atual.destino)) {
                    if (distancias[vizinho.destino] > distancias[atual.destino] + vizinho.peso) {
                        distancias[vizinho.destino] = distancias[atual.destino] + vizinho.peso;
                        filaPrioridade.add(new Aresta(vizinho.destino, distancias[vizinho.destino]));
                    }
                }
            }

            return distancias;
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