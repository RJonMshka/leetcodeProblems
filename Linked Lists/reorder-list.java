// Leetcode 143
// Reorder Linked List

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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // slow will be at middle
        ListNode firstList = head;
        ListNode secondList = slow.next;
        slow.next = null;
        ListNode prevSecond = null;

        // now reverse the second list
        while(secondList != null) {
            ListNode temp = secondList.next;
            secondList.next = prevSecond;
            prevSecond = secondList;`
            secondList = temp;
        }
        
        ListNode start = head;
        
        while(prevSecond != null) {
            ListNode next = start.next;
            start.next = prevSecond;
            prevSecond = prevSecond.next;
            start.next.next = next;
            start = start.next.next;
        }
        
    }
}