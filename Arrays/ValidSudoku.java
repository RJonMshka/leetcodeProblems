import java.util.*;

public class ValidSudoku {
    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, HashSet<Integer>> rowMap = new HashMap<>();
        Map<Integer, HashSet<Integer>> colMap = new HashMap<>();
        Map<String, HashSet<Integer>> boardMap = new HashMap<>();

        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[r].length; c++) {
                if(rowMap.isEmpty() || rowMap.get(r) == null) {
                    rowMap.put(r, new HashSet<Integer>());
                }
                if(colMap.isEmpty() || colMap.get(c) == null) {
                    colMap.put(c, new HashSet<Integer>());
                }
                String boardKey = String.valueOf(Math.floor(r / 3)) + String.valueOf(Math.floor(c / 3));
                if(boardMap.isEmpty() || boardMap.get(boardKey) == null) {
                    boardMap.put(boardKey, new HashSet<Integer>());
                }
                if(board[r][c] != '.' && (rowMap.get(r).contains( (int)board[r][c] ) ||
                        colMap.get(c).contains( (int)board[r][c]) ||
                        boardMap.get(boardKey).contains( (int)board[r][c]))) {
                    return false;
                } else {
                    rowMap.get(r).add((int)board[r][c]);
                    colMap.get(c).add((int)board[r][c]);
                    boardMap.get(boardKey).add((int)board[r][c]);
                }
            }
        }

        return true;
    }
}

// more simple solution
// public boolean isValidSudoku(char[][] board) {
//     Set seen = new HashSet();
//     for (int i=0; i<9; ++i) {
//         for (int j=0; j<9; ++j) {
//             char number = board[i][j];
//             if (number != '.')
//                 if (!seen.add(number + " in row " + i) ||
//                     !seen.add(number + " in column " + j) ||
//                     !seen.add(number + " in block " + i/3 + "-" + j/3))
//                     return false;
//         }
//     }
//     return true;
// }
