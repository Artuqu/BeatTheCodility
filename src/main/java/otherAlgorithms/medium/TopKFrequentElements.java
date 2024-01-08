package otherAlgorithms.medium;

import java.util.*;

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

    //using map solution
    public int[] solution2(int[] arr, int k) {
        Arrays.sort(arr);
        Map<Integer, Integer> cache = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (cache.containsKey(arr[i])) cache.put(arr[i], cache.get(arr[i]) + 1);
            else cache.put(arr[i], 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = cache.entrySet();
        for (Map.Entry<Integer, Integer> map : entries) {
            if (map.getValue() >= k)
                result.add(map.getKey());
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3};
        int[] arr2 = {1};
        System.out.println(Arrays.toString(new TopKFrequentElements().solution(arr, 2)));
        System.out.println(Arrays.toString(new TopKFrequentElements().solution2(arr, 2)));
        System.out.println(Arrays.toString(new TopKFrequentElements().solution(arr2, 1)));
        System.out.println(Arrays.toString(new TopKFrequentElements().solution2(arr2, 1)));
    }
}
