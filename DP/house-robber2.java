import java.util.stream.IntStream;

class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        
        return Math.max(this.robHelper(nums, 0, nums.length -1), this.robHelper(nums, 1, nums.length));
    }
    
     public int robHelper(int[] nums, int start, int end) {
        int robber1 = 0;
        int robber2 = 0;
        
        for(int i=start; i<end; i++) {
            int newRobber = Math.max(nums[i] + robber1, robber2);
            robber1 = robber2;
            robber2 = newRobber;
        }
        
        return robber2;
    }
}