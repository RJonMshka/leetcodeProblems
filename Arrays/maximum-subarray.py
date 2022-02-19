class Solution:
    def maxSubArray(self, nums):
        maxSum = nums[0]
        
        currentSum = 0
        for item in nums:
            # it means that anytime we get a negative sum, we ignore it as it would only reduce the value of maximum sum
            if currentSum < 0:
                currentSum = 0
                
            currentSum += item
            
            maxSum = max(maxSum, currentSum)
            
        return maxSum


# should return 6
print(Solution().maxSubArray( [-2, 1, -3, 4, -1, 2, 1, -5, 4] ))