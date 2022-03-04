# 413. Arithmetic Slices
# An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

# For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
# Given an integer array nums, return the number of arithmetic subarrays of nums.

# A subarray is a contiguous subsequence of the array.

class Solution:
    def numberOfArithmeticSlices(self, nums):
        totalAps = 0
        currentAps = 0
        for i in range(len(nums)):
            # ignore initial two runs
            if i == 0 or i == 1:
                continue
            
            # this is an AP
            if nums[i] - nums[i - 1] == nums[i - 1] - nums[ i - 2]:
                currentAps += 1
            else:
                currentAps = 0
            
            totalAps += currentAps
        
        return totalAps
            

# should print 3
print( Solution().numberOfArithmeticSlices( [1,2,3,4] ) )
            
            