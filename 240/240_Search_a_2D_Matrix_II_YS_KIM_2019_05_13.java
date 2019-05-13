class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length <= 0) return false;
        if(matrix[0].length <= 0) return false;
        List<Integer> candidateRows = new ArrayList<>();
        // search row
        for(int i = 0; i < matrix.length; i++) {
            int from = matrix[i][0];
            int to = matrix[i][matrix[i].length - 1];
            if(target == from || target == to) return true;
            if(target > from && target < to) {
                candidateRows.add(i);
            }
        }

        for(int row : candidateRows) {
            int[] candidateArr = matrix[row];
            for(int i : candidateArr) {
                if(i == target) return true;
            }
        }
        
        return false;
    }
}
