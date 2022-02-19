# Subset II

class Solution:
    def subsetsWithDup(self, nums):
        res = []
        nums.sort()

        def backtracking(i, subset):

            if(i == len(nums)):
                res.append(subset)
                return
            
            backtracking(i+1, subset + [nums[i]])
            
            # duplicate check
            while( i+1 < len(nums) and nums[i] == nums[i+1]):
                i += 1
            
            backtracking(i+1, subset)
        
        backtracking(0, [])

        return res

print(Solution().subsetsWithDup([4,8,8]))

# run cmd: python all-subset-array-dulplicate.py

        


        