class Solution {
    // In case of numRows = 4,
    // str      P A Y P A L I S H I  R  I  N  G
    // idx      0 1 2 3 4 5 6 7 8 9 10 11 12 13
    // arridx   0 1 2 3 2 1 0 1 2 3  2  1  0  1
    public String convert(String s, int numRows) {
        String[] stringsInZigZag = new String[numRows];
        for(int i = 0; i < stringsInZigZag.length; i++) {
            stringsInZigZag[i] = new String();
        }
        char[] sArr = s.toCharArray();
        
        int zigZagIdx = 0;
        boolean goUp = true;
        for(int i = 0; i < s.length(); i++) {
            char ch = sArr[i];
            stringsInZigZag[zigZagIdx] = stringsInZigZag[zigZagIdx] + ch;
            if(zigZagIdx == numRows - 1 || zigZagIdx == 0) goUp = !goUp;
            zigZagIdx = goUp ? 
                (zigZagIdx - 1 < 0 ? 0 : zigZagIdx - 1) : 
                (zigZagIdx + 1 >= numRows - 1 ? numRows - 1 : zigZagIdx + 1);
        }
        
        String ret = "";
        
        for(String str : stringsInZigZag) {
            ret = ret + str;
        }
        
        return ret;
    }
}
