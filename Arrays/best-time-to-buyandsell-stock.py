class Solution:
    def maxProfit(self, prices):
        maxCurrent = 0
        maxTotal = 0
        for i in range(1, len(prices)):
            maxCurrent += prices[i] - prices[i - 1]
            maxCurrent = max(0, maxCurrent)
            maxTotal = max(maxCurrent, maxTotal)
        return maxTotal

# should return 5, buy on day 2 (val - 1) and sell on day 4 (val - 6)
print(Solution().maxProfit( [7,1,5,3,6,4] ))

# should return zero as always in loss
print(Solution().maxProfit( [7,6,4,3,1] ))

# time: O(n)
# space: O(1)
