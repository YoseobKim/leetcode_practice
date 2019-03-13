class Solution {
    public int[] searchRange(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if(index >= 0) {
            int left = index - 1;
            while(true) {
                if(left >= 0 && nums[left] == target) {
                    left--;
                    continue;
                }
                break;
            }
            left++;
            int right = index + 1;
            while(true) {
                if(right <= nums.length - 1 && nums[right] == target) {
                    right++;
                    continue;
                }
                break;
            }
            right--;
            return new int[] {left, right};
        }
        return new int[] {-1, -1};
    }
}
