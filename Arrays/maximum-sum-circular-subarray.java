// Leetcode: 918. Maximum Sum Circular Subarray

public class LC918 {

    public static void main(String[] args) {
        int[] nums = {1,-2,3,-2};
        System.out.println(
                new LC918().maxSubarraySumCircular(nums)
        );
    }

//    public int maxSubArray(int[] nums) {
//
//    }
//
//    public int minSubArray(int[] nums) {
//
//    }

    public int maxSubarraySumCircular(int[] nums) {
        int currentMax = 0;
        int currentMin = 0;

        int totalSum = 0;
        int minSum = Integer.MAX_VALUE;
        int maxSum = Integer.MIN_VALUE;

        for(int n: nums) {
            if(currentMax < 0) {
                currentMax = 0;
            }

            currentMax += n;

            maxSum = Math.max(maxSum, currentMax);

            if(currentMin > 0) {
                currentMin = 0;
            }

            currentMin += n;

            minSum = Math.min(minSum, currentMin);

            totalSum += n;
        }

        System.out.println("max sum: " + maxSum);
        System.out.println("min sum: " + minSum);
        System.out.println("total sum: " + totalSum);

        // if all are negative then the least negative would be the output
        if(minSum == totalSum) {
            return maxSum;
        } else {
            // else, total sum - minimum subarray will be the answer
            return Math.max(totalSum - minSum, maxSum);
        }

    }
}
