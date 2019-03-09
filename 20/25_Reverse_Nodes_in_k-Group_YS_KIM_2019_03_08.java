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
    // store list to array with index
    private ListNode[] insertAllintoMap(ListNode node, int size) {
        ListNode[] ret = new ListNode[size];
        int idx = 0;
        ListNode n = node;
        while(n != null) {
            ret[idx] = n;
            n = n.next;
            idx++;
        }
        return ret;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = getLength(head);
        if(len == 0) return null;
        if(len == 1) return head;
        if(len < k) return head;
        ListNode[] nodesMap = insertAllintoMap(head, len);
        int loopCount = 0;
        for(int i = 0; i < len; i++) {
            if(i % k == 0) {
                for(int j = 0; j < k / 2; j++) {
                    int swapIndex1 = i + j;
                    int swapIndex2 = i + k - j - 1;
                    ListNode swapTarget1 = nodesMap[swapIndex1];
                    ListNode swapTarget2 = nodesMap[swapIndex2];
                    // swap using map
                    nodesMap[swapIndex1] = swapTarget2;
                    nodesMap[swapIndex2] = swapTarget1;
                }
            }
            if(i + k + 1 > len) break; // break
        }
        // rebuild array to list.
        for(int i = 0; i < nodesMap.length - 1; i++) {
            nodesMap[i].next = nodesMap[i + 1];
        }
        return nodesMap[0];    
    }
}
