package prefixSums;

public class PassingCars {

    public int solution(int[] A) {
        int eastCars = 0;
        long totalCars = 0;
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
        return (int) totalCars;
    }

    public static void main(String[] args) {
        int[] A = {0, 1, 0, 1, 1};
        int[] A1 = {0};
        System.out.println(new PassingCars().solution(A1));
        System.out.println(new PassingCars().solution(A));

    }
}
