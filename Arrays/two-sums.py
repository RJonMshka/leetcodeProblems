class Solution:
    def twoSum(self, nums, target):
        # hashmap: mapping value to index
        numsMap = {}
        
        for i, num in enumerate(nums):
            
            difference = target - num
            
            # check if the difference is in the hashmap
            if(difference in numsMap):
                return [numsMap[difference], i]
            
            numsMap[num] = i
            
        return 
    

# should return [1, 3]
print( Solution().twoSum([2, 1, 5, 3], 4) )

# time complexity: O(n) as it is linear
# space complexity: O(n) as it uses hashmaps

            