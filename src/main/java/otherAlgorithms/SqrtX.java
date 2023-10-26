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

    public static void main(String[] args) {
        System.out.println(new SqrtX().solution(4));
        System.out.println(new SqrtX().solution(16));
        System.out.println(new SqrtX().solution(12));
    }
}
