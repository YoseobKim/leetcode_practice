class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();
    
    public int combinationSum4(int[] nums, int target) {
        if(target < 0) return 0;
        if(target == 0) {
            return 1;
        }
        if(nums.length <= 0) return 0;
        if(memo.containsKey(target)) return memo.get(target);
        int ret = 0;
        for(int i = 0; i < nums.length; i++) {
            int newtarget = target - nums[i];
            ret += combinationSum4(nums, newtarget);
        }
        memo.put(target, ret);
        return ret;
    }
}
