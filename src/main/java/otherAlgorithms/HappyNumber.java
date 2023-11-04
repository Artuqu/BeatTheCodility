package otherAlgorithms;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean solution(int n) {
        Set<Integer> cache = new HashSet<>();
        while (n != 1) {
            n = calculateNumber(n);
            if (cache.contains(n)) return false;
            cache.add(n);
        }
        return true;
    }

    public boolean solution2(int n) {
        Set<Integer> cache = new HashSet<>();
        while (n != 1 && !cache.contains(n)) {
            cache.add(n);
            n = sumOfDigits(n);
        }
        return n == 1;
    }

    //    no extra data structure
    public boolean solution3(int n) {
        int slow = n;
        int fast = sumOfDigits(n);
        while (fast != 1 && slow != fast) {
            slow = sumOfDigits(slow);
            fast = sumOfDigits(sumOfDigits(fast));
        }
        return fast == 1;
    }

    private int sumOfDigits(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            n = n / 10;
            sum += digit * digit;
        }
        return sum;
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
        System.out.println(new HappyNumber().solution3(116));
        System.out.println(new HappyNumber().solution3(9));
        System.out.println(new HappyNumber().solution3(19));
        System.out.println(new HappyNumber().solution3(82));
        System.out.println(new HappyNumber().solution3(1));
    }
}
