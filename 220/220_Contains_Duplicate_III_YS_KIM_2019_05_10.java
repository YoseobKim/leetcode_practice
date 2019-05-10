class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        for(int i = 0; i < nums.length; i++) {
            int item1 = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                int item2 = nums[j];
                long diff = (long)item1 - (long)item2;
                if(Math.abs(diff) <= t && j - i <= k) return true;
            }
        }
        return false;
    }
}
