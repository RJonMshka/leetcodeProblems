// LC 542. 01 Matrix

import java.util.Arrays;

public class LC542 {
    public static void main(String[] args) {
        int[][] mat = new int[][] {
                {1,1,0,0,1,0,0,1,1,0},
                {1,0,0,1,0,1,1,1,1,1},
                {1,1,1,0,0,1,1,1,1,0},
                {0,1,1,1,0,1,1,1,1,1}
        };
        int[][] result = new LC542().updateMatrix(mat);
        for(int[] r: result) {
            for(int i: r) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] distance = new int[m][n];

        for(int[] d: distance) {
            Arrays.fill(d, Integer.MAX_VALUE - 10000);
        }

        for(int r = 0; r < m; r++) {
            for(int c = 0; c < n; c++) {
                if(mat[r][c] == 0) {
                    distance[r][c] = 0;
                } else {
                    if(r > 0) {
                        distance[r][c] = Math.min(distance[r][c], 1 + distance[r-1][c]);
                    }
                    if (c > 0) {
                        distance[r][c] = Math.min(distance[r][c], 1 + distance[r][c - 1]);
                    }
                }
            }
        }

        for(int r = m - 1; r >= 0; r--) {
            for(int c = n - 1; c >= 0; c--) {
                if(r < m - 1) {
                    distance[r][c] = Math.min(distance[r][c], 1 + distance[r + 1][c]);
                }
                if (c < n - 1) {
                    distance[r][c] = Math.min(distance[r][c], 1 + distance[r][c + 1]);
                }
            }
        }

        return distance;

    }
}
