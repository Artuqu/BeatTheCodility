package leader;

import java.util.Arrays;
import java.util.Stack;

public class Dominator {

    public static int solution(int[] A) {
        int half = A.length / 2;
        int counter = 0;
        int[] second = Arrays.copyOf(A, A.length);
        Arrays.sort(second);
        if (second.length > 0) {
            int first = second[0];
            for (int i : second) {
                if (i == first) {
                    counter++;
                } else counter = 1;
                if (counter > half) {
                    for (int j = 0; j < A.length; j++) {
                        if (A[j] == i) return j;
                    }
                }
                first = i;
            }
        }
        return -1;
    }

    public static int solution2(int[] A) {
        int counter = 0;
        int position = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i : A) {
            if (stack.isEmpty() || i == stack.peek()) {
                stack.push(i);
            } else if (!stack.isEmpty()) {
                if (stack.peek() != i) {
                    stack.pop();
                } else stack.push(i);
            }
        }
        if (!stack.isEmpty()) {
            for (int j = 0; j < A.length; j++) {
                if (stack.peek() == A[j]) {
                    counter++;
                    position = j;
                }
            }
        }
        return counter > A.length / 2 ? position : -1;
    }

    public static int solution3(int[] A) {
        int consecutiveSize = 0;
        int candidate = 0;
        for (int item : A) {
            if (consecutiveSize == 0) {
                candidate = item;
                consecutiveSize++;
            } else if (candidate == item) {
                consecutiveSize++;
            } else {
                consecutiveSize--;
            }
        }
        int occurrence = 0;
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == candidate) {
                occurrence++;
                index = i;
            }
        }
        return occurrence > A.length / 2 ? index : -1;
    }

    public static void main(String[] args) {
        int[] A = {3, 4, 3, 2, 3, -1, 3, 3};
        int[] B = {};
        int[] C = {0, 3, 4, 3, 2, 3, -1, 3, 3, 0};
        int[] D = {1, 4, 2, 3, 4, 0, 4, 4};
        int[] E = {2, 1, 1, 3, 4};
        System.out.println(solution2(A));
        System.out.println(solution2(E));
        System.out.println(solution3(C));
        System.out.println(solution2(B));
        System.out.println(solution2(D));
    }
}
