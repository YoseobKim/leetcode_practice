class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int size = nums.length;
        int leastAppearance = size / 3;
        Set<Integer> ret = new HashSet<>();
        // key : num, value : appearance
        Map<Integer, Integer> appearanceMap = new HashMap<>();
        if(nums.length <= 0) return new ArrayList<>(ret);
        
        for(int i = 0; i < nums.length; i++) {
            int item = nums[i];
            if(appearanceMap.containsKey(item)) {
                int appearance = appearanceMap.get(item);
                appearance++;
                appearanceMap.put(item, appearance);
                if(appearance > leastAppearance) {
                    ret.add(item);
                }
            } else {
                appearanceMap.put(item, 1);
                if(1 > leastAppearance) {
                    ret.add(item);
                }
            }
        }
        return new ArrayList<>(ret);
    }
}
