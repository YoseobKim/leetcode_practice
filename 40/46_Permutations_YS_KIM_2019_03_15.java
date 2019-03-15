class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        if(nums.length <= 1) {
            List<Integer> item = new ArrayList<>();
            item.add(nums[0]);
            ret.add(item);
            return ret;
        }
        
        int[] nexts = Arrays.copyOfRange(nums, 1, nums.length); // remove 0 index (first)
        List<List<Integer>> prev = permute(nexts);
        int currentItem = nums[0]; (me)
        for(List<Integer> item : prev) {
            for(int i = 0; i <= item.size(); i++) {
                List<Integer> newItem = new ArrayList<>(item.size());
                newItem.addAll(item);
                newItem.add(i, currentItem); 
                // insert me inside of prev permutaions
                ret.add(newItem);
            }
        }
        
        return ret;
    }
}
