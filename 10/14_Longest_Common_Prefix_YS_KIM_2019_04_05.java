class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length <= 0) return "";
        if(strs.length <= 1) return strs[0];
        String prefix = strs[0];
        for(String s : strs) {
            // find the shortest str in strs and initialize prefix with it.
            if(prefix.length() > s.length()) prefix = s;
        }
        
        for(String s : strs) {
            String newPrefix = "";
            for(int i = 0; i < prefix.length(); i++) {
                if(s.charAt(i) == prefix.charAt(i)) {
                    newPrefix += prefix.charAt(i);
                    continue;
                }
                break;
            }
            prefix = newPrefix;
        }
        
        return prefix;
    }
}
