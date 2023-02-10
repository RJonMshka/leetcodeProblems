// LC 853: Car Fleet

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Stack;

public class LC853 {
    public static void main(String[] args) {
        int[] position = new int[] {10,8,0,5,3};
        int[] speed = new int[] {2,4,1,1,3};

        System.out.println(
                new LC853().carFleet(12, position, speed)
        );
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;

        Pair<Integer, Integer>[] posSpeed = new Pair[n];

        for(int i = 0; i < n; i++) {
            posSpeed[i] = new Pair<>(position[i], speed[i]);
        }

        // sort position speed array with position in ascending order using Quick Sort
        this.quickSort(posSpeed);

        Stack<Pair<Integer, Integer>> carFleetStack = new Stack<>();

        for(int i = n-1; i >= 0; i--) {
            if(carFleetStack.isEmpty()) {
                carFleetStack.add(posSpeed[i]);
            } else {
                Pair<Integer, Integer> topOfStack = carFleetStack.peek();
                float timeTopNeed = (target - topOfStack.getKey()) / topOfStack.getValue().floatValue();
                float timeNextNeed = (target - posSpeed[i].getKey()) / posSpeed[i].getValue().floatValue();

                // they would not intesect
                if(timeNextNeed > timeTopNeed) {
                    carFleetStack.add(posSpeed[i]);
                }
            }


        }

        return carFleetStack.size();

    }

    private void swapItems(Pair<Integer, Integer>[] givenArray, int firstIndex, int secondIndex) {
        Pair<Integer, Integer> temp = givenArray[firstIndex];
        givenArray[firstIndex] = givenArray[secondIndex];
        givenArray[secondIndex] = temp;
    }

    public Pair<Integer, Integer>[] quickSort(Pair<Integer, Integer>[] arrayToSort) {
        this.performQuickSort(arrayToSort, 0 , arrayToSort.length - 1);
        return arrayToSort;
    }

    private int partition(Pair<Integer, Integer>[] arrayToSort, int low, int high) {
        Pair<Integer, Integer> pivot = arrayToSort[high];

        int left = low;

        for(int i = low; i <= high - 1; i++) {
            if(arrayToSort[i].getKey() < pivot.getKey()) {
                this.swapItems(arrayToSort, left, i);
                left++;
            }
        }

        this.swapItems(arrayToSort, left, high);
        return left;

    }

    private void performQuickSort(Pair<Integer, Integer>[] arrayToSort, int start, int end) {
        // select a pivot and then swap the pivot with end of the list
        if (start < end) {
            int pivotIndex = this.partition(arrayToSort, start, end);
            this.performQuickSort(arrayToSort, start, pivotIndex - 1);
            this.performQuickSort(arrayToSort, pivotIndex + 1, end);
        }

    }
}
