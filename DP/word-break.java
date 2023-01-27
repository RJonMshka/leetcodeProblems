// lC 139. Word Break


import java.util.Arrays;
import java.util.List;

public class LC139 {

    public static void main(String[] args) {
        String s = "abcd";
        String[] sArr = new String[] {"a","abc","b","cd"};

        System.out.println(
                new LC139().wordBreak(s, Arrays.asList(sArr))
        );
    }

    private boolean matchWordWithString(String word, String s, int index) {

        if( (s.length() - index >= word.length())
                && s.substring(index, index + word.length()).equals(word) ) {
            return true;
        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];

        Arrays.fill(dp, false);

        dp[n] = true;

        for(int i = n - 1; i >= 0; i--) {
            for(String word: wordDict) {
                if(this.matchWordWithString(word, s, i) && dp[i] == false) {
                    dp[i] = dp[i + word.length()];
                }
            }
        }

        return dp[0];
    }
}
