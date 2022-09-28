import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSeq {
    public static void main(String[] args) {
        int[] nums = new int[] {100,4,200,1,3,2};
        System.out.println( new LongestConsecutiveSeq().longestConsecutive(nums) );
    }

    public int longestConsecutive(int[] nums) {
        int longest = 0;
        int i = 0;
        Set<Integer> numsSet = new HashSet<>();
        Arrays.stream(nums).forEach(numsSet::add);
        while(i < nums.length) {
            int localLong = 0;
            // start of a sequence
            if(!numsSet.contains(nums[i] - 1)) {
                localLong += 1;
                while(numsSet.contains(nums[i] + localLong)) {
                    localLong += 1;
                }
                longest = Math.max(longest, localLong);
            }
            i++;
        }

        return longest;
    }
}
