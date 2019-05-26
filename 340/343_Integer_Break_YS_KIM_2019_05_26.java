class Solution {
    private Map<Integer, Integer> memo = new HashMap<>();
    public int integerBreak(int n) {
        if(n <= 2) return 1;
        if(memo.containsKey(n)) return memo.get(n);
        int max = 0;
        for(int i = 1; i < n; i++) {
            int target = n - i;
            int prod = Math.max(i * target, i * integerBreak(target));
//            System.out.println(i + " * func(" + target + ") = " + prod);
            max = Math.max(prod, max);
        }
        memo.put(n, max);
        return max;
    }
}
