/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode merge(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0); // to point out head
        ListNode p = ret;
    
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
    
        if (l1 != null)
            p.next = l1;
    
        if (l2 != null)
            p.next = l2;
    
        return ret.next;
    }
    
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        // step 1. find mid using runner method
        ListNode prev = null;
        ListNode mid = head;
        ListNode fast = head;
    
        while (fast != null && fast.next != null) {
            prev = mid;
            mid = mid.next;
            fast = fast.next.next;
        }
    
        // divide it.
        prev.next = null;
    
        // step 2. sort each half basically same with merge sort algoritm.
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(mid);
    
        // step 3. merge l1 and l2
        return merge(l1, l2);
    }
}
