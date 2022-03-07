# 1359. Count All Valid Pickup and Delivery Options

class Solution:
    def countOrders(self, n):
        ways = 1
        for i in range(1, n + 1):
            # the bigger number can be placed in 2i-1 places 
            places = 2 * i - 1
            # since pickup needs to be placed first, 
            # if pickup is placed first then there are only 2i-1  + 2i-2  + 2i-3 + .... + 1 ways delivery can be placed as it has to come after the pickup
            currentWays = (places * (places + 1)) // 2
            
            ways *= currentWays
            
            # given in question: "Since the answer may be too large, return it modulo 10^9 + 7."
            ways %= 1000000007;
            
        return ways

# should return 90
print( Solution().countOrders(3) )
            