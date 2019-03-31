/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    private void traverse(Node root, Map<Integer, List<Node>> map, int level) {
        if(root != null) {
            List<Node> list = map.getOrDefault(level, new ArrayList<>());
            list.add(root);
            map.put(level, list);
            traverse(root.left, map, level + 1);
            traverse(root.right, map, level + 1);
        }
    }
    
    public Node connect(Node root) {
        Map<Integer, List<Node>> map = new HashMap<>();
        traverse(root, map, 0);
        for(int i = 0; i < map.size(); i++) {
            List<Node> list = map.get(i);
            if(list == null) continue;
            Node prev = list.get(0);
            if(list.size() <= 1) {
                prev.next = null;
                continue;
            }
            for(int j = 1; j < list.size(); j++) {
                Node n = list.get(j);
                prev.next = n;
                prev = n;
            }
        }
        return root;
    }
}
