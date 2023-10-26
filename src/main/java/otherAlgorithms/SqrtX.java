package otherAlgorithms;

public class SqrtX {

    //O (log n)
    public int solution(int a) {
        if (a < 2) return a;
        int left = 2;
        int right = a / 2;
        int pivot = 0;
        long number = 0;
        while (left < right) {
            pivot = left + (right - left) / 2;
            number = (long) pivot * pivot;
            if (number > a) right = --pivot;
            else if (number < a) left = ++pivot;
            else return pivot;
        }
        return right;
    }

//    recursion
    public int solution2(int a) {
        if (a < 2) return a;
        int left = solution2(a >> 2) << 1;
        int right = left + 1;
        return (long) right * right > a ? left : right;
    }

    public static void main(String[] args) {
        System.out.println(new SqrtX().solution2(4));
        System.out.println(new SqrtX().solution2(16));
        System.out.println(new SqrtX().solution2(12));
    }
}
