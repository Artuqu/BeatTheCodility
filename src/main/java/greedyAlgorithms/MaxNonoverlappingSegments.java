package greedyAlgorithms;

import java.util.Stack;

public class MaxNonoverlappingSegments {
    public int solution(int[] A, int[] B) {
        Stack<Segment> segmentStack = new Stack<>();
        for (int i = 0; i < A.length; i++) {
            Segment segment = new Segment(A[i], B[i]);
            if (segmentStack.isEmpty() || segment.start > segmentStack.peek().end) {
                segmentStack.push(segment);
            }
        }
        return segmentStack.size();
    }

    class Segment {
        private int start;
        private int end;

        public Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

    public int solution2(int[] A, int[] B) {
        int lastEndSegment = -1;
        int chosenCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > lastEndSegment) {
                chosenCount++;
                lastEndSegment = B[i];
            }
        }
        return chosenCount;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 7, 9, 9};
        int[] B = {5, 6, 8, 9, 10};
        int[] A1 = {};
        int[] B1 = {};
        System.out.println(new MaxNonoverlappingSegments().solution2(A1, B1));
        System.out.println(new MaxNonoverlappingSegments().solution2(A, B));
    }
}
