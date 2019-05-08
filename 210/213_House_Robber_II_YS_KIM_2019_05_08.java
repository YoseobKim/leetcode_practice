class Solution {
    // key : param value : ret val
    private Map<String, Integer> memo = new HashMap<>();
    // dp with recursion
    private int robHelper(int[] nums, int start, int end) {
        if(start <= end) {
            String key = start + ":" + end;
            if(memo.containsKey(key)) return memo.get(key);
            int ret = 0;
            for(int i = start; i <= end; i++) {
                int val = nums[i] + robHelper(nums, i + 2, end);
                ret = Math.max(ret, val);
            }
            memo.put(key, ret);
            return ret;
        }
        return 0;
    }
    
    public int rob(int[] nums) {
        // boundary cases
        if(nums.length <= 0) return 0;
        if(nums.length <= 1) return nums[0];
        if(nums.length <= 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        int withFirstHouse = robHelper(nums, 0, nums.length - 2);
        int withLastHouse = robHelper(nums, 1, nums.length - 1);
        return Math.max(withFirstHouse, withLastHouse);
    }
}
