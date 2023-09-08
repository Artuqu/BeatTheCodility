package arrays;

import java.util.Arrays;

public class CyclicRotation {

    public static int[] solution(int[] A, int K) {
        try {
            int B[] = new int[A.length];
            while (K > 0) {
                B[0] = A[A.length - 1];
                for (int i = 1; i < A.length; i++) {
                    B[i] = A[i - 1];
                }
                K--;
                A = Arrays.copyOf(B, B.length);
            }
            return B;
        } catch (ArrayIndexOutOfBoundsException e) {
            return new int[]{};
        }
    }

    public static int[] solution2(int[] A, int K) {
        int[] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
//            modulo is set on array length to not go out of range
            B[(i + K) % A.length] = A[i];
        }
        return B;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 7};
        int[] A1 = {};
        System.out.println(Arrays.toString(solution(A1, 11)));
        System.out.println(Arrays.toString(solution2(A, 11)));
    }
}
