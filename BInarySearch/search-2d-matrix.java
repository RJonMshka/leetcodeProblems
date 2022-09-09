public class TwoDMatrix {
    public static void main(String[] args) {
        int[][] twoDMatrix = new int[][]{new int[]{1, 3, 5, 7}, new int[]{10, 11, 16, 20}, new int[]{23, 30, 34, 60}};
        int target = 3;
        boolean result = new TwoDMatrix().searchMatrix(twoDMatrix, target);
        System.out.println(result);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int topRow = 0;
        int botRow = rows - 1;

        while(topRow <= botRow) {
            int midRow = (topRow + botRow) / 2;
            // first check if the target is less than the first element of mid row
            if(target < matrix[midRow][0]) {
                // check only the top rows
                botRow = midRow - 1;

            // then if the target is greater than the last element of mid row
            } else if (target > matrix[midRow][columns - 1]) {
                // check only the bottom rows
                topRow = midRow + 1;
            } else {
                break;
            }
        }

        // check if topRow has exceeded the bottom, then the target cannot be found
        if(topRow > botRow) {
            return false;
        }

        int midRow = ( topRow + botRow ) / 2;

        int left = 0;
        int right = columns - 1;

        while (left <= right) {
            int middle = ( left + right ) / 2;

            if(target < matrix[midRow][middle]) {
                // only search the left side
                right = middle - 1;

            } else if (target > matrix[midRow][middle]) {
                // only search the right side
                left = middle + 1;
            } else if (target == matrix[midRow][middle]) {
                return true;
            }
        }
        return false;
    }
}
