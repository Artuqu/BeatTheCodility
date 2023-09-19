package prefixSums;

import java.util.Arrays;

public class GenomicRangeQuery {
    // 75% Time complexity O(N*M)
    public int[] solution(String S, int[] P, int[] Q) {
        int[] impactFactors = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            int placeP = P[i];
            int placeQ = Q[i];
            impactFactors[i] = findMinNumber(S, placeP, placeQ);
        }
        return impactFactors;
    }

    private int findMinNumber(String s, int start, int end) {
        String sequence = s.substring(start, end + 1);
        if (sequence.contains("A")) return 1;
        else if (sequence.contains("C")) return 2;
        else if (sequence.contains("G")) return 3;
        else return 4;
    }

    public static void main(String[] args) {
        String s = "CAGCCTA";
        int[] P = {2, 5, 0};
        int[] Q = {4, 5, 6};
        System.out.println(Arrays.toString(new GenomicRangeQuery().solution(s, P, Q)));
    }
}
