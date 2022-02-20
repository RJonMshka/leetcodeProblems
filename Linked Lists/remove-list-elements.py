# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def removeElements(self, head: Optional[ListNode], val: int) -> Optional[ListNode]:
        dummyNode = ListNode()
        tail = dummyNode
        tail.next = head
        llist = head
        
        while llist:
            # if values match 
            if llist.val == val:
                # tail will point to that node's next element (tail kind of serves as prev pointer)
                tail.next = llist.next
                # that node's next is removed
                llist.next = None
                # llist is assigned to a node which tail's next is pointing to 
                llist = tail.next
            else:
                # increase both tail and llist
                tail = tail.next
                llist = llist.next
        
        return dummyNode.next