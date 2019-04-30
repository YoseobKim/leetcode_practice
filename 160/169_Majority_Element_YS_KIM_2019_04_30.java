class Solution {
    public int majorityElement(int[] nums) {
        if(nums == null || nums.length <= 0) return 0;
        // key : item, value : appearance count
        Map<Integer, Integer> appearanceMap = new HashMap<>();
        int maxAppearanceCount = 1;
        int maxAppearanceNum = nums[0];
        for(int i : nums) {
            if(appearanceMap.containsKey(i)) {
                int appearance = appearanceMap.get(i);
                appearance++;
                if(maxAppearanceCount < appearance) {
                    maxAppearanceCount = appearance;
                    maxAppearanceNum = i;
                }
                appearanceMap.put(i, appearance);
            } else {
                appearanceMap.put(i, 1);
            }
        }
        return maxAppearanceNum;
    }
}
