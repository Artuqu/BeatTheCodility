package sorting;

import java.util.Arrays;

public class NumberOfDiscIntersections {

    public int solution(int[] A) {
        int result = 0;
        DiscCircle[] discCircles = new DiscCircle[A.length];
        for (int i = 0; i < A.length; i++) {
            discCircles[i] = new DiscCircle((long) i - A[i], (long) i + A[i]);
        }
        Arrays.sort(discCircles);
        for (int i = 0; i < discCircles.length; i++) {
            long endPointValue = discCircles[i].endPosition;
            for (int j = i; j < discCircles.length; j++) {
                long startPointValue = discCircles[j].startPosition;
                if (endPointValue >= startPointValue) {
                    result++;
                }
            }
            result--;
        }
        return result;
    }

    class DiscCircle implements Comparable<DiscCircle> {

        long startPosition;
        long endPosition;

        @Override
        public int compareTo(DiscCircle dc) {
            return this.startPosition != dc.startPosition ? Long.compare(this.startPosition, dc.startPosition) : Long.compare(this.endPosition, dc.endPosition);
        }

        public DiscCircle(long startPosition, long endPosition) {
            this.startPosition = startPosition;
            this.endPosition = endPosition;
        }
    }


    //    second solution
    class DiscLog implements Comparable<DiscLog> {
        final long x;
        final int startEnd;

        public DiscLog(long x, int startEnd) {
            this.x = x;
            this.startEnd = startEnd;
        }

        @Override
        public int compareTo(DiscLog o) {
            return this.x != o.x ? Long.compare(this.x, o.x) : Integer.compare(o.startEnd, this.startEnd);
        }

    }

    public int solution2(int[] A) {
        int length = A.length;
        DiscLog[] discHistory = new DiscLog[length * 2];
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            discHistory[j++] = new DiscLog((long) i - A[i], 1);
            discHistory[j++] = new DiscLog((long) i + A[i], -1);
        }
        Arrays.sort(discHistory);
        int intersections = 0;
        int activeIntersections = 0;
        for (DiscLog logs : discHistory) {
            activeIntersections += logs.startEnd;
            if (logs.startEnd > 0) intersections += activeIntersections - 1;
            if (intersections > 10000000) return -1;
        }
        return intersections;
    }


    public static void main(String[] args) {
        int[] A = {1, 5, 2, 1, 4, 0};
        System.out.println(new NumberOfDiscIntersections().solution(A));

    }
}
