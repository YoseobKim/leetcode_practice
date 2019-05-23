class Solution {
    private Map<String, Integer> memo = new HashMap<>();
    private String makeKey(int i, int j) {
        return i + ":" + j;
    }
    private int longestIncreasingPathHelper(int[][] matrix, int i, int j, int w, int h, boolean[][] visited, int untilNow, int prev) {
        // due to visited, memoization is quite difficult...
//        if(memo.containsKey(makeKey(i, j))) return memo.get(makeKey(i, j)) + untilNow - 1;
        if(i < 0 || i >= h) return untilNow - 1;
        if(j < 0 || j >= w) return untilNow - 1;
        if(visited[i][j]) return untilNow - 1;
        int item = matrix[i][j];
        if(item > prev) {
            visited[i][j] = true;
            
            int ret = untilNow;
            // go up
            int up = longestIncreasingPathHelper(matrix, i - 1, j, w, h, visited, untilNow + 1, item);
            ret = Math.max(ret, up);
            // go down
            int down = longestIncreasingPathHelper(matrix, i + 1, j, w, h, visited, untilNow + 1, item);
            ret = Math.max(ret, down);
            // go left
            int left = longestIncreasingPathHelper(matrix, i, j - 1, w, h, visited, untilNow + 1, item);
            ret = Math.max(ret, left);
            // go right
            int right = longestIncreasingPathHelper(matrix, i, j + 1, w, h, visited, untilNow + 1, item);
            ret = Math.max(ret, right);
            
            visited[i][j] = false;

            return ret;

        }
        return untilNow - 1;
    }
    
    public int longestIncreasingPath(int[][] matrix) {
        int h = matrix.length;
        if(h == 0) return 0;
        int w = matrix[0].length;
        int max = 0;
        
        for(int i = 0; i < h; i++) {
            for(int j = 0; j < w; j++) {
                boolean[][] visited = new boolean[h][w];
                int res = longestIncreasingPathHelper(matrix, i, j, w, h, visited, 1, Integer.MIN_VALUE);
//                memo.put(makeKey(i, j), res);
//                System.out.println(i + " : " + j + " = " + res);
                max = Math.max(res, max);
            }
        }
        
        return max;
    }
}
