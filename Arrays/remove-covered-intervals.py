class Solution:
    def removeCoveredIntervals(self, intervals):
        intervals.sort(key=lambda i: (i[0], -i[1]))
        res = [intervals[0]]
        
        for l, r in intervals[1:]:
            prevL, prevR = res[-1]
            
            if prevL <= l and prevR >= r:
                # that means that [l, r] are covered in [prevL, prevR], so we don't append them in the res list
                continue
            
            # otherwise
            res.append([l, r])
            
        return len(res)


# should print 2
print( Solution().removeCoveredIntervals( [[1,4],[3,6],[2,8]] ) )