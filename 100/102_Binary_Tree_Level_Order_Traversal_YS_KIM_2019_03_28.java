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
    private void levelOrderHelper(TreeNode root, int level, Map<Integer, List<Integer>> ret) {
        if(root != null) {
            List<Integer> list = ret.get(level);
            if(list == null) list = new ArrayList<>();
            list.add(root.val);
            ret.put(level, list);
            levelOrderHelper(root.left, level + 1, ret);
            levelOrderHelper(root.right, level + 1, ret);
        }
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        Map<Integer, List<Integer>> retHelper = new HashMap<>();
        levelOrderHelper(root, 0, retHelper);
        List<List<Integer>> ret = new ArrayList<>();
        for(int i = 0; i < retHelper.size(); i++) {
            List<Integer> list = retHelper.get(i);
            ret.add(list);
        }
        
        return ret;
    }
}
