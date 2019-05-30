public class Solution {
    private Map<Integer, Integer> upMemo = new HashMap<>();
    private Map<Integer, Integer> downMemo = new HashMap<>();
    
    private int calculate(int[] nums, int index, boolean up) {
        if(up && upMemo.containsKey(index)) return upMemo.get(index);
        else if(!up && downMemo.containsKey(index)) return downMemo.get(index);
        
        int max = 0;
        int me = nums[index];
        for (int i = index + 1; i < nums.length; i++) {
            if ((up && nums[i] > me) || (!up && nums[i] < me))
                max = Math.max(max, 1 + calculate(nums, i, !up));
        }
        if(up) upMemo.put(index, max);
        else downMemo.put(index, max);
        return max;
    }

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        return 1 + Math.max(calculate(nums, 0, true), calculate(nums, 0, false));
    }
}
