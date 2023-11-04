package otherAlgorithms;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean solution(int n) {
        Set<Integer> cache = new HashSet<>();
        while (n >= 1) {
            if (cache.contains(1)) return true;
            n = calculateNumber(n);
            if (cache.contains(n)) return false;
            cache.add(n);
        }
        return false;
    }

    private Integer calculateNumber(int n) {
        String number = String.valueOf(n);
        int result = 0;
        for (int i = 0; i < number.length(); i++) {
            int toSquare = Integer.parseInt(String.valueOf(number.charAt(i)));
            result += toSquare * toSquare;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().solution(9));
        System.out.println(new HappyNumber().solution(19));
        System.out.println(new HappyNumber().solution(116));
        System.out.println(new HappyNumber().solution(82));
        System.out.println(new HappyNumber().solution(1));
    }
}
