class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            int item = nums[i];
            if(item != 0) {
                nums[index++] = item;
            }
        }
        
        for(int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
