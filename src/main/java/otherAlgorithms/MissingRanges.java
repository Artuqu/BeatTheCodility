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

    public List<String> solution2(int[] numbers, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (numbers.length == 0) return result;
        int prevPointer = lower - 1;
        for (int i = 0; i <= numbers.length; i++) {
            int curr = i < numbers.length ? numbers[i] : upper + 1;
            String rs = build(prevPointer + 1, curr - 1);
            if (rs != null) result.add(rs);
            prevPointer = curr;
        }
        return result;
    }

    public String build(int lower, int upper) {
        if (lower > upper) return null;
        else if (lower == upper) return String.valueOf(lower);
        else return lower + "->" + upper;
    }

    public static void main(String[] args) {
        int[] numbers1 = new int[]{0, 1, 3, 50, 75};
        int[] numbers2 = new int[]{-1};
        int[] numbers3 = new int[]{};
        int[] numbers4 = new int[]{1, 4, 5, 10, 12};
        System.out.println(new MissingRanges().solution(numbers1, -2, 99));
        System.out.println(new MissingRanges().solution2(numbers1, -2, 99));
        System.out.println(new MissingRanges().solution(numbers2, -1, 3));
        System.out.println(new MissingRanges().solution2(numbers2, -1, 3));
        System.out.println(new MissingRanges().solution(numbers3, -1, -1));
        System.out.println(new MissingRanges().solution2(numbers3, -1, -1));
        System.out.println(new MissingRanges().solution(numbers2, -1, -1));
        System.out.println(new MissingRanges().solution2(numbers2, -1, -1));
        System.out.println(new MissingRanges().solution(numbers4, -2, 17));
        System.out.println(new MissingRanges().solution2(numbers4, -2, 17));
    }
}
