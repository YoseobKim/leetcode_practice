/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Boolean> appearanceMap = new HashMap<>();
        ListNode node = head;
        while(node != null) {
            int val = node.val;
            // if duplication checked? mark false.
            boolean appearance = appearanceMap.get(val) == null ? true : false;
            appearanceMap.put(val, appearance);
            node = node.next;
        }
        
        ListNode prev = null;
        node = head;
        while(node != null) {
            int val = node.val;
            if(!appearanceMap.get(val)) {
                // case 1. prev == null. move head ahead until appearanceMap.get(val) == true 
                if(prev == null) {
                    head = node.next;
                    node = node.next;
                    continue;
                } else {
                // case 2. prev.next = node.next. point next one until appearanceMap.get(val) == true
                    prev.next = node.next; 
                    node = node.next;
                    continue;
                }
            }
            prev = node;
            node = node.next;
        }
        
        return head;
    }
}
