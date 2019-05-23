class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int range = 0;
        
        for(int i = 0; i < nums.length; i++) {
            int item = nums[i];
            if(lower <= item && item <= upper) {
                range++;
            }
        }
        
        int ret = 0;
        for(int i = range; i >= 1; i--) {
            ret += i;
        }
        
        return ret;
    }
}
