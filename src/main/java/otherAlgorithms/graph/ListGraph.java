package otherAlgorithms.graph;

import java.util.LinkedList;

public class ListGraph {

    private int V;  // vertices
    private int E;  // edges
    private LinkedList<Integer>[] list;

    public ListGraph(int vertices) {
        V = vertices;
        E = 0;
        this.list = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            list[i] = new LinkedList<>();
        }
    }

    public void addEdge(int i, int j) {
        list[i].add(j);
        list[j].add(i);
        E++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices; " + E + " edges" + "\n");
        for (int i = 0; i < V; i++) {
            sb.append(i + ": ");
            for (int j : list[i]) {
                sb.append(j + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
