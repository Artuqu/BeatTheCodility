package otherAlgorithms;

import java.util.Arrays;

public class MissingInteger {

    //    O(n log(n))
    public int solution(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i) return A[i] - 1;
        }
        return A.length;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int[] A1 = {0, 1, 2};
        int[] A2 = {0, 5, 3, 4, 2};
        System.out.println(new MissingInteger().solution(A));
        System.out.println(new MissingInteger().solution(A1));
        System.out.println(new MissingInteger().solution(A2));
    }
}
