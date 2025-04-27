class Solution {  
    public ListNode removeNthFromEnd(ListNode head, int n) {  
        // Create a dummy node to simplify edge cases  
        ListNode dummy = new ListNode(0, head);  
        ListNode first = dummy;  
        ListNode second = dummy;  
        
        // Move first pointer n+1 steps ahead  
        for (int i = 0; i <= n; i++) {  
            first = first.next;  
        }  
        
        // Move first to the end, maintaining the gap  
        while (first != null) {  
            first = first.next;  
            second = second.next;  
        }  
        
        // second now points to the node before the one to remove  
        second.next = second.next.next;  
        
        return dummy.next;  
    }  
}  