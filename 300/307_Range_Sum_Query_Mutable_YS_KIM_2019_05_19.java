class NumArray {
    private int[] nums = null;
    private int[] sums = null;
    public NumArray(int[] nums) {
        this.nums = nums;
        sums = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
    }
    
    public void update(int i, int val) {
        nums[i] = val;
        for(int j = i; j < nums.length; j++) {
            sums[j + 1] = sums[j] + nums[j];
        }
    }
    
    public int sumRange(int i, int j) {
        return sums[j + 1] - sums[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
