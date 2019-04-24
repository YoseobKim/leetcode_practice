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
    private void preorderTraversalHelper(TreeNode root, List<Integer> traversal) {
        if(root != null) {
            traversal.add(root.val);
            preorderTraversalHelper(root.left, traversal);
            preorderTraversalHelper(root.right, traversal);
        }
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        preorderTraversalHelper(root, ret);
        return ret;
    }
}
