# 287. Find the Duplicate Number

class Solution:
    def findDuplicate(self, nums):
        # a linked list problem solved with floyd's algo - cycle detection
        slow, fast = 0, 0
        
        while True:
            slow = nums[slow]
            fast = nums[nums[fast]]
            
            if slow == fast:
                break
        
        anotherSlow = 0
        
        while True:
            slow = nums[slow]
            anotherSlow = nums[anotherSlow]
            
            if slow == anotherSlow:
                break
        return slow

print( Solution().findDuplicate( [1,3,4,2,2] ) )