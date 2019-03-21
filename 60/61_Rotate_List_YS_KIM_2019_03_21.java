/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // 1->2->3->4, k = 2
    // 4->1->2->3, k = 1
    // 3->4->1->2, l = 0
    // like this way, recursively call same function.
    // in every call, connect the end node with the first node
    // 1->2->3->4->1->2->... like this,
    // and disconnect ahead of the end node with the end node
    // 1->2->3  4->1->2->3 like this
    // and return the end node as a head.
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        if(head.next == null) return head;
        if(k <= 0) return head;
        ListNode end = head;
        ListNode endPrev = null;
        int len = 1;
        // moving node to the end node
        // not only moving it to the end, but also calculates len.
        while(end.next != null) {
            len++;
            endPrev = end;
            end = end.next;
        }
        // to make it faster, k should be k % len.
        k = k % len;
        if(k == 0) return head; // no need to check it more.
        
        // connect the end node to the first node.
        end.next = head;
        
        // disconnect previous last node and last node
        endPrev.next = null;
        
        // shift it again until k become less than 0.
        // and new head should be end node.
        return rotateRight(end, k - 1);
    }
}
