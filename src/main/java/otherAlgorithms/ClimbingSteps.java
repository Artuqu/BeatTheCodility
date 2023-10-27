package otherAlgorithms;

public class ClimbingSteps {
    //O(n!)
    public int solution(int stairs) {
        return helper_recursive(stairs);
    }

    public int solution2(int stairs) {
        int[] cache = new int[stairs + 1];
        return helper_recursive_cached(stairs, cache);
    }

    public int helper_recursive(int stairs) {
        if (stairs < 0) return 0;
        if (stairs == 0) return 1;
        return helper_recursive(stairs - 1) + helper_recursive(stairs - 2);
    }

    public int helper_recursive_cached(int stairs, int[] cache) {
        if (stairs < 0) return 0;
        if (stairs == 0) return 1;
        if (cache[stairs] > 0) return cache[stairs];
        cache[stairs] = helper_recursive_cached(stairs - 1, cache) + helper_recursive_cached(stairs - 2, cache);
        return cache[stairs];
    }

    public static void main(String[] args) {
        System.out.println(new ClimbingSteps().solution2(5));
        System.out.println(new ClimbingSteps().solution2(4));
        System.out.println(new ClimbingSteps().solution2(2));
    }
}
