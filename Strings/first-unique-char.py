class Solution:
    def firstUniqChar(self, s):
        
        if len(s) == 0:
            return -1
        
        charMap = {}
        
        for i, c in enumerate(s):
            if c not in charMap:
                charMap[c] = i
            else:
                charMap[c] = -1
        
        min = len(s)
        
        for key in charMap:
            if charMap[key] != -1 and charMap[key] < min:
                min = charMap[key]
                
        if min != len(s):
            return min
        
        return -1

print( Solution().firstUniqChar("leetcode"))