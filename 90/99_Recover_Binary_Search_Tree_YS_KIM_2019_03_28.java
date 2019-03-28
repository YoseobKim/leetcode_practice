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
    private void swapValue(TreeNode root, TreeNode swapNode) {
        int temp = swapNode.val;
        swapNode.val = root.val;
        root.val = temp;
    }
    
    private void inOrderHelper(TreeNode node, List<TreeNode> ret) {
        if(node != null) {
            inOrderHelper(node.left, ret);
            ret.add(node);
            inOrderHelper(node.right, ret);
        }
    }
    
    private List<TreeNode> inorder(TreeNode root) {
        List<TreeNode> ret = new ArrayList<>();
        inOrderHelper(root, ret);
        return ret;
    }
    
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        List<TreeNode> ret = inorder(root);
//        for(TreeNode t : ret) {
//            System.out.print(t.val + ", ");
//        }
//        System.out.println("");
        for(int i = 0; i < ret.size(); i++) {
            for(int j = i + 1; j < ret.size(); j++) {
                TreeNode item1 = ret.get(i);
                TreeNode item2 = ret.get(j);
                if(item1.val > item2.val) {
                    swapValue(item1, item2);
                }
            }
        }
    }
}
