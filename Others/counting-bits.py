# 338. Counting Bits
# Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.

class Solution:
    def countBits(self, n):
        result = []
        for i in range(n + 1):
            result.append(self.returnBits(i))
        return result
    
    def returnBits(self, num):
        count = 0
        while num != 0:
            if num % 2 != 0:
                count += 1
            num = num // 2
        return count

print( Solution().countBits(5) )