import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    int[][] matrix;
    int numEdge;
    int[] Mark;

    public Graph(int n) {
        this.Mark = new int[n];
        this.matrix = new int[n][n];
        this.numEdge = 0;
    }

    public int first(int v) {
        for (int i = 0; i < this.matrix.length; i++) {
            if (this.matrix[v][i] != 0) {
                return i;
            }
        }
        return this.matrix.length;
    }

    public int next(int v, int w) {
        for (int i = w + 1; i < this.matrix.length -1; i++) {
            if (this.matrix[v][i] != 0) {
                return i;
            }
        }
        return this.matrix.length;
    }

    public void setEdge(int i, int j, int wt) {
        if(wt == 0) {
            return;
        }

        if(this.matrix[i][j] == 0) {
            this.numEdge++;
        }

        this.matrix[i][j] = wt;
    }

    public void delEdge(int i, int j) {
        if(this.matrix[i][j] != 0) {
            this.numEdge--;
        }

        this.matrix[i][j] = 0;
    }

    public void graphTraverseDFS() {
        for( int v = 0; v < this.matrix.length -1; v++) {
            this.Mark[v] = 0;
        }

        for( int v = 0; v < this.matrix.length -1; v++) {
            if(this.Mark[v] == 0) {
                this.dfsTraverse(v);
            }
        }
    }

    public void dfsTraverse(int v) {
        preVisit(v);
        this.Mark[v] = 1;
        int weight = first(v);
        while(weight < this.matrix.length) {
            if(this.Mark[weight] == 0) {
                dfsTraverse(weight);
            }
            weight = next(v, weight);
        }

        posVisit(v);
    }

    public void preVisit(int v) {
       
    }

    public void posVisit(int v) {
      
    }

    public void graphTraverseBFS() {
        for( int v = 0; v < this.matrix.length -1; v++) {
            this.Mark[v] = 0;
        }

        for( int v = 0; v < this.matrix.length -1; v++) {
            if(this.Mark[v] == 0) {
                this.bfsTraverse(v);
            }
        }
    }

    public void bfsTraverse(int start) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(start);
        this.Mark[start] = 1;

        while(q.size() > 0) {
            int v = q.remove();
            preVisit(v);
            int weight = first(v);
            while(weight < this.matrix.length) {
                if(this.Mark[weight] == 0) {
                    this.Mark[weight] = 1;
                    q.add(weight);
                }
                weight = next(v, weight);
            }
            posVisit(v);
        }

    }
}
