class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        if(nums.length <= 0) return ret;
        for(int i = 0; i < nums.length; i++) {
            int item1 = nums[i];
            int count = 0;
            for(int j = i + 1; j < nums.length; j++) {
                int item2 = nums[j];
                if(item1 > item2) count++; 
            }
            ret.add(count);
        }
        return ret;
    }
}
