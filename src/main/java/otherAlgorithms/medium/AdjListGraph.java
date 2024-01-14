package otherAlgorithms.medium;

import java.util.LinkedList;

public class AdjListGraph {

    private int V;
    private int E;

    private LinkedList<Integer>[] adj;

    public AdjListGraph() {
        V = 6;
        E = 0;
        this.adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
        buildGraph();
        System.out.println(this);
    }

    private void buildGraph() {
        int celebrity = 3;
        for (int i = 0; i < V; i++) {
            if (celebrity == i) continue;
            addEdge(i, celebrity);
        }
        addEdge(0, 2);
        addEdge(4, 5);
        addEdge(5, 0);
        addEdge(0, 5);
    }

    private void addEdge(int person, int knows) {
        adj[person].add(knows);
        E++;
    }

    public boolean knows(int i, int j) {
        if (i > V || j > V) return false;
        LinkedList<Integer> vs = adj[i];
        if (vs == null || vs.isEmpty()) return false;
        return vs.contains(j);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices " + E + " edges" + "\n");
        for (int i = 0; i < V; i++) {
            sb.append(i + ":");
            for (int w : adj[i]) sb.append(w + " ");
            sb.append("\n");
        }
        return sb.toString();
    }

}
