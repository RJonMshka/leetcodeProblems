class Solution:
    def removeKdigits(self, num, k):
        # monotonic stack
        mStack = []
        for ch in num:
            while k>0 and mStack and mStack[-1] > ch:
                k -= 1
                mStack.pop()
            mStack.append(ch)
            
        # edge case: if still there are k left, we want to pop them from end
        mStack = mStack[: len(mStack) - k]
            
        return str(int("".join(mStack))) if mStack else "0"

print( Solution().removeKdigits("1432219", 3) )