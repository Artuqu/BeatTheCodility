package otherAlgorithms;

import java.util.Arrays;

public class SquaresOfSortedArray {

    //O(n log n) time complexity
    public int[] solution(int[] A) {
        if (A == null) {
            return new int[]{};
        }
        int[] result = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            result[i] = A[i] * A[i];
        }
        Arrays.sort(result);
        return result;
    }

    //O(n) time complexity
    public int[] solution2(int[] A) {
        if (A == null) {
            return new int[]{};
        }
        int n = A.length - 1;
        int[] result = new int[A.length];
        int left = 0;
        int right = n, index = n;
        while (left <= right) {
            int number;
            if (Math.abs(A[right]) > Math.abs(A[left])) {
                number = right;
                right--;
            } else {
                number = left;
                left++;
            }
            result[index] = A[number] * A[number];
            index--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {-4, -1, 0, 3, 10};
        int[] A1 = {-7, -3, 2, 3, 11};
        int[] A2 = null;
        System.out.println(Arrays.toString(new SquaresOfSortedArray().solution(A)));
        System.out.println(Arrays.toString(new SquaresOfSortedArray().solution(A1)));
        System.out.println(Arrays.toString(new SquaresOfSortedArray().solution(A2)));
    }
}
