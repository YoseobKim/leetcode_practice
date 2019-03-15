class Solution {
    private Map<String, Integer> cache = new HashMap<>();
    
    private String arrayToString(int[] num) {
        String str = "";
        for(int i : num) {
            str += i + ",";
        }
        return str;
    }
    
    public int jump(int[] nums) {        
        if(nums.length <= 1) {
            return 0;
        }
        
        int maxJump = nums[0];
        int minJump = Integer.MAX_VALUE;
        if(maxJump == 0) {
            maxJump = 1;
        } else if(maxJump >= nums.length - 2) {
            // not good. special edge case treatment.
            return nums.length - maxJump > 0 ? nums.length - maxJump : 1;
        }
        
        // not good. special edge case treatment.
        boolean all1 = true;
        for(int i : nums) {
            if(i == 1) continue;
            all1 = false;
            break;
        }
        if(all1) {
            return nums.length - 1;
        }
        
        String key = arrayToString(nums);
        if(cache.containsKey(key)) {
            return cache.get(key);
        }

        // main logic.
        for(int jump = 1; jump <= maxJump; jump++) {
            if(jump > nums.length - 1) return 1;
            int[] nexts = Arrays.copyOfRange(nums, jump, nums.length);
            // get least jump of [jump - end] array.
            int jumps = jump(nexts);
            int allJump = jumps;
            minJump = allJump < minJump ? allJump : minJump;
            if(minJump <= 0) break;
        }
        cache.put(key, new Integer(minJump + 1));
        return minJump + 1; // add 1 to minJump. 1 mean this.
    }
}
