class Solution {
    private boolean isBitSet(int num, int k) {
        int ret = num & 1 << k;
        return ret != 0;
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length <= 0) new ArrayList<>();
        
        Set<List<Integer>> ret = new HashSet<>();
        for(int i = 0; i < Math.pow(2, nums.length); i++) {
            List<Integer> list = new ArrayList<>();
            for(int bit = 0; bit < nums.length; bit++) {
                if(isBitSet(i, bit)) {
                    list.add(nums[bit]);
                }
            }
            Collections.sort(list); // sort is necessary to determine duplication properly.
            ret.add(list);
        }
        
        return new ArrayList<>(ret);
    }
}
