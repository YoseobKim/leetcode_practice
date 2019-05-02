class Solution {
    private boolean numIslandsHelper(char[][] grid, int w, int h, int x, int y) {
        if(x < 0 || y < 0 || x >= w || y >= h || grid[x][y] == '0') return false;
        grid[x][y] = '0'; // change land to water
        // do same thing for up
        numIslandsHelper(grid, w, h, x, y - 1);
        // do same thing for down
        numIslandsHelper(grid, w, h, x, y + 1);
        // do same thing for left
        numIslandsHelper(grid, w, h, x - 1, y);
        // do same thing for right
        numIslandsHelper(grid, w, h, x + 1, y);
        // by doing these, it will turn all connected land to water.
        
        return true;
    }
    
    public int numIslands(char[][] grid) {
        int w = grid.length;
        if(w <= 0) return 0;
        int h = grid[0].length;
        if(h <= 0) return 0;
        int ret = 0;
        for(int i = 0; i < w; i++) {
            for(int j = 0; j < h; j++) {
                if(numIslandsHelper(grid, w, h, i, j)) ret++;
            }
        }
        return ret;
    }
}
