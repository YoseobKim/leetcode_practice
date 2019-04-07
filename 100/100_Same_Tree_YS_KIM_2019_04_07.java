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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        if(p == null && q != null) return false;
        if(p != null && q == null) return false;
        if(p.val == q.val) {
            boolean leftSame = isSameTree(p.left, q.left);
            boolean rightSame = isSameTree(p.right, q.right);
            return leftSame & rightSame;
        }
        return false;
    }
}
