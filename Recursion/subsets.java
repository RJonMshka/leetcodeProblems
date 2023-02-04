// LC 78: Subsets

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC78 {

    private void dfs(int[] nums, int start, List<Integer> path, List<List<Integer>> result) {
        if(start >= nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        path.add(nums[start]);
        this.dfs(nums, start + 1, new ArrayList<>(path), result);

        // remove it now
        path.remove(path.size() - 1);
        this.dfs(nums, start + 1, new ArrayList<>(path), result);

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();

        this.dfs(nums, 0, currentPath, result);

        return result;
    }
}
