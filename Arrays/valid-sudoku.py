class Solution:
    def isValidSudoku(self, board):
        # the key is to create 3 different hashmaps of hashsets
        rows = {}
        cols = {}
        squares = {}
        size = 9
        
        for r in range(size):
            for c in range(size):
                
                if board[r][c] == ".":
                    continue
                
                if (( r in rows and board[r][c] in rows[r]) or
                   (c in cols and board[r][c] in cols[c]) or
                   ((r // 3, c // 3) in squares and board[r][c] in squares[(r // 3, c // 3)]) ):
                   return False
                
                if r not in rows:
                    rows[r] = set()
                rows[r].add(board[r][c])
                    
                
                if c not in cols:
                    cols[c] = set()
                cols[c].add(board[r][c])
                    
                if (r // 3, c // 3) not in squares:
                    squares[(r // 3, c // 3)] = set()
                squares[(r // 3, c // 3)].add(board[r][c])

                    
                    
        return True


print(Solution().isValidSudoku([
["8","3",".",".","7",".",".",".","."],
["6",".",".","1","9","5",".",".","."],
[".","9","8",".",".",".",".","6","."],
["8",".",".",".","6",".",".",".","3"],
["4",".",".","8",".","3",".",".","1"],
["7",".",".",".","2",".",".",".","6"],
[".","6",".",".",".",".","2","8","."],
[".",".",".","4","1","9",".",".","5"],
[".",".",".",".","8",".",".","7","9"]
]))
