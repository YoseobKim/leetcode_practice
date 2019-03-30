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
    // first preorder is always root.
    // we can find root from inorder.
    // before root index is left side in inorder.
    // after root index is right side in inorder.
    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
    
    private TreeNode buildTreeHelper(int[] inorder) {
        if(inorder.length <= 0) return null;
        if(inorder.length <= 1) return new TreeNode(inorder[0]);
        
        TreeNode head = new TreeNode(inorder[1]);
        head.left = new TreeNode(inorder[0]);
        head.right = buildTreeHelper(Arrays.copyOfRange(inorder, 2, inorder.length));
        return head;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }
}
