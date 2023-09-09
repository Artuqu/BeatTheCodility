package arrays;

import java.util.Arrays;

public class OddOccurrencesInArray {


    public static int solution(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] != A[i + 1]) {
                return A[i];
            }
            i ++;
        }
        return A[A.length - 1];
    }

    public static void main(String[] args) {
        int[] A = {9, 3, 9, 3, 9, 7, 9};
        System.out.println(solution(A));
    }
}
