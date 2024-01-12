package otherAlgorithms.medium;

import java.util.Arrays;

public class RotateImageArray {
    public int[][] solution(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
        return matrix;
    }

    public void solution2(int[][] A) {
        transpose(A);
        reflect(A);
    }

    private void reflect(int[][] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][n - j - 1];
                A[i][n - j - 1] = temp;
            }
        }
    }

    private void transpose(int[][] A) {
        int n = A.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = A[j][i];
                A[j][i] = A[i][j];
                A[i][j] = temp;
            }
        }
    }


    public static void main(String[] args) {
        int[][] arr = new int[][]{{5, 1, 9, 11, 22}, {2, 4, 8, 10, 23}, {13, 3, 6, 7, 24}, {15, 14, 12, 16, 25},
                {33, 34, 35, 36, 37}};
        int[][] arrS = new int[][]{{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        int[][] arr2 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arr2S = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println(Arrays.deepToString(new RotateImageArray().solution(arr)));
        System.out.println(Arrays.deepToString(new RotateImageArray().solution(arr2)));
        ;
        new RotateImageArray().solution2(arrS);
        System.out.println(Arrays.deepToString(arrS));
        new RotateImageArray().solution2(arr2S);
        System.out.println(Arrays.deepToString(arr2S));
    }
}
