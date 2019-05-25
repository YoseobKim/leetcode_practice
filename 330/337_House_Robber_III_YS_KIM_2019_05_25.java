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
    private Map<TreeNode, Integer> memo = new HashMap<>();
    public int rob(TreeNode root) {
        if (root == null) return 0;
        if(memo.containsKey(root)) return memo.get(root);
        int ret = 0;
        int withMe = 0;
        if (root.left != null) {
            withMe += rob(root.left.left) + rob(root.left.right);
        }
    
        if (root.right != null) {
            withMe += rob(root.right.left) + rob(root.right.right);
        }
        ret = Math.max(withMe + root.val, rob(root.left) + rob(root.right));
        memo.put(root, ret);
        // compare with me and without me
        return ret;
    }
}
