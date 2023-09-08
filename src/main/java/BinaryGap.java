public class BinaryGap {

    public static int solution(int N) {
        int result = 0;
        String binary = Integer.toBinaryString(N);
        String[] gaps = binary.split("1");
        if (String.valueOf(binary.charAt(binary.length() - 1)).equals("1")) {
            result = getResult(result, gaps, gaps.length - 1);
        } else {
            result = getResult(result, gaps, gaps.length);
        }
        return result;
    }

    private static int getResult(int result, String[] gaps, int length) {
        try {
            result = gaps[0].length();
            for (int i = 0; i < length; i++) {
                length = gaps[i].length();
                if (length > result) {
                    result = length;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(32));
    }
}
