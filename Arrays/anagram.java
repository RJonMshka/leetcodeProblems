import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] sCharMap = new int[26];
        int[] tCharMap = new int[26];
        char offsetChar = 'a';
        
        for (int i = 0; i < s.length(); i++) {
            sCharMap[(int)s.charAt(i) - (int)offsetChar] += 1;
            tCharMap[(int)t.charAt(i) - (int)offsetChar] += 1;
        }
        
        return Arrays.equals(sCharMap, tCharMap);
    }
}