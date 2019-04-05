class Solution {
    public int removeDuplicates(int[] nums) {
        SortedSet<Integer> numSet = new TreeSet<>();
        for(int i : nums) {
            numSet.add(i);
        }
        
        int index = 0;
        for(Integer i : numSet) {
            nums[index++] = i;
        }
        
        return numSet.size();
    }
}
