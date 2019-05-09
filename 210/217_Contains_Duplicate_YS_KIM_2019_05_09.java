class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> helper = new HashSet<>();
        boolean ret = false;
        for(int i : nums) {
            if(helper.contains(i)) {
                ret = true;
                break;
            }
            helper.add(i);
        }
        
        return ret;
    }
}
