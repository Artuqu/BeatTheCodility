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

    public int[] solution2(int[] A) {
        int length = A.length - 1;
        for (int i = length; i >= 0; i--) {
            if (A[i] == 9) A[i] = 0;
            else {
                A[i]++;
                return A;
            }
        }
        A = new int[length + 2];
        A[0] = 1;
        return A;
    }


    public static void main(String[] args) {
        int[] A = {1, 2, 3};
        int[] A1 = {4, 3, 2, 1};
        int[] A2 = {9, 9};
        int[] A3 = {2, 9, 9};
        System.out.println(Arrays.toString(new PlusOne().solution2(A)));
        System.out.println(Arrays.toString(new PlusOne().solution2(A1)));
        System.out.println(Arrays.toString(new PlusOne().solution2(A2)));
        System.out.println(Arrays.toString(new PlusOne().solution2(A3)));
    }
}
