class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> retSet = new HashSet<>(); // for uniqueness
        List<List<Integer>> ret = new ArrayList<>();
        if(nums.length <= 1) {
            List<Integer> item = new ArrayList<>();
            item.add(nums[0]);
            ret.add(item);
            return ret;
        }
        
        int[] nexts = Arrays.copyOfRange(nums, 1, nums.length); // remove 0 index
        List<List<Integer>> prev = permuteUnique(nexts);
        int currentItem = nums[0];
        for(List<Integer> item : prev) {
            for(int i = 0; i <= item.size(); i++) {
                List<Integer> newItem = new ArrayList<>(item.size());
                newItem.addAll(item);
                newItem.add(i, currentItem);
                retSet.add(newItem);
            }
        }
        
        for(List<Integer> item : retSet) {
            ret.add(item);
        }
        
        return ret;
    }
}
