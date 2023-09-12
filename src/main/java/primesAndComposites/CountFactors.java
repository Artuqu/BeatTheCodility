package primesAndComposites;

public class CountFactors {
    public int solution(int N) {
        int totalFactors = 0;
        int firstFactor = 1;
        int lastFactor = N;
        while (lastFactor > firstFactor) {
            if (N % firstFactor == 0) totalFactors++;
            if (N % lastFactor == 0) totalFactors++;
            firstFactor++;
            lastFactor = N / firstFactor;
        }
        if (firstFactor == lastFactor && N % firstFactor == 0) totalFactors++;
        return totalFactors;
    }

    public static void main(String[] args) {
        System.out.println(new CountFactors().solution(5));
        System.out.println(new CountFactors().solution(1));
        System.out.println(new CountFactors().solution(24));
    }
}
