package caterpillarMethod;

import java.util.Arrays;

public class MinAbsSumOfTwo {

    public int solution(int[] A) {
        Arrays.sort(A);
        int minValue = Integer.MAX_VALUE;
        int front = A.length - 1;
        for (int back = 0; back <= front; back++) {
            while (Math.abs(A[front]) > Math.abs(A[back])) {
                minValue = getMinValue(A, front, back, minValue);
                front--;
            }
            minValue = getMinValue(A, front, back, minValue);
        }
        return minValue;
    }

    private static int getMinValue(int[] A, int front, int back, int minValue) {
        if (Math.abs(A[front] + A[back]) < minValue)
            minValue = Math.abs(A[front] + A[back]);
        return minValue;
    }

    public static void main(String[] args) {
        int[] A = {1, 4, -3};
        int[] A1 = {-8, 4, 5, -10, 3};
        System.out.println(new MinAbsSumOfTwo().solution(A1));
        System.out.println(new MinAbsSumOfTwo().solution(A));
    }
}
