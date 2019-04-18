/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    // key : orig, value : copied
    private Map<Node, Node> nodeMap = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        if(nodeMap.containsKey(node)) return nodeMap.get(node);
        
        Node copied = new Node(node.val, new ArrayList<>());
        nodeMap.put(node, copied);
        
        List<Node> copiedNeighbors = copied.neighbors;
        for(Node adj : node.neighbors) {
            Node adjCopy = cloneGraph(adj);
            copiedNeighbors.add(adjCopy);
        }
        
        return copied;
    }
}
