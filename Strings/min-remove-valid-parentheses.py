# 1249. Minimum Remove to Make Valid Parentheses

class Solution:
    def minRemoveToMakeValid(self, s):
        stack = []
        invalidIndices = []
        
        for i, ch in enumerate(s):
            if ch == '(':
                stack.append(ch)
                invalidIndices.append(i)
            elif ch == ')':
                if stack and stack[-1] == '(':
                    stack.pop()
                    invalidIndices.pop()
                else:
                    invalidIndices.append(i)
                    
        st = ""
        
        for i, ch in enumerate(s):
            if i not in invalidIndices:
                st += ch
                
        return st

print(Solution().minRemoveToMakeValid( "lee(t(c)o)de)" ))
        