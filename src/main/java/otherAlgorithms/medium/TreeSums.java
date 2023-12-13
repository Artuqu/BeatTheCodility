package otherAlgorithms.medium;

import java.util.*;

public class TreeSums {

    public List<List<Integer>> solution(int[] arr, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        if (arr[0] >= sum) return result;
        int sumOfTree;
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            if (i > 0) {
                if (arr[i - 1] == arr[i]) continue;
            }
            while (left < right) {
                sumOfTree = arr[i] + arr[left] + arr[right];
                if (sumOfTree > sum) right--;
                else if (sumOfTree < sum) left++;
                else {
                    result.add(List.of(arr[i], arr[left], arr[right]));
                    left++;
                    right--;
                }
            }
        }
        return result;
    }

    public int[][] solution2(int[] arr, int sum) {
        Arrays.sort(arr);
        if (arr[0] >= sum) return new int[0][];
        int[][] result = new int[arr.length][];
        int sumOfTree;
        int size = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            if (i > 0) {
                if (arr[i - 1] == arr[i]) continue;
            }
            while (left < right) {
                sumOfTree = arr[i] + arr[left] + arr[right];
                if (sumOfTree > sum) right--;
                else if (sumOfTree < sum) left++;
                else {
                    result[size] = new int[]{arr[i], arr[left], arr[right]};
                    left++;
                    right--;
                    size++;
                }
            }
        }
        return result;
    }

    public List<List<Integer>> solution3(int[] arr, int sum) {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < arr.length && arr[i] <= sum; i++) {
            if (i == 0 || arr[i - 1] != arr[i]) twoSum(arr, i, result, sum);
        }
        return result;

    }

    private void twoSum(int[] arr, int i, List<List<Integer>> result, int sum) {
        Set<Integer> cache = new HashSet<>();
        for (int j = i + 1; j < arr.length; ++j) {
            int restOfThree = sum - arr[i] - arr[j];
            if (cache.contains(restOfThree)) {
                result.add(Arrays.asList(arr[i], arr[j], restOfThree));
                while (j + 1 < arr.length && arr[j] == arr[j + 1]) j++;
            }
            cache.add(arr[j]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 2, 2, 2};
        int[] arr2 = {-4, -1, -1, 0, 1, 2};
        System.out.println(new TreeSums().solution(arr, 6));
        System.out.println(Arrays.deepToString(new TreeSums().solution2(arr, 6)));
        System.out.println(new TreeSums().solution3(arr, 6));
        System.out.println(new TreeSums().solution(arr2, 0));
        System.out.println(Arrays.deepToString(new TreeSums().solution2(arr2, 0)));
        System.out.println(new TreeSums().solution3(arr2, 0));

    }
}
