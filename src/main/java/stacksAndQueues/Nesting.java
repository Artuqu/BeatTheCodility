package stacksAndQueues;

import java.util.Stack;

public class Nesting {

    public static int solution(String S) {
        Stack<Character> stack = new Stack<>();
        for (char i : S.toCharArray()) {
            if (i == '(') stack.push(i);
            else if (i == ')') {
                if (stack.isEmpty() || stack.pop() != '(') return 0;
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        String S = "(()(())())";
        solution(S);
    }
}
