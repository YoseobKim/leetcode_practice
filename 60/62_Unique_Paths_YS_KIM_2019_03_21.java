
class Solution {
    // As the robot only able to move right and down,
    // we can draw edge pathes easily.
    // m = 3, n = 2 and the array will store # of way to get to the right-most bottom
    // [0,0,1]
    // [1,1,1]
    // and the calculation should be arr[i][j] = arr[i + 1][j] + arr[i][j + 1]
    // [3,2,1]
    // [1,1,1]
    public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0) return 0;
        if(m <= 1 || n <= 1) return 1;

        int[][] arr = new int[m][n];
        
        // initialize
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = 1;
            }
        }
        
        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                arr[i][j] = arr[i + 1][j] + arr[i][j + 1];
            }
        }
        
        return arr[0][0];
    }
}
