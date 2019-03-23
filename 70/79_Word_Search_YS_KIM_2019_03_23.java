class Solution {
    private final int UNKNOWN = -1;
    private final int LEFT = 0;
    private final int RIGHT = 1;
    private final int UP = 2;
    private final int DOWN = 3;
    private boolean[][] checked; // boolean map for checking and backtracking. 
    private boolean existRecursive(char[][] board, String word, int row, int col, int prevMove) {
        if(row < 0 || col < 0) return false;
        if(row >= board.length || col >= board[row].length) return false;

        // all cases checked
        if(word.length() <= 0) return true;
        char firstCharInWord = word.charAt(0);
        if(word.length() <= 1 && board[row][col] == firstCharInWord) {
            return true;
        }
        // same with
        // word.length() <= 1 && board[row][col] != firstCharInWord
        if(word.length() <= 1) return false;
        
        String wordToNext = word.substring(1, word.length());

        if(firstCharInWord == board[row][col]) {
            checked[row][col] = true;
            
            // check up
            if(prevMove != DOWN && row - 1 >= 0 && !checked[row - 1][col] && 
               existRecursive(board, wordToNext, row - 1, col, UP)) return true;
            // check left
            if(prevMove != RIGHT && col - 1 >= 0 && !checked[row][col - 1] && 
               existRecursive(board, wordToNext, row, col - 1, LEFT)) return true;
            // check right
            if(prevMove != LEFT && col + 1 < board[row].length && !checked[row][col + 1] && 
               existRecursive(board, wordToNext, row, col + 1, RIGHT)) return true;
            // check down
            if(prevMove != UP && row + 1 < board.length && !checked[row + 1][col] && 
               existRecursive(board, wordToNext, row + 1, col, DOWN)) return true;
            
            checked[row][col] = false;
            return false;
        }
        
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        if(n <= 0) return false;
        int m = board[0].length;
        if(m <= 0) return false;
        if(word.length() <= 0) return true;
        checked = new boolean[n][m];
        
        char firstCharInWord = word.charAt(0);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(firstCharInWord == board[i][j]) {
                // if the array element contains first char,
                // start from this index.
                    if(existRecursive(board, word, i, j, UNKNOWN)) return true;
                }
            }
        }
        return false;
    }
}
