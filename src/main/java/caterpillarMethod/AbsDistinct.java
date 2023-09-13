package caterpillarMethod;

import java.util.HashSet;

public class AbsDistinct {

    public int solution(int[] A) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) hashSet.add(A[i] * -1);
            else hashSet.add(A[i]);
        }
        return hashSet.size();
    }

    public static void main(String[] args) {
        int[] A = {-5, -3, -1, 0, 3, 6};
        System.out.println(new AbsDistinct().solution(A));
    }
}
