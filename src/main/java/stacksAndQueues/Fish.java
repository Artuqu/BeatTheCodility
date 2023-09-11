package stacksAndQueues;

import java.util.Stack;

public class Fish {

    public static int solution(int[] A, int[] B) {
        Stack<Integer> stack = new Stack<>();
        int fish = 0;
        for (int i = 0; i < A.length; i++) {
            int stream = B[i];
            int size = A[i];
            if (stream == 1) stack.push(size);
            if (stream == 0 && !stack.isEmpty()) {
                while (!stack.isEmpty() && stack.peek() < size)
                    stack.pop();
            }
            if (stream == 0 && stack.isEmpty()) fish++;
        }
        return fish + stack.size();
    }

    public static int solution2(int[] A, int[] B) {
        Stack<Integer> stack = new Stack<>();
        int fish = 0;
        for (int i = 0; i < A.length; i++) {
            int weight = A[i];
            int stream = B[i];
            if (stream == 1) {
                stack.push(weight);
            } else {
                int weightDown = stack.isEmpty() ? -1 : stack.pop();
                while (weightDown != -1 && weightDown < weight)
                    weightDown = stack.isEmpty() ? -1 : stack.pop();
                if (weightDown == -1) fish++;
                else stack.push(weightDown);
            }
        }
        return fish + stack.size();
    }

    public static void main(String[] args) {
        int[] A = {4, 3, 2, 1, 5};
        int[] B = {1, 0, 0, 0, 0};
        System.out.println(solution(A, B));
    }
}
