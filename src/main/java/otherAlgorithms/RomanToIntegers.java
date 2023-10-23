package otherAlgorithms;

import java.util.HashMap;

public class RomanToIntegers {

    char[] symbols = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    int[] value = new int[]{1, 5, 10, 50, 100, 500, 1000};

    public int solution(String s) {
        int result = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 7; i++) {
            hashMap.put(symbols[i], value[i]);
        }
        int lastChar = hashMap.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 1; i >= 0; i--) {
            char roman = s.charAt(i);
            int value = hashMap.get(roman);
            if (value < lastChar) {
                result -= value;
            } else result += value;
            lastChar = value;
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "III";
        String s1 = "LVIII";
        String s2 = "MCMXCIV";
        System.out.println(new RomanToIntegers().solution(s));
        System.out.println(new RomanToIntegers().solution(s1));
        System.out.println(new RomanToIntegers().solution(s2));
    }
}
