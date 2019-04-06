class Solution {
    public int maxSubArray(int[] nums) {
        int maxUntilNow = nums[0];
        int maxNew = nums[0];
        for(int i = 1; i < nums.length; i++) {
            maxUntilNow = Math.max(nums[i], maxUntilNow + nums[i]);
            maxNew = Math.max(maxNew, maxUntilNow);
        }
        
        return maxNew;
        
    }
}
