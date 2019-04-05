class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() <= 0) return 0;
        if(haystack.length() <= 0) return -1;
        if(haystack.length() == needle.length()) return haystack.equals(needle) ? 0 : -1;
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            String substr = haystack.substring(i, i + needle.length());
            if(needle.equals(substr)) return i;
        }
        return -1;
    }
}
