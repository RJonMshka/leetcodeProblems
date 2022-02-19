class Solution:
    def fib(self, n: int) -> int:
        i = 0
        j = 0
        sum = 0
        for count in range(0, n+1):
            
            if(count < 2):
                sum = count
            else:
                i = j
                j = sum
                sum = i + j
        return sum

print(Solution().fib(0), Solution().fib(1), Solution().fib(2), Solution().fib(3), Solution().fib(4), Solution().fib(5))