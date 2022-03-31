class Solution:
    def numEnclaves(self, grid):
        visited = set()
        
        rows = len(grid)
        cols = len(grid[0])
        
        enclaves = 0
        
        for r in range(rows):
            for c in range(cols):
                
                if grid[r][c] == 1 and (r, c) not in visited:
                    temp = self.dfs(grid, r, c, visited)
                    if(temp > 0):
                        enclaves += temp
                        
        return enclaves
                    
                    
    
    def dfs(self, grid, r, c, visited):
        # out of bound and reached, means that there is 1 at boundaries
        if r < 0 or c < 0 or r == len(grid) or c == len(grid[r]):
            return -1
        
        if grid[r][c] == 0:
            return 0
        
        if (r, c) in visited:
            return 0
        
        visited.add((r, c))
        
        top = self.dfs(grid, r-1, c, visited)
        bottom = self.dfs(grid, r+1, c, visited)
        left = self.dfs(grid, r, c-1, visited)
        right = self.dfs(grid, r, c+1, visited)
        
        if top == -1 or bottom == -1 or left == -1 or right == -1:
            return -1
        
        return 1 + top + right + left + bottom

#should return 0
print( Solution().numEnclaves([[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]) )
        
            
                
        