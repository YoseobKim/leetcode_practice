class Solution {
    public int removeElement(int[] nums, int val) {
        int len = 0;
        for(int i = 0; i < nums.length; i++) {
            int item = nums[i];
            if(item == val) {
                for(int j = i + 1; j < nums.length; j++) {
                    if(nums[j] != val) {
                        int swap = nums[i];
                        nums[i] = nums[j];
                        nums[j] = swap;
                        len++;
                        break;
                    }
                }
            } else {
                len++;
            }
        }
        return len;
    }
}
