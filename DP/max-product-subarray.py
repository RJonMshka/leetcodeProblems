class Solution:
    def maxProduct(self, nums):
        totalMax = nums[0]
        
        # As anything multiplied by 0 is 0 itself
        currentMax, currentMin = 1,1
        
        for n in nums:
            # if 0, reset the current max and min
            if n == 0:
                currentMax, currentMin = 1,1
            
            # to cache the n*currentMax value
            temp = n * currentMax
            # numbers can be negative, so if current min is negative and n is also negative
            # their multiplication can give positive (max) result
            currentMax = max(temp, n * currentMin, n)
            currentMin = min(temp, n * currentMin, n)
            
            totalMax = max(totalMax, currentMax)
            
        return totalMax

print( Solution().maxProduct( [-2, 3, -4] ) )