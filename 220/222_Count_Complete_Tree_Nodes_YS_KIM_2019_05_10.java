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
    int nodeNum = 0;
    private void countNodesHelper(TreeNode root) {
        if(root != null) {
            countNodesHelper(root.left);
            nodeNum++;
            countNodesHelper(root.right);
        }
    }
    public int countNodes(TreeNode root) {
        countNodesHelper(root);
        return nodeNum;
    }
}
