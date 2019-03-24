/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);
        
        ListNode node = head;
        ListNode beforeNode = beforeHead;
        ListNode afterNode = afterHead;
        ListNode beforePrev = null;
        ListNode afterPrev = null;
        while(node != null) {
            if(node.val < x) {
                beforeNode.val = node.val;
                beforeNode.next = new ListNode(0);
                beforePrev = beforeNode;
                beforeNode = beforeNode.next;
            } else {
                afterNode.val = node.val;
                afterNode.next = new ListNode(0);
                afterPrev = afterNode;
                afterNode = afterNode.next;                
            }
            
            node = node.next;
        }
        
        if(afterPrev != null) afterPrev.next = null;
        if(beforePrev != null) beforePrev.next = null;
        
        ListNode retNode = beforePrev == null ? (afterPrev == null ? head : afterHead) : beforeHead;
        
        if(beforePrev != null && afterPrev != null) beforePrev.next = afterHead;
        
        return retNode;
    }
}
