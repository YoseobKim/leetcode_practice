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
    int calledNum = 0;
    int ret = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root != null) {
            kthSmallest(root.left, k);
            calledNum++;
            if(k == calledNum) {
                ret = root.val;
            }
            kthSmallest(root.right, k);
        }
        return ret;
    }
}
