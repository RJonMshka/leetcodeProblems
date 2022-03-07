import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Custom Heap Class
 */
public class CustomMaxHeap {
    // heap array list
    private ArrayList<Integer> heap;
    // number of children each parent can have
    private int childrenSize;
    private int size = 0;
    private int rootIndex = 0;

    /**
     * Class Constructor
     * @param childrenSizeOrder - children size of order, a parent can have 2 ^ childSizeOrder number of chidren
     */
    public CustomMaxHeap(int childrenSizeOrder) {
        this.childrenSize = (int) Math.pow(2, childrenSizeOrder);
    }

    /**
     * Inserts a number into the heap
     * @param num - number to be inserted
     */
    public void insert(int num) {
        if(this.heap == null) {
            this.buildHeap(Arrays.asList());
        }
        this.size ++;
        this.heap.add(num);
        this.percolateUp(this.size - 1);
    }

    /**
     * Swap Two elements given a indexes
     * @param a - index of element 1 to swapped
     * @param b - index of element 2 to swapped
     */
    private void swapElements(int a, int b) {
        int tmp = this.heap.get(a);
        this.heap.set(a, this.heap.get(b));
        this.heap.set(b, tmp);
    }

    /**
     * Percolate up when a new number is inserted into the heap
     * @param index - index from where percolation needs to start
     */
    private void percolateUp(int index) {
        int parentIndex = (index - 1) / this.childrenSize;
        if (index <= rootIndex) {
            return;
        } else if (this.heap.get(parentIndex) < this.heap.get(index)) {
            this.swapElements(parentIndex, index);
            this.percolateUp(parentIndex);
        }
    }

    /**
     * Returns the max value in heap
     * @return Integer - max value in heap
     */
    public Integer popMax() {
        int max = this.heap.get(this.rootIndex);
        if(this.size > this.rootIndex + 1) {
            this.heap.set(this.rootIndex, this.heap.get(this.size - 1));
            this.size--;
            this.maxHeapify(rootIndex);
            this.heap.remove(this.size);
            return max;
        } else if (this.size == this.rootIndex + 1) {
            this.size--;
            this.heap.remove(this.size);
            return max;
        } else {
            return null;
        }
    }

    /**
     * Makes sure that every parent node is larger than its children
     * @param index - index of the parent node to be ensured to have a max heap property
     */
    private void maxHeapify(int index) {
        int largest = index;

        for (int i = 1; i <= this.childrenSize; i++) {
            int child = (index * this.childrenSize) + i;

            if( this.size > child && this.heap.get(largest) < this.heap.get(child) ) {
                largest = child;
            }
        }

        if(largest != index) {
            this.swapElements(largest, index);
            this.maxHeapify(largest);
        }
    }

    /**
     * This method builds the Heap when called with particular number of elements
     * @param heapEls - List of integers passed as initial heap elements
     */
    public void buildHeap(List<Integer> heapEls) {
        this.heap = new ArrayList<Integer>(heapEls);
        this.size = this.heap.size();

        for (int i = ((this.size - 1) / this.childrenSize ); i >= 0; i--) {
            this.maxHeapify(i);
        }
    }
}
