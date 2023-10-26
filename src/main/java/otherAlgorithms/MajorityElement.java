package otherAlgorithms;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public int solution(int[] A) {
        if (A == null) return 0;
        Map<Integer, Integer> elements = new HashMap<>();
        for (int a : A) {
            elements.put(a, elements.getOrDefault(a, 0) + 1);
            if (elements.get(a) > A.length / 2) return a;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A = {3,2,3};
        int[] A1 = {2,2,1,1,1,2,2};
        int[] A2 = {1};
        int[] A3 = {};
        System.out.println(new MajorityElement().solution(A));
        System.out.println(new MajorityElement().solution(A1));
        System.out.println(new MajorityElement().solution(A2));
        System.out.println(new MajorityElement().solution(A3));
    }
}
