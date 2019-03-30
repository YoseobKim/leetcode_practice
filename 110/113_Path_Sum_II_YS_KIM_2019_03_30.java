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
    List<List<Integer>> ret = new ArrayList<>();
    private void pathSumHelper(TreeNode root, int sum, int sumUntil, List<Integer> path) {
        if(root == null) {
            return;
        }

        List<Integer> currentPath = new ArrayList<>(path);
        currentPath.add(root.val);
        sumUntil = sumUntil + root.val;
        if(root.left == null && root.right == null) {
            if(sum == sumUntil) ret.add(currentPath);
            return;
        }
        
        pathSumHelper(root.left, sum, sumUntil, currentPath);
        pathSumHelper(root.right, sum, sumUntil, currentPath);
        
        return;
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        pathSumHelper(root, sum, 0, new ArrayList<>());
        return ret;
    }
}
