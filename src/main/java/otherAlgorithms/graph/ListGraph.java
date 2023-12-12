package otherAlgorithms.graph;

import java.util.*;

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

    public void DFS(int n) {
        Set<Integer> visited = new HashSet<>();
        System.out.print("DFS Graph: ");
        DFS(n, visited);
    }

    private void DFS(int n, Set<Integer> visited) {
        visited.add(n);
        System.out.print(n + " ");
        for (int s : list[n]) {
            if (!visited.contains(s)) DFS(s, visited);
        }
    }

    public void stackDFS(int n) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        System.out.print("DFS with Stack Graph: ");
        while (!stack.isEmpty()) {
            int number = stack.pop();
            if (!visited.contains(number)) {
                visited.add(number);
                System.out.print(number + " ");
                for (int i : list[number]) {
                    if (!visited.contains(i)) stack.push(i);
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
