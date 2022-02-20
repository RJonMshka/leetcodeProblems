class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        ddict = {')': '(', '}': '{', ']': '['}
        for c in s:
            if c in ddict:
                if stack and stack[-1] == ddict[c]:
                    stack.pop()
                else:
                    return False
            else:
                stack.append(c)

        return True if not stack else False