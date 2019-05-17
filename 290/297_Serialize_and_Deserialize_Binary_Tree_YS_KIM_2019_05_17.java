/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    private String serializeHelper(TreeNode node, String prev) {
        if(node != null) {
            String ret = node.val + ",";
            String left = serializeHelper(node.left, prev);
            String right = serializeHelper(node.right, prev);
            return prev + ret + left + right;
        } else {
            return "null,";
        }
    }
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String ret = serializeHelper(root, "");
        int lastCommaIndex = ret.lastIndexOf(",");
        ret = ret.substring(0, lastCommaIndex);
//        System.out.println(ret);
        return ret;
    }
    
    private TreeNode deserializeHelper(List<String> queue) {
        if(queue.size() > 1) {
            // dequeue it.
            String item = queue.get(0);
            queue.remove(0);
            if(item.equals("null")) return null;
            TreeNode ret = new TreeNode(Integer.parseInt(item));
            ret.left = deserializeHelper(queue);
            ret.right = deserializeHelper(queue);
            return ret;
        }
        return null;
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() > 0) {
            String[] dataArr = data.split(",");
            List<String> queue = new LinkedList<>(Arrays.asList(dataArr));
            return deserializeHelper(queue);
        } 
        return null;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
