class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 0) return 0;
        int appearance = 1;
        int prev = nums[0];
        int len = 1;
        
        for(int i = 1; i < nums.length; i++) {
            int item = nums[i];
            if(prev == item) appearance++;
            else appearance = 1;
            if(appearance <= 2) {
                len++;
            } else {
                nums[i] = Integer.MAX_VALUE;
            }
            prev = item;
        }
        
        // for convenience and better understanding.
        Arrays.sort(nums);
        
        return len;
    }
}
