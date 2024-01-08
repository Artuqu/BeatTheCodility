package otherAlgorithms.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TopKFrequentElements {

    public int[] solution(int[] arr, int k) {
        Arrays.sort(arr);
        List<Integer> result = new ArrayList<>();
        int firstPivot = 0;
        int secondPivot = 0;
        int counter = 0;
        while (secondPivot < arr.length) {
            if (arr[firstPivot] == arr[secondPivot]) {
                counter++;
                secondPivot++;
            } else {
                counter = 0;
                firstPivot = secondPivot;
            }
            if (counter == k) result.add(arr[firstPivot]);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3};
        int[] arr2 = {1};
        System.out.println(Arrays.toString(new TopKFrequentElements().solution(arr, 2)));
        System.out.println(Arrays.toString(new TopKFrequentElements().solution(arr2, 1)));
    }
}
