# DP Bottom Up

class Solution:
    def climbStairs(self, n: int) -> int:
        # it is like a fibonnaci series
        one = 1
        two = 1
        if(n < 2):
            return 1
        else:
            for count in range(n - 1):
                temp = one
                one = one + two
                two = temp
        return one


# should print 8
print(Solution().climbStairs(5))