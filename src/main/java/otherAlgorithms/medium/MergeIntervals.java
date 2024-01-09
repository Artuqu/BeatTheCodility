package otherAlgorithms.medium;

import java.util.*;

public class MergeIntervals {

    public int[][] solution(int[][] intervals) {
        LinkedList<int[]> result = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        for (int[] singleInterval : intervals) {
            if (result.isEmpty() || result.getLast()[1] < singleInterval[0]) result.add(singleInterval);
            else {
                result.getLast()[1] = Math.max(result.getLast()[1], singleInterval[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] arr = {{5, 10}, {8, 15}, {5, 6}, {10, 12}, {16, 18}, {17, 22}};
        int[][] arr2 = {{2, 5}, {1, 4}, {9, 10}, {6, 9}};
        System.out.println(Arrays.deepToString(new MergeIntervals().solution(arr2)));
        System.out.println(Arrays.deepToString(new MergeIntervals().solution(arr)));
    }
}
