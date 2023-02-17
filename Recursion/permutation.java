// LC 46. Permutations

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LC46 {
    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        System.out.println(
                new LC46().permute(nums)
        );
    }

    private void dfs(List<List<Integer>> result, int start, int[] nums) {
        if(start == nums.length) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }

        for(int i = start; i < nums.length; i++) {
            // swap i with start to ignore
            swap(nums, i, start);

            this.dfs(result, start + 1, nums);

            swap(nums, i, start);
        }

    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        this.dfs(result, 0, nums);

        return result;
    }
}
