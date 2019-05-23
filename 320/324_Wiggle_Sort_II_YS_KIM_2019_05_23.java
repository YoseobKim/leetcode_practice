class Solution {
    public void wiggleSort(int[] nums) {
        int[] helper = new int[nums.length];
        int index = 0;
        for(int num : nums) helper[index++] = num;
        Arrays.sort(helper);
        int left = nums.length % 2 == 0 ? nums.length / 2 - 1 : nums.length / 2;
        int right = nums.length - 1;
        for(int i = 0; i < nums.length; i++) {
            if(i % 2 == 0) nums[i] = helper[left--];
            else nums[i] = helper[right--];
        }
    }
}
