// Leetcode 926 - Flip String to Monotone Increasing
// https://leetcode.com/problems/flip-string-to-monotone-increasing/description/

public class LC926 {
    public static void main(String[] args) {
        System.out.println(
                new LC926().minFlipsMonoIncr("001001010")
        );
    }
    public int minFlipsMonoIncr(String s) {
        int dp = 0;
        int numOfOnes = 0;
        for(int i = 0; i< s.length(); i++) {
            if(s.charAt(i) == '0') {
                // if s[i] is 0, then either we can flip s[i] or not
                // if we flip it, then it becomes 1, so we need to add 1 to dp[i - 1] as number of flips increases
                // if we don't flip the 0, we have to flip the previous number of 1's to 0, which means that previous number of 1's are the number of flips required at that index in dp
                // finally we take minimum of them
                dp = Math.min(numOfOnes, dp + 1);
            } else {
                numOfOnes += 1;
            }

        }
        return dp;
    }
}
