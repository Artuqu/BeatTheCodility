package timeComplexity;

public class Equilibrium {

    public static int solution(int[] A) {
        long leftSum = A[0], rightSum = 0;
        int result = 0;
        for (int i = 1; i < A.length; i++) {
            rightSum += A[i];
        }
        result = (int) Math.abs(leftSum - rightSum);
//  iterate has to end length - 1 cause right side is at least size one
        for (int i = 1; i < A.length - 1; i++) {
            leftSum += A[i];
            rightSum -= A[i];
            int newSum = (int) Math.abs(leftSum - rightSum);
            if (newSum < result) {
                result = newSum;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {3, 1, 2, 4, 3};
        int[] B = {3, -11};
        System.out.println(solution(A));
        System.out.println(solution(B));
    }
}
