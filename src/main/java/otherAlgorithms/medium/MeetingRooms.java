package otherAlgorithms.medium;

import java.lang.ref.ReferenceQueue;
import java.util.*;

public class MeetingRooms {

    // solution with bug
    public int solution(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(intervals[0]);
        int counter = 1;
        int i = 1;
        while (!queue.isEmpty() && i < intervals.length) {
            int[] curr = queue.poll();
            int[] lastInterval = intervals[i];
            if (curr[1] > lastInterval[0]) counter++;
            queue.add(intervals[i]);
            i++;
        }
        return counter;
    }

    public int solution2(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> endTimes = new PriorityQueue<>();
        endTimes.offer(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int earliestEndTime = endTimes.peek();
            if (interval[0] >= earliestEndTime) endTimes.poll();
            endTimes.offer(interval[1]);
        }
        return endTimes.size();
    }

    //Chronological order
    public int solution3(int[][] intervals) {
        if (intervals.length == 0 || intervals[0].length == 0) return 0;
        int[] startPoint = new int[intervals.length];
        int[] endPoint = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            startPoint[i] = intervals[i][0];
            endPoint[i] = intervals[i][1];
        }
        Arrays.sort(startPoint);
        Arrays.sort(endPoint);
        int rooms = 0;
        for (int startIndex = 0, endIndex = 0; startIndex < intervals.length; startIndex++) {
            if (startPoint[startIndex] < endPoint[endIndex]) rooms++;
            else endIndex++;
        }
        return rooms;
    }

    public static void main(String[] args) {
        int[][] arr = {{0, 30}, {5, 10}, {15, 20}};
        int[][] arr2 = {{7, 10}, {2, 4}};
        int[][] arr3 = {{1, 10}, {2, 7}, {3, 19}, {8, 12}, {10, 20}, {11, 30}};
        int[][] arr4 = {{1, 2}};

        System.out.println(new MeetingRooms().solution(arr));
        System.out.println(new MeetingRooms().solution(arr2));
        System.out.println(new MeetingRooms().solution(arr3));
        System.out.println(new MeetingRooms().solution(arr4));
        System.out.println();
        System.out.println(new MeetingRooms().solution2(arr));
        System.out.println(new MeetingRooms().solution2(arr2));
        System.out.println(new MeetingRooms().solution2(arr3));
        System.out.println(new MeetingRooms().solution2(arr4));
        System.out.println();
        System.out.println(new MeetingRooms().solution3(arr));
        System.out.println(new MeetingRooms().solution3(arr2));
        System.out.println(new MeetingRooms().solution3(arr3));
        System.out.println(new MeetingRooms().solution3(arr4));

    }
}
