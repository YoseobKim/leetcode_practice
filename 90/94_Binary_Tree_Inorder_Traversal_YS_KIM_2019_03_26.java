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
    List<Integer> ret = new ArrayList<>();
    Stack<TreeNode> retStack = new Stack<>();
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        if(root == null) return new ArrayList<>();
        inorderTraversal(root.left);
        ret.add(root.val);
        inorderTraversal(root.right);
        return ret;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        TreeNode point = root;
        while(point != null || !retStack.isEmpty()) {
            while(point != null) {
                retStack.push(point);
                point = point.left;
            }
            point = retStack.pop();
            ret.add(point.val);
            point = point.right;
        }
        return ret;
    }
}
