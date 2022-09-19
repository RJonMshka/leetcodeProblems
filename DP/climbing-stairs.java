class Solution {
    public int climbStairs(int n) {
        int left = 1;
        int right = 1;
        
        for(int i = 0; i < n - 1; i++) {
            int newLeft = left + right;
            right = left;
            left = newLeft;
        }
        
        return left;
    }
}