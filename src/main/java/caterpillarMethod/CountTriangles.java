package caterpillarMethod;

import java.util.Arrays;

public class CountTriangles {

    public int solution(int[] A) {
        int triangles = 0;
        Arrays.sort(A);
        for (int back = 0; back < A.length - 2; back++) {
            int front = back + 2;
            for (int middle = back + 1; middle < A.length - 1; middle++) {
                while (front < A.length && A[back] + A[middle] > A[front]) {
                    front++;
                }
                triangles += front - middle - 1;
            }
        }
        return triangles;
    }


    public static void main(String[] args) {
        int[] A = {10, 2, 5, 1, 8, 12};
        System.out.println(new CountTriangles().solution(A));
    }

}
