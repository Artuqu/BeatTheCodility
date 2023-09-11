package maximumSliceProblem;

public class MaxSliceSum {

    public int solution(int[] A) {
        int globalMax = Integer.MIN_VALUE;
        int currentMax = 0;
        for (int i : A) {
            currentMax += i;
            if (currentMax < i) currentMax = i;
            globalMax = Math.max(currentMax, globalMax);
        }
        return globalMax;
    }

    public static void main(String[] args) {
        int[] A = {3, 2, -6, 4, 0};
        System.out.println(new MaxSliceSum().solution(A));
    }
}
