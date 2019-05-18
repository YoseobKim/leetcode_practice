class NumMatrix {
    private int[][] matrix = null;
    private int[] matrix1D = null;
    private int[] sum = null;
    private int rowLen = 0;
    private int colLen = 0;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        /*
        matrix1D = new int[matrix.length * matrix[0].length];
        int index = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix1D[index++] = matrix[i][j];
            }
        }
        sum = new int[matrix1D.length + 1];
        for(int i = 0; i < matrix.length; i++) {
            sum[i + 1] = sum[i] + matrix1D[i];
        }
        
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        */
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i = row1; i <= row2; i++) {
            for(int j = col1; j <= col2; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
        /*
        int start = row1 * colLen + col1;
        int end = row2 * colLen + col2;
        
        return sum[end + 1] - sum[start];
        */
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
