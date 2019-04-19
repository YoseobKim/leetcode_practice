/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    // key : orig, value : copied
    private Map<Node, Node> nodeMap = new HashMap<>();
    public Node copyRandomList(Node head) {
        Node ptr = head;
        // 1. Copy value and store it into the map
        while(ptr != null) {
            nodeMap.put(ptr, new Node(ptr.val, null, null));
            ptr = ptr.next;
        }
        // 2. Treat next and random
        ptr = head;
        while(ptr != null) {
            Node copiedNext = nodeMap.get(ptr.next);
            Node copiedRandom = nodeMap.get(ptr.random);
            Node copiedPtr = nodeMap.get(ptr);
            copiedPtr.next = copiedNext;
            copiedPtr.random = copiedRandom;
            ptr = ptr.next;
        }
        
        return nodeMap.get(head);
    }
}
