class Solution:
    def rob(self, nums):
        # can either rob house all except last or all except first
        # nums[0] is the edge case, when there is only 1 house, so helper would work on empty array, so needed to add first house here in max as well
        return max(nums[0], self.helpderRobOne( nums[:-1] ), self.helpderRobOne( nums[1:] ))
        
    def helpderRobOne(self, nums):
        rob1, rob2 = 0,0

        for n in nums:
            temp = max(n + rob1, rob2)
            rob1 = rob2
            rob2 = temp

        return rob2

print( Solution().rob([2,3,2]) )