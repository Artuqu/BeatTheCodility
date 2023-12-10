package otherAlgorithms.graph;

public class MatrixGraph {


    private int V;  // vertices
    private int E;  // edges
    private int[][] matrix;

    public MatrixGraph(int vertices) {
        V = vertices;
        E = 0;
        this.matrix = new int[vertices][vertices];
    }

    public void addEdge(int i, int j) {
        matrix[i][j] = 1;
        matrix[j][i] = 1;
        E++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices; " + E + " edges" + "\n");
        for (int i = 0; i < V; i++) {
            sb.append(i + ": ");
            for (int j : matrix[i]){
                sb.append(j + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
