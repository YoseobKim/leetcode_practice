class Solution {
    public int findMin(int[] nums) {
        int prev = nums[0];
        // If the pivot is in the array, it is the minimum.
        // It is follow up question of 153 (medium) but there is no difference.
        // no difference in run-time complexity. It only checks whether the i can be less than prev.
        for(int i : nums) {
            if(prev > i) return i;
            prev = i;
        }
        // else no pivot. means first item is the minimum.
        return nums[0];
    }
}
