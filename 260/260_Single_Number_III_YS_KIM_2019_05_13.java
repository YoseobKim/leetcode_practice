class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length <= 0) return new int[0];
        if(nums.length <= 1) {
            int[] ret = new int[1];
            ret[0] = nums[0];
            return ret;
        }
        
        Set<Integer> every = new HashSet<>();
        Set<Integer> duplicated = new HashSet<>();
        
        for(int i : nums) {
            if(!every.add(i)) {
                duplicated.add(i);
            }
        }
        // remove all duplicated things.
        every.removeAll(duplicated);
        
        int[] ret = new int[every.size()];
        int index = 0;
        for(int item : every) {
            ret[index++] = item;
        }
        
        return ret;
    }
}
