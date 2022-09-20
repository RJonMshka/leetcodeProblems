class Solution {
    public int rob(int[] nums) {
        int robber1 = 0;
        int robber2 = 0;
        
        for(int i=0; i<nums.length; i++) {
            int newRobber = Math.max(nums[i] + robber1, robber2);
            robber1 = robber2;
            robber2 = newRobber;
        }
        
        return robber2;
    }
}