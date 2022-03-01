class Solution:
    def isRobotBounded(self, instructions):
        x, y = 0, 0   # initial position of the robot
        dirX, dirY = 0, 1   # (x, y) x can be -1, 0, 1 and same set for y
        # (0, 1) means up, (1, 0) means left, (-1, 0) means right and (0, -1) means down
        
        for i in instructions:
            if i == "G":
                # increase the position by direction
                x, y = x + dirX, y + dirY
            elif i == "L":
                # inituition,
                dirX, dirY =  -1 * dirY, dirX         # if in direction (0, 1) or up, taking a left would make dir of y 0 and dir of x -1
            else: 
                # right case - opposite of left
                dirX, dirY = dirY, -1 * dirX
                
        # either if position remains same or direction has changed then probably will be cycle
        return (x, y) == (0, 0) or (dirX, dirY) != (0, 1)


print( Solution().isRobotBounded( "GGLLGG" ) )