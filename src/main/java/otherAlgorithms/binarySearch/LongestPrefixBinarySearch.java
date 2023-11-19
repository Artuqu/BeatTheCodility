package otherAlgorithms.binarySearch;

public class LongestPrefixBinarySearch {

    public String solution(String[] strings) {
        return lcp(strings, 0, strings.length - 1);
    }

    private String lcp(String[] strings, int left, int right) {
        if (left == right) return strings[left];
        if (right > left) {
            int mid = left + (right - left) / 2;
            String s1 = lcp(strings, left, mid);
            String s2 = lcp(strings, mid + 1, right);
            return commonPrefix(s1, s2);
        }
        return null;
    }

    private String commonPrefix(String s1, String s2) {
        int min = Math.min(s1.length(), s2.length());
        for (int i = 0; i < min; i++) {
            if (s1.charAt(i) != s2.charAt(i)) return s1.substring(0, i);
        }
        return s1.substring(0, min);
    }

    public static void main(String[] args) {
        String[] strings1 = {"flat", "flower", "flow", "flight", "florida"};
        String[] strings2 = {"dog", "cat", "car"};
        String[] strings3 = {"can", "cat", "car"};
        String[] strings4 = {"peace", "peaceful", "peach", "pear"};

        System.out.println(new LongestPrefixBinarySearch().solution(strings1));
        System.out.println(new LongestPrefixBinarySearch().solution(strings2));
        System.out.println(new LongestPrefixBinarySearch().solution(strings3));
        System.out.println(new LongestPrefixBinarySearch().solution(strings4));
    }
}
