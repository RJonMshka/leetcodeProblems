import queue

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        visited = set()
        q = queue.Queue()
        islands = 0
        
        rows = len(grid)
        cols = len(grid[0])
        
        def bfs(rows, cols, r, c, grid):
            q.put((r, c))
            
            while not q.empty():
                rq, cq = q.get()
                
                if((rq, cq) not in visited):
                    visited.add((rq, cq))
                    
                    # top
                    if rq - 1 >= 0 and grid[rq - 1][cq] == "1":
                        q.put((rq-1, cq))
                        
                    # right
                    if cq + 1 < cols and grid[rq][cq + 1] == "1":
                        q.put((rq, cq + 1))
                        
                    # bottom
                    if rq + 1 < rows and grid[rq + 1][cq] == "1":
                        q.put((rq+1, cq))
                        
                    # left
                    if cq - 1 >= 0 and grid[rq][cq - 1] == "1":
                        q.put((rq, cq - 1))
                    
                
                
        for r in range(len(grid)):
            for c in range(len(grid[r])):
                if grid[r][c] == "1" and (r, c) not in visited:
                    islands += 1
                    bfs(rows, cols, r, c, grid)
                    
        
                    
        return islands