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
    private List<List<Integer>> getPathAsList(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null) return ret;
        if(root.left == null && root.right == null) {
            // leaf node
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            ret.add(list);
            return ret;
        }
        
        List<List<Integer>> prevLeft = getPathAsList(root.left);
        List<List<Integer>> prevRight = getPathAsList(root.right);
        for(List<Integer> prev : prevLeft) {
            List<Integer> item = new ArrayList<>(prev);
            item.add(0, root.val);
            ret.add(item);
        }
        for(List<Integer> prev : prevRight) {
            List<Integer> item = new ArrayList<>(prev);
            item.add(0, root.val);
            ret.add(item);
        }
        return ret;
    }
    
    private int listToNum(List<Integer> list) {
        int ret = 0;
        int digit = 1;
        for(int i = list.size() - 1; i >= 0; i--) {
            int item = list.get(i);
            ret += item * digit;
            digit *= 10;
        }
        
        return ret;
    }
    
    public int sumNumbers(TreeNode root) {
        List<List<Integer>> all = getPathAsList(root);
        int sum = 0;
        for(List<Integer> num : all) {
            sum += listToNum(num);
        }
        return sum;
    }
}
