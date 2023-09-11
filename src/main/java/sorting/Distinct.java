package sorting;

import java.util.HashSet;
import java.util.Set;

public class Distinct {

    public int solution(int[] A) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            hashSet.add(A[i]);
        }
        return hashSet.size();
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 1, 2, 3, 1};
        System.out.println(new Distinct().solution(A));

    }
}
