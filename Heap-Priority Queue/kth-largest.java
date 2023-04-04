import java.util.PriorityQueue;

// 703. Kth Largest Element in a Stream
public class LC703 {

    class KthLargest {

        private PriorityQueue<Integer> minHeap;
        private int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            this.minHeap = new PriorityQueue<>();

            for(int i = 0; i < nums.length; i++) {
                this.minHeap.add(nums[i]);
            }

            // remove element till only k left and the top most would be the kth largest as it will be the smallest in k sized PQ
            while(this.minHeap.size() > this.k) {
                this.minHeap.poll();
            }

        }

        public int add(int val) {
            this.minHeap.add(val);

            while(this.minHeap.size() > this.k) {
                this.minHeap.poll();
            }

            return this.minHeap.peek();

        }
    }

}
