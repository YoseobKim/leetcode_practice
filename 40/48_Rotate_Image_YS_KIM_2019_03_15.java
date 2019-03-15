class Solution {
    private void swap(int i1, int j1, int i2, int j2, int[][] matrix) {
        int ij1 = matrix[i1][j1];
        int ij2 = matrix[i2][j2];
        matrix[i1][j1] = ij2;
        matrix[i2][j2] = ij1;
        return;
    }
    
    public void rotate(int[][] matrix) {
        int size = matrix.length; // assume that the array is N x N following the description.
        int mid = size % 2 == 0? (size / 2) - 1 : size / 2;
        // 1. reverse it.
        // 1 2 3    7 8 9
        // 4 5 6    4 5 6
        // 7 8 9    1 2 3
        for(int i = 0; i < size / 2 ; i++) {
            for(int j = 0; j < size; j++) {
                swap(i, j, size - 1 - i, j, matrix);
            }
        }

        // swap symmetry
        // 7 8 9    7 4 1
        // 4 5 6    8 5 2
        // 1 2 3    9 6 3
        for(int i = 0; i < size; i++) {
            for(int j = i; j < size; j++) {
                swap(i, j, j, i, matrix);
            }
        }
    }
}
