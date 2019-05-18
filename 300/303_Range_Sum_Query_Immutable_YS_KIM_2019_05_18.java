class NumArray {
    private int[] nums_ = null;
    private int[] sums = null;
    
    public NumArray(int[] nums) {
        nums_ = nums;
        sums = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }
    
    public int sumRange(int i, int j) {
        /*
        int ret = 0;
        for(int start = i; start <= j; start++) {
            ret += nums_[start];
        }
        return ret;
        */
        return sums[j + 1] - sums[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
