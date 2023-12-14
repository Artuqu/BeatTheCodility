package otherAlgorithms.medium;

public class ReverseInteger {

    public int solution(int n) {
        long result = 0;
        while (n != 0) {
            int rest = n % 10;
            n = n / 10;
            result = result * 10 + rest;
        }
//        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) return 0;
        if (result > Math.pow(2, 31) || result < Math.pow(-2, 31)) return 0;
        return (int) result;
    }

    public static void main(String[] args) {

        System.out.println(new ReverseInteger().solution(90));
        System.out.println(new ReverseInteger().solution(190));
        System.out.println(new ReverseInteger().solution(251));
        System.out.println(new ReverseInteger().solution(-130));
        System.out.println(new ReverseInteger().solution((int) Math.pow(-2, 31)));

    }
}
