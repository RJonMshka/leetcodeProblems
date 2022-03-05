# 799. Champagne Tower

# similar to pascal's triangle

class Solution:
    def champagneTower(self, poured, query_row, query_glass):
        if poured == 0:
            return 0
        
        l1 = [poured]
        
        while query_row > 0:
            temp = [0] + l1 + [0]
            l1 = []
            for i in range(len(temp) - 1):
                l1.append(max( (temp[i] - 1) / 2 , 0 ) + max( (temp[i + 1] - 1) / 2 , 0 ) )                
            
            query_row -= 1
            
        return min(l1[query_glass], 1)

print( Solution().champagneTower(2, 1, 1) )