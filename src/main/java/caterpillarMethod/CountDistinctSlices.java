package caterpillarMethod;

public class CountDistinctSlices {

    public int solution(int M, int[] A) {
        int totalSlices = 0;
        boolean[] isInCurrentSlice = new boolean[M + 1];
        int front = 0;
        for (int back = 0; back < A.length; back++) {
            while (front < A.length && !isInCurrentSlice[A[front]]) {
                isInCurrentSlice[A[front]] = true;
                totalSlices += (front - back) + 1;
                front++;
                if (totalSlices > 1000000000) return 1000000000;
            }
            isInCurrentSlice[A[back]] = false;
        }
        return totalSlices;
    }

    public static void main(String[] args) {
        int[] A = {3, 4, 5, 5, 2};
        int[] A1 = {2, 4, 1, 7, 4, 9, 7, 3, 5, 5, 8, 7, 1};
        System.out.println(new CountDistinctSlices().solution(6, A));
        System.out.println(new CountDistinctSlices().solution(9, A1));
    }
}
