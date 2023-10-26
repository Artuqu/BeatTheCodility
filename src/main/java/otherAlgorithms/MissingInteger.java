package otherAlgorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingInteger {

    //    O(n log(n))
    public int solution(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i) return A[i] - 1;
        }
        return A.length;
    }

    //    O(2n)
    public int solution2(int[] A) {
        Set<Integer> cache = new HashSet<>();
        for (int a : A) cache.add(a);
        for (int i = 0; i < A.length + 1; i++) {
            if (!cache.contains(i)) return i;
        }
        throw new RuntimeException("Not found!");
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int[] A1 = {0, 1, 2};
        int[] A2 = {0, 5, 3, 4, 2};
        int[] A3 = {};
        System.out.println(new MissingInteger().solution2(A));
        System.out.println(new MissingInteger().solution2(A1));
        System.out.println(new MissingInteger().solution2(A2));
        System.out.println(new MissingInteger().solution2(A3));
    }
}
