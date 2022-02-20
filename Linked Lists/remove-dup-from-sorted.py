# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head == None:
            return head
        
        llist = head
        
        # here need to check if llist's next actually points to a real node
        while llist.next:
            # if value matches
            if llist.val == llist.next.val:
                # store the ref of node that needs to be removed
                tempRef = llist.next
                # make a pointer from prev to next, omitting node to be removed
                llist.next = llist.next.next
                # node to removed's next points to None
                tempRef.next = None
            else:
                # else move to next element as usual
                llist = llist.next
                
        return head