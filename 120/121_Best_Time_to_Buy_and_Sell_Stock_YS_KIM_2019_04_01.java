class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int benefit = 0;
        for(int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if(price < minPrice) {
                minPrice = price;
            } else {
                benefit = price - minPrice > benefit ? price - minPrice : benefit;
            }
        }
        return benefit;
            
    }
}
