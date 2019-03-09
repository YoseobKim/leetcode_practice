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
    
    // In the explanation, we can find 
    // "You may not modify the values in the list's nodes, only nodes itself may be changed."
    // swap should be done by pointer change.
    private ListNode swapNode(ListNode l1, ListNode l2) {
        ListNode tmp = l2.next;
        l2.next = l1;
        l1.next = tmp;
        return l2; // front node in swapped list.
    }
    
    public ListNode swapPairs(ListNode head) {
        int len = getLength(head);
        if(len == 0) return null;
        if(len == 1) return head;
        ListNode ret = head.next; // ret head node is always second node.
        ListNode node1 = head;
        ListNode node2 = head.next;
        ListNode prevNode = null;
        if(len % 2 > 0) len--; // loop until max even num
        for(int i = 0; i < len; i++) {
            if(i % 2 == 0) {
                ListNode orig = swapNode(node1, node2);
                if(prevNode == null) prevNode = orig;
                else {
                    // prev front.next.next should be new front node.
                    // Step1 1 -> 2 -> 3 -> 4
                    // Step2 2 -> 1 -> 3 -> 4
                    //       * (orig, prev)
                    // Step3 2 -> 1    4 -> 3
                    //       * (prev)  * (orig)
                    // Step4 2 -> 1 -> 4 -> 3
                    prevNode.next.next = orig;
                    prevNode = orig;
                }
                // because of swap, node1 doesn't need to be changed.
                node2 = node1.next;
                continue;
            }
            // in case of not swapping, need to precess both of pointers.
            if(node2 == null) break; // finished.
            node1 = node1.next;
            node2 = node2.next;
        }
        
        return ret;
    }
}
