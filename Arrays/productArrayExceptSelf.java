public class ProductofArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        int[] productArray = new ProductofArrayExceptSelf().productExceptSelf(nums);

    }

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int prefix = 1;
        int postfix = 1;
        result[0] = prefix;
        // 1 2 3 4 5
        // 1 1 2 6 24 pre
        // 120 60 40 30 24 post
        for(int i = 0; i < nums.length - 1; i++) {
            prefix = nums[i] * prefix;
            result[i+1] = prefix;
        }

        result[result.length - 1] *= postfix;
        for(int i = nums.length - 1; i > 0; i--) {
            postfix = nums[i] * postfix;
            result[i -1] *= postfix;
        }

        return result;
    }
}
