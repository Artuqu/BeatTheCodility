package otherAlgorithms;

import java.util.Stack;

public class ValidParentheses {

    public boolean solution(String s) {
        boolean result = true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char bracket = s.charAt(i);
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
            } else if (bracket == ')') {
                if (stack.isEmpty() || stack.pop() != '(') return false;
            } else if (bracket == ']') {
                if (stack.isEmpty() || stack.pop() != '[') return false;
            } else if (bracket == '}') {
                if (stack.isEmpty() || stack.pop() != '{') return false;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "()";
        String s1 = "()[]{}";
        String s2 = "(]";
        System.out.println(new ValidParentheses().solution(s));
        System.out.println(new ValidParentheses().solution(s1));
        System.out.println(new ValidParentheses().solution(s2));
    }
}
