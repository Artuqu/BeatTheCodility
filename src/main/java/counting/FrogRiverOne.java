package counting;

public class FrogRiverOne {


    public static int solution(int X, int[] A) {
        int[] leafs = new int[X];
        int result = -1;
        int counter = X;
        for (int i = 0; i < A.length; i++) {
            if (leafs[A[i] - 1] == 0) {
                counter--;
            }
            leafs[A[i] - 1] = A[i];
            if (counter == 0) {
                return i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 1, 4, 2, 3, 5, 4};
        System.out.println(solution(5, array));
    }
}
