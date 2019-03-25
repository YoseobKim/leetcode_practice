/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    private int getSize(ListNode head) {
        int ret = 0;
        while(head != null) {
            ret++;
            head = head.next;
        }
        return ret;
    }
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode node = head;
        int length = getSize(head);
        if(length <= 0) return head;
        List<ListNode> arr = new ArrayList<>();
        for(int i = 0; i < length; i++) {
            arr.add(new ListNode(0));
        }
        int newLen = n - m;
        int index = 1;
        while(node != null) {
            if(index >= m && index <= n) {
                int newIndex = index - m;
                arr.set(newLen - newIndex + (m - 1), node);
            } else {
                arr.set(index - 1, node);
            }
            index++;
            node = node.next;
        }
        
        for(int i = 0; i < length - 1; i++) {
            ListNode cur = arr.get(i);
            cur.next = arr.get(i + 1);
        }
        
        return arr.get(0);
    }
}
