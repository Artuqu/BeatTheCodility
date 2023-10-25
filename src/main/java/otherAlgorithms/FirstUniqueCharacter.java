package otherAlgorithms;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacter {

    public int solution(String s) {
        if (s == null || s.isEmpty()) return -1;
        Map<Character, Integer> cache = new HashMap<>();
        for (char i : s.toCharArray()) {
            if (cache.containsKey(i)) cache.put(i, cache.get(i) + 1);
            else cache.put(i, 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (cache.get(s.charAt(i)) == 1) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        String s1 = "loveleetcode";
        String s2 = "aabb";
        String s3 = "";
        String s4 = "a";
        System.out.println(new FirstUniqueCharacter().solution(s));
        System.out.println(new FirstUniqueCharacter().solution(s1));
        System.out.println(new FirstUniqueCharacter().solution(s2));
        System.out.println(new FirstUniqueCharacter().solution(s3));
        System.out.println(new FirstUniqueCharacter().solution(s4));
    }
}
