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
    private void inOrderHelper(TreeNode node, List<Integer> ret) {
        if(node != null) {
            inOrderHelper(node.left, ret);
            ret.add(node.val);
            inOrderHelper(node.right, ret);
        }
    }
    
    private List<Integer> inorder(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        inOrderHelper(root, ret);
        return ret;
    }
    
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        List<Integer> shouldBeSorted = inorder(root);
        long prev = Integer.MIN_VALUE;
        prev = prev - 1;
        for(int i = 0; i < shouldBeSorted.size(); i++) {
            int item = shouldBeSorted.get(i);
            if(prev < item) {
                prev = item;
                continue;
            }
            return false;
        }
        
        return true;
    }
}
