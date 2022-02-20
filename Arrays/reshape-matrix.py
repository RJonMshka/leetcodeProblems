class Solution:
    def matrixReshape(self, mat, r, c):
        rows = len(mat)
        cols = len(mat[0])
        
        # reshaping cannot be possible
        if(rows * cols != r * c):
            return mat
        
        # creating an reshaped matric with zeros in it
        solution = [[0] * c for _ in range(r)]
        for i in range(0, r*c):
            solution[i//c][i%c] = mat[i//cols][i%cols]
        return solution


print(Solution().matrixReshape( [[1,2],[3,4]], 4, 1 ))