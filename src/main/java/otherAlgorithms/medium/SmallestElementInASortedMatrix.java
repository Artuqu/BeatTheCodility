package otherAlgorithms.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SmallestElementInASortedMatrix implements Comparator<HeapNode> {
    //    O(n)
    public int solution(int[][] matrix, int k) {
        for (int i = 0; i < matrix.length; i++) {
            if (k > matrix.length * i + matrix.length) continue;
            for (int j = 0; j < matrix.length; j++) {
                if (i * (matrix.length) + j + 1 == k) return matrix[i][j];
            }
        }
        return -1;
    }

    //O(n2)
    public int solution2(int[][] matrix, int k) {
        int N = matrix.length;
        PriorityQueue<HeapNode> minHeap = new PriorityQueue<>(Math.min(N, k), new SmallestElementInASortedMatrix());
        for (int r = 0; r < Math.min(N, k); r++) {
            minHeap.offer(new HeapNode(matrix[r][0], r, 0));
        }
        HeapNode element = minHeap.peek();
        while (k > 0) {
            k--;
            element = minHeap.poll();
            int r = element.row, c = element.column;
            if (c < N - 1) minHeap.offer(new HeapNode(matrix[r][c + 1], r, c + 1));
        }
        return element.value;
    }

    //    O(1)
    public int solution3(int[][] matrix, int k) {
        int matrixSize = matrix.length * matrix.length;
        if (k > matrixSize || k <= 0) return -1;
        int i = k / matrix.length;
        int restOfK = k % matrix.length;

        int j = restOfK > 0 ? restOfK - 1 : matrix.length - 1;
        if (restOfK == 0) {
            i--;
        }

        if (k <= matrix.length) {
            return matrix[0][k - 1];
        }
        return matrix[i][j];
    }

    public static void main(String[] args) {
        int[][] matrix1 = {{-5}};
        int[][] matrix3 = {{1, 2, 3}, {5, 6, 7}, {9, 10, 21}};
        int[][] matrix3s = {{1, 3, 7}, {5, 10, 12}, {6, 12, 15}};
        int[][] matrix4 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {10, 12, 21, 32}, {33, 34, 46, 77}};
        System.out.println(new SmallestElementInASortedMatrix().solution(matrix1, 1));
        System.out.println(new SmallestElementInASortedMatrix().solution2(matrix1, 1));
        System.out.println(new SmallestElementInASortedMatrix().solution3(matrix1, 1));
        System.out.println(new SmallestElementInASortedMatrix().solution(matrix3, 8));
        System.out.println(new SmallestElementInASortedMatrix().solution2(matrix3, 8));
        System.out.println(new SmallestElementInASortedMatrix().solution3(matrix3, 8));
        System.out.println(new SmallestElementInASortedMatrix().solution(matrix4, 12));
        System.out.println(new SmallestElementInASortedMatrix().solution2(matrix4, 12));
        System.out.println(new SmallestElementInASortedMatrix().solution3(matrix4, 12));
        System.out.println(new SmallestElementInASortedMatrix().solution(matrix3s, 8));
        System.out.println(new SmallestElementInASortedMatrix().solution2(matrix3s, 8));
        System.out.println(new SmallestElementInASortedMatrix().solution3(matrix3s, 8));
    }

    @Override
    public int compare(HeapNode x, HeapNode y) {
        return x.value - y.value;
    }
}
