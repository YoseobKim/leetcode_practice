/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        int start = l1.val;
        if(l1.val > l2.val) {
            start = l2.val;
            l2 = l2.next;
        } else {
            start = l1.val;
            l1 = l1.next;
        }
        ListNode retHead = new ListNode(start);
        ListNode ret = retHead;
        
        while(l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                ret.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                ret.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            ret = ret.next;
        }
        
        if(l1 != null) {
            // l1 remained
            while(l1 != null) {
                ret.next = new ListNode(l1.val);
                l1 = l1.next;
                ret = ret.next;
            }
        } else if(l2 != null) {
            // l2 remained
            while(l2 != null) {
                ret.next = new ListNode(l2.val);
                l2 = l2.next;
                ret = ret.next;
            }
        }
        
        return retHead;
    }
}
