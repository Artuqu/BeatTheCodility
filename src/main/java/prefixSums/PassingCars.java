package prefixSums;

public class PassingCars {

    public int solution(int[] A) {
        int eastCars = 0;
        int totalCars = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                eastCars++;
            } else if (A[i] == 1) {
                totalCars += eastCars;
            }
        }
        if (totalCars > 1000000000) {
            return -1;
        }
        return totalCars;
    }

    public int solution2(int[] A) {
        int[] suffixSum = new int[A.length + 1];
        int count = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            suffixSum[i] = A[i] + suffixSum[i + 1];
            if (A[i] == 0) count += suffixSum[i];
            if (count > 1000000000) return -1;
        }
        return count;
    }


    public static void main(String[] args) {
        int[] A = {0, 1, 0, 1, 1};
        int[] A1 = {0};
        System.out.println(new PassingCars().solution2(A1));
        System.out.println(new PassingCars().solution2(A));

    }
}
