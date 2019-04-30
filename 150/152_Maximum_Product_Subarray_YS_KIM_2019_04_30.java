class Solution {
    private int subArrayProduct(int i, int j, int[] orig) {
        int[] arr = Arrays.copyOfRange(orig, i, j + 1);
        int ret = 1;
        for(int item : arr) {
            if(item == 0) return 0;
            if(item == 1) continue;
            ret *= item;
        }
        return ret;
    }
    
    public int maxProduct(int[] nums) {
        // got this algorithm from discussion channel
        int prod = 1;
        int result = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++) {
            prod = prod * nums[i];
            result = Math.max(prod, result);
            if(prod == 0) {
                prod = 1;
            }
        }
        prod = 1;
        
        for(int i = nums.length - 1; i >= 0; i--) {
            prod = prod * nums[i];
            result = Math.max(prod, result);
            if(prod == 0) {
                prod = 1;
            }      
        }
        return result;
        /*
        if(nums == null || nums.length <= 0) return 0;
        if(nums.length <= 1) return nums[0];
        int maxProductRet = Integer.MIN_VALUE;
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                maxProductRet = Math.max(maxProductRet, subArrayProduct(i, j, nums));
            }
        }
        
        return maxProductRet;
        */
    }
}
