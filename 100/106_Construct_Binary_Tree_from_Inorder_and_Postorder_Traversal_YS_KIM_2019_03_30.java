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
    // basic idea
    // in post order, last index is always head
    // we can find head from inorder
    // before head node is left side in inorder
    // after head node is right side in inorder
    private TreeNode helper(int postStart, int inStart, int inEnd, int[] postorder, int[] inorder) {
        if (postStart < 0 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
                break;
            }
        }
        root.left = helper(postStart - (inEnd - inIndex  + 1), inStart, inIndex - 1, postorder, inorder);
        root.right = helper(postStart - 1, inIndex + 1, inEnd, postorder, inorder);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(postorder.length - 1, 0, inorder.length - 1, postorder, inorder);
    }
}
