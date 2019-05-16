class Solution {
    private Map<Integer, Boolean> squareMap = new HashMap<>();
    private Map<Integer, Integer> memo = new HashMap<>();
    
    private boolean isSquare(int n) {
        if(squareMap.containsKey(n)) return squareMap.get(n);
        int i = (int)Math.sqrt(n);
        int ret = i * i;
        squareMap.put(n, (ret == n));
        return ret == n;
    }
    
    public int numSquares(int n) {
        if(memo.containsKey(n)) return memo.get(n);
        int ret = n;
        if(n <= 0) return 0;
        if(isSquare(n)) return 1;
        int i = 1;
        while(i * i < n) {
            int target = n - (i * i);
            ret = Math.min(ret, 1 + numSquares(target));
            i++;
        }
        // Time limit exceeded. Don't need to check all n. until sqrt(n) is also perfectly fine.
/*
        for(int i = 1; i < n; i++) {
            if(isSquare(i)) {
                int target = n - i;
                ret = Math.min(ret, 1 + numSquares(target));
            }
        }
*/
        memo.put(n, ret);
        return ret;
    }
}
