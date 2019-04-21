/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    private Set<ListNode> existance = new HashSet<>();
    
    public ListNode detectCycle(ListNode head) {
        ListNode node = head;
        
        while(node != null) {
            if(existance.contains(node)) {
                return node;
            }
            existance.add(node);
            node = node.next;
        }
            
        return null;
    }
}
