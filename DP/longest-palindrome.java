class Solution {
    public String longestPalindrome(String s) {
        int lPSLeft = 0;
        int lPSRight = 0;
        int longestLength = 0;
        int stringLength = s.length();
        
        for(int i = 0; i < stringLength; i++) {
            // odd palindrome
            int left = i;
            int right = i;
            
            while (left >= 0 && right < stringLength && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 > longestLength) {
                    lPSLeft = left;
                    lPSRight = right;
                    
                    longestLength = right - left + 1;
                }
                
                
                left -= 1;
                right += 1;
            }
            
            // even palindrome
            left = i;
            right = i + 1;
            
            while (left >= 0 && right < stringLength && s.charAt(left) == s.charAt(right)) {
                if(right - left + 1 > longestLength) {
                    lPSLeft = left;
                    lPSRight = right;
                    
                    longestLength = right - left + 1;
                }
                
                left -= 1;
                right += 1;
            }
            
        }
        
        return s.substring(lPSLeft, lPSRight + 1);
    }
}