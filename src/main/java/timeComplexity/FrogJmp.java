package timeComplexity;

public class FrogJmp {
    public int solution(int X, int Y, int D) {
        int jumps = (Y - X) / D;
        if ((Y - X) % D != 0) {
            jumps++;
        }
        return jumps;
    }

    public static void main(String[] args) {
        System.out.println(new FrogJmp().solution(10, 85, 30));
    }
}
