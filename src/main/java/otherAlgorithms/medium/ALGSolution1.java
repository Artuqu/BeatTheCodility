package otherAlgorithms.medium;

public class ALGSolution1 extends AdjListGraph {

    private int numberOfPeople;

    public int findCelebrity(int n) {
        numberOfPeople = n;
        for (int i = 0; i < n; i++) {
            if (isCelebrity(i)) return i;
        }
        return -1;
    }

    boolean isCelebrity(int i) {
        for (int j = 0; j < numberOfPeople; j++) {
            if (i == j) continue;
            if (knows(i, j)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ALGSolution1 solution1 = new ALGSolution1();
        System.out.println("First solution: " + solution1.findCelebrity(6));

    }
}
