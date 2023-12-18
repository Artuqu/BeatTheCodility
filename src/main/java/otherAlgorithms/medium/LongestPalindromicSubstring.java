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

    //    dynamic programming version
    public String solution2(String s) {
        if (s == null || s.isEmpty()) return "";
        int n = s.length();
        String longest = s.substring(0, 1);
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                boolean compareCharacters = s.charAt(i) == s.charAt(j);
                if (len == 2) dp[i][j] = compareCharacters;
                else {
                    dp[i][j] = (compareCharacters && dp[i + 1][j - 1]);
                }
//                update the longest palindromic substring if needed
                if (dp[i][j] && len > longest.length()) longest = s.substring(i, j + 1);
            }
        }
        return longest;
    }


    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().solution("abccba"));
        System.out.println(new LongestPalindromicSubstring().solution("abcdcba"));
        System.out.println(new LongestPalindromicSubstring().solution("abcdddefaa"));
        System.out.println("Second solution:");
        System.out.println(new LongestPalindromicSubstring().solution2("abccba"));
        System.out.println(new LongestPalindromicSubstring().solution2("abcdcba"));
        System.out.println(new LongestPalindromicSubstring().solution2("abcdddefaa"));
    }
}
