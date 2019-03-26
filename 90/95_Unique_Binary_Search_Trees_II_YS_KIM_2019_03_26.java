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
    private List<List<Integer>> combination(int n) {
        List<List<Integer>> ret = new ArrayList<>();
        if(n <= 2) {
            List<Integer> one = new ArrayList<>();
            one.add(1);
            one.add(2);
            ret.add(one);
            List<Integer> two = new ArrayList<>();
            two.add(2);
            two.add(1);
            ret.add(two);
            return ret;
        }
        
        List<List<Integer>> prev = combination(n - 1);
        int cur = n;
        for(List<Integer> item : prev) {
            for(int i = 0; i < n; i++) {
                List<Integer> newItem = new ArrayList<>(n);
                newItem.addAll(item);
                newItem.add(i, cur);
                ret.add(newItem);
            }
        }
        
        return ret;
    }
    
    private TreeNode insert(TreeNode head, int val) {
        TreeNode node = head;
        TreeNode parent = null;
        while(node != null) {
            parent = node;
            int cur = node.val;
            if(cur >= val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        if(parent.val >= val) {
            parent.left = new TreeNode(val);
        } else {
            parent.right = new TreeNode(val);
        }
        
        return head;
    }
    
    private void preOrderHelper(TreeNode head, List<Integer> res) {
        if(head != null) {
            res.add(head.val);
            preOrderHelper(head.left, res);
            preOrderHelper(head.right, res);
        }
    }
    
    private List<Integer> preOrder(TreeNode head) {
        List<Integer> ret = new ArrayList<>();
        preOrderHelper(head, ret);
        return ret;
    }
    
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ret = new ArrayList<>();
        if(n <= 0) return ret;
        if(n <= 1) {
            TreeNode node = new TreeNode(n);
            ret.add(node);
            return ret;
        }

        // get all combinations
        List<List<Integer>> combinations = combination(n);
        // insert list into tree
        for(List<Integer> item : combinations) {
            TreeNode newHead = new TreeNode(item.get(0));
            for(int i = 1; i < item.size(); i++) {
                int val = item.get(i);
                insert(newHead, val);
            }
            ret.add(newHead);
        }
        
        // check and remove duplications
        Iterator itr = ret.iterator(); 
        Set<List<Integer>> traversalResult = new HashSet<>();

        while (itr.hasNext()) 
        { 
            TreeNode head = (TreeNode)itr.next(); 
            List<Integer> res = preOrder(head);
            if(traversalResult.contains(res)) itr.remove();
            else traversalResult.add(res);
        }
            
        return ret;
    }
}
