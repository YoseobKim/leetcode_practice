class Solution {
    public int findDuplicate(int[] nums) {
        // 0. naive approach [accepted]
        /*
        for(int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                int num2 = nums[j];
                if(num1 == num2) return num1;
            }
        }
        return 0;
        */
        
        // 1. sorting [accepted]
        /*
        Arrays.sort(nums);
        int prev = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(prev == nums[i]) return prev;
            prev = nums[i];
        }
        
        return 0;
        */
        // 2. It is not O(1) in space order, but set way. [accepted]
        Set<Integer> appeared = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            int item = nums[i];
            if(appeared.contains(item)) return item;
            appeared.add(item);
        }
        return 0;
        // Trying to find better way but not working since it may have duplicated values several times...
        /*
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 1; i < nums.length; i++) {
            sum1 += i;
        }
        
        for(int i = 0; i < nums.length; i++) {
            sum2 += nums[i];
        }
        
        int ret = sum2 - sum1;
        if(ret <= 0 || ret >= nums.length) {
            for(int i = 0; i < nums.length; i++) {
                int num1 = nums[i];
                for(int j = i + 1; j < nums.length; j++) {
                    int num2 = nums[j];
                    if(num1 == num2) return num1;
                }
            }
        }
        
        return sum2 - sum1;
        */
    }
}
