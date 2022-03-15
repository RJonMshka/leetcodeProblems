# 187. Repeated DNA Sequences

class Solution:
    def findRepeatedDnaSequences(self, s):
        # create two hashsets, one will hold every string of length 10
        # other will hold the strings which have more than one occurance
        seen, seenMoreThanOnce = set(), set()
        
        for i in range(len(s) - 9):
            substr = s[i: i + 10]
            
            if substr in seen:
                seenMoreThanOnce.add(substr)
            else:
                seen.add(substr)
                
        return list(seenMoreThanOnce)


print( Solution().findRepeatedDnaSequences( "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT" ) )
                