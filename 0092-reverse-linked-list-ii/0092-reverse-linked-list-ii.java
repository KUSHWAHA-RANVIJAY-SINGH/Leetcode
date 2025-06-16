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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        // Create a dummy node to simplify edge cases where head is reversed
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Move prev pointer to the node before the `left`th node
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Start reversing nodes
        ListNode current = prev.next;
        ListNode then = current.next;

        // Reverse the nodes between left and right
        for (int i = 0; i < right - left; i++) {
            current.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = current.next;
        }

        return dummy.next;
    }
}