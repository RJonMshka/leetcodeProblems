# 394. Decode String

class Solution:
    def decodeString(self, s):
        stack = []
        
        for ch in s:
            if ch != "]":
                stack.append(ch)
            else:
                # need to pop till [ comes up
                string = ""
                while stack and stack[-1] != "[":
                    string = stack.pop() + string
                    
                # Pop [ also
                stack.pop()
                
                # there should be a number to the left of [
                num = ""
                while stack and stack[-1].isdigit():
                    num = stack.pop() + num
                
                stack.append( int(num) * string)
                
        return "".join(stack)

# should return "accaccacc"
print( Solution().decodeString("3[a2[c]]") )