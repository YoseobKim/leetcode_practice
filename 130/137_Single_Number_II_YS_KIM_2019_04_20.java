class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> entire = new HashSet<>();
        Set<Integer> duplicated = new HashSet<>();
        
        for(int i : nums) {
            if(entire.contains(i)) {
                duplicated.add(i);
            } else {
                entire.add(i);
            }
        }
        
        entire.removeAll(duplicated);
        for(Integer ret : entire) return ret;
        return 0;   
    }
}
