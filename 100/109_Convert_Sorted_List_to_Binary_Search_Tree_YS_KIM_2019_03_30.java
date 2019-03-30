/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode sortedListToBSTHelper(List<Integer> arr, int start, int end) {
        if(start > end) return null;
        if(end == start) return new TreeNode(arr.get(end));
        if(end - start <= 1) {
            TreeNode head = new TreeNode(arr.get(end));
            head.left = new TreeNode(arr.get(start));
            return head;
        }
        int mid = (start + end) / 2;
        TreeNode head = new TreeNode(arr.get(mid));
        head.left = sortedListToBSTHelper(arr, start, mid - 1);
        head.right = sortedListToBSTHelper(arr, mid + 1, end);
        return head;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> arr = new ArrayList<>();
        ListNode node = head;
        while(node != null) {
            arr.add(node.val);
            node = node.next;
        }
        
        return sortedListToBSTHelper(arr, 0, arr.size() - 1);
    }
}
