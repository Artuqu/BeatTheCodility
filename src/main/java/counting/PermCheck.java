package counting;

import java.util.Arrays;

public class PermCheck {
    public int solution(int[] A) {
        int result = 1;
        Arrays.sort(A);
        if (A[0] != 1) {
            return 0;
        }
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] + 1 != A[i + 1]) {
                return 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {4, 1, 3, 2};
        int[] A1 = {4, 1, 3};
        int[] A2 = {1};
        int[] A3 = {2, 3};
        System.out.println(new PermCheck().solution(A2));
        System.out.println(new PermCheck().solution(A));
        System.out.println(new PermCheck().solution(A1));
        System.out.println(new PermCheck().solution(A3));
    }
}
