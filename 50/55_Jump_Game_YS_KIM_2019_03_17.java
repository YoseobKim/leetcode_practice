// Couldn't be solved because of time limit.
class Solution {
    private Map<Integer, Boolean> cache = new HashMap<>();

    private boolean canJumpRecursive(int[] nums, int n) {
        if(cache.get(n) != null) return cache.get(n);
        if(nums.length - n <= 1) {
            cache.put(n, true);
            return true;
        }
        int maxJump = nums[n];
        if(maxJump <= 0) {
            cache.put(n, false);
            return false;
        }
        
        for(int jump = 1; jump < maxJump + 1; jump++) {
            if(jump > nums.length - 1) {
                cache.put(n, true);
                return true;
            }
            if(canJumpRecursive(nums, n + jump)) {
                cache.put(n, true);
                return true;
            }
        }
        cache.put(n, false);
        return false;        
    }
    
    public boolean canJump(int[] nums) {
        return canJumpRecursive(nums, 0);
    }
}
