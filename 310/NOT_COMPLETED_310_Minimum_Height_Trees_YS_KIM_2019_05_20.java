class Solution {
    private int getHeight(Map<Integer, List<Integer>> tree, int node, int height, boolean[] visited) {
        if(tree.containsKey(node) && visited[node] == false) {
            visited[node] = true;
            List<Integer> childs = tree.get(node);
            int maxHeight = Integer.MIN_VALUE;
            for(Integer child : childs) {
                maxHeight = Math.max(maxHeight, getHeight(tree, child, height + 1, visited));
            }
            
            return Math.max(maxHeight, height + 1); 
        }
        return Integer.MIN_VALUE;
    }
    
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> ret = new ArrayList<>();
        if(n <= 0) return ret;
        Map<Integer, List<Integer>> tree = new HashMap<>();
        // make a tree like graph
        for(int i = 0; i < edges.length; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            // since it is bi-directional, we need to store both of directions into the map.
            List<Integer> arr1 = tree.getOrDefault(node1, new ArrayList<>());
            arr1.add(node2);
            tree.put(node1, arr1);
            
            List<Integer> arr2 = tree.getOrDefault(node2, new ArrayList<>());
            arr2.add(node1);
            tree.put(node2, arr2);
        }
        
        int minHeight = Integer.MAX_VALUE;
        Map<Integer, List<Integer>> heightMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            // calculate each graph's height
            int height = getHeight(tree, i, 0, visited);
            List<Integer> nodeList = heightMap.getOrDefault(height, new ArrayList<>());
            nodeList.add(i);
            heightMap.put(height, nodeList);
            minHeight = Math.min(minHeight, height);
        }
        
        return heightMap.get(minHeight);
    }
}
