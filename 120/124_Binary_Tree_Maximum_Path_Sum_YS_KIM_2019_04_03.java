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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        maxPathHelper(root);
        return maxSum;
    }
    
    private int maxPathHelper(TreeNode root) {
        if(root == null) return 0;
        int leftSum = Math.max(0, maxPathHelper(root.left));
        int rightSum = Math.max(0, maxPathHelper(root.right));
        int sum = leftSum + rightSum + root.val;
        maxSum = Math.max(maxSum, sum);
        return Math.max(leftSum, rightSum) + root.val;
    }
}
