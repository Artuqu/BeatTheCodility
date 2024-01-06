package otherAlgorithms.medium;

public class SmallestElementInASortedMatrix {
    public int solution(int[][] matrix, int position) {
        for (int i = 0; i < matrix.length; i++) {
            if (position > matrix.length * i + matrix.length) continue;
            for (int j = 0; j < matrix.length; j++) {
                if (i * (matrix.length) + j + 1 == position) return matrix[i][j];
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {5, 6, 7}, {9, 10, 21}};
        int[][] matrix4 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 21, 32}, {33, 34, 46, 77}};
        System.out.println(new SmallestElementInASortedMatrix().solution(matrix, 8));
        System.out.println(new SmallestElementInASortedMatrix().solution(matrix4, 15));
    }
}
