/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private int getLength(ListNode node) {
        int len = 0;
        ListNode n = node;
        while(n != null) {
            len++;
            n = n.next;
        }
        return len;
    }
    
    // a very simple merging function.
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // edge cases.
        if(getLength(l1) <= 0) return l2;
        if(getLength(l2) <= 0) return l1;
        ListNode retList = new ListNode(0);
        ListNode retPtr = retList;
        ListNode l1Ptr = l1;
        ListNode l2Ptr = l2;
        
        while(l1Ptr != null && l2Ptr != null) {
            // compare and merge into retList.
            if(l1Ptr.val >= l2Ptr.val) {
                retPtr.val = l2Ptr.val;
                retPtr.next = new ListNode(0);
                retPtr = retPtr.next;
                l2Ptr = l2Ptr.next;
            } else {
                retPtr.val = l1Ptr.val;
                retPtr.next = new ListNode(0);
                retPtr = retPtr.next;
                l1Ptr = l1Ptr.next;
            }
        }
        
        // l1 remain. which means remained l1 is always larger than merged list.
        if(l1Ptr != null) {
            while(l1Ptr != null) {
                retPtr.val = l1Ptr.val;
                l1Ptr = l1Ptr.next;
                if(l1Ptr != null) {
                    retPtr.next = new ListNode(0);
                    retPtr = retPtr.next;
                }
            }
        }
        
        // l2 remain. which means remained l2 is always larger than merged list.
        if(l2Ptr != null) {
            while(l2Ptr != null) {
                retPtr.val = l2Ptr.val;
                l2Ptr = l2Ptr.next;
                if(l2Ptr != null) {
                    retPtr.next = new ListNode(0);
                    retPtr = retPtr.next;
                }
            }
        }
        
        return retList;
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        // edge cases.
        if(len == 0) return null;
        if(len == 1) return lists[0];
        // [[1,4,5],[1,3,4],[2,6]]
        // i = 0    [1, 4, 5], [1, 3, 4]        [1, 1, 3, 4, 4, 5]
        // i = 1    [1, 1, 3, 4, 4, 5], [2, 5]  [1, 1, 2, 3, 4, 4, 5, 6]
        // i = 2 is not necessary. => len - 1 loop is enough.
        // return [1, 1, 2, 3, 4, 4, 5, 6]
        for(int i = 0; i < len - 1; i++) {
            ListNode l1 = lists[i];
            ListNode l2 = lists[i + 1];
            ListNode merged = mergeTwoLists(l1, l2);

            // to avoid memory limit exceeded situation.
            lists[i] = null;
            lists[i + 1] = merged;
        }
        // after above loop, last item will be merged total.
        return lists[len - 1];
    }
}
