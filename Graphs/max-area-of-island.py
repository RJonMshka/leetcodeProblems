import queue

class Solution:
    def maxAreaOfIsland(self, grid):
        area = 0
        q = queue.Queue()
        visited = set()
        rows = len(grid)
        cols = len(grid[0])
        currentArea = 0
        
        
        def bfs(rows, cols, r, c, grid):
            cA = 0
            q.put( (r, c) )
            visited.add( (r, c) )
            
            while not q.empty():
                rq, cq = q.get()
                cA += 1
            
                
                # top
                if rq - 1 >= 0 and (rq - 1, cq) not in visited and grid[rq - 1][cq] == 1:
                    visited.add( (rq - 1, cq) )
                    q.put( (rq - 1, cq) )
                
                # bottom
                if rq + 1 < rows and (rq + 1, cq) not in visited and grid[rq + 1][cq] == 1:
                    visited.add( (rq + 1, cq) )
                    q.put( (rq + 1, cq) )
                    
                # left
                if cq - 1 >= 0 and (rq, cq - 1) not in visited and grid[rq][cq - 1] == 1:
                    visited.add( (rq, cq - 1) )
                    q.put( (rq, cq - 1) )
                
                # right
                if cq + 1 < cols and (rq, cq + 1) not in visited and grid[rq][cq + 1] == 1:
                    visited.add( (rq, cq + 1) )
                    q.put( (rq, cq + 1) )
                    
            return cA
            
        
        for r in range(rows):
            for c in range(cols):
                if (r, c) not in visited and grid[r][c] == 1:
                    currentArea = bfs(rows, cols, r, c, grid)
                area = max(area, currentArea)
                
        return area

print( Solution().maxAreaOfIsland([[1,1,0,0,0],
                                    [1,1,0,0,0],
                                    [0,0,0,1,1],
                                    [0,0,0,1,1]] ) )