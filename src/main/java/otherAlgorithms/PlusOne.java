package otherAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {

    public int[] solution(int[] A) {
        StringBuilder s = new StringBuilder();
        for (int i : A) {
            s.append(i);
        }
        long newNumber = Long.parseLong(s.toString()) + 1;
        List<Integer> result = new ArrayList<>();
        String number = String.valueOf(newNumber);
        for (int i = 0; i < number.length(); i++) {
            result.add(Integer.parseInt(String.valueOf(number.charAt(i))));
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int[] A1 = {4, 3, 2, 1};
        int[] A2 = {9};
        System.out.println(Arrays.toString(new PlusOne().solution(A)));
        System.out.println(Arrays.toString(new PlusOne().solution(A1)));
        System.out.println(Arrays.toString(new PlusOne().solution(A2)));
    }
}
