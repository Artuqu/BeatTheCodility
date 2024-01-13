package otherAlgorithms.medium;

import java.util.*;

public class MeetingRooms {


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


    public static void main(String[] args) {
        int[][] arr = {{0, 30}, {5, 10}, {15, 20}};
        int[][] arr2 = {{7, 10}, {2, 4}};
        int[][] arr3 = {{1, 10}, {2, 7}, {3, 19}, {8, 12}, {10, 20}, {11, 30}};
        int[][] arr4 = {{}, {}};

        System.out.println(new MeetingRooms().solution(arr));
        System.out.println(new MeetingRooms().solution(arr2));
        System.out.println(new MeetingRooms().solution(arr3));
        System.out.println(new MeetingRooms().solution(arr4));

    }
}
