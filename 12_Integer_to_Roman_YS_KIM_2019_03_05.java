class Solution {
    // extra case : 4, 9, 40, 90 ... that can be % 4 == 0 || % 9 == 0
    private final int[] ROMAN_NUM = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
    private final String[] ROMAN_CHAR = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    
    private int findClosestRomanIndex(int num) {
        int diff = Integer.MAX_VALUE;
        int idx = 0;
        
        for(int i = 0; i < ROMAN_NUM.length; i++) {
            int curDiff = num - ROMAN_NUM[i];
            if(curDiff < 0) break;
            // as we are handling 4, 9 cases in exception, do not exceed num to find closest roman num.
            if(diff > curDiff) {
                diff = curDiff;
                idx = i;
            }
        }
        
        return idx;
    }
            
    public String intToRoman(int num) {
        if(num <= 0) return "";
        int idx = findClosestRomanIndex(num);
        int closestVal = ROMAN_NUM[idx];
        String closestChar = ROMAN_CHAR[idx];
        // e.g) 8 : 5 + 3 == X + III
        return closestChar + intToRoman(num - closestVal);
    }
}
