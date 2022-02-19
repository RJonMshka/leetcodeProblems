class Solution:
    def tribonacci(self, n: int) -> int:
        sum = 0
        i = 0
        j = 0
        k = 0
        for count in range(0, n+1):
            if(count == 1 or count == 2):
                j = k = 1
                sum = j
            else:
                sum = i + j + k
                i = j
                j = k
                k = sum
        return sum


// test
print(Solution().tribonacci(10))