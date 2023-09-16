import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Banana {

    public int solution(String s) {
        char[] charWord = s.toCharArray();
        List<Integer> lettersList = new ArrayList<>();
        Arrays.sort(charWord);
        boolean isNoMoreN = false, nCounting = false;
        int A = 0, B = 0, N = 0;
        for (int i = 0; i < charWord.length; i++) {
            if (charWord[i] == 'A') A++;
            else if (charWord[i] == 'B') B++;
            else if (charWord[i] == 'N') {
                N++;
                nCounting = true;
            }
            if (nCounting)
                if (charWord[i] != 'N') isNoMoreN = true;
            if (nCounting && isNoMoreN) break;
        }
        lettersList.add(A / 3);
        lettersList.add(B);
        lettersList.add(N / 2);

        return Collections.min(lettersList);
    }

    public static void main(String[] args) {
        String s = "NAABXXAN";
        String s1 = "NAANAAXNABABYNNBZ";
        String s2 = "QABAAAWOBL";
        System.out.println(new Banana().solution(s));
        System.out.println(new Banana().solution(s1));
        System.out.println(new Banana().solution(s2));
    }
}
