class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int left = cost[cost.length - 1];
        int right = 0;
        
        for(int i = 1; i < cost.length; i++) {
            int newLeft = Math.min(cost[cost.length - 1 - i] + left, cost[cost.length - 1 - i] + right);
            right = left;
            left = newLeft;
        }
        
        return Math.min(left, right);
    }
}