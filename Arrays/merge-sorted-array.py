class Solution:
    def merge(self, nums1, m, nums2, n):
        """
        Do not return anything, modify nums1 in-place instead.
        """

        #pointer to the last of nums1 array
        last = m + n - 1

        # keep filling nums1 from end by checking in both arrays nums1 and nums2
        while(m > 0 and n > 0):
            if(nums1[m-1] >= nums2[n-1]):
                # always try to fill the last of nums1
                nums1[last] = nums1[m-1]
                m = m - 1
            else:
                # always try to fill the last of nums1
                nums1[last] = nums2[n-1]
                n = n - 1
            last = last - 1
        
        while(n > 0):
            # always try to fill the last of nums1
            nums1[last] = nums2[n-1]
            n, last = n - 1, last - 1

        return nums1


print(Solution().merge([2, 4, 5, 0, 0, 0], 3, [1, 3, 7], 3))

# time: O(m + n)
# space: O(1): mp extra array is created

