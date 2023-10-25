package otherAlgorithms;

import java.util.Arrays;

public class XorBitAlgorithm {

    //    O(n) time complexity
    public int solution(int[] A) {
        int result = 0;
        for (int num : A) {
            result = result ^ num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 2, 3};
        System.out.println(new XorBitAlgorithm().solution(A));
    }
}
