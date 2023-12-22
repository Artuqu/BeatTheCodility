package otherAlgorithms.medium;

public class InterpolationSearch {

    public int solution(int[] numbers, int target) {
        if (numbers.length == 0) return -1;
        int low = 0;
        int high = numbers.length - 1;
        while (low <= high && target >= numbers[low] && target <= numbers[high]) {
            int pos = low + ((target - numbers[low]) * (high - low)) / (numbers[high] - numbers[low]);
            if (numbers[pos] == target) return pos;
            else if (numbers[pos] < target) low = pos + 1;
            else high = pos - 1;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 6, 9};
        System.out.println(new InterpolationSearch().solution(numbers, 5));
    }
}
