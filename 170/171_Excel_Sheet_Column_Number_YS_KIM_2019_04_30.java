class Solution {
    private int charToInt(char c) {
        return c - 'A' + 1;
    }
    
    public int titleToNumber(String s) {
        int ret = 0;
        int digit = 1;
        for(int i = s.length() - 1; i >= 0; i--) {
            int num = charToInt(s.charAt(i));
            ret += digit * num;
            digit *= 26;
        }
        return ret;
    }
}
