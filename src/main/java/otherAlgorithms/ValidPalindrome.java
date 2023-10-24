package otherAlgorithms;

public class ValidPalindrome {

    public boolean solution(String s) {
        if (s.length() == 1) return true;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char leftChar = Character.toLowerCase(s.charAt(left));
            char rightChar = Character.toLowerCase(s.charAt(right));
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                continue;
            }
            if (leftChar != rightChar) return false;
            right--;
            left++;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = " nan, ";
        String s1 = "race a car";
        System.out.println(new ValidPalindrome().solution(s));
        System.out.println(new ValidPalindrome().solution(s1));
    }
}
