package otherAlgorithms;

import java.util.BitSet;

public class FindingDuplicates {


    public void solution(int[] A) {
        boolean[] withoutDuplicates = new boolean[3201];
        for (int i = 0; i < A.length; i++) {
            withoutDuplicates[A[i]] = true;
        }
        for (int i = 0; i < withoutDuplicates.length; i++) {
            if (withoutDuplicates[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public void solution2(int[] A) {
        BitSet bits = new BitSet();
        for (int i = 0; i < A.length; i++) {
            int number = A[i];
            if (bits.get(number)) {
                System.out.println("Duplicate: " + number);
            }
            bits.set(number);
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 5, 1, 7, 0, 9, 5, 3200};

        new FindingDuplicates().solution(A);
        new FindingDuplicates().solution2(A);

    }
}
