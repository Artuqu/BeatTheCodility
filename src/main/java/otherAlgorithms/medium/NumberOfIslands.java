package otherAlgorithms.medium;

public class NumberOfIslands {

    public int solution(int[][] grid) {
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


    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}};
        System.out.println(new NumberOfIslands().solution(grid));
    }
}
