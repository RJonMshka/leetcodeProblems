# 523. Continuous Subarray Sum

class Solution:
    def checkSubarraySum(self, nums, k):
        # solved with hashmpa (remainder -> index)
        # initially (0 -> -1 ) added to avoid edge case of first element being the multiple of k
        remainderMap = { 0: -1 }
        total = 0
        
        for i, n in enumerate(nums):
            total += n
            remainder = total % k
            
            if remainder not in remainderMap:
                remainderMap[remainder] = i
            elif i - remainderMap[remainder] > 1:
                return True
            
        return False


print( Solution().checkSubarraySum([23,2,6,4,7], 6) )