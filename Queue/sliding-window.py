import collections

class Solution:
    def maxSlidingWindow(self, nums, k):
        # indicates the portion of window
        l, r = 0, 0
        output = []
        q = collections.deque()

        while r < len(nums):
            # before adding anything to the queue, check if the last value is less than the value that we are going to add
            # if so that remove that value until a bigger value is found or q is empty
            while q and nums[q[-1]] < nums[r]:
                q.pop()
            # Then append the current value
            q.append(r)
            
            # check if left is out of bound, if l is greater than lefts most value or index, our sliding window is out of bound,
            # so we need to remove an elm from left
            if l > q[0]:
                q.popleft()

            # for initial k-1 loops, it won't satisfy, after than it will
            if r + 1 >= k:
                output.append(nums[q[0]])
                # shift the window
                l += 1
            
            # move to next element
            r += 1
        return output

print( Solution().maxSlidingWindow([1,3,-1,-3,5,3,6,7], 3) )
                
                
            