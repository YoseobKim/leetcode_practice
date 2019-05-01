class Solution {
    public void rotate(int[] nums, int k) {
        if(k == 0) return;
        if(k % nums.length == 0) return;
        k = k % nums.length;
        for(int i = 0; i < nums.length - 1; i++) {
            int temp = nums[nums.length - 1];
            nums[nums.length - 1] = nums[i];
            nums[i] = temp;
        }
        rotate(nums, k - 1);
    }
    
    public void rotate2(int[] nums, int k) {
        if(k == 0) return;
        if(k % nums.length == 0) return;
        k = k % nums.length;
        
        List<Integer> arr = new ArrayList<>();
        for(int i = nums.length - k; i < nums.length; i++) {
            arr.add(nums[i]);
        }
        for(int i = 0; i < nums.length - k; i++) {
            arr.add(nums[i]);
        }
        for(int i = 0; i < arr.size(); i++) {
            nums[i] = arr.get(i);
        }
    }
}
