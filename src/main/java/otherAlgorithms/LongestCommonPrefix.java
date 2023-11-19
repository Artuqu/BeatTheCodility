package otherAlgorithms;

import java.util.Arrays;
import java.util.Comparator;

public class LongestCommonPrefix {

    public String solution(String[] strings) {
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strings, Comparator.comparing(String::length));
        int length = strings[0].length();
        for (int i = 0; i < length; i++) {
            char first = strings[i].charAt(i);
            for (int j = i + 1; j < strings.length; j++) {
                char second = strings[j].charAt(i);
                if (first != second) return sb.toString();
                if (j == strings.length - 1) sb.append(first);
            }
        }
        return sb.toString();
    }

    public String scanning(String[] strings) {
        String lcp = strings[0];
        for (int i = 1; i < strings.length; i++) {
            lcp = commonPrefix(lcp, strings[i]);
        }
        return lcp;
    }

    private String commonPrefix(String s1, String s2) {
        int min = Math.min(s1.length(), s2.length());
        for (int i = 0; i < min; i++) {
            if (s1.charAt(i) != s2.charAt(i)) return s1.substring(0, i);
        }
        return s1.substring(0, min);
    }

    public static void main(String[] args) {
        String[] strings1 = {"flat", "flower", "flow", "flight", "florida"};
        String[] strings2 = {"dog", "cat", "car"};
        String[] strings3 = {"can", "cat", "car"};
        System.out.println(new LongestCommonPrefix().solution(strings1));
        System.out.println(new LongestCommonPrefix().scanning(strings1));

        System.out.println(new LongestCommonPrefix().solution(strings2));
        System.out.println(new LongestCommonPrefix().scanning(strings2));

        System.out.println(new LongestCommonPrefix().solution(strings3));
        System.out.println(new LongestCommonPrefix().scanning(strings3));

    }
}
