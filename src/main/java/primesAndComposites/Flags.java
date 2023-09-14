package primesAndComposites;

public class Flags {

    public int solution(int[] A) {
        int[] peaks = new int[A.length];
        int nextPeak = A.length;
        peaks[A.length - 1] = nextPeak;
        for (int i = A.length - 2; i > 0; i--) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                nextPeak = i;
            }
            peaks[i] = nextPeak;
        }
        peaks[0] = nextPeak;
        int currentGuess = 0;
        int nextGuess = 0;
        while (canPlaceFlags(peaks, nextGuess)) {
            currentGuess = nextGuess;
            nextGuess++;
        }
        return currentGuess;
    }

    private boolean canPlaceFlags(int[] peaks, int flagsToPlace) {
        int currentPosition = 1 - flagsToPlace;
        for (int i = 0; i < flagsToPlace; i++) {
            if (currentPosition + flagsToPlace > peaks.length - 1) {
                return false;
            }
            currentPosition = peaks[currentPosition + flagsToPlace];
        }
        return currentPosition < peaks.length;
    }

    public static void main(String[] args) {
        int[] A = {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2};
        System.out.println(new Flags().solution(A));
    }
}
