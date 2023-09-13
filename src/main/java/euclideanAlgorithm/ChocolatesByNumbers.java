package euclideanAlgorithm;

public class ChocolatesByNumbers {

    public int solution(int N, int M) {
        int commonDivider = findGcd(N, M);
        return N / commonDivider;
    }

    private int findGcd(int a, int b) {
        if (b == 0) return a;
        else
            return findGcd(b, a % b);

    }

    public static void main(String[] args) {
        System.out.println(new ChocolatesByNumbers().solution(10, 4));
    }
}
