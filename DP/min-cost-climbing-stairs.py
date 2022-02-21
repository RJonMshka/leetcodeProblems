class Solution:
    def minCostClimbingStairs(self, cost):
        # [10, 15, 20], 0 - WILL APPEND THAT O TO COST ARRAY
        cost.append(0)
        
        #start from two elements before the end, that means from 15 in above example as 20 and 0 will not get updated, because from 20 you can 
        # get to the top stair only in 1 way by selecting the 1 step which costs 20 itself, cannot do 2 step as that would be out of bound
        
        # before 20 we are going to update each element with the cost associated
        # it will be min of cost taken in 1 step and 2 step
        # lets have a look
        
        for i in range(len(cost) - 3, -1, -1):
            # cost[i] = min(cost[i] + cost[i + 1], cost[i] + cost[i + 2]), can be reduced to whats below
            cost[i] += min(cost[i + 1], cost[i + 2])
            
        return min(cost[0], cost[1])

# should return 15
print(Solution().minCostClimbingStairs( [10, 15, 20] ))