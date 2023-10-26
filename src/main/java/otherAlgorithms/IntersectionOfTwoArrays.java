package otherAlgorithms;

import java.util.*;

public class IntersectionOfTwoArrays {

    public int[] solution(int[] A, int[] B) {
        if (A == null || B == null) return new int[0];
        if (B.length > A.length) return solution(B, A);
        List<Integer> intersection = new ArrayList<>();
        Map<Integer, Integer> cache = new HashMap<>();
        for (int a : A) {
            cache.put(a, cache.getOrDefault(a, 0) + 1);
        }
        for (int b : B) {
            int count = cache.getOrDefault(b, 0);
            if (count > 0) {
                intersection.add(b);
                cache.put(b, count - 1);
            }
        }
        return intersection.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 2, 4};
        int[] A1 = {4, 9, 5};
        int[] A2 = {};
        int[] B = {2, 2};
        int[] B1 = {9, 4, 9, 8, 4};
        int[] B2 = {};
        System.out.println(Arrays.toString(new IntersectionOfTwoArrays().solution(A, B)));
        System.out.println(Arrays.toString(new IntersectionOfTwoArrays().solution(A1, B1)));
        System.out.println(Arrays.toString(new IntersectionOfTwoArrays().solution(A2, B2)));
    }
}
