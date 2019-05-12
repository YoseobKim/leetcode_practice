/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        while(node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
    
    public boolean isPalindrome(ListNode head) {
        ListNode node1 = head;
        ListNode node2 = head;
        
        while(node2 != null && node2.next != null) {
            node1 = node1.next;
            node2 = node2.next.next;
        }
        
        if(node2 != null) {
            // odd
            node1 = node1.next;
        }
        // mid
        ListNode mid = node1;
        mid = reverse(mid);
        
        while(mid != null) {
            if(mid.val == head.val) {
                head = head.next;
                mid = mid.next;
            } else {
                return false;
            }
        }
        
        return true;
    }
}
