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
    private boolean hasPathSumHelper(TreeNode node, int sumUntil, int sum) {
        if(node != null) {
            if(node.left == null && node.right == null) {
                sumUntil = sumUntil + node.val;
                return sumUntil == sum ? true : false;
            }
            boolean retLeft = hasPathSumHelper(node.left, sumUntil + node.val, sum);
            boolean retRight = hasPathSumHelper(node.right, sumUntil + node.val, sum);
            return retLeft || retRight;
        } 
        return false;
    }
    
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        return hasPathSumHelper(root, 0, sum);
    }
}
