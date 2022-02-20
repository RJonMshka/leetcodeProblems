# since already sorted can help us choose search algo
# we can use binary search which is the best

#  since also it is provided that last item of top row is always less than first element of next row, we can apply binary search on rows itself O(log m)

# then when we get which row to operate on, we can again apply binary search on that particular row O(log n)

class Solution:
    def searchMatrix(self, matrix, target):
        rows, cols = len(matrix), len(matrix[0])
        
        # top and bottom pointers
        topRow, botRow = 0, rows - 1
        
        # search the row first
        while (topRow <= botRow):
            midRow = (topRow + botRow) // 2
            
            if target > matrix[midRow][-1]:
                topRow = midRow + 1
            elif target < matrix[midRow][0]:
                botRow = midRow - 1
            else:
                break
            
        # check whether target is not invalid
        if not topRow <= botRow:
            return False
        
        # second search for element in the row
        rowToWork = (topRow + botRow) // 2 
        left, right = 0, cols - 1
        while (left <= right):
            mid = (left + right) // 2
            
            if target > matrix[rowToWork][mid]:
                left = mid + 1
            elif target < matrix[rowToWork][mid]:
                right = mid - 1
            else:
                return True
        
        return False


print(Solution().searchMatrix([[1,3,5,7],[10,11,16,20],[23,30,34,60]], 3))
# O(log m + log n )