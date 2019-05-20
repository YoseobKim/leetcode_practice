class Solution {
    private void printList(List<Integer> nums) {
        for(int i : nums) System.out.print(i + ",");
        System.out.println("");
    }
    // time limit exceeded
    private int maxCoinsHelper(List<Integer> nums) {
        if(nums.size() <= 0) return 0;
        int sum = 0;
        for(int i = 0; i < nums.size(); i++) {
            int cur = nums.get(i);
            int left = (i == 0 ? 1 : nums.get(i - 1));
            int right = (i == nums.size() - 1 ? 1 : nums.get(i + 1));
            int curCoin = left * cur * right;
            nums.remove(i);
            //printList(nums);
            int maxCoin = curCoin + maxCoinsHelper(nums);
            //System.out.println(cur + " : " + maxCoin);
            sum = Math.max(sum, maxCoin);
            nums.add(i, cur);
            //printList(nums);
        }
        
        return sum;
    }
    // wrong answer
    private int maxCoinsHelper2(List<Integer> nums) {
        if(nums.size() <= 0) return 0;
        List<Integer> coins = new ArrayList<>();
        int maxIdx = 0;
        int maxCoin = 0;
        for(int i = 0; i < nums.size(); i++) {
            int cur = nums.get(i);
            int left = (i == 0 ? 1 : nums.get(i - 1));
            int right = (i == nums.size() - 1 ? 1 : nums.get(i + 1));
            int curCoin = left * right;
            if(maxCoin < curCoin) {
                maxIdx = i;
                maxCoin = curCoin;
            }
        }
        int cur = nums.get(maxIdx);
        nums.remove(maxIdx);
//        printList(nums);
//        System.out.println(maxCoin);
        return maxCoin * cur + maxCoinsHelper2(nums);
    }
    
    public int maxCoins(int[] nums) {
        if(nums.length <= 0) return 0;
        List<Integer> helperList = new LinkedList<>();
        for(int i : nums) helperList.add(i);
        return maxCoinsHelper(helperList);
        //return maxCoinsHelper2(helperList);
    }
}
