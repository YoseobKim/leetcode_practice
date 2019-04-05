class Solution {
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if(val < target) continue;
            else return i;
        }
        return nums.length;
    }
}
