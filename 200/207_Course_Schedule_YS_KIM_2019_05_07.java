class Solution {
    private boolean hasCycle(int from, Map<Integer, List<Integer>> graph, boolean[] visited, boolean[] processed) {
        if(processed[from]) return true;
        if(visited[from]) return false;
        
        visited[from] = true;
        processed[from] = true;
        
        List<Integer> childs = graph.get(from);
        if(childs == null) {
            processed[from] = false;
            return false;
        }

        for(int child : childs) {
            if(hasCycle(child, graph, visited, processed)) return true;
        }
        
        processed[from] = false;
        
        return false;
    }
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites.length <= 0) return true;
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        // build a graph
        for(int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];
            List<Integer> childs = graph.getOrDefault(from, new ArrayList<>());
            childs.add(to);
            graph.put(from, childs);
        }
        
        for(int i = 0; i < numCourses; i++) {
            boolean[] visited = new boolean[numCourses];
            boolean[] processed = new boolean[numCourses];
            if(hasCycle(i, graph, visited, processed)) return false;
        }
        return true;
    }
}
