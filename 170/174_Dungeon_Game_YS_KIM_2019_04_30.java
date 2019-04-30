class Solution {
    private void print(int[][] arr) {
        System.out.println("============");
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ,");
            }
            System.out.println("");
        }
        System.out.println("============");
    }
    
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon.length <= 0) return 1;
        int w = dungeon.length;
        int h = dungeon[0].length;
        int[][] dp = new int[w][h];
       
        for(int i = 0; i < w; i++) {
            for(int j = 0; j < h; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[w - 1][h - 1] = dungeon[w - 1][h - 1] < 0 ? (-1 * dungeon[w - 1][h - 1]) + 1 : 1;
//        System.out.println(dp[w - 1][h - 1]);
        
        for(int i = dungeon.length - 1; i >= 0; i--) {
            for(int j = dungeon[i].length - 1; j >= 0; j--) {
                int up = i - 1 < 0 ? Integer.MAX_VALUE : dungeon[i - 1][j];
                int left = j - 1 < 0 ? Integer.MAX_VALUE : dungeon[i][j - 1];
//                System.out.println("(" + i + " , " + j + ") : " + up + " : " + left);
                int targetUp = Math.max(dp[i][j] - up, 1);
//                System.out.println(dp[i][j] + " - " + up + " = " + targetUp);
                int targetLeft = Math.max(dp[i][j] - left, 1);
//                System.out.println(dp[i][j] + " - " + left + " = " + targetLeft);
                
                if(i > 0) dp[i - 1][j] = Math.min(dp[i - 1][j], targetUp);
                if(j > 0) dp[i][j - 1] = Math.min(dp[i][j - 1], targetLeft);
//                print(dp);
                
            }
        }
        return dp[0][0];
    }
}
