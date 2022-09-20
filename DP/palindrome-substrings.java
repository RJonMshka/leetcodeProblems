class Solution {
    public int countSubstrings(String s) {
        int subStrings = 0;
        
        for(int i = 0; i < s.length(); i++) {
            // odd palindrome
            int left = i;
            int right = i;
            
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                subStrings += 1;
                left -= 1;
                right += 1;
            }
            
            // even palindrome
            left = i;
            right = i + 1;
            
            while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                subStrings += 1;
                left -= 1;
                right += 1;
            }
        }
        
        return subStrings;
    }
}