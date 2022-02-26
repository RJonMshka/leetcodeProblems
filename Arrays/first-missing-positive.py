class Solution:
    def firstMissingPositive(self, nums):
        # first loop marking all negatives as zeros
        
        for i in range(len(nums)):
            if nums[i] < 0:
                # marking negatives as zeros
                nums[i] = 0
        
        # second loop - marking the available integers as negatives and other not so much
        for i in range(len(nums)):
            # first convert it into a positive value, it might be a negative value at first
            val = abs(nums[i])
            
            if 1 <= val <= len(nums):
                if nums[val - 1] > 0:
                    nums[val - 1] *= -1
                elif nums[val - 1] == 0:
                    nums[val - 1] = -1 * (len(nums) + 1)

        # loop over 1 to len(nums) + 1 as the result might be in between those numbers
        for i in range(1, len(nums) + 1):
            # only positive numbers that will be left will be part of solution 
            if nums[i - 1] >= 0:
                return i
        
        # if nothing is return from last loop, this is the worst case one
        return len(nums) + 1;

print( Solution().firstMissingPositive( [3, 4, -1, 1] ) )