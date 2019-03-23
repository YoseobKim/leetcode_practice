// Same with 33. merge double nums and do binary search on it.
// When the array contains duplication, binary search time complexity is affected.
// from O(logN) to O(N)
// because if there are duplication, we need to do binary search on both side. 
// which means we need to check N items.
class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length <= 0) return false;
        if(nums.length == 1 && nums[0] == target) return true; 
        int doubleLength = nums.length * 2;
        int mid = doubleLength / 2;
        int midItem = nums[mid % nums.length];
        if(midItem == target) return true;
        int lIdx = 0;
        if(nums[lIdx] == target) return true;
        int rIdx = doubleLength - 1;
        if(nums[rIdx % nums.length] == target) return true;
        boolean foundBoundary = false;
        while(true) {
            if(lIdx >= rIdx) break;
            int lItem = nums[lIdx % nums.length];
            if(lItem == target) {
                return true;
            }
            if(lItem >= midItem && !foundBoundary) {
                lIdx++;
                continue;
            }

            int rItem = nums[rIdx % nums.length];
            if(rItem == target) {
                return true;
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
                return true;
            }
            if(midItem > target) {
                rIdx = mid - 1;
            } else {
                lIdx = mid + 1;
            }
        }

        return false;
    }
}
