import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    // Coded By
    // Breno Silva

    static int numVertices, numArestas;
    static ArrayList<Aresta> listaArestas;
    static ArrayList<Integer> resultado;

    static void kruskal() {
        resultado = new ArrayList<Integer>();
        Collections.sort(listaArestas);
        ConjuntoDisjunto cd = new ConjuntoDisjunto(numVertices);
        int indice = 0;

        while (indice < listaArestas.size()) {
            Aresta atual = listaArestas.get(indice++);
            int origem = atual.origem, destino = atual.destino, custo = atual.custo;

            if (!cd.mesmoConjunto(origem, destino))
                cd.unir(origem, destino);
            else
                resultado.add(custo);
        }
        Collections.sort(resultado);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader leitor = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder saida = new StringBuilder();

        while (true) {
            st = new StringTokenizer(leitor.readLine());
            numVertices = Integer.parseInt(st.nextToken());
            numArestas = Integer.parseInt(st.nextToken());

            if (numVertices == 0)
                break;

            listaArestas = new ArrayList<Aresta>(numArestas);

            for (int i = 0; i < numArestas; i++) {
                st = new StringTokenizer(leitor.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                listaArestas.add(new Aresta(a, b, c));
            }

            kruskal();

            if (resultado.size() == 0)
                saida.append("forest\n");
            else {
                for (int i = 0; i < resultado.size() - 1; i++)
                    saida.append(resultado.get(i) + " ");

                saida.append(resultado.get(resultado.size() - 1) + "\n");
            }
        }
        System.out.print(saida);
    }

    static class Aresta implements Comparable<Aresta> {
        int origem, destino, custo;

        public Aresta(int origem, int destino, int custo) {
            this.origem = origem;
            this.destino = destino;
            this.custo = custo;
        }

        public int compareTo(Aresta o) {
            return custo - o.custo;
        }
    }

    static class ConjuntoDisjunto {
        int[] conjunto, rank;
        int numConjuntos;

        public ConjuntoDisjunto(int n) {
            numConjuntos = n;
            conjunto = new int[n];
            rank = new int[n];

            for (int i = 0; i < rank.length; i++) {
                conjunto[i] = i;
                rank[i] = 1;
            }
        }

        public int encontrar(int x) {
            return (conjunto[x] == x) ? x : (conjunto[x] = encontrar(conjunto[x]));
        }

        public void unir(int a, int b) {
            int x = encontrar(a), y = encontrar(b);

            if (mesmoConjunto(a, b))
                return;

            if (rank[x] > rank[y])
                conjunto[y] = x;
            else {
                conjunto[x] = y;

                if (rank[x] == rank[y])
                    rank[y]++;
            }
            numConjuntos--;
        }

        public boolean mesmoConjunto(int a, int b) {
            return encontrar(a) == encontrar(b);
        }
    }
}
