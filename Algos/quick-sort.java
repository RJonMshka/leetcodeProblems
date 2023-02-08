public class QuickSort {
    public static void main(String[] args) {
        int[] arrayToSort = new int[] {6,7,1,8,9,2, 1, 0, 9, 3,6,7,1,3,5,2,7,6,9,1,0};
        int[] result = new QuickSort().quickSort(arrayToSort);
        for(int i: result) {
            System.out.print(i + " ");
        }
    }

    private void swapItems(int[] givenArray, int firstIndex, int secondIndex) {
        int temp = givenArray[firstIndex];
        givenArray[firstIndex] = givenArray[secondIndex];
        givenArray[secondIndex] = temp;
    }

    public int[] quickSort(int[] arrayToSort) {
        this.performQuickSort(arrayToSort, 0 , arrayToSort.length - 1);
        return arrayToSort;
    }

    private int partition(int[] arrayToSort, int low, int high) {
        int pivot = arrayToSort[high];

        int left = low;

        for(int i = low; i <= high - 1; i++) {
            if(arrayToSort[i] < pivot) {
                this.swapItems(arrayToSort, left, i);
                left++;
            }
        }

        this.swapItems(arrayToSort, left, high);
        return left;

    }

    private void performQuickSort(int[] arrayToSort, int start, int end) {
        // select a pivot and then swap the pivot with end of the list
        if (start < end) {
            int pivotIndex = this.partition(arrayToSort, start, end);
            this.performQuickSort(arrayToSort, start, pivotIndex - 1);
            this.performQuickSort(arrayToSort, pivotIndex + 1, end);
        }

    }

}
