class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxSize = 0;
        if(matrix.length <= 0) return 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1') {
                    // initial size should be one.
                    int sqlen = 1;
                    boolean flag = true;
                    while (sqlen + i < matrix.length && sqlen + j < matrix[0].length && flag) {
                        for (int k = j; k <= sqlen + j; k++) {
                            if (matrix[i + sqlen][k] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        for (int k = i; k <= sqlen + i; k++) {
                            if (matrix[k][j + sqlen] == '0') {
                                flag = false;
                                break;
                            }
                        }
                        if (flag)
                            sqlen++;
                    }
                    maxSize = Math.max(maxSize, sqlen);
                }
            }
        }
        return maxSize * maxSize;
    }
}
