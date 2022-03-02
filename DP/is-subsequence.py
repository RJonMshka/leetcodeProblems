# 392. Is Subsequence


class Solution:
    def isSubsequence(self, s, t):
        i = 0
        for ch in t:
            if i < len(s) and s[i] == ch:
                i += 1
                
        return i == len(s)

# should return true
print( Solution().isSubsequence( "abc", "ahbgdc" ) )