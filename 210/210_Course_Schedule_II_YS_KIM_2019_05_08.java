class Solution {
        private boolean hasCycle(int from, Map<Integer, List<Integer>> graph, boolean[] visited, boolean[] processed, List<Integer> visitList) {
        if(processed[from]) return true;
        if(visited[from]) return false;
        
        visited[from] = true;
        processed[from] = true;
        
        List<Integer> childs = graph.getOrDefault(from, new ArrayList<>());

        for(int child : childs) {
            if(hasCycle(child, graph, visited, processed, visitList)) return true;
        }
        visitList.add(from);
        processed[from] = false;
        
        return false;
    }
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if(prerequisites.length <= 0) {
            int[] ret = new int[numCourses];
            for(int i = 0; i < numCourses; i++) {
                ret[i] = i;
            }
            return ret;
        }
        
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        // build a graph
        for(int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            List<Integer> childs = graph.getOrDefault(from, new ArrayList<>());
            childs.add(to);
            graph.put(from, childs);
        }
        
        List<Integer> inList = new ArrayList<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] processed = new boolean[numCourses];
        
        for(int i = 0; i < numCourses; i++) {
            if(hasCycle(i, graph, visited, processed, inList)) return new int[0];
        }
        
        // at least there is no cycle.
        int[] ret = new int[numCourses];
        int index = 0;
        for(int i = inList.size() - 1; i >= 0; i--) {
            int in = inList.get(i);
            ret[index++] = in;
        }
        
        return ret;
    }
}
