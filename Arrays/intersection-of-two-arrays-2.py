class Solution:
    def intersect(self, nums1, nums2):
        map = {}
        inter = []
        for num in nums1:
            if num in map:
                map[num] += 1
            else:
                map[num] = 1
                
        for num in nums2:
            if(num in map and map[num] > 0):
                inter.append(num)
                map[num] -= 1
        
        return inter


print(Solution().intersect( [1,2,2,1], [2,2] ))

# time: O(num1len + nums2len) ~ O(n + m)
# space: O(nums1len) ~ O(n)


# What if the given array is already sorted? How would you optimize your algorithm?
# ans: Classic two pointer iteration, i points to nums1 and j points to nums2. Because a sorted array is in ascending order, so if nums1[i] > nums[j], we need to increment j, and vice versa. 
# Only when nums1[i] == nums[j], we add it to the result array. Time Complexity O(max(N, M)). Worst case, for example, would be nums1 = {100}, and nums2 = {1, 2, ..., 100 }. 
# We will always iterate the longest array. The example code is below(I sorted it so it could go through OJ)


# What if nums1's size is small compared to nums2's size? Which algorithm is better?
# Can do binary search for each element of nums1. let len of nums1 is k and n is length of larger array num2. then each lookup in nums2 will cost O(logn) and there are k elements in nums1, then total would be O(k log n)