def cmp_to_key(mycmp):
    class K(object):
        def __init__(self, obj, *args):
            print('obj created with ',obj)
            self.obj = obj
        def __lt__(self, other):
            print('comparing less than ',self.obj)
            return mycmp(self.obj, other.obj) < 0
        def __gt__(self, other):
            print('comparing greter than ',self.obj)
            return mycmp(self.obj, other.obj) > 0
        def __eq__(self, other):
            print('comparing equal to ',self.obj)
            return mycmp(self.obj, other.obj) == 0
        def __le__(self, other):
            print('comparing less than equal ',self.obj)
            return mycmp(self.obj, other.obj) <= 0
        def __ge__(self, other):
            print('comparing greater than equal',self.obj)
            return mycmp(self.obj, other.obj) >= 0
        def __ne__(self, other):
            print('comparing not equal ',self.obj)
            return mycmp(self.obj, other.obj) != 0
    return K


class Solution:
    def largestNumber(self, nums):
        
        def myCompare(n1, n2):
            if n1 + n2 > n2 + n1:
                return -1
            else:
                return 1
            
        # convert into string
        for i, item in enumerate(nums):
            nums[i] = str(item)
            
        nums = sorted(nums, key=cmp_to_key(myCompare))
        
        return str(int("".join(nums)))


print(Solution().largestNumber([1,4,789,232,232]))
        