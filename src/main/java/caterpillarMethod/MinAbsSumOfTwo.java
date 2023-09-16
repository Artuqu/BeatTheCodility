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

//    second solution

    public int solution2(int[] A) {
        Arrays.sort(A);
        int minAbsSumOfTwo = Integer.MAX_VALUE;
        int tail = 0;
        int head = A.length - 1;
        while (head >= tail) {
            minAbsSumOfTwo = Math.min(minAbsSumOfTwo, Math.abs(A[tail] + A[head]));
            if (A[tail] + A[head] < 0) tail++;
            else head--;
        }
        return minAbsSumOfTwo;
    }

    public static void main(String[] args) {
        int[] A = {1, 4, -3};
        int[] A1 = {-8, 4, 5, -10, 3};
        System.out.println(new MinAbsSumOfTwo().solution2(A1));
        System.out.println(new MinAbsSumOfTwo().solution2(A));
    }
}
