/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private ListNode jump(ListNode head, int jumpForLast) {
        ListNode ret = head;
        for(int i = 0; i < jumpForLast; i++) {
            ret = ret.next;
        }
        
        return ret;
    }
    
    public void reorderList(ListNode head) {
        if(head == null) return;
        ListNode node = head;
        
        int jumpForLast = 0;
        while(node.next != null) {
            node = node.next;
            jumpForLast++;
        }
        if(jumpForLast <= 1) return;
            
        ListNode first = head;
        ListNode last = node;
        ListNode prevLast = null;
        int loopCount = 0;
        int halfLen = (jumpForLast + 1) / 2;
        while(true) {
            if(first == last) {
                prevLast.next = first;
                first.next = null;
                break;
            }
            if(loopCount >= halfLen) {
                prevLast.next = null;
                break;
            }
            
            ListNode next = first.next;
            first.next = last;
            if(prevLast != null) prevLast.next = first;
            
            first = next;
            prevLast = last;
            jumpForLast = jumpForLast - 2;
            // first -> last linked. So next last jump should be minused 2.
            // ex) 1->2->3->4, initial jumpForLast = 3, 1->4 (next first 2 and next last 3, in this case jumpForLast = 1)
            last = jump(next, jumpForLast);
            loopCount++;
        }
    }
}
