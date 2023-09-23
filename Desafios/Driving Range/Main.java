import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Coded By
        // Breno Silva

        FastReader sc = new FastReader();
        StringBuilder sb = new StringBuilder();

        while (true) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            if (n == 0 && m == 0) break;

            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
                edges.add(new Edge(u, v, w));
            }

            sb.append(minimumRange(n, edges)).append("\n");
        }
        
        System.out.print(sb.toString());
    }

    static String minimumRange(int n, List<Edge> edges) {
        Collections.sort(edges);  // Sort edges by weight
        UnionFind uf = new UnionFind(n);
        int maxEdgeUsed = 0;
        int components = n;

        for (Edge edge : edges) {
            if (!uf.isSameSet(edge.u, edge.v)) {
                uf.union(edge.u, edge.v);
                maxEdgeUsed = Math.max(maxEdgeUsed, edge.weight);
                components--;
            }
        }

        return components == 1 ? String.valueOf(maxEdgeUsed) : "IMPOSSIBLE";
    }
}

class Edge implements Comparable<Edge> {
    int u, v, weight;

    Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.weight, other.weight);
    }
}

class UnionFind {
    private int[] parent;
    private int[] rank;

    UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    boolean isSameSet(int x, int y) {
        return find(x) == find(y);
    }

    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
                if (rank[rootX] == rank[rootY]) {
                    rank[rootY]++;
                }
            }
        }
    }
}

class FastReader {
    BufferedReader bufferedReader;
    StringTokenizer stringTokenizer;

    public FastReader() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (stringTokenizer == null || !stringTokenizer.hasMoreElements()) {
            try {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return stringTokenizer.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }
}
