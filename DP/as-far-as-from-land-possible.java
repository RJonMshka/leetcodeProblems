// LC 1162:  As Far from Land as Possible

import java.util.Arrays;

public class LC1162 {
    public static void main(String[] args) {
        int[][] grid = new int[][] {
                {1, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        int result = new LC1162().maxDistance(grid);

        System.out.println(result);
    }

    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int maxDist = n * n;

        int result = 0;

        int[][] dist = new int[n][n];

        for(int[] d: dist) {
            Arrays.fill(d, maxDist);
        }

        for(int r = 0; r < n; r++) {
            for(int c = 0; c < n; c++) {
                if(grid[r][c] == 1) {
                    dist[r][c] = 0;
                } else {
                    if(r > 0) {
                        dist[r][c] = Math.min(dist[r][c], 1 + dist[r - 1][c]);
                    }
                    if(c > 0) {
                        dist[r][c] = Math.min(dist[r][c], 1 + dist[r][c - 1]);
                    }
                }
            }
        }

        for(int r = n - 1; r >= 0; r--) {
            for(int c = n - 1; c >= 0; c--) {
                if(r < n - 1) {
                    dist[r][c] = Math.min(dist[r][c], 1 + dist[r + 1][c]);
                }
                if(c < n - 1) {
                    dist[r][c] = Math.min(dist[r][c], 1 + dist[r][c + 1]);
                }

                result = Math.max(result, dist[r][c]);
            }
        }

        return result == maxDist || result == 0 ? -1 : result;
    }
}
