package otherAlgorithms.medium;

import java.util.ArrayList;
import java.util.List;

public class StringPatternMatch {


    public int solution(String needle, String haystack) {
        int nLength = needle.length();
        int hLength = haystack.length();
        for (int i = 0; i < hLength - nLength + 1; i++) {
//            improving time complexity
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i, i + nLength).equals(needle)) return i;
            }
        }
        return -1;
    }

    public List<Integer> solution2(String needle, String haystack) {
        int n = 0;// current position of character in needle
        int h = 0;
        int nLength = needle.length();
        int hLength = haystack.length();

        List<Integer> matches = new ArrayList<>();
        int[] lpsArr = lps(needle);
        while (h < hLength) {
            if (needle.charAt(n) == haystack.charAt(h)) {
                n++;
                h++;
                if (n == nLength) {
                    matches.add(h - n);
                    n = lpsArr[n];
                }
            } else {
                n = lpsArr[n];
                if (n < 0){
                    n++;
                    h++;
                }
            }
        }
        return matches;
    }

    //longest prefix suffix array
    public int[] lps(String pattern) {
        int patternLen = pattern.length();
        int[] arr = new int[patternLen + 1];
        arr[0] = -1;
        arr[1] = 0;

        int prefixLen = 0;
        int i = 1;
        while (i < patternLen) {
            if (pattern.charAt(prefixLen) == pattern.charAt(i)) {
                prefixLen++;
                i++;
                arr[i] = prefixLen;
            } else if (prefixLen > 0) {
                prefixLen = arr[prefixLen];
            } else {
                i++;
                arr[i] = 0;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        String haystack = "istomistom";
        String needle = "tom";
        System.out.println(new StringPatternMatch().solution(needle, haystack));
        System.out.println(new StringPatternMatch().solution("onions", "oniononions"));
        System.out.println("Second solution:");
        System.out.println(new StringPatternMatch().solution2(needle, haystack));
        System.out.println(new StringPatternMatch().solution2("onions", "oniononions"));

    }
}
