class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length <= 0) return 0;
        if(nums.length <= 1) return 0;
        int prev = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int item = nums[i];
            if(item < prev) return i - 1;
            prev = item;
        }
        return nums.length - 1;
    }
}
