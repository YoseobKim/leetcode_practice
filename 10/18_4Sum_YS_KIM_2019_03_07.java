class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> retSet = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            int num1 = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                int num2 = nums[j];
                for(int k = j + 1; k < nums.length; k++) {
                    int num3 = nums[k];
                    int sum = num1 + num2 + num3;
                    int search = target - sum;
                    if(k + 1 > nums.length) break;
               		int[] splited = Arrays.copyOfRange(nums, k + 1, nums.length);

                    if(Arrays.binarySearch(splited, search) >= 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(num1);
                        list.add(num2);
                        list.add(num3);
                        list.add(search);
                        retSet.add(list);
                    }
                }
            }
        }
        
        List<List<Integer>> retList = new ArrayList<>();
        
        for(List<Integer> li : retSet) {
            retList.add(li);
        }
        
        return retList;
    }
}
