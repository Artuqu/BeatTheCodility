package otherAlgorithms.medium;

import java.util.Arrays;

public class UniquePaths {

    public int solution(int m, int n) {
        int[][] grid = new int[m][n];
        Arrays.fill(grid[0], 1);
        for (int i = 1; i < m; i++) {
            grid[i][0] = 1;
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
            }
        }
        return grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UniquePaths().solution(3, 7));
        System.out.println(new UniquePaths().solution(2, 2));
        System.out.println(new UniquePaths().solution(3, 2));
    }
}
