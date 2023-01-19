// Leetcode 974: Sub-Array sums divisible by K

public class LC974 {
    public static void main(String[] args) {
        int[] nums = {4,5,10,15,2};
        int k = 5;

        System.out.println(
                new LC974().subarraysDivByK(nums, k)
        );
    }

    public int subarraysDivByK(int[] nums, int k) {
        int prefixMod = 0;
        int[] modGroups = new int[k];
        int result = 0;

        // 1 for element which is divisible by k
        modGroups[0] = 1;

        for(int n: nums) {
            prefixMod = (prefixMod + (n % k) + k) % k;
            result += modGroups[prefixMod];
            modGroups[prefixMod]++;
        }

        return result;
    }

}
