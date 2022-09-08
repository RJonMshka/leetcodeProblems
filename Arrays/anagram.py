# 242. Valid Anagram

class Solution:
    def isAnagram(self, s, t):
        if len(s) != len(t):
            return False
        
        sCharMap = [0] * 26
        tCharMap = [0] * 26
        for i in range(0, len(s)):
            a = ord('a')
            sCharMap[ord(s[i]) - a] += 1
            tCharMap[ord(t[i]) - a] += 1
        
        print(sCharMap)
        print(tCharMap)
        return sCharMap == tCharMap
    

print(Solution().isAnagram('rat', 'car'))
        