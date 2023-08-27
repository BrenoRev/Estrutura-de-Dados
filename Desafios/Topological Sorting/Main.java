import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    // Coded By
    // Breno Silva

    public static void main(String[] args) throws Exception {
        BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
        int quantidadeCasos = Integer.parseInt(leitor.readLine());

        for (int casoAtual = 1; casoAtual <= quantidadeCasos; casoAtual++) {
            StringTokenizer st = new StringTokenizer(leitor.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int origem = Integer.parseInt(st.nextToken());
            int destino = Integer.parseInt(st.nextToken());

            ArrayList<Aresta>[] listaArestas = new ArrayList[n];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(leitor.readLine());
                int orig = Integer.parseInt(st.nextToken());
                int dest = Integer.parseInt(st.nextToken());
                int custo = Integer.parseInt(st.nextToken());

                if (listaArestas[orig] == null)
                    listaArestas[orig] = new ArrayList<>();
                listaArestas[orig].add(new Aresta(orig, dest, custo));

                if (listaArestas[dest] == null)
                    listaArestas[dest] = new ArrayList<>();
                listaArestas[dest].add(new Aresta(dest, orig, custo));
            }

            int[] custos = new int[n];
            Arrays.fill(custos, Integer.MAX_VALUE);
            dijkstra(listaArestas, custos, origem, destino);

            if (custos[destino] != Integer.MAX_VALUE)
                System.out.println("Case #" + casoAtual + ": " + custos[destino]);
            else
                System.out.println("Case #" + casoAtual + ": unreachable");
        }
    }

    public static class Aresta implements Comparable<Aresta> {
        private int custo;
        private int origem;
        private int destino;

        public Aresta(int origem, int destino, int custo) {
            this.origem = origem;
            this.custo = custo;
            this.destino = destino;
        }

        public int compareTo(Aresta aresta) {
            return this.custo - aresta.custo;
        }
    }

    public static void dijkstra(ArrayList<Aresta>[] listaArestas, int[] menorCusto, int origem, int destino) {
        menorCusto[origem] = 0;

        PriorityQueue<Aresta> fila = new PriorityQueue<>();
        fila.add(new Aresta(origem, origem, 0));

        while (!fila.isEmpty()) {
            Aresta arestaAtual = fila.poll();
            if (arestaAtual.destino == destino)
                break;
            else if (listaArestas[arestaAtual.destino] != null) {
                for (Aresta aresta : listaArestas[arestaAtual.destino]) {
                    if (menorCusto[aresta.destino] > menorCusto[aresta.origem] + aresta.custo) {
                        menorCusto[aresta.destino] = menorCusto[aresta.origem] + aresta.custo;
                        fila.offer(new Aresta(aresta.origem, aresta.destino, menorCusto[aresta.destino]));
                    }
                }
            }
        }
    }
}
