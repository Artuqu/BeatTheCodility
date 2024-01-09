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
        for (int j : arr) {
            cache.put(j, cache.getOrDefault(j, 0) + 1);
        }
        Set<Map.Entry<Integer, Integer>> entries = cache.entrySet();
        for (Map.Entry<Integer, Integer> map : entries) {
            if (map.getValue() >= k)
                result.add(map.getKey());
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] solution3(int[] arr, int k) {
        Arrays.sort(arr);
        if (k == arr.length) return arr;
        Map<Integer, Integer> cache = new HashMap<>();
        for (int n : arr) {
            cache.put(n, cache.getOrDefault(n, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(cache.entrySet());
        Collections.sort(entries, (e1, e2) -> e2.getValue() - e1.getValue());
        List<Integer> result = new ArrayList<>();
        for (int i = k - 1; i >= 0; i--) {
            if (entries.get(i).getValue() >= k) result.add(entries.get(i).getKey());
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] solution4(int[] arr, int k) {
        Arrays.sort(arr);
        Map<Integer, Integer> cache = new HashMap<>();
        for (int n : arr) {
            cache.put(n, cache.getOrDefault(n, 0) + 1);
        }
        List<Integer>[] buckets = new List[arr.length + 1];
        for (int num : cache.keySet()) {
            int frequency = cache.get(num);
            if (buckets[frequency] == null) buckets[frequency] = new ArrayList<>();
            buckets[frequency].add(num);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = buckets.length - 1; i >= k; i--) {
            if (buckets[i] != null) result.addAll(buckets[i]);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3};
        int[] arr2 = {1};
        int[] arr3 = {1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 6, 6, 6};
        System.out.println(Arrays.toString(new TopKFrequentElements().solution(arr, 2)));
        System.out.println(Arrays.toString(new TopKFrequentElements().solution2(arr, 2)));
        System.out.println(Arrays.toString(new TopKFrequentElements().solution3(arr, 2)));
        System.out.println(Arrays.toString(new TopKFrequentElements().solution(arr2, 1)));
        System.out.println(Arrays.toString(new TopKFrequentElements().solution2(arr2, 1)));
        System.out.println(Arrays.toString(new TopKFrequentElements().solution3(arr2, 1)));
        System.out.println(Arrays.toString(new TopKFrequentElements().solution(arr3, 3)));
        System.out.println(Arrays.toString(new TopKFrequentElements().solution2(arr3, 3)));
        System.out.println(Arrays.toString(new TopKFrequentElements().solution3(arr3, 3)));
        System.out.println(Arrays.toString(new TopKFrequentElements().solution4(arr3, 3)));
    }
}
