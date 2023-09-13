package timeComplexity;

public class PermMissingElement {


    static int solution(int[] A) {
        int sum = 0;
        long arrSum = 0;
        long max = A.length + 1;
        sum = (int) ((max * (max + 1)) / 2);
        for (int i = 0; i < A.length; i++) {
            arrSum += A[i];
        }
        return (int) (sum - arrSum);
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 5};
        int[] arr1 = {3, 2, 5, 1, 6, 8, 4};
        System.out.println(solution(arr));
        System.out.println(solution(arr1));
    }
}
