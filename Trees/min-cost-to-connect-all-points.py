# 1584. Min Cost to Connect All Points'

# You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

# The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

# Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
import heapq

class Solution:
    def minCostConnectPoints(self, points):
        # solved with pri's algo
        # minimum span tree problem - O(n^2 * log n)}

        pointsLen = len(points)
        adj = { i:[] for i in range(pointsLen) }
        
        # starting from first node, check add the cost of node to other nodes and add it in adjacency matrix
        for i in range(pointsLen):
            x1, y1 = points[i]
            # all neighbours of i
            for j in range( i + 1, pointsLen):
                x2, y2 = points[j]
                # manhattan distance
                distance = abs(x2 - x1) + abs(y2 - y1)
                adj[i].append([distance, j])
                adj[j].append([distance, i])

        # now adjacency matrix is filled

        # Prim's algo
        result = 0
        visited = set()

        minHeap = [[0, 0]]  # cost, node

        while len(visited) < pointsLen:
            cost, node = heapq.heappop(minHeap)
            if node in visited:
                continue
            
            visited.add(node)
            result += cost

            for nCost, neighbour in adj[node]:
                if neighbour not in visited:
                    heapq.heappush(minHeap, [nCost, neighbour])

        return result


    


print( Solution().minCostConnectPoints( [[3,12],[-2,5],[-4,1]] ) )
        