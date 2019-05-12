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
    private List<TreeNode> pAncestors = new ArrayList<>();
    private List<TreeNode> qAncestors = new ArrayList<>();
    private boolean pFound = false;
    private boolean qFound = false;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root != null && p != null && q != null) {
            if(!pFound) pAncestors.add(root);
            if(!qFound) qAncestors.add(root);
            
            if(root == p) pFound = true;
            if(root == q) qFound = true;
            if(pFound && qFound) return null;

            lowestCommonAncestor(root.left, p, q);
            lowestCommonAncestor(root.right, p, q);
            
            if(!pFound) pAncestors.remove(root);
            if(!qFound) qAncestors.remove(root);
        }
        
        int len = Math.min(pAncestors.size(), qAncestors.size());
        TreeNode prev = null;
        TreeNode lowestCommon = null;
        for(int i = 0; i < len; i++) {
            TreeNode pAncestor = pAncestors.get(i);
            TreeNode qAncestor = qAncestors.get(i);
            if(pAncestor == qAncestor) lowestCommon = pAncestor;
        }
        
        return lowestCommon;        
    }
}
