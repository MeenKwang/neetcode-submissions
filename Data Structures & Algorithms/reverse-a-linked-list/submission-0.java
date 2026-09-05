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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while(current != null) {
            // Save the next node in the original list
            next = current.next;

            // Reverse the current node's pointer
            current.next = prev;

            // Move prev and current one step forward
            prev = current;
            current = next;

        }

        return prev; 
    }
}
