class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length <= 0) return new int[0];
        List<Integer> retHelper = new ArrayList<>();
        for(int i = 0; i <= nums.length - k; i++) {
            int max = nums[i];
            for(int j = i; j < i + k; j++) {
                max = Math.max(nums[j], max);
            }
            retHelper.add(max);
        }
        
        int[] ret = new int[retHelper.size()];
        for(int i = 0; i < ret.length; i++) {
            ret[i] = retHelper.get(i);
        }
        
        return ret;
    }
}
