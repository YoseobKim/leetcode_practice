class Solution {
    private boolean isAlpha(char c) {
        int a = (int)'a';
        int z = (int)'z';
        int t = (int)c;
        return a <= t && t <= z;
    }
    
    private String remainAlphas(String s) {
        String ret = "";
        char[] sArr = s.toCharArray();
        for(int i = 0; i < sArr.length; i++) {
            char c = sArr[i];
            if(isAlpha(c)) ret += c;
        }
        return ret;
    } 
    
    public boolean isPalindrome(String s) {
        String actual = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String rev = new StringBuffer(actual).reverse().toString();
        return actual.equals(rev);
        /*
        if(s.isEmpty()) return true;
        if(s.length() <= 1) return true;
        String converted = s.toLowerCase();
        converted = remainAlphas(converted);
//        System.out.println(converted);

        boolean ret = false;
        for(int i = 0; i < converted.length() / 2; i++) {
            char left = converted.charAt(i);
            char right = converted.charAt(converted.length() - 1 - i);
            if(left == right){
                ret = true;
                continue;
            }
            return false;
        }
        return ret;
        */
    }
}
