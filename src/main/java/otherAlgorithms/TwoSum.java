package otherAlgorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] solution(int[] nums, int target) {
        return twoSumHelper(0, 1, nums, target);
    }

    private int[] twoSumHelper(int i, int j, int[] nums, int target) {
        if (j == nums.length) return twoSumHelper(i + 1, i + 2, nums, target);
        if (i == nums.length - 1) throw new RuntimeException();
        if (nums[i] + nums[j] == target) return new int[]{i, j};
        return twoSumHelper(i, j + 1, nums, target);
    }


    public int[] solution2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            map.put(nums[i], i);
            if (map.containsKey(difference)) return new int[]{map.get(difference), i};
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 9, 11, 12};
        System.out.println(Arrays.toString(new TwoSum().solution2(nums, 21)));
    }
}
