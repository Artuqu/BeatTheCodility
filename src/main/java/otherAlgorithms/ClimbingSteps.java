package otherAlgorithms;

public class ClimbingSteps {
    //O(n!)
    public int solution(int stairs) {
        return helper_recursive(stairs);
    }

    public int helper_recursive(int stairs) {
        if (stairs < 0) return 0;
        if (stairs == 0) return 1;
        return helper_recursive(stairs - 1) + helper_recursive(stairs - 2);
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingSteps().solution(5));
        System.out.println(new ClimbingSteps().solution(4));
        System.out.println(new ClimbingSteps().solution(2));
    }
}
