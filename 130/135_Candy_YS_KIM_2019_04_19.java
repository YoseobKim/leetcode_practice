class Solution {
    public int candy(int[] ratings) {
        int candies[] = new int[ratings.length];
        
        for(int i = 0; i < ratings.length; i++) {
            int nextIndex = i + 1 >= ratings.length ? i : i + 1;
            int prevIndex = i - 1 < 0 ? i : i - 1;
            
            if(ratings[prevIndex] > ratings[i]) {
                candies[i] = 1;
                for(int j = i - 1; j >= 0; j--) {
                    if(ratings[j] > ratings[j + 1] && candies[j] <= candies[j + 1]) {
                        candies[j] = candies[j] + 1;
                        continue;
                    }
                    break;
                }                
            } else if(ratings[prevIndex] < ratings[i]) {
                candies[i] = candies[prevIndex] + 1;
            } else {
                candies[i] = 1;
            }
        }
        
        int ret = 0;
        for(int i : candies) ret += i;
        
        return ret;
    }
}
