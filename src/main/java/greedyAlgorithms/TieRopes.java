package greedyAlgorithms;

public class TieRopes {

    public int solution(int K, int[] A) {
        int sum = 0;
        int sumOfK = 0;
        for (int rope : A) {
            sum += rope;
            if (sum >= K) {
                sumOfK++;
                sum = 0;
            }
        }
        return sumOfK;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 1, 1, 3};
        System.out.println(new TieRopes().solution(4, A));
    }
}
