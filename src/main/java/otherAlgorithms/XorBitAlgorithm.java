package otherAlgorithms;

import java.util.Arrays;

public class XorBitAlgorithm {

    //    O(n) time complexity
    public int solution(int[] A) {
        if (A == null || A.length == 0) return 0;
        int result = 0;
        for (int num : A) {
            result = result ^ num;
        }
        return result;
    }

    //O(n log(n)) time complexity
    public int solution2(int[] A) {
        if (A == null || A.length == 0) return 0;
        Arrays.sort(A);
        int length = A.length;
        if (A.length == 1) return A[0];
        if (A[0] != A[1]) return A[0];
        if (A[length - 1] != A[length - 2]) return A[length - 2];
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] != A[i] && A[i] != A[i + 1]) {
                return A[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 2, 3};
        int[] A1 = {};
        int[] A2 = null;
        System.out.println(new XorBitAlgorithm().solution2(A2));
    }
}
