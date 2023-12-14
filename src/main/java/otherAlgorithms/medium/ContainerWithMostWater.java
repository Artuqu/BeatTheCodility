package otherAlgorithms.medium;

public class ContainerWithMostWater {

    public int solution(int[] height) {
        int result = 0, curr;
        int right = height.length - 1;
        int left = 0;
        while (left < right) {
            curr = Math.min(height[left], height[right]) * (right - left);
            result = Math.max(result, curr);
            if (height[left] > height[right]) {
                right--;
            } else left++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(new ContainerWithMostWater().solution(arr));
    }
}
