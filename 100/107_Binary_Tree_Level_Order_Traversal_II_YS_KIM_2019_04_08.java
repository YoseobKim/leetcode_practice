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
    private Map<Integer, List<Integer>> retHelper = new HashMap<>();
    private void levelOrderBottomHelper(TreeNode node, int level) {
        if(node != null) {
            levelOrderBottomHelper(node.left, level + 1);
            levelOrderBottomHelper(node.right, level + 1);
            List<Integer> list = retHelper.getOrDefault(level, new ArrayList<>());
            list.add(node.val);
            retHelper.put(level, list);
        }
    }
    
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        levelOrderBottomHelper(root, 0);
        
        List<List<Integer>> ret = new ArrayList<>();
        for(int i = retHelper.size() - 1; i >= 0; i--) {
            ret.add(retHelper.get(i));
        }
        return ret;
    }
}
