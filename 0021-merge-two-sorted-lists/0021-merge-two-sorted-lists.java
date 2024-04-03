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
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    // Create a dummy node to serve as the head of the merged list
    ListNode dummy = new ListNode(-1);
    ListNode current = dummy; // Pointer to the current node in the merged list

    // Traverse both lists simultaneously
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        current.next = list1; // Attach list1 node to the merged list
        list1 = list1.next;   // Move list1 pointer forward
      } else {
        current.next = list2; // Attach list2 node to the merged list
        list2 = list2.next;   // Move list2 pointer forward
      }
      current = current.next; // Move current pointer forward
    }

    // Attach the remaining nodes of the non-empty list
    if (list1 != null) {
      current.next = list1;
    } else {
      current.next = list2;
    }

    // Return the head of the merged list (skipping the dummy node)
    return dummy.next;
  }
}
