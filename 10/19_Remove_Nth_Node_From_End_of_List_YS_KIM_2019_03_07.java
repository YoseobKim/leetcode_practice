/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private int getLenOfList(ListNode node) {
        int ret = 0;
        ListNode n = node;
        while(n != null) {
            ret++;
            n = n.next;
        }
        return ret;
    }
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = getLenOfList(head);
        if(len <= 1) return null;
        if(len == n) {
            // remove first node
            head = head.next;
            return head;
        }
        ListNode ahead = head;
        ListNode tail = head;
        for(int i = 0; i < n; i++) {
            ahead = ahead.next;
        }
        ListNode prevTail = head;

        while(ahead != null) {
            prevTail = tail;
            tail = tail.next;
            ahead = ahead.next;
        }
        prevTail.next = tail.next;        
        return head;
    }
}
