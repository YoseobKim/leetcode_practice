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
    private TreeNode sortedListToBSTHelper(int[] arr, int start, int end) {
        if(start > end) return null;
        if(end == start) return new TreeNode(arr[end]);
        if(end - start <= 1) {
            TreeNode head = new TreeNode(arr[end]);
            head.left = new TreeNode(arr[start]);
            return head;
        }
        int mid = (start + end) / 2;
        TreeNode head = new TreeNode(arr[mid]);
        head.left = sortedListToBSTHelper(arr, start, mid - 1);
        head.right = sortedListToBSTHelper(arr, mid + 1, end);
        return head;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedListToBSTHelper(nums, 0, nums.length - 1);
    }
}
