class Solution {
    private int getVol(int[] heights, int from, int to) {
        int width = to - from + 1;
        int height = Integer.MAX_VALUE;
        for(int i = from; i <= to; i++) {
            height = heights[i] < height ? heights[i] : height;
        }
        return width * height;
    }
    
    public int largestRectangleArea(int[] heights) {
        int maxVol = 0;
        for(int i = 0; i < heights.length; i++) {
            for(int j = i; j < heights.length; j++) {
                int vol = getVol(heights, i, j);
                maxVol = vol > maxVol ? vol : maxVol;
            }
        }
        return maxVol;
    }
    // matrix         height array
    // [1,0,1,0,0] => [1,0,1,0,0]
    // [1,0,1,1,1] => [2,0,2,1,0]
    // [1,1,1,1,1] => [3,1,3,2,1]
    // [1,0,0,1,0] => [4,0,0,3,0]
    // do volumne calculation on height array using 84.
    
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if(n <= 0) return 0;
        int m = matrix[0].length;
        if(m <= 0) return 0;
        int[] heights = new int[m];
        int maxVol = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == '0') heights[j] = 0;
                else heights[j] = heights[j] + 1;
            }
            int vol = largestRectangleArea(heights);
            maxVol = vol > maxVol ? vol : maxVol;
        }
        return maxVol;
    }
}
