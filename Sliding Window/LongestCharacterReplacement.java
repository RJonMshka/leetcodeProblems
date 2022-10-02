import java.util.*;

public class LongestCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        System.out.println(
                new LongestCharacterReplacement().characterReplacement(s, k)
        );
    }

    public int characterReplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int maxFreq = 0;
        int result = 0;
        int[] charArray = new int[26];

        while(r < s.length()) {
            charArray[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, charArray[s.charAt(r) - 'A']);

            if(r - l + 1 - maxFreq > k) {
                charArray[s.charAt(l) - 'A']--;
                l++;
            }
            result = Math.max(result, r - l + 1);
            r++;

        }
        return result;
    }
}
