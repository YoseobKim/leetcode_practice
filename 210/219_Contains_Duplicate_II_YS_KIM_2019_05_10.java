class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // key : nums[i], value : i
        Map<Integer, Integer> itemMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(itemMap.containsKey(nums[i])) {
                int dupIdx = i;
                int origIdx = itemMap.get(nums[i]);
                if(dupIdx - origIdx <= k) return true;
                itemMap.put(nums[i], i);
                continue;
            }
            itemMap.put(nums[i], i);
        }
        
        return false;
    }
}
