import java.util.HashMap;
import java.util.Map;

public class LC3 {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(
                new LC3().lengthOfLongestSubstring(s)
        );
    }

    public int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        while(right < s.length() && left <= right) {
            if( charMap.containsKey( s.charAt(right) ) && charMap.get( s.charAt(right) ) >= left) {
                left = charMap.get( s.charAt(right) ) + 1;
            }
            charMap.put(s.charAt(right), right);
            longest = Math.max(longest, right - left + 1);
            right++;
        }
        return longest;
    }
}
