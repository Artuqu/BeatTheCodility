package sorting;

import java.util.Arrays;

public class Triangle {

    public int solution(int[] A) {
        int result = 0;
        Arrays.sort(A);
        for (int i = 0; i <= A.length - 3; i++) {
            if (A[A.length - i - 1] < A[A.length - 2 - i] + A[A.length - 3 - i]) {
                long firstEdge = A[A.length - i - 1];
                long secondEdge = A[A.length - i - 2];
                long thirdEdge = A[A.length - i - 3];
                if (firstEdge + secondEdge > thirdEdge && secondEdge + thirdEdge > firstEdge && firstEdge + thirdEdge > secondEdge) {
                    return 1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {10, 2, 5, 1, 8, 20};
        int[] A1 = {10, 50, 5, 1};
        int[] A2 = {5, 3, 3};
        System.out.println(new Triangle().solution(A));
        System.out.println(new Triangle().solution(A1));
        System.out.println(new Triangle().solution(A2));

    }
}
