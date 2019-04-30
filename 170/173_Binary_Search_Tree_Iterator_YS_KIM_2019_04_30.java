/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    private TreeNode root = null;
    private int cur = 0;
    private List<TreeNode> nodeList = null;
    
    private void initializeList(TreeNode root) {
        if(root != null) {
            initializeList(root.left);
            nodeList.add(root);
            initializeList(root.right);
        }
    }
    
    public BSTIterator(TreeNode root) {
        root = root;
        cur = 0;
        nodeList = new ArrayList<>();
        initializeList(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        int val = nodeList.get(cur).val;
        cur++;
        return val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return cur < nodeList.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
