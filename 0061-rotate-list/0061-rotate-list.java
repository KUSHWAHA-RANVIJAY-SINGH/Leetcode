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
    public ListNode rotateRight(ListNode head, int k) {
         if (head == null || head.next == null || k == 0) return head;  

        // Compute the length of the list and get the tail node  
        ListNode tail = head;  
        int length = 1;  
        while (tail.next != null) {  
            tail = tail.next;  
            length++;  
        }  
        
        // Make it a circular list  
        tail.next = head;  

        // Find the new tail: (length - (k % length) - 1)th node  
        // Find the new head: (length - (k % length))th node  
        k = k % length;  
        int stepsToNewTail = length - k - 1;  
        ListNode newTail = head;  
        for (int i = 0; i < stepsToNewTail; i++) {  
            newTail = newTail.next;  
        }  

        ListNode newHead = newTail.next;  

        // Break the circle  
        newTail.next = null;  

        return newHead;  
    }
}