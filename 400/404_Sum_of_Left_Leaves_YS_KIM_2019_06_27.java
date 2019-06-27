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
    private int ret = 0;
    private void sumOfLeafLeaves(TreeNode node, boolean left) {
        if(node != null) {
            if(node.left == null && node.right == null && left) {
                ret += node.val;
                return;
            }
            sumOfLeafLeaves(node.left, true);
            sumOfLeafLeaves(node.right, false);
        }
    }
    
    public int sumOfLeftLeaves(TreeNode root) {
        sumOfLeafLeaves(root, false);
        return ret;
    }
}
