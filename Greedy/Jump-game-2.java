// LC 45. Jump Game II

public class JumpGame2 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,1,1,4};

        System.out.println(
                new JumpGame2().jump(nums)
        );
    }
    public int jump(int[] nums) {
        int end = 0;
        int far = 0;

        int result = 0;

        for(int i = 0; i < nums.length - 1; i++) {
            far = Math.max(far, i + nums[i]);

            if(i == end) {
                end = far;
                ++result;
            }

        }

        return result;
    }
}
