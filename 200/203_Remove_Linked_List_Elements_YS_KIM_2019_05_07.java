/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode node = head;
        ListNode prev = null;
        while(node != null) {
            if(node.val == val) {
                if(prev != null) {
                    prev.next = node.next;
                    node = node.next;
                    continue;
                } else {
                    head = node.next;
                    node = head;
                    continue;
                }
            }
            prev = node;
            node = node.next;
        }
        return head;
    }
}
