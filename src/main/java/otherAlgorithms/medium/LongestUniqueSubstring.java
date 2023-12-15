package otherAlgorithms.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestUniqueSubstring {

    public int solution(String s) {
        int maxLength = 0;
        if (s.isEmpty()) return maxLength;
        for (int i = 0; i < s.length(); i++) {
            int curr = calculateLength(s, i);
            maxLength = Math.max(curr, maxLength);
        }
        return maxLength;
    }

    private int calculateLength(String s, int i) {
        Set<Character> cache = new HashSet<>();
        int counter = 0;
        for (int j = i; j < s.length(); j++) {
            if (cache.contains(s.charAt(j))) {
                return counter;
            } else cache.add(s.charAt(j));
            counter++;
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(new LongestUniqueSubstring().solution("abcdebifg"));
        System.out.println(new LongestUniqueSubstring().solution("ddabcabcbb"));
        System.out.println(new LongestUniqueSubstring().solution("abcabca"));
        System.out.println(new LongestUniqueSubstring().solution("aaaaaaa"));
    }
}
