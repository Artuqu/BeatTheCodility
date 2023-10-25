package otherAlgorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    //    O(n log (n))
    public boolean solution(int[] A) {
        if (A == null) return false;
        Arrays.sort(A);
        int max = A[A.length - 1];
        int[] duplicates = new int[max + 1];
        for (int num : A) {
            duplicates[num]++;
        }
        for (int num : duplicates) {
            if (num > 1) return true;
        }
        return false;
    }

    //    O(n) time complexity
    public boolean solution2(int[] A) {
        if (A == null) return false;
        Set<Integer> cache = new HashSet<>();
        for (int j : A) {
            if (cache.contains(j)) return true;
            else {
                cache.add(j);
            }
        }
        return false;
    }

    public boolean solution3(int[] A) {
        if (A == null) return false;
        Set<Integer> cache = new HashSet<>();
        for (int num : A) {
            cache.add(num);
        }
        return A.length != cache.size();
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 1};
        int[] A1 = {1, 2, 3, 4};
        int[] A2 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        int[] A3 = {1};
        int[] A4 = null;
        int[] A5 = {};
        System.out.println(new ContainsDuplicate().solution3(A));
        System.out.println(new ContainsDuplicate().solution3(A1));
        System.out.println(new ContainsDuplicate().solution3(A2));
        System.out.println(new ContainsDuplicate().solution3(A3));
        System.out.println(new ContainsDuplicate().solution2(A4));
        System.out.println(new ContainsDuplicate().solution2(A5));

    }
}
