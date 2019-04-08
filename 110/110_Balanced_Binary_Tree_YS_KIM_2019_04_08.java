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
    int max = 0;
    private void isBalancedHelper(TreeNode node, int level) {
        if(node != null) {
            isBalancedHelper(node.left, level + 1);
            isBalancedHelper(node.right, level + 1);
            max = Math.max(level, max);
        }
    }
    
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        max = 0;
        isBalancedHelper(root.left, 1);
        int leftMax = max;
        max = 0;
        isBalancedHelper(root.right, 1);
        int rightMax = max;
        boolean ret = Math.abs(leftMax - rightMax) <= 1 ? true : false;
        return isBalanced(root.left) & isBalanced(root.right) & ret;
    }
}
