// LC 491: Non-decreasing Subsequences

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC491 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,1,1,1,1,1};
        System.out.println(
                new LC491().findSubsequences(nums)
        );
    }

    private void addIncrementingSeqToSet(Set<List<Integer>> resultSet, List<Integer> sequence, int index, int[] nums) {
        if(sequence.size() >= 2) {
            resultSet.add(new ArrayList<>(sequence));
        }
        if(index == nums.length) {
            return;
        }

        // only add the the new number if it is less or equal to last element in existing sequence
        // or if the list is empty
        if(sequence.isEmpty() || sequence.get(sequence.size() - 1) <= nums[index]) {
            sequence.add(nums[index]);

            // recursion with new index now
            this.addIncrementingSeqToSet(resultSet, sequence, index + 1, nums);

            // remove the element to choose other number
            sequence.remove(sequence.size() - 1);
        }

        // recursion with difference sequence from above in if block
        this.addIncrementingSeqToSet(resultSet, sequence, index + 1, nums);
    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();

        List<Integer> sequence = new ArrayList<>();

        this.addIncrementingSeqToSet(resultSet, sequence, 0, nums);

        return new ArrayList<>(resultSet);
    }
}
