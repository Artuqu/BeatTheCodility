package otherAlgorithms.medium;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    //DFS
    public int solution(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    counter++;
                    dfs(grid, i, j);
                }
            }
        }
        return counter;
    }

    private void dfs(int[][] grid, int i, int j) {
        int n = grid.length;
        int m = grid[0].length;
        if (i >= n || i < 0 || j >= m || j < 0 || grid[i][j] == 0) return;
        ;
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    //BFS
    public int solution2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        int counter = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    counter++;
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] curr = queue.poll();
                        int first = curr[0];
                        int second = curr[1];
                        if (first >= n || first < 0 || second >= m || second < 0 || grid[first][second] != 1) continue;
                        grid[first][second] = 0;
                        for (int[] direction : directions) {
                            int x = first + direction[0];
                            int y = second + direction[1];
                            queue.add(new int[]{x, y});
                        }
                    }
                }
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0, 0},
                        {1, 1, 0, 0, 0},
                        {0, 0, 1, 0, 0},
                        {0, 0, 0, 1, 1}};
        int[][] grid2 = {{1, 1, 0, 0, 0},
                         {1, 1, 0, 0, 0},
                         {0, 0, 1, 0, 0},
                         {0, 0, 0, 1, 1}};
        System.out.println(new NumberOfIslands().solution(grid));
        System.out.println(new NumberOfIslands().solution2(grid2));
    }
}
