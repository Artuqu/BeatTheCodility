package otherAlgorithms.graph;

import java.util.*;

public class DirectedGraphPath<T> {

    private Map<T, LinkedList<T>> map;

    public DirectedGraphPath() {
        this.map = new HashMap<>();
    }

    public void addVertex(T vertex) {
        map.put(vertex, new LinkedList<>());
    }

    public void addEdge(T vertex1, T vertex2) {
        if (map.get(vertex1) == null) addVertex(vertex1);
        map.get(vertex1).add(vertex2);
    }

    public boolean isPath(T from, T to) {
        Queue<T> queue = new ArrayDeque<>();
        Set<T> visited = new HashSet<>();
        queue.add(from);
        while (!queue.isEmpty()) {
            T element = queue.poll();
            List<T> searching = map.get(element);
            if (searching != null)
                for (T t : searching) {
                    if (t != null && !visited.contains(t)) {
                        visited.add(t);
                        queue.add(t);
                        if (t.equals(to)) return true;
                    }
                }
        }
        return false;
    }
}
