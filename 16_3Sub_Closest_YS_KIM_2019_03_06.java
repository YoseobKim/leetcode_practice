class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ret = 0;
        int prevDiff = Integer.MAX_VALUE;
        
        for(int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                int num2 = nums[j];
                for(int k = j + 1; k < nums.length; k++) {
                    int num3 = nums[k];
                    int sum = num1 + num2 + num3;
                    if(Math.abs(sum - target) < prevDiff) {
                        ret = sum;
                        prevDiff = Math.abs(sum - target);
                    }
                }
            }
        }
        
        return ret;
    }
}
