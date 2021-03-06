class Solution {
    private final int GO_RIGHT = 0;
    private final int GO_DOWN = 1;
    private final int GO_LEFT = 2;
    private final int GO_UP = 3;

    private boolean allDone(boolean[][] check) {
        for(int i = 0; i < check.length; i++) {
            for(int j = 0; j < check.length; j++) {
                if(!check[i][j]) return false; 
            }
        }
        return true;
    }
    
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length <= 0) return new ArrayList<Integer>();
        int state = GO_RIGHT;
        int rowSize = matrix.length;
        int colSize = matrix[0].length;
        boolean checked[][] = new boolean[rowSize][colSize];
        
        int row = 0;
        int col = 0;
        int loopCount = 0;
        
        List<Integer> ret = new ArrayList<>();
        
        while(true) {
            if(loopCount++ >= rowSize * colSize) break;
            int item = matrix[row][col];
            checked[row][col] = true;
            ret.add(item);
            if(state == GO_RIGHT) {
                if(col + 1 >= colSize || checked[row][col + 1]) {
                    // next is go down
                    state = GO_DOWN;
                    row++;
                    continue;
                }
                col++;
                continue;
            } else if(state == GO_DOWN) {
                if(row + 1 >= rowSize || checked[row + 1][col]) {
                    // next is go left
                    state = GO_LEFT;
                    col--;
                    continue;
                }
                row++;
                continue;
            } else if(state == GO_LEFT) {
                if(col - 1 < 0 || checked[row][col - 1]) {
                    // next is go up
                    state = GO_UP;
                    row--;
                    continue;
                }
                col--;
                continue;
            } else {
                if(row - 1 < 0 || checked[row - 1][col]) {
                    // next is go right
                    state = GO_RIGHT;
                    col++;
                    continue;
                }
                row--;
                continue;
            }
        }
        
        return ret;
    }
}
