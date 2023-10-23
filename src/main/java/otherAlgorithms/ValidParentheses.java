package otherAlgorithms;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public boolean solution(String s) {
        boolean result = true;
        if (s == null || s.isEmpty()) return false;
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

    Map<Character, Character> characters = Map.of(
            ')', '(',
            ']', '[',
            '}', '{'
    );

    public boolean solution2(String s) {
        if (s == null || s.isEmpty()) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char input = s.charAt(i);
            if (characters.containsValue(input)) stack.push(input);
            else {
                if (stack.isEmpty() || stack.pop() != characters.get(input)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "()";
        String s1 = "()[]{}";
        String s2 = "(]";
        System.out.println(new ValidParentheses().solution2(s));
        System.out.println(new ValidParentheses().solution2(s1));
        System.out.println(new ValidParentheses().solution2(s2));
    }
}
