class Solution {
    private boolean findWordsHelper(char[][] board, String word, int x, int y, boolean[][] visited) {
        // boundary check
        if(x < 0 || y < 0) return false;
        if(x >= board.length || y >= board[0].length) return false;
        if(visited[x][y] == true) return false;
        
        if(word.length() == 0) return true;
        char targetChar = word.charAt(0);
        char curChar = board[x][y];
        visited[x][y] = true;
        if(targetChar != curChar) {
            visited[x][y] = false;
            return false;
        }
        if(word.length() == 1) return true;
        
        boolean ret = false;
        String targetString = word.substring(1);

        // go up
        ret = findWordsHelper(board, targetString, x - 1, y, visited);
        if(ret) return true;
        // go down
        ret = findWordsHelper(board, targetString, x + 1, y, visited);
        if(ret) return true;
        // go left
        ret = findWordsHelper(board, targetString, x, y - 1, visited);
        if(ret) return true;
        // go right
        ret = findWordsHelper(board, targetString, x, y + 1, visited);
        if(ret) return true;
        
        visited[x][y] = false;

        return false;
    }
    
    public List<String> findWords(char[][] board, String[] words) {
        List<String> ret = new ArrayList<>();
        
        if(board.length <= 0) return ret;
        if(words.length <= 0) return ret;
        
        for(String targetString : words) {
            char targetChar = targetString.charAt(0);
            for(int i = 0; i < board.length; i++) {
                boolean breakMe = false;
                for(int j = 0; j < board[0].length; j++) {
                    char curChar = board[i][j];
                    if(targetChar == curChar) {
                        boolean[][] visited = new boolean[board.length][board[0].length];
                        if(findWordsHelper(board, targetString, i, j, visited)) {
                            ret.add(targetString);
                            breakMe = true;
                            break;
                        }
                    }
                }
                if(breakMe) break;
            }
        }
        
        return ret;
    }
}
