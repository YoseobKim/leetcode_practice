class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        int[] leftMuls = new int[nums.length];
        int[] rightMuls = new int[nums.length];
        
        leftMuls[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            // shift by one multiply from left
            leftMuls[i] = leftMuls[i - 1] * nums[i - 1];
        }
        
        rightMuls[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            // shift by one multiply from right
            rightMuls[i] = rightMuls[i + 1] * nums[i + 1];
        }
        
        for(int i = 0; i < nums.length; i++) {
            ret[i] = leftMuls[i] * rightMuls[i];
        }
        
        return ret;
    }
}
