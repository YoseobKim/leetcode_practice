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
    private List<String> helperList = new ArrayList<>();
    private void binaryTreePathsHelper(TreeNode root, List<Integer> untilNow) {
        if(root != null) {
            untilNow.add(root.val);
            if(root.left == null && root.right == null) {
                // leaf node
                String str = "";
                for(int i = 0; i < untilNow.size(); i++) {
                    int item = untilNow.get(i);
                    String add = i < untilNow.size() - 1 ? item + "->" : "" + item;
                    str += add;
                }
                helperList.add(str);
            }
            binaryTreePathsHelper(root.left, untilNow);
            binaryTreePathsHelper(root.right, untilNow);
            untilNow.remove(untilNow.size() - 1);
        }
    }
    
    public List<String> binaryTreePaths(TreeNode root) {
        binaryTreePathsHelper(root, new LinkedList<>());
        return helperList;
    }
}
