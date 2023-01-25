// LC 909. Snakes and Ladders

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class LC909 {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,35,-1,-1,13,-1},
                {-1,-1,-1,-1,-1,-1},
                {-1,15,-1,-1,-1,-1}
        };

        System.out.println(
                new LC909().snakesAndLadders(board)
        );
    }
    public int snakesAndLadders(int[][] board) {
        int n = board.length;

        // we will ignore 0 and start from 1 index as it matches the board configuration.
        // last index will be n*n
        Pair<Integer, Integer>[] boardCells = new Pair[n * n + 1];
        int label = 1;
        int counter = 0;

        // populating the boardCells array as per board game
        for(int row = n - 1; row >= 0; row--) {
            int x = row + n - 1;
            if(counter++ % 2 == 0) {
                for(int col = 0; col < n; col++) {
                    boardCells[label++] = new Pair<>(new Integer(row), new Integer(col));
                }
            } else {
                for(int col = n-1; col >= 0; col--) {
                    boardCells[label++] = new Pair<>(new Integer(row), new Integer(col));
                }
            }
        }

        // array representing number of moves of each position from position 1
        int[] distance = new int[n * n + 1];
        for(int i = 0; i < distance.length; i++) {
            distance[i] = -1;
        }

        // starting at cell 1, whose distance to itself is 1.
        distance[1] = 0;

        Queue<Integer> queue = new LinkedList<Integer>();

        queue.add(1);

        while(!queue.isEmpty()) {
            int current = queue.remove();
            // math.min is here to handle edge case when moves are very close to final destination in board
            // and we cannot go further than n*n even we get large numbers on dice rolls
            for(int next = current + 1; next <= Math.min(current + 6, n * n); next++) {
                int row = boardCells[next].getKey();
                int col = boardCells[next].getValue();

                int destination = board[row][col] != -1 ? board[row][col] : next;

                // if distance not set already
                if(distance[destination] == -1) {
                    // distance of dest is 1 step more than current cell's distance as it would take only one more move to reach there
                    distance[destination] = distance[current] + 1;
                    queue.add(destination);
                }
            }
        }

        return distance[n * n];
    }
}
