class Solution {
    public static int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }
    public int[] twoSum(int[] nums, int target) {
        List<Integer> ret = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            int a = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                int b = nums[j];
                if(a + b == target) {
                    ret.add(i);
                    ret.add(j);
                    break;
                }
            }
        }
        int[] arr = convertIntegers(ret);
        return arr;
    }
}
