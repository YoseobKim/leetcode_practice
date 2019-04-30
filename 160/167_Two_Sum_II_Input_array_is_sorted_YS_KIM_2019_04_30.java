class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];
        // key : value , value : index;
        Map<Integer, Integer> valueMap = new HashMap<>();
        
        for(int i = 0; i < numbers.length; i++) {
            valueMap.put(numbers[i], i);
        }
        
        for(int i = 0; i < numbers.length; i++) {
            int item = numbers[i];
            int rem = target - item;
            if(valueMap.containsKey(rem)) {
                ret[0] = i + 1;
                ret[1] = valueMap.get(rem) + 1;
                return ret;
            }
        }
        
        return ret;
    }
}
