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
    public void flatten(TreeNode root) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode leftRightMost = root.left;
        if(leftRightMost == null) return;
        while(leftRightMost.right != null) {
            leftRightMost = leftRightMost.right;
        }
        leftRightMost.right = root.right;
        root.right = root.left;
        root.left = null;
        return;
    }
}
