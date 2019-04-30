class Solution {
    public int findMin(int[] nums) {
        int prev = nums[0];
        // If the pivot is in the array, it is the minimum.
        for(int i : nums) {
            if(prev > i) return i;
            prev = i;
        }
        // else no pivot. means first item is the minimum.
        return nums[0];
    }
}
