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
    int maxDepth = 0;
    private void maxDepthHelper(TreeNode node, int depth) {
        if(node != null) {
            maxDepth = Math.max(maxDepth, depth);
            maxDepthHelper(node.left, depth + 1);
            maxDepthHelper(node.right, depth + 1);
        }
    }
    
    public int maxDepth(TreeNode root) {
        maxDepthHelper(root, 1);
        return maxDepth;
    }
}
