/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        
        while(cur != null) {
            if(prev != null && prev.val == cur.val) {
                prev.next = cur.next; // remove cur
                cur = prev.next;
                continue;
            }
            
            prev = cur;
            cur = cur.next;
        }
        
        return head;
    }
}
