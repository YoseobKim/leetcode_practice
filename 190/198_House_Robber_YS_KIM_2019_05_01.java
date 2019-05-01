class Solution {
    // key : param value : ret val
    private Map<Integer, Integer> memo = new HashMap<>();
    // dp with recursion
    private int robHelper(int[] nums, int start) {
        if(nums.length <= 0) return 0;
        if(nums.length <= 1) return nums[0];
        if(nums.length <= 2) {
            return Math.max(nums[0], nums[1]);
        }
        if(start < nums.length) {
            if(memo.containsKey(start)) return memo.get(start);
            int ret = 0;
            for(int i = start; i < nums.length; i++) {
                int val = nums[i] + robHelper(nums, i + 2);
                ret = Math.max(ret, val);
            }
            memo.put(start, ret);
            return ret;
        }
        return 0;
    }
    
    public int rob(int[] nums) {
        return robHelper(nums, 0);
    }
    // dp
    public int rob2(int[] nums) {
        if(nums.length <= 0) return 0;
        if(nums.length <= 1) return nums[0];
        if(nums.length <= 2) {
            return Math.max(nums[0], nums[1]);
        }
        int prevNo = 0;
        int prevYes = 0;
        for (int n : nums) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = n + temp;
        }
        return Math.max(prevNo, prevYes);
    }
}
