// LC 131 - Palindrome Partitioning
// TC: O(N.2^N) - N for checking for palindrome for each combination
// 2^N as there are total 2^3  = 8 nodes in "aaa" "worst case" string

import java.util.ArrayList;
import java.util.List;

public class LC131 {

    private boolean isPalindrome(String s, int startIndex, int endIndex) {
        while(startIndex < endIndex) {
            if(s.charAt(startIndex++) != s.charAt(endIndex--)) return false;
        }
        return true;
    }

    private void dfs(List<List<String>> result, List<String> currentList, String s, int startIndex) {
        if(startIndex >= s.length()) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for(int endIndex = startIndex; endIndex < s.length(); endIndex++) {
            if(this.isPalindrome(s, startIndex, endIndex)) {
                currentList.add(s.substring(startIndex, endIndex + 1));

                this.dfs(result, currentList, s, endIndex + 1);

                currentList.remove(currentList.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        List<String> currentList = new ArrayList<>();

        this.dfs(result, currentList, s, 0);

        return result;
    }
}
