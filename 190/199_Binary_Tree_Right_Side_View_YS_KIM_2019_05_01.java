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
    private Map<Integer, Stack<TreeNode>> helper = new HashMap<>();
    private void rightSideViewHelper(TreeNode node, int level) {
        if(node != null) {
            rightSideViewHelper(node.left, level + 1);
            Stack<TreeNode> stack = helper.getOrDefault(level, new Stack<TreeNode>());
            stack.push(node);
            helper.put(level, stack);
            rightSideViewHelper(node.right, level + 1);
        }
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        rightSideViewHelper(root, 0);
        for(int i = 0; i < helper.size(); i++) {
            Stack<TreeNode> stack = helper.get(i);
            ret.add(stack.peek().val);
        }
        
        return ret;
    }
}
