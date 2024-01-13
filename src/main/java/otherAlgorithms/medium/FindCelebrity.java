package otherAlgorithms.medium;

public class FindCelebrity {

    //time complexity O(n2) + n, space O(1)
    public int solution(int[][] graph) {
        int i = getPossibleCelebrity(graph);
        int counter = 0;
        for (int j = 0; j < graph.length; j++) {
            if (graph[j][i] == 1) counter++;
        }
        return counter == graph.length ? i : -1;
    }

    private int getPossibleCelebrity(int[][] graph) {
        int counter = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (knows(i, j, graph)) counter++;
            }
            if (counter == 1) return i;
            counter = 0;
        }
        return -1;
    }

    public boolean knows(int a, int b, int[][] graph) {
        int[] aConnections = graph[a];
        return aConnections[b] == 1;
    }

    public static void main(String[] args) {
        int[][] graph = {{1, 1, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] graph2 = {{1, 1, 0, 1}, {1, 0, 1, 1}, {1, 1, 1, 1}, {0, 0, 0, 1}};
        int[][] graph3 = {{1, 0, 1, 1, 0, 1}, {0, 1, 0, 1, 0, 0}, {0, 0, 1, 1, 0, 0}, {0, 0, 0, 1, 0, 0}, {0, 0, 0, 1, 1, 1}, {1, 0, 0, 1, 0, 1}};
        System.out.println(new FindCelebrity().solution(graph));
        System.out.println(new FindCelebrity().solution(graph2));
        System.out.println(new FindCelebrity().solution(graph3));
    }
}
