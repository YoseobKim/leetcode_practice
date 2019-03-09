/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    // little helper function to get the length of the list
    public int getLength(ListNode node) {
        int ret = 0;
        while(node != null) {
            ret++;
            node = node.next;
        }
        return ret;
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode ret = new ListNode(0);
        ListNode retPtr = ret;
        int lenOfNode1 = getLength(node1);
        int lenOfNode2 = getLength(node2);
        int maxLen = lenOfNode1 > lenOfNode2 ? lenOfNode1 : lenOfNode2;
        // cannot exceed max len.
        
        for(int i = 0; i < maxLen; i++) {
            int node1Val = node1 != null ? node1.val : 0;
            int node2Val = node2 != null ? node2.val : 0;
            int sumOfthisDigit = node1Val + node2Val + carry;
            
            node1 = node1 != null ? node1.next : null;
            node2 = node2 != null ? node2.next : null;

            carry = sumOfthisDigit / 10;
            sumOfthisDigit = sumOfthisDigit % 10;
            
            retPtr.val = sumOfthisDigit;
            if(node1 != null || node2 != null) {
                retPtr.next = new ListNode(0);
                retPtr = retPtr.next; // move on to the next node
            } else {
                // This node is the end. Just make sure the MSD.
                if(carry > 0) {
                    retPtr.next = new ListNode(carry);           
                }
            }
        }
        
        return ret;
    }
}
