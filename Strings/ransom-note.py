class Solution:
    def canConstruct(self, ransomNote, magazine):
        magMap = {}
        
        for c in magazine:
            if c not in magMap:
                magMap[c] = 1
            else:
                magMap[c] += 1
                
        for c in ransomNote:
            if (c not in magMap or magMap[c] <= 0):
                return False
            
            magMap[c] -= 1
        
        return True

print(Solution().canConstruct("aa", "aab"))
            