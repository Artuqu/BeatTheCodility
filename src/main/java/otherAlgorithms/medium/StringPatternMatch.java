package otherAlgorithms.medium;

public class StringPatternMatch {


    public int solution(String needle, String haystack) {
        int result = -1;
        int nLength = needle.length();
        int hLength = haystack.length();
        for (int i = 0; i < hLength - nLength + 1; i++) {
            if (haystack.substring(i, i + nLength).equals(needle)) return i;
        }
        return result;
    }

    public static void main(String[] args) {
        String haystack = "istomistom";
        String needle = "tom";
        System.out.println(new StringPatternMatch().solution(needle, haystack));

    }
}
