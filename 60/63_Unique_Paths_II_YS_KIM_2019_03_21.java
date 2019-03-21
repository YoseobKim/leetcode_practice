class Solution {
    // Same with 62 unique path
    // but treat block as 0
    // initial state of way array is Integer.MIN_VALUE
    // edges will be initially 1.
    // but if block comes at the edge, 0 ~ block index should be 0
    // ex) 
    // [0,0,0]      [min,min,1]     [2,1,1]
    // [0,1,0]  =>  [min, 0 ,1]  => [1,0,1] => return [0][0]
    // [0,0,0]      [1  , 1 ,1]     [1,1,1]
    // [0,0]        [0,1]      [1,1]
    // [1,0]    =>  [0,1]  =>  [0,1] => return [0][0]
    // [0,0]        [1,1]      [1,1]
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        if(n <= 0) return 0;
        int m = obstacleGrid[0].length;
        if(m <= 0) return 0;
        
        if(n <= 1) {
            int[] path = obstacleGrid[0];
            for(int i = 0; i < path.length; i++) {
                if(path[i] == 1) return 0;
            }
            return 1;
        }
        
        if(m <= 1) {
            for(int i = 0; i < n; i++) {
                int path = obstacleGrid[i][0];
                if(path == 1) return 0;
            }
            return 1;
        }
        
        if(obstacleGrid[n - 1][m - 1] == 1) return 0;
        
        int[][] way = new int[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(obstacleGrid[i][j] == 1) {
                    way[i][j] = 0;
                    continue;
                }
                way[i][j] = Integer.MIN_VALUE;
            }
        }
        
        boolean beforeShouldBeNotAccessible = false;
        // initialize
        for(int i = n - 1; i >= 0; i--) {
            if(beforeShouldBeNotAccessible) way[i][m - 1] = 0;
            else if(obstacleGrid[i][m - 1] == 1) {
                way[i][m - 1] = 0;
                beforeShouldBeNotAccessible = true;
            } else {
                way[i][m - 1] = 1;
            }
        }
        beforeShouldBeNotAccessible = false;
        for(int i = m - 1; i >= 0; i--) {
            if(beforeShouldBeNotAccessible) way[n - 1][i] = 0;
            else if(obstacleGrid[n - 1][i] == 1) {
                way[n - 1][i] = 0;
                beforeShouldBeNotAccessible = true;
            } else {
                way[n - 1][i] = 1;
            }
        }
    
        for(int i = n - 2; i >= 0; i--) {
            for(int j = m - 2; j >= 0; j--) {
                if(way[i][j] == 0) continue;
                way[i][j] = way[i][j + 1] + way[i + 1][j];
            }
        }
       
        return way[0][0];
    }
}
