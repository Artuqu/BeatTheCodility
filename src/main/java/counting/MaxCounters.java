package counting;

import java.util.Arrays;

public class MaxCounters {


    public static int[] solution(int N, int[] A) {
        int[] result = new int[N];
        int max = 0;
        int startLine = 0;
        for (int i : A) {
            int position = i - 1;
            if (i <= N) {
                result[position]++;
                if (result[position] <= startLine) {
                    result[position] = startLine + 1;
                }
                if (result[position] > max) {
                    max = result[position];
                }
            } else if (i <= N + 1) {
                startLine = max;
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] < startLine) {
                result[i] = startLine;
            }
        }
        return result;
    }

    public static int[] solution2(int N, int[] A) {
        int[] result = new int[N];
        int startLine = 0;
        int max = 0;
        for (int i : A) {
            int x = i - 1;
            if (i > N) startLine = max;
            else if (result[x] < startLine) result[x] = startLine + 1;
            else result[x]++;

            if (i <= N && result[x] > max) max = result[x];
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] < startLine) {
                result[i] = startLine;
            }
        }
        return result;
    }

    public static int[] s3(int N, int[] A) {
        int[] result = new int[N];
        int max = 0;
        int startLine = 0;

        for (int i = 0; i < A.length; i++) {
            int position = A[i] - 1;
            if (position >= N) {
                startLine = max;
            } else if (result[position] <= startLine) {
                result[position] = startLine + 1;
            } else {
                result[position]++;
            }
//            check first argument first, if not true doesn't go further
            if (position < N && result[position] > max) {
                max = result[position];
            }
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] < startLine) {
                result[i] = startLine;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {3, 4, 4, 6, 1, 4, 4, 6, 1, 2};
        System.out.println(Arrays.toString(solution(5, A)));
        System.out.println(Arrays.toString(solution2(5, A)));
        System.out.println(Arrays.toString(s3(5, A)));
    }
}
