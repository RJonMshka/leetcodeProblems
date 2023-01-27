// LC 472. Concatenated Words

import java.util.*;

public class LC472 {
    public static void main(String[] args) {
        String[] words = new String[] {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};

        System.out.println(
                new LC472().findAllConcatenatedWordsInADict(words)
        );
    }

    private boolean wordBreak(String word, Set<String> wordDict) {
        int n = word.length();
        boolean[] dp = new boolean[n + 1];

        Arrays.fill(dp, false);

        dp[n] = true;

        for(int i = n - 1; i >= 0; i--) {
            int j = i + 1;
            while(j <= n && dp[i] == false) {
                if(wordDict.contains(word.substring(i, j)) && !(i == 0 && j == n)) {
                    dp[i] = dp[j];
                }
                j++;
            }
        }

        return dp[0];
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> resultList = new ArrayList<>();
        Set<String> dictionary = new HashSet<>(Arrays.asList(words));

        for(int i = 0; i < words.length; i++) {
            if(this.wordBreak(words[i], dictionary)) {
                resultList.add(words[i]);
            }
        }

        return resultList;
    }
}
