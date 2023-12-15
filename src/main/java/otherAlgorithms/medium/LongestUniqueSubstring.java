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

    public int solution2(String s) {
        Set<Character> cache = new HashSet<>();
        int left = 0, right = 0, max = 0;

        while (right < s.length()) {
            if (!cache.contains(s.charAt(right))) {
                cache.add(s.charAt(right));
                right++;
            } else {
                cache.remove(s.charAt(right));
                left++;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestUniqueSubstring().solution("abcdebifg"));
        System.out.println(new LongestUniqueSubstring().solution("ddabcabcbb"));
        System.out.println(new LongestUniqueSubstring().solution("abcabca"));
        System.out.println(new LongestUniqueSubstring().solution("aaaaaaa"));
        System.out.println("second solution:");
        System.out.println(new LongestUniqueSubstring().solution2("abcdebifg"));// wrong answer
        System.out.println(new LongestUniqueSubstring().solution2("ddabcabcbb"));
        System.out.println(new LongestUniqueSubstring().solution2("abcabca"));
        System.out.println(new LongestUniqueSubstring().solution2("aaaaaaa"));

    }
}
