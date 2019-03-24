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
}
