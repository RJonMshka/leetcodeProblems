class Solution:
    def rob(self, nums):
        rob1, rob2 = 0,0
        
        # [rob1, rob2, n, n+1, .....]
        
        for n in nums:
            # look at the above array, if we are calculating for n, we can rob n and rob1 or we can rob rob2 only (not include n as it is adjacent to rob2)
            temp = max(n + rob1, rob2)
            rob1 = rob2
            rob2 = temp
            
        return rob2


print(Solution().rob([1,2,3,1]))