// basic concept is concatinate nums array and do binary search within the proper boundary.
class Solution {    
    public int search(int[] nums, int target) {
        if(nums.length <= 0) return -1;
        if(nums.length == 1 && nums[0] == target) return 0; 
        int doubleLength = nums.length * 2;
        int mid = doubleLength / 2;
        int midItem = nums[mid % nums.length];
        if(midItem == target) return mid % nums.length;
        int lIdx = 0;
        if(nums[lIdx] == target) return 0;
        int rIdx = doubleLength - 1;
        if(nums[rIdx % nums.length] == target) return rIdx % nums.length;
        boolean foundBoundary = false;
        while(true) {
            if(lIdx >= rIdx) break;
            int lItem = nums[lIdx % nums.length];
            if(lItem == target) {
                return lIdx % nums.length;
            }
            if(lItem >= midItem && !foundBoundary) {
                lIdx++;
                continue;
            }

            int rItem = nums[rIdx % nums.length];
            if(rItem == target) {
                return rIdx % nums.length;
            }
            if(rItem <= midItem && !foundBoundary) {
                rIdx--;
                continue;
            }

            // lIdx and rIdx is properly configured.
            foundBoundary = true;
            mid = (lIdx + rIdx) / 2;

            midItem = nums[mid % nums.length];
            if(midItem == target) {
                return mid % nums.length;
            }
            if(midItem > target) {
                rIdx = mid - 1;
            } else {
                lIdx = mid + 1;
            }
        }

        return -1;
    }
}
