package maximumSliceProblem;

public class MaxProfit {

    public int solution(int[] A) {
        int globalMaxValue = 0;
        int localMaxValue = 0;
        for (int i = 1; i < A.length; i++) {
            int d = A[i] - A[i - 1];
            localMaxValue = Math.max(d, d + localMaxValue);
            globalMaxValue = Math.max(localMaxValue, globalMaxValue);
        }
        return globalMaxValue;
    }

    public static void main(String[] args) {
        int[] A = {23171, 21011, 21123, 21366, 21013, 21367};
        System.out.println(new MaxProfit().solution(A));
    }
}
