class Solution {
    public int maxArea(int[] height) {
        int maxVolume = 0;
        int start = 0;
        int end = 0;
        for(int i = 0; i < height.length; i++) {
            int heightLeft = height[i];
            for(int j = i; j < height.length; j++) {
                int width = j - i;
                int heightRight = height[j];
                int curHeight = heightLeft > heightRight ? heightRight : heightLeft;
                int volume = curHeight * width;
                if(maxVolume < volume) maxVolume = volume;
            }
        }
        
        return maxVolume;
    }
}
