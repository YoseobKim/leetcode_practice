class Solution {
    // [1,3,1]    [7,6,3]
    // [1,5,1] => [8,7,2] => return [0][0]
    // [4,2,1]    [7,3,1]
    // The idea is adding [i][j] from [n-1][m-1] with smaller one among the below one and right one.
    // The sum of smaller path will be the shortest path.
    
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        if(n <= 0) return 0;
        int m = grid[0].length;
        if(m <= 0) return 0;
        
        if(n <= 1) {
            int[] path = grid[0];
            int ret = 0;
            for(int i = 0; i < path.length; i++) {
                ret += path[i];
            }
            return ret;
        }
        
        if(m <= 1) {
            int ret = 0;
            for(int i = 0; i < n; i++) {
                ret += grid[i][0];
            }
            return ret;
        }
        
        for(int i = n - 1; i >= 0 ; i--) {
            for(int j = m - 1; j >= 0; j--) {
                if(i == n - 1 && j == m - 1) continue; 
                // skip grid[n - 1][m - 1], the last item of the grid.
                int downItem = i == n - 1 ? Integer.MAX_VALUE : grid[i + 1][j];
                int rightItem = j == m - 1 ? Integer.MAX_VALUE : grid[i][j + 1];
                int smaller = downItem > rightItem ? rightItem : downItem;
                grid[i][j] = grid[i][j] + smaller;
            }
        }
        
        
        return grid[0][0];
    }
}
