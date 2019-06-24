class Solution {
    private Map<Integer, List<Integer>> indexMap = null;
    public Solution(int[] nums) {
        indexMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int item = nums[i];
            List<Integer> indexArr = indexMap.getOrDefault(item, new ArrayList<>());
            indexArr.add(i);
            indexMap.put(item, indexArr);
        }
    }
    
    public int pick(int target) {
        List<Integer> indexArr = indexMap.get(target);
        if(indexArr == null) return 0;
        int len = indexArr.size();
        int random = (int)(Math.random() * len);
        return indexArr.get(random);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
