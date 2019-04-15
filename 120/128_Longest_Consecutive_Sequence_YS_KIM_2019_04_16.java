class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length <= 0) return 0;
        if(nums.length <= 1) return 1;
        
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            set.add(i);
        }
        
        int size = 1;
        
        for(int num : set) {
            //System.out.println(num);
            if(set.contains(num - 1)) {
                int current = num;
                int currentConsecutive = 2;
                // current, num - 1 (size : 2)
                
                while(set.contains(current + 1)) {
                    current++;
                    currentConsecutive++;
                }
                
                size = Math.max(size, currentConsecutive);
            }
        }
        
        return size;
    }
}
