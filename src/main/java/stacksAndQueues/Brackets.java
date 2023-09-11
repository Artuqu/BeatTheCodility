package stacksAndQueues;

import java.util.Stack;

public class Brackets {

    public static int solution(String S) {
        Stack<Character> characters = new Stack<>();
        for (char c : S.toCharArray()) {
            if (c == '{' || c == '[' || c == '(') {
                characters.push(c);
            } else if (c == '}') {
                if (characters.isEmpty() || characters.pop() != '{') return 0;
            } else if (c == ']') {
                if (characters.isEmpty() || characters.pop() != '[') return 0;
            } else if (c == ')') {
                if (characters.isEmpty() || characters.pop() != '(') return 0;
            }
        }
        return characters.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) {
        String S = "{[()()]}";
        String S1 = ")(";
        System.out.println(solution(S));
        System.out.println(solution(S1));
    }
}
