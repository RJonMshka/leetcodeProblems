# Binary Search algo

def bSearch(nums, item):
    low = 0
    high = len(nums) - 1

    while low <= high:
        mid = (low + high) // 2
        guess = nums[mid]

        if item == guess:
            # we have found it
            return mid
        elif guess > item:
            # high needs to adjusted to a low value
            high = mid - 1
        else:
            # if guess  < item, then low pointer needs to be adjusted
            low = mid + 1
        
    return None

print( bSearch([1,3,4,5,8,12,34,56,78,456,1234], 34) )