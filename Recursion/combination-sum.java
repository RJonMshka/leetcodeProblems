// LC 39: Combination Sum
// Time complexity: O(2 ^ target)

import java.util.ArrayList;
import java.util.List;

public class LC39 {

    public static void main(String[] args) {
        int[] candidates = new int[] {2,3,6,7};
        int target = 7;

        System.out.println(
                new LC39().combinationSum(candidates, target)
        );
    }
    private void dfs(int[] candidates, List<List<Integer>> result, List<Integer> currentPath, int start, int currentSum, int target) {
        if(currentSum == target) {
            result.add(new ArrayList<>(currentPath));
            return;
        } else if (currentSum > target || start >= candidates.length) {
            return;
        }

        currentPath.add(candidates[start]);
        this.dfs(candidates, result, new ArrayList<>(currentPath), start, currentSum + candidates[start], target);

        currentPath.remove(currentPath.size() - 1);
        this.dfs(candidates, result, new ArrayList<>(currentPath), start + 1, currentSum, target);

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int start = 0;
        int currentSum = 0;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();

        this.dfs(candidates, result, currentPath, start, currentSum, target);

        return result;

    }
}
