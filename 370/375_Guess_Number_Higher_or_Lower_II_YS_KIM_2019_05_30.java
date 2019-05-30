class Solution {
    public int getMoneyAmount(int n) {
        if (n == 1) {
            return 0;
        }
        
        // dp[i][j] means max val for i <= x <= j
        int[][] dp = new int[n + 1][n + 1];
        
        for (int jump = 1; jump < n; jump++) {
            for (int i = 0; i + jump <= n; i++) {
                int j = i + jump;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    // Math.max(from i to k - 1 and from k + 1 to j) + k
                    int includingK = k + Math.max(k - 1 >= i ? dp[i][k - 1] : 0, j >= k + 1 ? dp[k + 1][j] : 0);
                    dp[i][j] = Math.min(dp[i][j], includingK);
                }
            }
        }
        // 1 to n
        return dp[1][n];
    }
}
