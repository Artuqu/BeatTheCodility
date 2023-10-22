package otherAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pairs {


    public List<String> solution(int N, int[] A) {
        List<String> pairs = new ArrayList<>();
        Arrays.sort(A);
        int leftPointer = 0;
        int rightPointer = A.length - 1;
        int sum = A[leftPointer] + A[rightPointer];
        for (int i = 0; i < A.length; i++) {
            if (N > sum) leftPointer++;
            else if (N < sum) rightPointer--;
            else {
                pairs.add("Sum of " + N + " is " + A[leftPointer] + " and " + A[rightPointer]);
                leftPointer++;
                rightPointer--;
                i++;
            }
            sum = A[leftPointer] + A[rightPointer];
        }
        return pairs;
    }

    public static void main(String[] args) {
        int[] A = {2, 3, -1, 9, -5, 10};
        System.out.println(new Pairs().solution(5, A));

    }
}
