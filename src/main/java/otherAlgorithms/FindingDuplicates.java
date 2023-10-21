package otherAlgorithms;

public class FindingDuplicates {


    public void solution(int[] A) {
        boolean[] withoutDuplicates = new boolean[3200];
        for (int i = 0; i < A.length; i++) {
            withoutDuplicates[A[i]] = true;
        }
        for (int i = 0; i < withoutDuplicates.length; i++) {
            if (withoutDuplicates[i]) {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 5, 1, 7, 0, 9, 5,};

        new FindingDuplicates().solution(A);
    }
}
