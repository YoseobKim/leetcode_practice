class NeighborsStatus {
    public int numDead = 0;
    public int numLive = 0;
}
class Solution {
    private boolean isValidIndex(int i, int j, int w, int h) {
        if(i >= 0 && i < w && j >= 0 && j < h) return true;
        return false;
    }
    
    private NeighborsStatus countNeighbors(int[][] board, int i, int j) {
        int w = board.length;
        int h = board[0].length;
        NeighborsStatus ret = new NeighborsStatus();
        // up
        if(isValidIndex(i - 1, j, w, h)) {
            int up = board[i - 1][j];
            if(up == 1) ret.numLive++;
            else ret.numDead++;
        }
        // down
        if(isValidIndex(i + 1, j, w, h)) {
            int up = board[i + 1][j];
            if(up == 1) ret.numLive++;
            else ret.numDead++;
        }
        // left
        if(isValidIndex(i, j - 1, w, h)) {
            int up = board[i][j - 1];
            if(up == 1) ret.numLive++;
            else ret.numDead++;
        }
        // right
        if(isValidIndex(i, j + 1, w, h)) {
            int up = board[i][j + 1];
            if(up == 1) ret.numLive++;
            else ret.numDead++;
        }
        // up-left
        if(isValidIndex(i - 1, j - 1, w, h)) {
            int up = board[i - 1][j - 1];
            if(up == 1) ret.numLive++;
            else ret.numDead++;
        }
        // up-right
        if(isValidIndex(i - 1, j + 1, w, h)) {
            int up = board[i - 1][j + 1];
            if(up == 1) ret.numLive++;
            else ret.numDead++;
        }
        // down-left
        if(isValidIndex(i + 1, j - 1, w, h)) {
            int up = board[i + 1][j - 1];
            if(up == 1) ret.numLive++;
            else ret.numDead++;
        }
        // down-right
        if(isValidIndex(i + 1, j + 1, w, h)) {
            int up = board[i + 1][j + 1];
            if(up == 1) ret.numLive++;
            else ret.numDead++;
        }
        
        return ret;
    }
    
    public void gameOfLife(int[][] board) {
        if(board.length <= 0) return;
        if(board[0].length <= 0) return;
        
        int[][] ret = new int[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                int me = board[i][j];
                NeighborsStatus res = countNeighbors(board, i, j);
                if(me == 1) {
                    if(res.numLive < 2) { 
                        // 1. Any live cell with fewer than two live neighbors dies.
                        ret[i][j] = 0;
                    } else if(res.numLive == 2 || res.numLive == 3) {
                        // 2. Any live cell with two or three live neighbors live on the next generation.
                        ret[i][j] = 1;
                    } else if(res.numLive > 3) {
                        // 3. Any live cell with more than three live neighbors dies.
                        ret[i][j] = 0;
                    }
                } else {
                    if(res.numLive == 3) {
                        // 4. Any dead cell with exactly three live neighbors becomes a live cell.
                        ret[i][j] = 1;
                    } else {
                        ret[i][j] = me;
                    }
                }
            }
        }
        
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] = ret[i][j];
            }
        }
    }
}
