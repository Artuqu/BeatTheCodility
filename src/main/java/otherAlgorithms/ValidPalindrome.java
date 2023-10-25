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

    public boolean solution2(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray())
            if (Character.isLetterOrDigit(ch)) sb.append(Character.toLowerCase(ch));
        String filteredString = sb.toString();
        String reversedString = sb.reverse().toString();
        return filteredString.equals(reversedString);
    }

    public static void main(String[] args) {
        String s = " nan, ";
        String s1 = "race a car";
        System.out.println(new ValidPalindrome().solution2(s));
        System.out.println(new ValidPalindrome().solution2(s1));
    }
}
