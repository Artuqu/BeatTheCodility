package otherAlgorithms.graph;

public class GraphApp {

    public static void main(String[] args) {
        MatrixGraph matrix = new MatrixGraph(4);
        matrix.addEdge(0, 1);
        matrix.addEdge(1, 2);
        matrix.addEdge(2, 3);
        matrix.addEdge(3, 0);
        System.out.println(matrix);

        ListGraph list = new ListGraph(4);
        list.addEdge(0, 1);
        list.addEdge(1, 2);
        list.addEdge(2, 3);
        list.addEdge(3, 0);
        list.addEdge(3, 1);
        System.out.println(list);
        list.BFS(0);
        System.out.println();
        list.DFS(0);
        System.out.println();
        list.stackDFS(0);
    }
}
