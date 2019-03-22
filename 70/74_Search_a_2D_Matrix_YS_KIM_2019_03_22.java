class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if(n <= 0) return false;
        int m = matrix[0].length;
        if(m <= 0) return false;
        if(n <= 1) {
            int[] targetRow = matrix[0];
            int result = Arrays.binarySearch(targetRow, target);
            boolean ret = result < 0 ? false : true;
            return ret;
        }
        if(m <= 1) {
            for(int i = 0; i < matrix.length; i++) {
                int target2 = matrix[i][0]; // the first item of the row.
                if(target2 == target) return true;
                if(target2 < target) {
                    continue;
                }
                break;
            }
            return false;
        }
        
        int targetRowIdx = 0;
        boolean targetRowIdxChanged = false;
        for(int i = 0; i < matrix.length; i++) {
            int target2 = matrix[i][0]; // the first item of the row.
            if(target2 == target) return true;
            if(target2 < target) {
                continue;
            }
            targetRowIdx = i - 1;
            targetRowIdxChanged = true;
            break;
        }
        
        if(targetRowIdx < 0) return false;
        if(!targetRowIdxChanged) targetRowIdx = matrix.length - 1; // check the last row.
        int[] targetRow = matrix[targetRowIdx];
        
        int result = Arrays.binarySearch(targetRow, target);
        boolean ret = result < 0 ? false : true;
                
        return ret;
    }
}
