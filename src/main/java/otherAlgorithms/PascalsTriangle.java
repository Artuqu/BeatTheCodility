package otherAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public List<List<Integer>> solution(int n) {
        List<List<Integer>> pTriangle = new ArrayList<>();
        pTriangle.add(List.of(1));
        for (int i = 1; i < n; i++) {
            List<Integer> currentRow = new ArrayList<>();
            List<Integer> prevRow = pTriangle.get(i - 1);
            currentRow.add(1);
            for (int j = 1; j < i; j++) {
                currentRow.add(prevRow.get(j) + prevRow.get(j - 1));
            }
            currentRow.add(1);
            pTriangle.add(currentRow);
        }
        return pTriangle;
    }

    public static void main(String[] args) {
        System.out.println(new PascalsTriangle().solution(5));

    }
}
