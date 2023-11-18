package otherAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {


    public List<String> solution(int[] list, int lower, int upper) {
        List<String> result = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        secondList.add(lower);
        for (int i = 0; i < list.length; i++) {
            secondList.add(list[i]);
        }
        secondList.add(upper);
        if (list.length == 0) return result;
        for (int i = 0; i < secondList.size() - 1; i++) {
            int firstPointer = secondList.get(i);
            int firstNumber = firstPointer + 1;
            if (firstPointer == lower) {
                firstNumber = lower;
                firstPointer--;
            }

            int secondPointer = secondList.get(i + 1);
            int secondNumber = secondPointer - 1;
            if (secondPointer == upper) secondNumber = upper;
            if (firstPointer + 2 == secondPointer) {
                sb.append(firstNumber);
                result.add(String.valueOf(sb));
                sb = new StringBuilder();
            } else if (firstPointer + 2 < secondPointer) {
                sb.append(firstNumber).append("->").append(secondNumber);
                result.add(String.valueOf(sb));
                sb = new StringBuilder();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] numbers1 = new int[]{0, 1, 3, 50, 75};
        int[] numbers2 = new int[]{-1};
        int[] numbers3 = new int[]{};
        int[] numbers4 = new int[]{1, 4, 5, 10, 12};
        System.out.println(new MissingRanges().solution(numbers1, -2, 99));
        System.out.println(new MissingRanges().solution(numbers2, -1, 3));
        System.out.println(new MissingRanges().solution(numbers3, -1, -1));
        System.out.println(new MissingRanges().solution(numbers2, -1, -1));
        System.out.println(new MissingRanges().solution(numbers4, -2, 17));
    }
}
