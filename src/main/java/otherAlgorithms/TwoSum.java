package otherAlgorithms;

import java.util.Arrays;

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

    public static void main(String[] args) {
        int[] nums = {1, 5, 9, 11, 12};
        System.out.println(Arrays.toString(new TwoSum().solution(nums, 21)));
    }
}
