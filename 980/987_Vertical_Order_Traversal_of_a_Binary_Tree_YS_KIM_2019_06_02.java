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
    private int leftMost = 0;
    private int rightMost = 0;
    private void traverse(TreeNode node, Map<Integer, List<Integer>> map, int pos) {
        if(node != null) {
            leftMost = Math.min(pos, leftMost);
            rightMost = Math.max(pos, rightMost);
            List<Integer> nodes = map.getOrDefault(pos, new ArrayList<>());
            nodes.add(node.val);
            map.put(pos, nodes);
            traverse(node.left, map, pos - 1);
            traverse(node.right, map, pos + 1);
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        Map<Integer, List<Integer>> retHelper = new HashMap<>();
        traverse(root, retHelper, 0);
        for(int i = leftMost; i <= rightMost; i++) {
            List<Integer> list = retHelper.get(i);
            ret.add(list);
        }
        
        return ret;
    }
}
