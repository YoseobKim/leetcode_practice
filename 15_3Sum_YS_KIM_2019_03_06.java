class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<Integer> varietySet = new HashSet<>();
        for(int i : nums) {
            varietySet.add(i);
        }
        // means all 0s in nums arr
        if(varietySet.size() == 1 && varietySet.contains(0) && nums.length >= 3) {
            List<List<Integer>> ret = new ArrayList<>();
            List<Integer> arrList = new ArrayList<>();
            Integer[] threeSumArr = {0, 0, 0};
            arrList.addAll(Arrays.asList(threeSumArr));
            ret.add(arrList);
            return ret;
        }
        
        // use set to remove duplicate triplets.
        Set<List<Integer>> retSet = new HashSet<>();
        // nlogn
        Arrays.sort(nums);
        
        // n^2logn
        for(int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                int num2 = nums[j];
                int sumUntilNum2 = num1 + num2;
                int candidate = sumUntilNum2 * -1;
                int[] remain = Arrays.copyOfRange(nums, j + 1, nums.length);
                // logn
                int index = Arrays.binarySearch(remain, candidate);
                
                if(index >= 0) {
                    Integer[] threeSumArr = {num1, num2, candidate};
                    List<Integer> arrList = new ArrayList<>();
                    arrList.addAll(Arrays.asList(threeSumArr));
                    retSet.add(arrList);
                }
            }
        }
        
        // convert to list
        List<List<Integer>> ret = new ArrayList<>();
        for(List<Integer> list : retSet) {
            ret.add(list);
        }
        
        return ret;
    }
}
