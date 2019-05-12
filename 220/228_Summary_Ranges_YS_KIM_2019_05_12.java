class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        if(nums.length <= 0) return ret;
        if(nums.length <= 1) {
            ret.add("" + nums[0]);
            return ret;
        }
        if(nums.length <= 2) {
            int num1 = nums[0];
            int num2 = nums[1];
            if(num1 + 1 == num2) {
                ret.add(num1 + "->" + num2);
            } else {
                ret.add("" + num1);
                ret.add("" + num2);
            }
            return ret;
        }
        int fromIdx = 0;
        int prevInt = nums[0];
        ret.add(prevInt + "");
        for(int i = 1; i < nums.length; i++) {
            int item = nums[i];
            if(prevInt + 1 == item) {
                int num1 = nums[fromIdx];
                String stritem = num1 + "->" + item;
                if(ret.size() <= 0) ret.add(stritem);
                else ret.set(ret.size() - 1, stritem);
            } else {
                String stritem = "" + item;
                ret.add(stritem);
                fromIdx = i;
            }
            prevInt = item;
        }
        
        return ret;
    }
}
