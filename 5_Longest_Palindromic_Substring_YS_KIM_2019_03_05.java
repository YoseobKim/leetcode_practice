class Solution {
    private boolean isPalindrome(String s) {
        int mid = s.length() / 2;
        char[] sArr = s.toCharArray();

        boolean isPalindrom = true;
        
        for(int left = 0; left < mid; left++) {
            int right = s.length() - left - 1;
            if(sArr[left] != sArr[right]) return false;
        }
        
        return isPalindrom;
    }
    
    private int indexAt(String s, char c, int from) {
        char[] sArr = s.toCharArray();
        for(int i = from; i < s.length(); i++) {
            if(c == sArr[i]) return i;
        }
        return -1;
    }
    
    public String longestPalindrome(String s) {
        if(s.length() < 2) return s;
        char[] sArr = s.toCharArray();
        String longestPalindrome = "";
        
        for(int i = 0; i < s.length(); i++) {
            char start = sArr[i];
            for(int j = i; j < s.length(); j++) {
                int next = indexAt(s, start, j);
                if(next == -1) continue;
                String substr = s.substring(i, next + 1);
                if(isPalindrome(substr) && substr.length() >= longestPalindrome.length()) {
                    longestPalindrome = substr;
                }
            }
            
        }
        
        return longestPalindrome;
    }
