class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            sums[i + 1] = nums[i] + sums[i];
        }
        
        int ret = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                long sub = sums[j + 1] - sums[i];
                if(lower <= sub && sub <= upper) ret++;
            }
        }
        return ret;
    }
}
