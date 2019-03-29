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
    private List<TreeNode> readAllChilds(List<TreeNode> childs) {
        List<TreeNode> ret = new ArrayList<>();
        for(TreeNode n : childs) {
            if(n.left != null) ret.add(n.left);
            if(n.right != null) ret.add(n.right);
        }
        return ret;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        
        List<Integer> initial = new ArrayList<>();
        initial.add(root.val);
        ret.add(initial);
        
        List<TreeNode> childs = new ArrayList<>();
        if(root.left != null) childs.add(root.left);
        if(root.right != null) childs.add(root.right);
        
        int level = 1;
        while(true) {
            if(childs.size() <= 0) break;
            List<Integer> list = new ArrayList<>();
            if(level % 2 == 0) {
                for(int i = 0; i < childs.size(); i++) {
                    TreeNode n = childs.get(i);
                    list.add(n.val);
                }
            } else {
                for(int i = childs.size() - 1; i >= 0; i--) {
                    TreeNode n = childs.get(i);
                    list.add(n.val);
                }
            }
            ret.add(list);
            childs = readAllChilds(childs);
            level++;
        }
        
        return ret;
    }
}
