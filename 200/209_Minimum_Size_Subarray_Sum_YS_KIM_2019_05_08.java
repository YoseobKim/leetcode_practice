class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        boolean changed = false;
        long[] sums = new long[nums.length + 1];
        sums[0] = 0;
                
        for(int i = 0; i < nums.length; i++) {
            // if nums[i] == s means that the nums[i] self is the shortest sub arr. So length is 1
            if(nums[i] == s) return 1;
            sums[i + 1] = sums[i] + nums[i];
        }

        for(int start = 0; start < sums.length; start++) {
            for(int end = start + 1; end < sums.length; end++) {
                long sum1 = sums[start];
                long sum2 = sums[end];
                // sum2 must be always larger than sum1
                // sum2 - sum1 means [start - 1, ..., end] subarray's sum since sums array alredy sumed accumulatly.
                if(s <= sum2 - sum1) {
                    changed = true;
                    len = Math.min(end - start, len);
                }
            }
        }
        return changed ? len : 0;
    }
}
