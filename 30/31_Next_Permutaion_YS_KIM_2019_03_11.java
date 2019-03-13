    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    // 4 2 3 1 -> 4 3 1 2
    //   * decreasing index
    //     * nextNum index
    // 4 3 2 1 (after swap)
    // swap all after decreasing index
    // 4 3 1 2
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1) return;
        int decreasingIdx = nums.length - 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            int num = nums[i];
            if(num < nums[i + 1]) {
                decreasingIdx = i;
                break;
            }
        }

        int nextNumIdx = nums.length - 1;
        for(int i = decreasingIdx + 1; i < nums.length; i++) {
            if(nums[decreasingIdx] >= nums[i]) {
                nextNumIdx = i - 1;
                break;
            }
        }

        swap(nums, decreasingIdx, nextNumIdx);
        if(decreasingIdx != nextNumIdx)
            reverse(nums, decreasingIdx + 1);
        else // entire array is already reached to end permutaion. reverse it.
            reverse(nums, 0);
        return;
    }
