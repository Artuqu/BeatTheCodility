package otherAlgorithms;

public class BestTimeOfBuyAndSell {

    public int solution(int[] A) {
        if (A == null || A.length == 0) return 0;
        int minPrice = A[0];
        int profit = 0;
        for (int i = 1; i < A.length; i++) {
            minPrice = Math.min(minPrice, A[i]);
            profit = Math.max(A[i] - minPrice, profit);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] A = {7, 1, 5, 3, 6, 4};
        int[] A1 = {7, 3, 20, 3, 1, 6, 10};
        int[] A2 = {7, 5, 4, 3, 1};
        System.out.println(new BestTimeOfBuyAndSell().solution(A));
        System.out.println(new BestTimeOfBuyAndSell().solution(A1));
        System.out.println(new BestTimeOfBuyAndSell().solution(A2));
    }
}
