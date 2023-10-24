package otherAlgorithms;

import java.util.Arrays;

public class ReverseString {


    //    Reverse String with O(1) extra memory
    public void solution(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[right];
            s[right] = s[left];
            s[left] = temp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(s));
    }

    public static void main(String[] args) {
        char[] s = {'h', 'e', 'l', 'l', 'o'};
        char[] s1 = {'h', 'o', 'm', 'e'};
        new ReverseString().solution(s);
        new ReverseString().solution(s1);
    }
}
