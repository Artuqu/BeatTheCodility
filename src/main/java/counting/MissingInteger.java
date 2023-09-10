package counting;

import java.util.Arrays;

public class MissingInteger {

    public static int solution(int[] A) {
        Arrays.sort(A);
        int firstDigit = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] >= firstDigit) {
                if (firstDigit < A[i]) {
                    return firstDigit;
                }
                firstDigit++;
            }
        }
        return firstDigit;

    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        int[] b = {1, 3, 6, 4, 1, 2};
        int[] c = {88};
        System.out.println(solution(a));
        System.out.println(solution(b));
        System.out.println(solution(c));

    }
}
