class Solution {
    // in sudoku game, there will be three constraints except number range constraint.
    // 1. there will be no duplication in a row.
    // 2. there will be no duplication in a col.
    // 3. there will be no duplication in 3x3 section.
    public boolean isValidSudoku(char[][] board) {
        if(board == null) return false;
        if(board.length <= 1) return false;
        if(board[0].length <= 1) return false;
        
        Set<Character> check = new HashSet<>();
        
        // rows check. rule1
        for(int rowIdx = 0; rowIdx < board.length; rowIdx++) {
            for(int colIdx = 0; colIdx < board[rowIdx].length; colIdx++) {
                char item = board[rowIdx][colIdx];
                if(item == '.') continue;
                if(check.contains(item)) {
                    return false;
                }
                check.add(item);
            }
            // initialize
            check.clear();
        }
        
        check.clear(); // initialize
        int colLen = board[0].length;
        // cols check. rule2
        for(int colIdx = 0; colIdx < colLen; colIdx++) {
            for(int rowIdx = 0; rowIdx < board.length; rowIdx++) {
                char item = board[rowIdx][colIdx];
                if(item == '.') continue;
                if(check.contains(item)) {
                    return false;
                }
                check.add(item);
            }
            // initialize
            check.clear();
        }
        
        check.clear();
        // rows * cols (3 * 3) check. rule3
        for(int rowIdx = 0; rowIdx < board.length; ) {
            char[] row1 = board[rowIdx];
            char[] row2 = board[rowIdx + 1];
            char[] row3 = board[rowIdx + 2];
            rowIdx = rowIdx + 3;
            for(int colIdx = 0; colIdx < row1.length; ) {
                char[] items = {
                    row1[colIdx], row1[colIdx + 1], row1[colIdx + 2],
                    row2[colIdx], row2[colIdx + 1], row2[colIdx + 2],
                    row3[colIdx], row3[colIdx + 1], row3[colIdx + 2],
                };
                colIdx = colIdx + 3;
                // initialize
                check.clear();
                for(char item : items) {
                    if(item == '.') continue;
                    if(check.contains(item)) {
                        return false;
                    }
                    check.add(item);
                }
            }
            // initialize
            check.clear();
        }
        
        return true;
        
    }
}
