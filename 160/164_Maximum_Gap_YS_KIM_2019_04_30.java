class Solution {
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length <= 1) return 0;
        Arrays.sort(nums);
        int prev = nums[0];
        int maxGap = Integer.MIN_VALUE;
        for(int i = 1; i < nums.length; i++) {
            int item = nums[i];
            maxGap = Math.max(maxGap, item - prev);
            prev = item;
        }
        return maxGap;
    }
}
