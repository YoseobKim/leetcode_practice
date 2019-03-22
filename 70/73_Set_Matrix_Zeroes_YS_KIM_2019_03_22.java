class Solution {
    private void setZero(int row, int col, int[][] matrix) {
        // for row
        for(int i = 0; i < matrix[row].length; i++) {
            matrix[row][i] = 0;
        }
        // for col
        for(int j = 0; j < matrix.length; j++) {
            matrix[j][col] = 0;
        }
    }
    
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        if(n <= 0) return;
        int m = matrix[0].length;
        if(m <= 0) return;
        
        // edge case for size is 1
        if(n <= 1) {
            boolean have0 = false;
            for(int i : matrix[0]) {
                if(i == 0) {
                    have0 = true;
                    break;
                }
            }
            if(have0) {
                for(int i = 0; i < matrix[0].length; i++) {
                    matrix[0][i] = 0;
                }
                return;
            }
            return;
        }
        // edge case for size is 1
        if(m <= 1) {
            boolean have0 = false;
            for(int i = 0; i < n; i++) {
                if(matrix[i][0] == 0) {
                    have0 = true;
                    break;
                }
            }
            if(have0) {
                for(int i = 0; i < n; i++) {
                    matrix[i][0] = 0;
                }
            }
            return;
        }
        
        boolean[][] zeroMatrix = new boolean[n][m];
        // fill out zero matrix. if 0 is in the index, fill true.
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == 0) {
                    zeroMatrix[i][j] = true;
                    continue;
                }
                zeroMatrix[i][j] = false;
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(zeroMatrix[i][j] == true) setZero(i, j, matrix);
            }
        }
        
        return;
    }
}
