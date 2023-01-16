// Leetcode 19
// Remove Nth Node From End of List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyToHead = new ListNode();
        dummyToHead.next = head;
        ListNode left = dummyToHead;
        ListNode right = head;

        for(int i=0; i<n; i++) {
            right = right.next;
        }

        while(right != null) {
            left = left.next;
            right = right.next;
        }

        // delete node after left
        ListNode nodeToDelete = left.next;
        left.next = nodeToDelete.next;
        nodeToDelete.next = null;
        
        return dummyToHead.next;
    }
}