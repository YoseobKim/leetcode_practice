// very simple. add all item into set
// and traverse from 1 to INT_MAX to find which positive number is not contained in the set.
class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> positiveSet = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++) {
            int item = nums[i];
            if(item <= 0) continue;
            positiveSet.add(item);
        }
        
        for(int i = 1; i < Integer.MAX_VALUE; i++) {
            if(!positiveSet.contains(i)) return i;
        }
        
        return 0;
    }
}
