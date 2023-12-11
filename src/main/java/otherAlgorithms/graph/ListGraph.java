package otherAlgorithms.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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

    public void BFS(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(n);
        visited.add(n);
        System.out.print("BFS Graph: ");
        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");
            for (int i = 0; i < list[v].size(); i++) {
                int s = list[v].get(i);
                if (!visited.contains(s)) {
                    queue.add(s);
                    visited.add(s);
                }
            }
        }
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
