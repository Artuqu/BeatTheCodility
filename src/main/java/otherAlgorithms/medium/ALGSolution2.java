package otherAlgorithms.medium;

public class ALGSolution2 extends ALGSolution1 {

    public int findCelebrity2(int n) {
        int celebrityCandidate = 0;
        for (int i = 0; i < n; i++) {
            if (knows(celebrityCandidate, i)) celebrityCandidate = i;
        }
        if (isCelebrity(celebrityCandidate)) return celebrityCandidate;
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Second solution: " + new ALGSolution2().findCelebrity2(6));
    }
}
