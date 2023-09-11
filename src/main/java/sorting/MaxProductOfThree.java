package sorting;

import java.util.Arrays;

public class MaxProductOfThree {

    public int solution(int[] A) {
        Arrays.sort(A);
        int resultWithNegative, resultWithPositive;
        int start = A.length - 3;
        resultWithPositive = A[start] * A[start + 1] * A[start + 2];
        resultWithNegative = A[0] * A[1] * A[A.length - 1];

        return Math.max(resultWithNegative, resultWithPositive);
    }

    public static void main(String[] args) {
        int[] A = {-3, 1, 2, -2, 5, 6};
        int[] A2 = {-5, 5, -5, 4};
        int[] A3 = {-4, -6, 3, 4, 5};

        System.out.println(new MaxProductOfThree().solution(A));
        System.out.println(new MaxProductOfThree().solution(A2));
        System.out.println(new MaxProductOfThree().solution(A3));
    }
}
