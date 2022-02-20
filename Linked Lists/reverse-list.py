# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        # initial tail node for new list
        newList = ListNode()
        # llist moves to next on each iteration
        llist = head

        # while there are items in the llist
        while llist:
            # llist points to its next node
            llist = llist.next

            # head who need to put in a reverse list. its next now going to point to newList's next Node
            head.next = newList.next

            # newList's next points to this released head
            newList.next = head

            # updating head for the next iteration
            head = llist
            
        
        return newList.next