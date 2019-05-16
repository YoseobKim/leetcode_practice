class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern.length() <= 0) return false;
        if(str.length() <= 0) return false;
        String[] strarr = str.split(" ");
        if(strarr == null) return false;
        if(strarr.length != pattern.length()) return false;
        Map<Character, String> patterStrMap = new HashMap<>();
        Map<String, Character> strPatternMap = new HashMap<>();
        
        for(int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String strItem = strarr[i];
            if(patterStrMap.containsKey(c)) {
                String saved = patterStrMap.get(c);
                if(!strItem.equals(saved)) return false;
            } else if(strPatternMap.containsKey(strItem)) {
                char saved = strPatternMap.get(strItem);
                if(saved != c) return false;
            } else {
                patterStrMap.put(c, strItem);
                strPatternMap.put(strItem, c);
            }
        }
        
        return true;
    }
}
