class Solution {
    private Set<Integer> coinsSet = new HashSet<>();
    private Map<Integer, Integer> memo = new HashMap<>();
    
    private int coinChageHelper(int amount) {
        if(amount < 0) return -1;
        if(amount == 0) return 0;
        if(coinsSet.contains(amount)) return 1;
        if(memo.containsKey(amount)) return memo.get(amount);
        int ret = Integer.MAX_VALUE;
        for(int coin : coinsSet) {
            int left = coinChageHelper(amount - coin);
            if(left >= 0) ret = Math.min(ret, 1 + left);
        }
        ret = ret == Integer.MAX_VALUE ? -1 : ret;
        memo.put(amount, ret);
        return ret;
    }
    
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        for(int coin : coins) {
            coinsSet.add(coin);
        }
        return coinChageHelper(amount);
    }
}
