class Solution:
    def closedIsland(self, grid):
        rows = len(grid)
        cols = len(grid[0])
        closedIs = 0
        for r in range(rows):
            for c in range(cols):
                if(grid[r][c] == 0):
                    closed = self.isClosedIsland(grid, r, c)
                    if closed == True : 
                        closedIs += 1
        return closedIs

    def isClosedIsland(self, g, row, col):
        # check if it is out of bound 
        if (row >= len(g) or col >= len(g[0]) or row < 0 or col < 0):
            return False
        
        if(g[row][col] == 1):
            return True
        
        g[row][col] = 1
        #top
        top = self.isClosedIsland(g, row - 1, col)
        #bottom
        bottom = self.isClosedIsland(g, row + 1, col)
        #left
        left = self.isClosedIsland(g, row, col - 1)
        #right
        right = self.isClosedIsland(g, row, col + 1)
        return (bottom & right & top & left)

print( Solution().closedIsland([
    [1,1,1,1,1,1,1,0],
    [1,0,0,0,0,1,1,0],
    [1,0,1,0,1,1,1,0],
    [1,0,0,0,0,1,0,1],
    [1,1,1,1,1,1,1,0]]) )