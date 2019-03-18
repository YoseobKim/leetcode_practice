class Solution {
    List<List<String>> ret = new ArrayList<>();
    private void printNQueensArr(char[][] arr) {
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println("");
        }
    }
    
    private boolean isSafe(char arr[][], int row, int col) 
    { 
        // Check this row
        for(int j = 0; j < arr.length; j++) {
            if(j == col) continue;
            if(arr[row][j] == 'Q')
                return false; 
        }
        
        // Check this col
        for(int i = 0; i < arr.length; i++) {
            if(i == row) continue;
            if(arr[i][col] == 'Q')
                return false;
        }
  
        // Check down right diagonal
        for(int i = row, j = col; i < arr.length && j < arr.length; i++, j++) {
            if(i == row && j == col) continue;
            if(arr[i][col] == 'Q')
                return false;
        } 
        
        // Check upper left diagonal
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(i == row && j == col) continue;
            if(arr[i][j] == 'Q')
                return false;
        }
        
        // Check down left diagonal
        for(int i = row, j = col; i < arr.length && j >= 0; i++, j--) {
            if(i == row && j == col) continue;
            if(arr[i][j] == 'Q')
                return false;            
        }
  
        // Check upper right diagonal
        for(int i = row, j = col; i >= 0 && j < arr.length; i--, j++) {
            if(i == row && j == col) continue;
            if(arr[i][j] == 'Q')
                return false;
        }
        
        return true; 
    } 
    
    private boolean solveNQueensRecursive(char[][] arr, int row, int n) {
        if(row >= n) {
            // if row >= n means every row is successfully finished with proper queens.
            List<String> comb = new ArrayList<>();
            for(int i = 0; i < arr.length; i++) {
                String str = "";
                for(int j = 0; j < arr.length; j++) {
                    str += arr[i][j];
                }
                comb.add(str);
            }
            ret.add(comb);
//            printNQueensArr(arr);
//            System.out.println("=============");
            return true;
        }
        boolean res = false;
        for(int col = 0; col < n; col++) {
            if(isSafe(arr, row, col)) {
                // placable queen. let's try next row.
                arr[row][col] = 'Q';
                if(solveNQueensRecursive(arr, row + 1, n)) {
                    res = true;
                }
                arr[row][col] = '.'; // not solvable. remove it.
            }
        }
        // every case was not solvable.
        return res;
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] arr = new char[n][n];
        
        // initialize
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = '.';
            }
        }
        
        solveNQueensRecursive(arr, 0, n);
        
        return ret;
    }
}
