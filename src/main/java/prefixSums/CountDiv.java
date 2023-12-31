package prefixSums;

public class CountDiv {

    public int solution(int A, int B, int K) {
        int firstDivider = 0;
        int lastDivider = 0;
        for (int i = 0; i <= K; i++) {
            if ((A + i) % K == 0) {
                firstDivider = A + i;
                break;
            }
        }
        for (int i = 0; i <= K; i++) {
            if ((B - i) % K == 0) {
                lastDivider = B - i;
                break;
            }
        }
        return lastDivider / K - firstDivider / K + 1;
    }

    public int solution2(int A, int B, int K) {
        double start = Math.ceil((double) A / K);
        double end = Math.floor((double) B / K);
        return (int) (end - start + 1);
    }


    public static void main(String[] args) {

        System.out.println(new CountDiv().solution2(6, 11, 2));
        System.out.println(new CountDiv().solution2(6, 6, 2));
    }
}
