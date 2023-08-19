import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        // Coded by
        // Breno Silva

        StringBuilder stringBuilder = new StringBuilder();
        FastReader reader = new FastReader();

        int count = Integer.parseInt(reader.nextLine());

        for (int k = 1; k <= count; k++) {
            StringTokenizer stringTokenizer = new StringTokenizer(reader.nextLine());

            int vertice = Integer.parseInt(stringTokenizer.nextToken());
            int aresta = Integer.parseInt(stringTokenizer.nextToken());

            Grafo graph = new Grafo(vertice);

            for (int index = 0; index < aresta; index++) {
                stringTokenizer = new StringTokenizer(reader.nextLine());
                int from = Integer.parseInt(stringTokenizer.nextToken());
                int to = Integer.parseInt(stringTokenizer.nextToken());
                graph.adicionarVertice(from, to);
            }

            int n = Integer.parseInt(reader.nextLine());

            stringBuilder.append("Caso ").append(k).append("\n");

            for (int i = 0; i < n; i++) {
                stringTokenizer = new StringTokenizer(reader.nextLine());
                int s = Integer.parseInt(stringTokenizer.nextToken());
                int t = Integer.parseInt(stringTokenizer.nextToken());

                // Origem e igual a destino
                if (s == t) {
                    stringBuilder.append("0").append("\n");
                } else {
                    stringBuilder.append(graph.menorCaminho(s, t)).append("\n");
                }
            }
        }

        if (stringBuilder.length() > 0) {
            int lastNewlineIndex = stringBuilder.lastIndexOf("\n");
            stringBuilder.delete(lastNewlineIndex, stringBuilder.length());
        }

        System.out.println(stringBuilder);
    }

    static class Grafo {
        int vertice;
        List<Integer>[] listaAdjacencia;

        Grafo(int vertice) {
            if (vertice <= 0)
                throw new IllegalArgumentException("Numero de vertices tem que ser positivo");
            this.vertice = vertice;
            this.listaAdjacencia = new ArrayList[vertice];
            for (int i = 0; i < vertice; i++) {
                this.listaAdjacencia[i] = new ArrayList<>();
            }
        }

        void adicionarVertice(int inputVertice, int weight) {
            if (inputVertice < 0 || inputVertice >= vertice || weight < 0 || weight >= vertice)
                throw new IllegalArgumentException("Vertice fora do limite");
            listaAdjacencia[inputVertice].add(weight);
        }

        int menorCaminho(int inicio, int alvo) {
            if (inicio < 0 || inicio >= vertice || alvo < 0 || alvo >= vertice)
                throw new IllegalArgumentException("Inicio ou fim fora do limite");

            boolean[] visitado = new boolean[vertice];
            int[] distancia = new int[vertice];

            Queue<Integer> fila = new LinkedList<>();
            visitado[inicio] = true;
            fila.add(inicio);

            while (!fila.isEmpty()) {
                int head = fila.poll();

                for (int index = 0; index < listaAdjacencia[head].size(); index++) {
                    if (!visitado[listaAdjacencia[head].get(index)]) {
                        visitado[listaAdjacencia[head].get(index)] = true;
                        distancia[listaAdjacencia[head].get(index)] = distancia[head] + 1;
                        fila.add(listaAdjacencia[head].get(index));

                        if (listaAdjacencia[head].get(index) == alvo) {
                            return distancia[alvo];
                        }
                    }
                }
            }
            return -1;
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String nextLine() {
            String str = "";
            try {
                st = new StringTokenizer(br.readLine());
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