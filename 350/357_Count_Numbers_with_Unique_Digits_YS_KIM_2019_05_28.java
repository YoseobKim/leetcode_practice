class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        int[] dp = new int[n];
        dp[0] = 10;
        
        for(int i = 2; i <= n; i++) {
            int unique = 9;
            for(int mul = 9; mul >= (9 - i + 2); mul--) {
                unique *= mul;
            }
            dp[i - 1] = dp[i - 2] + unique;
        }
        
        return dp[n - 1];
    }
}
