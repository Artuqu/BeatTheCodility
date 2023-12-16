package otherAlgorithms.medium;

public class LongestPalindromicSubstring {


    public String solution(String s) {
        if (s == null || s.isEmpty()) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCentre(s, i, i);
            int len2 = expandAroundCentre(s, i, i + 1);
            int len = Math.max(len2, len1);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCentre(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().solution("abccba"));
        System.out.println(new LongestPalindromicSubstring().solution("abcdcba"));
        System.out.println(new LongestPalindromicSubstring().solution("abcdddefaa"));
    }
}
