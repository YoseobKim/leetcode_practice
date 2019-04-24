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
    private void postorderTraversalHelper(TreeNode root, List<Integer> traversal) {
        if(root != null) {
            postorderTraversalHelper(root.left, traversal);
            postorderTraversalHelper(root.right, traversal);
            traversal.add(root.val);
        }
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        postorderTraversalHelper(root, ret);
        return ret;
    }
}
