class Solution {
    private Map<String, Integer> memo = new HashMap<>();
    private int lengthOfLISHelper(int[] nums, int pos, int prev) {
        if(pos < nums.length) {
            String key = pos + ":" + prev;
            if(memo.containsKey(key)) return memo.get(key);
            int item = nums[pos];
            int includeMe = 0;
            int notIncludeMe = 0;
            if(item > prev) {
                includeMe = 1 + lengthOfLISHelper(nums, pos + 1, item);
            }
            notIncludeMe = lengthOfLISHelper(nums, pos + 1, prev);
            
            int ret = Math.max(includeMe, notIncludeMe);
            memo.put(key, ret);
            return ret;
        }
        return 0;
    }
    
    public int lengthOfLIS(int[] nums) {
        if(nums.length <= 0) return 0;
        if(nums.length <= 1) return 1;
        
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxAns = 1;
        for(int i = 1; i < nums.length; i++) {
            int maxVal = 0;
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    maxVal = Math.max(maxVal, dp[j]);
                }
            }
            dp[i] = maxVal + 1;
            maxAns = Math.max(dp[i], maxAns);
        }
        
        return maxAns;
        //return lengthOfLISHelper(nums, 0, Integer.MIN_VALUE);
    }
}
