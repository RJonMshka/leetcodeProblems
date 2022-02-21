from collections import Counter

class Solution:
    def deleteAndEarn(self, nums):
        count = Counter(nums)
        nums = sorted(list(set(nums)))
        earn1, earn2 = 0, 0
        
        for i in range(len(nums)):
            currentEarn = count[nums[i]] * nums[i]
            
            temp = earn2
            
            if i > 0 and nums[i] == nums[i-1] + 1:
                earn2 = max(currentEarn + earn1, earn2)
            else:
                earn2 = currentEarn + earn2
            
            earn1 = temp
            
        return earn2
        

print( Solution().deleteAndEarn( [1,2,2,3,4,5,5,5,7,8] ) )