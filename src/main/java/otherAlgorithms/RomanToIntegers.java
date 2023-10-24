package otherAlgorithms;

import java.util.HashMap;
import java.util.Map;

public class RomanToIntegers {

    char[] symbols = new char[]{'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    int[] value = new int[]{1, 5, 10, 50, 100, 500, 1000};

    public int solution(String s) {
        if (s == null || s.isEmpty()) return 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < 7; i++) {
            hashMap.put(symbols[i], value[i]);
        }
        int result = 0;
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


    Map<Character, Integer> romans = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000);

    public int solution2(String s) {
        if (s == null || s.isEmpty()) return 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c1 = s.charAt(i);
            Character c2 = i + 1 < s.length() ? s.charAt(i + 1) : null;
            if (specialCases(c1, c2) != null) {
                result += specialCases(c1, c2);
                i++;
            } else result += romans.get(c1);
        }
        return result;
    }

    public Integer specialCases(Character c1, Character c2) {
        if (c1 == null || c2 == null) return null;
        if (c1 == 'I' && c2 == 'V') return 4;
        if (c1 == 'I' && c2 == 'X') return 9;
        if (c1 == 'X' && c2 == 'L') return 40;
        if (c1 == 'X' && c2 == 'C') return 90;
        if (c1 == 'C' && c2 == 'D') return 400;
        if (c1 == 'C' && c2 == 'M') return 900;
        return null;
    }

    public static void main(String[] args) {
        String s = "III";
        String s1 = "LVIII";
        String s2 = "MCMXCIV";
        System.out.println(new RomanToIntegers().solution2(s));
        System.out.println(new RomanToIntegers().solution2(s1));
        System.out.println(new RomanToIntegers().solution2(s2));
    }
}
