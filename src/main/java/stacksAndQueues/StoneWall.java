package stacksAndQueues;

import java.util.Stack;

public class StoneWall {

    public int solution(int[] H) {
        Stack<Integer> stack = new Stack<>();
        int blocks = 0;
        for (int i : H) {
            while (!stack.isEmpty() && i < stack.peek()) {
                stack.pop();
            }
            if (!stack.isEmpty() && stack.peek() == i) {
            } else {
                stack.push(i);
                blocks++;
            }
        }
        return blocks;
    }

    public static void main(String[] args) {
        int[] A = {8, 8, 5, 7, 9, 8, 7, 4, 8};
        System.out.println(new StoneWall().solution(A));
    }
}
