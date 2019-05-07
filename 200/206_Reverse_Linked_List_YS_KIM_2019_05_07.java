/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private ListNode endNode = null;
    
    private void reverseListHelper(ListNode head, ListNode prev) {
        if(head != null) {
            reverseListHelper(head.next, head);
            head.next = prev;
        } else {
            endNode = prev;
        }
    }
    
    public ListNode reverseList(ListNode head) {
        reverseListHelper(head, null);
        return endNode;
    }
}
