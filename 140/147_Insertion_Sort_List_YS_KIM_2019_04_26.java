/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode ret = head;
        for(ListNode node1 = head; node1 != null; node1 = node1.next) {
            for(ListNode node2 = node1; node2 != null; node2 = node2.next) {
                if(node1.val > node2.val) {
                    // swap
                    int temp = node1.val;
                    node1.val = node2.val;
                    node2.val = temp;
                }
            }
        }
        return ret;
    }
}
