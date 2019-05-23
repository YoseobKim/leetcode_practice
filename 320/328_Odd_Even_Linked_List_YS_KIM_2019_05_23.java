/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode evenNodeStart = evenNode;
        
        while(evenNode != null) {
            ListNode nextOddNode = evenNode.next;
            if(nextOddNode == null) break;
            ListNode nextEvenNode = nextOddNode.next;
            
            oddNode.next = nextOddNode;
            evenNode.next = nextEvenNode;
            
            oddNode = nextOddNode;
            evenNode = nextEvenNode;
        }
        
        oddNode.next = evenNodeStart;
        
        return head;
    }
}
